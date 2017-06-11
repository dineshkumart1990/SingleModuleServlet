package trng.imcs.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WelcomeServlet
 */
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    String title = "Servlet Example: Showing Request Headers";
	    out.println(
	                "<HTML> <BODY BGCOLOR=\"#FDF5E6\">\n" +
	                "<H1 ALIGN=CENTER>" + title + "</H1>\n" +
	                "<B>Request Method: </B>" +
	                request.getMethod() + "<BR>\n" +
	                "<B>Request URI: </B>" +
	                request.getRequestURI() + "<BR>\n" +
	                "<B>Request Protocol: </B>" +
	                request.getProtocol() + "<BR><BR>\n" +
	                "<BR>\n" +
	                "<B>Request Contextpath: </B>" +
	                request.getContextPath() + "<BR><BR>\n" +
	                "<B>Request IPAddrfess: </B>" +
	                request.getRemoteHost() + "<BR><BR>\n" +
	                "<B>Request Contexttype: </B>" +
	                request.getContentType() + "<BR><BR>\n" +
	                "<TABLE BORDER=1 ALIGN=CENTER>\n" +
	                "<TR BGCOLOR=\"#FFAD00\">\n" +
	                "<TH>Header Name<TH>Header Value");
	    Enumeration headerNames = request.getHeaderNames();
	    while(headerNames.hasMoreElements()) {
	      String headerName = (String)headerNames.nextElement();
	      out.println("<TR><TD>" + headerName);
	      out.println("    <TD>" + request.getHeader(headerName));
	    }
	    
	    Enumeration parameterNames = request.getParameterNames();
	    while(parameterNames.hasMoreElements()) {
	      String parameterName = (String)parameterNames.nextElement();
	      out.println("<TR><TD>" + parameterName);
	      out.println("    <TD>" + request.getParameter(parameterName));
	    }
	    
	    out.println("</TABLE>\n</BODY></HTML>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
