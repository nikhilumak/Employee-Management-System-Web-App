 package org.techhub.SpringMVC.service;

import java.util.List;

import org.techhub.SpringMVC.model.Employee;

public interface EmployeeService {
	
	public boolean isAddEmployee(Employee e);
	public List<Employee> getAllEmployee();
	public List<Employee> getEmployee(String empMail);
	public boolean isDeleteById(int id);
	public List<Employee> getEmployeeById(int id);
	public boolean isUpdateEmployee(int id, String name, String email, String contact, String gender, String password, int uniId, double sal);
	public boolean getLogin(String mailId, String password);
	public List<Employee> getEmployeeByName(String name);
	public List<Employee> getByGender( String gender);

	
}
