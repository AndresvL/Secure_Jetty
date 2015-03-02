package nl.hu.v2iac1.servlet;

import java.io.*;
import java.util.Scanner;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import nl.hu.v2iac1.domein.DefaultUser;

public class ContextListener implements ServletContextListener {
	ServletContext context;
	private String name, pass, email, emailpassword;
	public void contextDestroyed(ServletContextEvent contextEvent) {
		System.out.println("ServletContextListener destroyed");
	}

	public void contextInitialized(ServletContextEvent contextEvent) {
		context = contextEvent.getServletContext();
		try {
			File file = new File("/Users/Andres/Desktop/userInfo.txt");
			Scanner sc = new Scanner(file);
			if (file.exists()) {
				while (sc.hasNext()) {
					name = sc.next();
					pass = sc.next();
					email = sc.next();
					emailpassword = sc.next();
				}
			}
			// setting up default user
			DefaultUser u = new DefaultUser(name, pass, email, emailpassword);
			context.setAttribute("defaultuser", u);
			sc.close();

		} catch (Exception e) {
			System.out.println("Error while reading file line by line:"
					+ e.getMessage());

		}
		
	}
}
