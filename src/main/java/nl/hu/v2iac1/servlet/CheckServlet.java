package nl.hu.v2iac1.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nl.hu.v2iac1.auth.GoogleAuthHelper;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CheckServlet extends HttpServlet {
	private HttpServletRequest request;
	private HttpServletResponse response;

	private String emailAdress;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.request = request;
		HttpSession session = request.getSession();
		final GoogleAuthHelper helper = new GoogleAuthHelper();
		if (request.getParameter("code") != null
				&& request.getParameter("state") != null
				&& request.getParameter("state").equals(
						session.getAttribute("state"))) {
			session.removeAttribute("state");
			String jsonString = helper.getUserInfoJson(request
					.getParameter("code"));
			try {
				JSONObject json = (JSONObject) new JSONParser().parse(jsonString);
				emailAdress = (String) json.get("email");
			} catch (ParseException e) {
			}
			if (emailAdress.equals("securejetty@gmail.com")) {
				response.sendRedirect("/Secure_Jetty/rest/verysecret/");
			}
			else{
				response.sendRedirect("/Secure_Jetty/loginVerySecret.jsp");
			}
		} else {
			response.sendRedirect("/Secure_Jetty/loginVerySecret.jsp");
		} 
	}

}
