package trng.imcs.model;

import java.util.Date;

enum genderEnum{M,F}
public class Employee {
	
	private int number;
	private String fname,lname;
	private String gender;
	private Date dob,doj;
	
	
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	
	// SETTING AND GETTING VALUES FOR THE GENDER ENUM
	public String getGender() {
	    return gender;
	}

	public void setGender(String gender) {
	    this.gender = gender;
	}
	public Employee(int number, String fname, String lname, String gender, Date dob, Date doj) {
		super();
		this.number = number;
		this.fname = fname;
		this.lname = lname;
		this.gender = gender;
		this.dob = dob;
		this.doj = doj;
	}
	public Employee() {
		super();
	}
	
	
}
