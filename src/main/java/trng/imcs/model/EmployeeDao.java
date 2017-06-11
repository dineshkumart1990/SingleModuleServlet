package trng.imcs.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import trng.imcs.utl.EmployeeUtil;

public class EmployeeDao {

	JDBCConnectionFactory connection = new JDBCConnectionFactory();
	PreparedStatement pStatement;
	ResultSet rs = null;
	Connection conn;
	
	public Employee getEmployee(int empId) throws IOException {
		Employee employee = new Employee();
		conn = connection.createConnection();
		
		try {
			pStatement = conn.prepareStatement("SELECT * FROM employees WHERE emp_no= ?");

			pStatement.setInt(1, empId);
			rs = pStatement.executeQuery();

			while (rs.next()) {
				employee.setNumber(rs.getInt("emp_no"));
				employee.setFname(rs.getString("first_name"));
				employee.setLname(rs.getString("last_name"));
				employee.setDob(rs.getDate("birth_date"));
				employee.setDoj(rs.getDate("hire_date"));
				employee.setGender(rs.getString("gender"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return employee;

	}

	public boolean setEmployee(Employee employee) throws IOException {
		boolean flag = false;
		Employee emp1 = null;
		emp1 = getEmployee(employee.getNumber());
		if (emp1==null){
		conn = connection.createConnection();
		System.out.println(conn);
		try{
	    	 
	    	  pStatement = conn.prepareStatement("INSERT INTO employees (emp_no,birth_date,first_name,last_name,gender,hire_date) VALUES (?,?,?,?,?,?)");
	    	  pStatement.setInt(1, employee.getNumber());
	    	  pStatement.setDate(2,EmployeeUtil.convertToSqlDate(employee.getDob()));
	    	  pStatement.setString(3, employee.getFname());
	    	  pStatement.setString(4, employee.getLname());
	    	  pStatement.setString(5, employee.getGender());
	    	  pStatement.setDate(6,EmployeeUtil.convertToSqlDate(employee.getDoj()));
			  
	    	  int insCount = pStatement.executeUpdate();
	    	  flag = true;
			  System.out.println("Inserted "+insCount+" records into the table...");
	      }catch(SQLException se){
	    	  se.printStackTrace();
	      }finally {
	    	  try{
			         if(conn!=null)
			            conn.close();
			      }catch(SQLException se){
			         se.printStackTrace();
		}
	      }

	      }else if(emp1!=null){
	    	  flag = updateEmployee(employee);
	      }
		return flag;
	}
	
	public boolean updateEmployee(Employee employee) throws IOException {
		boolean flag = false;
		conn = connection.createConnection();
		System.out.println(conn);
		try{
			
	    	  pStatement = conn.prepareStatement("UPDATE employees SET birth_date=?,first_name=?,last_name=?,gender=?,hire_date=? WHERE emp_no=?");
	    	  pStatement.setInt(6, employee.getNumber());
	    	  pStatement.setDate(1,EmployeeUtil.convertToSqlDate(employee.getDob()));
	    	  pStatement.setString(2, employee.getFname());
	    	  pStatement.setString(3, employee.getLname());
	    	  pStatement.setString(4, employee.getGender());
	    	  pStatement.setDate(5,EmployeeUtil.convertToSqlDate(employee.getDoj()));
			  
	    	  int upCount = pStatement.executeUpdate();
	    	  flag = true;
			  System.out.println("Updated "+upCount+" records into the table...");
	      }catch(SQLException se){
	    	  se.printStackTrace();
	      }finally {
	    	  try{
			         if(conn!=null)
			            conn.close();
			      }catch(SQLException se){
			         se.printStackTrace();
		}
	      }
		return flag;
	}

	public boolean deleteEmployee(int empId) {
		boolean flag = false;
		 try{
	    	 
	    	  pStatement = conn.prepareStatement("DELETE FROM employees WHERE emp_no=?");
	    	  pStatement.setInt(1, empId);
			 
	    	int delCount = pStatement.executeUpdate();
	      System.out.println("Deleted "+delCount+" records into the table...");
	      flag = true;
	      }catch(SQLException se){
	    	  se.printStackTrace();
	      }finally {
	    	  try{
			         if(conn!=null)
			            conn.close();
			      }catch(SQLException se){
			         se.printStackTrace();
		}

	}
		return flag;
	}
	
}
