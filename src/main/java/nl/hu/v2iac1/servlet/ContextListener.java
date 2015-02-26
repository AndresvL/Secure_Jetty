package nl.hu.v2iac1.servlet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServletRequest;
 
public class ContextListener implements ServletContextListener{
	ServletContext context;
	public void contextDestroyed(ServletContextEvent contextEvent) {
		System.out.println("ServletContextListener destroyed");
	}
 
	public void contextInitialized(ServletContextEvent contextEvent) {
		context = contextEvent.getServletContext();
	}
	
}