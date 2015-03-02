package nl.hu.v2iac1.security;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecurityFilter implements Filter {
	public void init(FilterConfig arg0) throws ServletException {
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req2 = (HttpServletRequest) req;
		if (req2.getSession().getAttribute("secretuser") != null) {
			chain.doFilter(req, resp);
		} else {
			RequestDispatcher rd = null;
			req.setAttribute("msgs",
					"Op deze manier kom je niet achter het Geheim!");
			rd = req.getRequestDispatcher("/index.jsp");
			rd.forward(req, resp);
		}
	}

	public void destroy() {
	}
}