package com.okta.poc.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.okta.poc.dto.OktaEventDTO;
import com.okta.poc.dto.VerifyDTO;

/**
 * 
 * Created for OKTA webhooks 
 * must have get and post method with same endpoints
 * Servlet implementation class OKTAWebhookServlet
 */
@WebServlet("/okta/webhooks")
public class OKTAWebhookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Gson gson = new Gson();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OKTAWebhookServlet() {
		super();
	}

	/**
	 * This method is used by OKTA webhook for verification when we provide url
	 * during webhook creation. OKTA will call this method only once should return
	 * JSON with verification code sent by okta
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// fetching all the header
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String header = headerNames.nextElement();
			System.out.println("Header  " + header);
			System.out.println("Value  " + request.getHeader(header));
			// Checking for header with key x-okta-verification-challenge (send by okta)
			if (header.equals("x-okta-verification-challenge")) {
				// converting the verification code received by okta into VertifyDTO object
				VerifyDTO verifyDTO = new VerifyDTO(request.getHeader(header));
				// converting verifyDTO object to JSON
				String verifyDTOString = this.gson.toJson(verifyDTO);

				// sending the JSON response back to OKTA
				PrintWriter out = response.getWriter();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				out.print(verifyDTOString);
				out.flush();
			}
		}

	}

	/**
	 * OKTA call this method every time subscribed event got executed send the JSON
	 * request in RequestBody
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//For testing and printing RequestBody received by OKTA
		// uncomment following code
//		String text = new BufferedReader(
//			      new InputStreamReader(request.getInputStream(), StandardCharsets.UTF_8))
//			        .lines()
//			        .collect(Collectors.joining("\n"));
//		System.out.println(text);

		// Fetch the RequestBody and Map to OKTAEventDTO class
		ObjectMapper mapper = new ObjectMapper();
		OktaEventDTO oktaEventDTO = mapper.readValue(request.getInputStream(), OktaEventDTO.class);
		System.out.println(oktaEventDTO);

	}

}
