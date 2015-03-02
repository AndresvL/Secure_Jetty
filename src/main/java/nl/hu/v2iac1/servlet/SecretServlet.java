package nl.hu.v2iac1.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.hu.v2iac1.domein.DefaultUser;
import nl.hu.v2iac1.domein.User;

public class SecretServlet extends HttpServlet {
	private HttpServletResponse resp;
	private HttpServletRequest req;
	HttpServletRequest req2 = (HttpServletRequest) req;
	ServletContext context;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		context = request.getServletContext();
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
		context.getAttribute("defaultUser");
		DefaultUser dU = (DefaultUser)context.getAttribute("defaultuser");	
		returnLogin = returnLogin && (username.equals(dU.getName()));
		returnLogin = returnLogin && (password.equals(dU.getPassword()));
		if (returnLogin) {
			User u = new User(username, password);
			req.getSession().setAttribute("secretuser", u);
			resp.sendRedirect("/Secure_Jetty/rest/secret/");
		} else {
			req.setAttribute("msgs", "Verkeerde gegevens ingevoerd!");
			rd = req.getRequestDispatcher("/loginSecret.jsp");
			rd.forward(req, resp);
		}
	}
}
