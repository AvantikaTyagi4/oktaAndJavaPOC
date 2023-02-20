package com.okta.poc.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.codec.binary.Base64;
import org.opensaml.DefaultBootstrap;
import org.opensaml.saml2.core.Attribute;
import org.opensaml.saml2.core.AttributeStatement;
import org.opensaml.saml2.core.Response;
import org.opensaml.saml2.core.Subject;
import org.opensaml.security.SAMLSignatureProfileValidator;
import org.opensaml.xml.Configuration;
import org.opensaml.xml.XMLObject;
import org.opensaml.xml.io.Unmarshaller;
import org.opensaml.xml.io.UnmarshallerFactory;
import org.opensaml.xml.schema.XSString;
import org.opensaml.xml.schema.impl.XSAnyImpl;
import org.opensaml.xml.security.credential.Credential;
import org.opensaml.xml.security.x509.BasicX509Credential;
import org.opensaml.xml.signature.SignatureValidator;
import org.opensaml.xml.validation.ValidationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Servlet implementation class OKTASevlet
 */
@WebServlet("/okta/saml/auth")
public class OKTASevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OKTASevlet() {
		super();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse servletResponse)
			throws ServletException, IOException {

		PrintWriter writer = servletResponse.getWriter();
		try {

			// Fetching SAML response returned by OKTA
			String samlResponse = request.getParameter("SAMLResponse");

			XMLObject xmlObj = generateXMLobject(samlResponse);
			Response response = (Response) xmlObj;

			// Validating the signature on the response 
			boolean result = validateSignature(response);

			// If signature is valid
			if (result) {
				
				// If validation was successful, get the username from the response. 
				Subject subject = response.getAssertions().get(0).getSubject();
				String username = subject.getNameID().getValue();
				// Fetching attributes we set in OKTA for users
				List<AttributeStatement> attributeStatements = response.getAssertions().get(0).getAttributeStatements();
				List<Attribute> attributes = attributeStatements.get(0).getAttributes();

				writer.println("<h1> Hello " + username + " </h1>");
				writer.println("User has been authenticated");

				attributes.forEach(attribute -> {

					XMLObject att = attribute.getAttributeValues().get(0);
					String value = getAttributeValue(att);
					// displaying attributes in UI
					writer.println("<h4> " + attribute.getName() + ":  " + value + "</h4>");

				});
				request.getRequestDispatcher("/logout.jsp").include(request, servletResponse);
			} else {

				throw new ValidationException("Signature doesn't match.");
			}
		} catch (Exception e) {

		} finally {
			
			writer.close();
		}

	}

	/**
	 * This method is used to decode SAML response and convert into XMLObject
	 * 
	 * @param request
	 * @return @XMLObject
	 */
	public XMLObject generateXMLobject(String request) {
		try {

			String responseXml = new String(Base64.decodeBase64(request), "UTF-8");

			// Generating SAML Response object from XML string 
			DefaultBootstrap.bootstrap();
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			documentBuilderFactory.setNamespaceAware(true);
			DocumentBuilder docBuilder = documentBuilderFactory.newDocumentBuilder();
			ByteArrayInputStream is = new ByteArrayInputStream(responseXml.getBytes());
			Document document = docBuilder.parse(is);
			Element element = document.getDocumentElement();

			UnmarshallerFactory unmarshallerFactory = Configuration.getUnmarshallerFactory();

			Unmarshaller unmarshaller = unmarshallerFactory.getUnmarshaller(element);

			XMLObject xmlObj = unmarshaller.unmarshall(element);

			return xmlObj;
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * This method is used to validate SAML response signature with Idp signature
	 * 
	 * @param response
	 * @return @boolean
	 * @throws CertificateException
	 * @throws FileNotFoundException
	 */
	private boolean validateSignature(Response response) throws CertificateException, FileNotFoundException {
		SAMLSignatureProfileValidator profileValidator = new SAMLSignatureProfileValidator();
		try {

			profileValidator.validate(response.getSignature());
		} catch (ValidationException e) {
			// Indicates signature did not confirm to SAML Signature profile 
			e.printStackTrace();

			return false;
		}

		Credential verificationCredential = getVerificationCredential();
		SignatureValidator sigValidator = new SignatureValidator(verificationCredential);

		try {

			sigValidator.validate(response.getSignature());
		} catch (ValidationException e) {
			
			// Indicates signature was not cryptographically valid, or possibly a processing error.
			e.printStackTrace();

			return false;
		}

		return true;
	}

	/**
	 * This method is used to get certificate from CERT file
	 * 
	 * @return @Credential
	 */
	private Credential getVerificationCredential() {

		try {

			// Read the certificate from .cert file
			BufferedInputStream bis = new BufferedInputStream(
					new FileInputStream(this.getServletContext().getRealPath("/Security/okta.cert")));
			CertificateFactory cf = CertificateFactory.getInstance("X509");
			X509Certificate cert = (X509Certificate) cf.generateCertificate(bis);
			BasicX509Credential x509Credential = new BasicX509Credential();
			x509Credential.setPublicKey(cert.getPublicKey());
			x509Credential.setEntityCertificate(cert);
			Credential credential = x509Credential;

			return credential;
		} catch (Exception e) {

			e.printStackTrace();
		}

		return null;
	}

	/**
	 * This method is used to extract attribute value from XMLObject
	 * 
	 * @param attributeValue
	 * @return @String
	 */
	private String getAttributeValue(XMLObject attributeValue) {

		return attributeValue == null ? null
				: attributeValue instanceof XSString ? getStringAttributeValue((XSString) attributeValue)
						: attributeValue instanceof XSAnyImpl ? getAnyAttributeValue((XSAnyImpl) attributeValue)
								: attributeValue.toString();
	}

	/**
	 * Extracting attribute value if attributeValue instance of @XSString
	 * 
	 * @param attributeValue
	 * @return @String
	 */
	private String getStringAttributeValue(XSString attributeValue) {

		return attributeValue.getValue();
	}

	/**
	 * Extracting attribute value if attributeValue instance of @XSAnyImpl
	 * 
	 * @param attributeValue
	 * @return @String
	 */
	private String getAnyAttributeValue(XSAnyImpl attributeValue) {

		return attributeValue.getTextContent();
	}

	/**
	 * This method is used to get Metadata from URL
	 * 
	 * @return
	 */
	public String getMetadataFromURL() {

		String xmlString = "";
		try {

			// Pass metadata URL
			URL obj = new URL("https://dev-73233639.okta.com/app/exk8265007IjJHGgG5d7/sso/saml/metadata");
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			System.out.println("GET Response Code :: " + responseCode);

			if (responseCode == HttpURLConnection.HTTP_OK) { 
				
				// success
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();

				// print result
				System.out.println(response.toString());
				xmlString = response.toString();
			} else {
				
				System.out.println("GET request did not work.");

			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		return xmlString;
	}
}
