package nl.hu.v2iac1.servlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nl.hu.v2iac1.domein.User;

public class SecretServlet extends HttpServlet {
	private HttpServletResponse resp;
	private HttpServletRequest req;
	HttpServletRequest req2 = (HttpServletRequest) req;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		resp = response;
		req = request;
		String username = (String) request.getParameter("username");
		String password = (String) request.getParameter("password");
		login(username, password);
	}

	public void login(String username, String password)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		boolean returnLogin = true;
		returnLogin = returnLogin && (username.equals("jacky"));
		returnLogin = returnLogin && (password.equals("andres"));
		if (returnLogin) {
			User u = new User(username, password);
			req.getSession().setAttribute("topsecretuser", u);		
			resp.sendRedirect("rest/secret");
		} else {		
			req.setAttribute("msgs", "Verkeerde gegevens ingevoerd!");
			rd = req.getRequestDispatcher("loginSecret.jsp");	
			rd.forward(req, resp);	
		}
			
	}

}
