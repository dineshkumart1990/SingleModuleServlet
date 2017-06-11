package trng.imcs.service;

import java.io.IOException;


import trng.imcs.model.Employee;
import trng.imcs.model.EmployeeDao;
import trng.imcs.utl.EmployeeUtil;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDao empDao = new EmployeeDao();
	private Employee emp = new Employee();
	
	
	public Employee getEmpInfo(int empId){
		//Employee emp = null;
		try {
			emp = empDao.getEmployee(empId);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return emp;
		
	}
	public boolean addEmpInfo(String[] newEmpInfo) {
		emp.setNumber(Integer.parseInt(newEmpInfo[0]));
		emp.setFname(newEmpInfo[1]);
		emp.setLname(newEmpInfo[2]);
		emp.setGender(newEmpInfo[3]);
		emp.setDob(EmployeeUtil.convertToUtilDate(newEmpInfo[4]));
		emp.setDoj(EmployeeUtil.convertToUtilDate(newEmpInfo[5]));
		boolean flag = false;
		try{
		flag = empDao.setEmployee(emp);}
		catch(Exception e){
			e.printStackTrace();
		}
		return flag;
			
	}
	
	public boolean deleteEmpInfo(int empId){
		boolean flag = false;
		flag = empDao.deleteEmployee(empId);
		return flag;
		
	}
	
	
}
