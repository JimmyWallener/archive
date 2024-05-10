package com.login;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public class CookieChecker extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public static String getCookie(HttpServletRequest request, String name) {
		try {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(name)) {
					return cookie.getValue();
				}
			}
		} 
	}
		catch (Exception e) {
			e.printStackTrace();
		} return null;

}

}
