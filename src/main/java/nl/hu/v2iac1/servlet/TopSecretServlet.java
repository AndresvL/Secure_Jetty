package nl.hu.v2iac1.servlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.hu.v2iac1.domein.User;
import nl.hu.v2iac1.auth.*;

public class TopSecretServlet extends HttpServlet {
	private HttpServletResponse resp;
	private HttpServletRequest req;
	HttpServletRequest req2 = (HttpServletRequest) req;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		resp = response;
		req = request;
		String username = (String) request.getParameter("username");
		String password = (String) request.getParameter("password");
		String email = (String) request.getParameter("email");
		login(username, password, email);
	}

	@SuppressWarnings("unchecked")
	public void login(String username, String password, String email)
			throws ServletException, IOException {
		boolean returnLogin = true;
		returnLogin = returnLogin && (username.equals("jacky"));
		returnLogin = returnLogin && (password.equals("andres"));
		if (returnLogin) {
			String mailKey = UUID.randomUUID().toString();
			sendEmail(email, mailKey);
			User u = new User(username, password, email, mailKey);
			req.getSession().setAttribute("topsecretuser", u);
			resp.sendRedirect("checkEmailkey.jsp");
		} else {
			req.setAttribute("msgs", "Verkeerde gegevens ingevoerd!");
			resp.sendRedirect("loginTopsecret.jsp");

		}

	}
	private void sendEmail(String email, String mailKey) {
		try {
			String sendTo = email;
			String host = "smtp.gmail.com";
	        String from = "securejetty@gmail.com";
	        String pass = "local.properties";
	        
	        // Setup mail server
	        Properties props = System.getProperties();
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", host);
	        props.put("mail.smtp.user", from);
	        props.put("mail.smtp.password", pass);
	        props.put("mail.smtp.port", "587");
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.debug", "true");			
			
			// Get the default Session object.
			Session session = Session.getInstance(props, new GMailAuthenticator(from, pass));
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set email from.
			message.setFrom(new InternetAddress(from));

			// Create message.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					sendTo));
			message.setSubject("Two-Step authentication");
			message.setText(mailKey);
			Transport.send(message);
			System.out.println("Sent message successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
