package nl.hu.v2iac1.security;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecurityVerysecret implements Filter{
	public void init(FilterConfig arg0) throws ServletException {
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req2 = (HttpServletRequest) req;
		HttpServletResponse resp2 = (HttpServletResponse) resp;
		if (req2.getSession().getAttribute("code") != null) {
			chain.doFilter(req, resp);
		} else {
			req.setAttribute("msgs",
					"Op deze manier kom je niet achter het Geheim!");
			resp2.sendRedirect("/Secure_Jetty/loginVerySecret.jsp");
		}
	}

	public void destroy() {
	}
}
