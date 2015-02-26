package nl.hu.v2iac1.servlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SecretServlet extends HttpServlet {
	private HttpSession session;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session = request.getSession();
		String username = (String) request.getParameter("username");
		String password = (String) request.getParameter("password");
		String key = login(username, password);
		response.sendRedirect("rest/" + key);
	}

	public String login(String username, String password) throws ServletException, IOException {
		String loginKey = null;
		boolean returnLogin = true;		
		returnLogin = returnLogin && (username.equals("jacky"));
		returnLogin = returnLogin && (password.equals("andres"));
		int pogingen = 0;
		if (returnLogin) {
			session.setAttribute("user", 1);
			loginKey = "secret";
		} else {
			pogingen ++;			
		}if(pogingen > 3){
			loginKey = UUID.randomUUID().toString();
		}
//		request.getServletContext().setAttribute("pogingen", pogingen);
		return loginKey;
	}
	
	
}
