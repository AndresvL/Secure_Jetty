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

public class TopSecretServlet extends HttpServlet {
	private HttpSession session; 
	private HttpServletResponse resp;
	private HttpServletRequest req;
	private int poging;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session = request.getSession();
		session.setAttribute("pogingen", 0);	
		poging = (Integer) session.getAttribute("pogingen");
		resp = response;
		req = request;
		String username = (String) request.getParameter("username");
		String password = (String) request.getParameter("password");
		login(username, password);
	}

	public void login(String username, String password)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		String message;
		boolean returnLogin = true;
		poging ++;
		returnLogin = returnLogin && (username.equals("jacky"));
		returnLogin = returnLogin && (password.equals("andres"));
		if (returnLogin && poging <= 3) {
			session.setAttribute("user", 1);
			resp.sendRedirect("rest/secret");
		} else {		
			message = "Verkeerde gegevens ingevoerd!  "+poging+" van de 3 pogingen verbruikt";
			req.setAttribute("msgs", message);
			session.setAttribute("pogingen", poging);
			rd = req.getRequestDispatcher("loginSecret.jsp");			
		}
		rd.forward(req, resp);		
	}

}
