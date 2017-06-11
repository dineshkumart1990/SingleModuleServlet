package trng.imcs.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import trng.imcs.model.UserInfo;
import trng.imcs.service.UserService;
import trng.imcs.service.UserServiceImpl;
import trng.imcs.utl.HttpRequestConstants;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter(HttpRequestConstants.USER_NAME);
		String password = request.getParameter(HttpRequestConstants.PASSWORD);
		
		UserInfo user = new UserInfo();
		user.setLoginTime(new Date());
		user.setUserId(userName);
		user.setPassword(password);
		
		UserService userHelper = new UserServiceImpl();
		boolean validUser = userHelper.validateUser(user, getServletConfig());
		
		if (validUser) {
			HttpSession session = request.getSession(true);
			session.setAttribute("userInfo", user);
			
			RequestDispatcher homeDisp = request.getRequestDispatcher("pages/home.jsp");
			homeDisp.forward(request, response);
		} else {
			request.setAttribute("message", "Invalid User");
			RequestDispatcher loginDisp = request.getRequestDispatcher("login");
			loginDisp.forward(request, response);
		}
	}


}
