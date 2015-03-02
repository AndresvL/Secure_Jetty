package nl.hu.v2iac1.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.hu.v2iac1.domein.User;

public class CheckEmail extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String key = request.getParameter("key");
		System.out.println("This is the key: " + key);
		User u = (User) request.getSession().getAttribute("topsecretuser");
		if (u.getKey().equals(key)) {
			response.sendRedirect("/Secure_Jetty/rest/topsecret/");
		} else {
			response.sendRedirect("/Secure_Jetty/loginTopsecret.jsp");
			request.getServletContext().setAttribute("user", null);
		}
	}
}
