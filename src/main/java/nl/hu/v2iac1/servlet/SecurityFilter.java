package nl.hu.v2iac1.servlet;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecurityFilter implements Filter {
	public void init(FilterConfig arg0) throws ServletException {}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req2 = (HttpServletRequest) req;
		RequestDispatcher rd = null;
		if (req2.getSession().getAttribute("secretuser") != null || (req2.getSession().getAttribute("topsecretuser") != null)) {
			chain.doFilter(req, resp);
		} else {
			req.setAttribute("msgs", "Op deze manier kom je niet achter het Geheim!");
			rd = req.getRequestDispatcher("/index.jsp");		
			rd.forward(req, resp);
			
		}
	}
	public void destroy() {}
}