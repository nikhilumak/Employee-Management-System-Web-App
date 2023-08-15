package org.techhub.SpringMVC.model;

public class Employee {
	
	private int empId;
	private String empName;
	private String empContact;
	private String empMail;
	private String empGender;
	private String password;
	private double empSal;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpContact() {
		return empContact;
	}
	public void setEmpContact(String empContact) {
		this.empContact = empContact;
	}
	public String getEmpMail() {
		return empMail;
	}
	public void setEmpMail(String empMail) {
		this.empMail = empMail;
	}
	public String getEmpGender() {
		return empGender;
	}
	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public double getEmpSal() {
		return empSal;
	}
	public void setEmpSal(double empSal) {
		this.empSal = empSal;
	}
	public Employee(int empId, String empName, String empContact, String empMail, String empGender, String password, double empSal) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empContact = empContact;
		this.empMail = empMail;
		this.empGender = empGender;
		this.password = password;
	}
	
	public Employee() {
		
	}
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empContact=" + empContact + ", empMail="
				+ empMail + ", empGender=" + empGender + ", password=" + password + ", empSal=" + empSal + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
//===================================================================================================================================
	
//	private String name;
//	private String email;
//	private String contact;
//	private int id;
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	public String getContact() {
//		return contact;
//	}
//	public void setContact(String contact) {
//		this.contact = contact;
//	}
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
	
}
