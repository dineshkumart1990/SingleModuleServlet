package trng.imcs.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trng.imcs.model.Employee;
import trng.imcs.model.Product;
//import trng.imcs.model.genderEnum;
import trng.imcs.service.EmployeeService;
import trng.imcs.service.EmployeeServiceImpl;

/**
 * Servlet implementation class EmployeeServlet
 */
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EmployeeService empService;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        empService = new EmployeeServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empId = request.getParameter("empId");
		System.out.println(empId);
		
		
			Employee emp = empService.getEmpInfo(Integer.parseInt(empId));
		
		System.out.println(emp.getFname());
		request.setAttribute("employee", new Employee(emp.getNumber(),emp.getFname(),emp.getLname(),null,emp.getDob(),emp.getDoj()));
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher homeDisp = request.getRequestDispatcher("pages/employeeSearch.jsp");
		homeDisp.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] newEmpInfo = new String[6];
		newEmpInfo[0]= request.getParameter("empId");
		newEmpInfo[1]= request.getParameter("fName");
		newEmpInfo[2]= request.getParameter("lName");
		newEmpInfo[3]= request.getParameter("gender");
		newEmpInfo[4]= request.getParameter("dob");
		newEmpInfo[5]= request.getParameter("doj");
		
		boolean insertStatus = empService.addEmpInfo(newEmpInfo);
		if (insertStatus==true){
			request.setAttribute("message", "Employee with ID "+newEmpInfo[0]+" inserted successfully");
		}else {request.setAttribute("message", "Employee values not inserted!!");}
			RequestDispatcher loginDisp = request.getRequestDispatcher("pages/addEmployee.jsp");
		loginDisp.forward(request, response);
		//doGet(request, response);
	}

}
