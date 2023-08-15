package org.techhub.SpringMVC.repository;

import java.util.*;

import org.techhub.SpringMVC.model.Employee;

public interface EmployeeRepository {
 
	public boolean isAddEmployee(Employee e);
	public boolean findByEmpMail(String mail);
	public boolean findByEmpContact(String contact);
	public List<Employee> getAllEmployee();
	public boolean validation(String email, String password);
	public List<Employee> getEmployee(String mail);
	public boolean isDeleteById(int id);
	public List<Employee> getEmployeeById(int id);
	public boolean isUpdateEmployee(int id, String name, String email, String contact, String gender, String password, int uniId, double sal);
	public List<Employee> getEmployeeByName(String name);
	public List<Employee> getByGender(String gender);
}
