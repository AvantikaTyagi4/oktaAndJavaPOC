package com.okta.poc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OktaRedirect
 */
@WebServlet("/oktaRedirect")
public class OktaRedirect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OktaRedirect() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Redirecting to Okta Sign in URL
		response.sendRedirect("https://dev-73233639.okta.com/app/dev-73233639_revize_1/exk8265007IjJHGgG5d7/sso/saml");	
	}

}
