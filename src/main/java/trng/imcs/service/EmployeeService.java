package trng.imcs.service;

import trng.imcs.model.Employee;

public interface EmployeeService {

	Employee getEmpInfo(int parseInt);

	boolean addEmpInfo(String[] newEmpInfo);

	boolean deleteEmpInfo(int parseInt);

	
	
}
