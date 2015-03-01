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
		RequestDispatcher rd = null;
		boolean returnLogin = true;
		returnLogin = returnLogin && (username.equals("jacky"));
		returnLogin = returnLogin && (password.equals("andres"));
		if (returnLogin) {
			String mailKey = UUID.randomUUID().toString();
			Map<String, String> verification = (Map<String, String>) req
					.getServletContext().getAttribute("keys");
			verification.put(email, mailKey);
			req.getServletContext().setAttribute("keys", verification);
			sendEmail(email, mailKey);
			User u = new User(username, password, email, mailKey);
			req.getSession().setAttribute("topsecretuser", u);
			resp.sendRedirect("checkEmailkey.jsp");
		} else {
			req.setAttribute("msgs", "Verkeerde gegevens ingevoerd!");
			rd = req.getRequestDispatcher("loginTopsecret.jsp");
			rd.forward(req, resp);

		}

	}

	private void sendEmail(String email, String mailKey) {
		try {
			String sendTo = email;
			final String sendFrom = "securejetty@gmail.com";
			final String password = "local.properties";
			// system properties
			Properties props = System.getProperties();

			// Setup mail server
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");

			// Get the default Session object.
			Session session = Session.getDefaultInstance(props,
					new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(sendFrom, password);
						}
					});
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set email from.
			message.setFrom(new InternetAddress(sendFrom));

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
