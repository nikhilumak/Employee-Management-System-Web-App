package org.techhub.SpringMVC.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.techhub.SpringMVC.model.Employee;
import org.techhub.SpringMVC.repository.EmployeeRepository;
import org.techhub.SpringMVC.repository.EmployeeRepositoryImpl;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	EmployeeRepositoryImpl repository = new EmployeeRepositoryImpl();

	public boolean getPasswordValidator(String password) {
		System.out.println("passwordvalidator "+password);
		if (password.length() > 7 && password.length() < 21 && password.matches(".*[A-Z].*")
				&& password.matches(".*[a-z].*") && password.matches(".*[!@#$%^&*(),.?:{}|<>].*")
				&& password.matches(".*\\d.*")) {
			return true;
		} else {
			return false;
		}
	}

	public String getHashpassword(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] hash = md.digest(password.getBytes());
			StringBuilder sb = new StringBuilder();
			for (byte b : hash) {
				sb.append(String.format("%02x", b));
			}
			String pass = String.valueOf(sb);
			return pass;
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}

	@Override
	public boolean isAddEmployee(Employee e) {
		boolean b = getDataValidator(e.getEmpMail(), e.getEmpContact(), e.getPassword());
		if (b) {
			String hashPass = getHashpassword(e.getPassword());
			e.setPassword(hashPass);
			return repository.isAddEmployee(e);
		} else {
			return false;
		}
	}

	private boolean getDataValidator(String mail, String contact, String password) {
		System.out.println("controller datavalidator"+mail+contact+password);
		boolean existMail = repository.findByEmpMail(mail);
		System.out.println("existmail"+existMail);
		boolean existContact = repository.findByEmpContact(contact);
		System.out.println("existcontact"+existContact);
		try {
			if (mail.contains("@") && mail.contains(".") && existMail == false) {
				if (contact.length() == 10 && existContact == false) {
					if (getPasswordValidator(password)) {
						return true;
					} else {
						return false;
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
		} catch (NullPointerException e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> employeeList = repository.getAllEmployee();
		return employeeList;
	}

	@Override
	public boolean getLogin(String mailId, String password) {
		String hashPass = getHashpassword(password);
		boolean b = repository.validation(mailId, hashPass);
		if (b) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Employee> getEmployee(String mail) {
		// TODO Auto-generated method stub
		List<Employee> employeeList = repository.getEmployee(mail);
		return employeeList;
	}

	@Override
	public boolean isDeleteById(int id) {
		return repository.isDeleteById(id);
	}

	@Override
	public List<Employee> getEmployeeById(int id) {
		List<Employee> employeeList = repository.getEmployeeById(id);
		return employeeList;
	}

	@Override
	public boolean isUpdateEmployee(int id, String name, String email, String contact, String gender, String password, int uniId, double sal) {
			String hashPass = getHashpassword(password);
			System.out.println("service "+hashPass);
			return repository.isUpdateEmployee(id, name, email, contact, gender, hashPass, uniId, sal);
	}

	@Override
	public List<Employee> getEmployeeByName(String name) {
		List<Employee> employeeList = repository.getEmployeeByName(name);
		return employeeList;
	}

	@Override
	public List<Employee> getByGender(String gender) {
		List<Employee> empList= repository.getByGender(gender);
		return empList;
	}
}
