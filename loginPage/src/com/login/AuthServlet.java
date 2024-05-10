package com.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AuthServlet
 */
@WebServlet("/AuthServlet")
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		String text = request.getParameter("text");
		
		// reusing code for setting up authorization check. 
		Auth beanAuth = new Auth();
		
		beanAuth.setName(name);
		beanAuth.setValue(text);
		beanAuth.setPassword(password);
		request.setAttribute("Auth", beanAuth);
		boolean status = beanAuth.validate();
		
		// creating the cookie
		response.addCookie(createCookie(name, text));
           
		
		if (status) {
			RequestDispatcher rd = request.getRequestDispatcher(name + ".jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("login-error.jsp");
			rd.forward(request, response);
		}
		
		
	}
	// Cookie Method for generating a cookie with a 2 hour persistance and httponly to remove tampering.
	private Cookie createCookie(String name, String value) {
		Cookie cookie = new Cookie(name,value);
		cookie.setMaxAge(3600*2);
		cookie.setHttpOnly(true);
		return cookie;
	}
	
}
