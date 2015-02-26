package nl.hu.v2iac1.servlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecretServlet extends HttpServlet {
	private HttpServletRequest request;
	private HttpServletResponse response;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.request = request;
		String username = (String) request.getParameter("username");
		String password = (String) request.getParameter("password");
		String key = login(username, password);
		response.sendRedirect("rest/" + key);
	}

	public String login(String username, String password) throws ServletException, IOException {
		String returnkey = null;
		boolean returnLogin = true;
		returnLogin = returnLogin && (username.equals("jacky"));
		returnLogin = returnLogin && (password.equals("andres"));
		int pogingen = (Integer) request.getServletContext().getAttribute("pogingen");
		if (returnLogin) {
			returnkey = "secret/";
		} else {
			pogingen ++;			
		}if(pogingen > 3){
			returnkey = UUID.randomUUID().toString();
			pogingen = 0;
		}
		request.getServletContext().setAttribute("pogingen", pogingen);
		return returnkey;
	}
	
	
}
