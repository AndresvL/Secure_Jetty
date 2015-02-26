package nl.hu.v2iac1.servlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SecretServlet extends HttpServlet {
	private HttpSession session; 
	private HttpServletResponse resp;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session = request.getSession();
		session.setAttribute("pogingen", 0);
		resp = response;
		String username = (String) request.getParameter("username");
		String password = (String) request.getParameter("password");
		login(username, password);
	}

	public String login(String username, String password)
			throws ServletException, IOException {
		String loginKey = null;
		boolean returnLogin = true;
		returnLogin = returnLogin && (username.equals("jacky"));
		returnLogin = returnLogin && (password.equals("andres"));
		int pogingen = (Integer) session.getAttribute("pogingen");
		if (returnLogin) {
			session.setAttribute("user", 1);
			resp.sendRedirect("rest/secret");
		} else {
			pogingen ++;
			resp.sendRedirect("loginSecret.jsp");
		}
		if (pogingen > 3) {
			loginKey = "opnieuw";
		}
		session.setAttribute("pogingen", 0);
		return loginKey;
	}

}
