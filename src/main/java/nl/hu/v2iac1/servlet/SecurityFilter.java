package nl.hu.v2iac1.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

public class SecurityFilter implements Filter {
	public void init(FilterConfig arg0) throws ServletException {}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest r2 = (HttpServletRequest) req;
		if (r2.getSession().getAttribute("user") != null) {
			chain.doFilter(req, resp);
		} else {
			r2.getRequestDispatcher("loginSecret.jsp").forward(req, resp);
		}
	}

	public void destroy() {}
}