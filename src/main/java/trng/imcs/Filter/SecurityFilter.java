package trng.imcs.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class SecurityFilter
 */
public class SecurityFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SecurityFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// place your code here
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		
		HttpSession session = httpRequest.getSession(false);
		boolean flag = isPathRestricted(httpRequest);
		System.out.println(session + " " + flag + " " + httpRequest.getRequestURI());
		if (flag && (session == null || session.getAttribute("userInfo") == null)) {
			httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
		}
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	private boolean isPathRestricted(HttpServletRequest httpRequest) {
		String requestUri = httpRequest.getRequestURI();
		return !(requestUri.contains("/login") || requestUri.contains("/index.html"));
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
