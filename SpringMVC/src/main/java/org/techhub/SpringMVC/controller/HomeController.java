package org.techhub.SpringMVC.controller;

import java.util.*;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.techhub.SpringMVC.model.Employee;
import org.techhub.SpringMVC.service.EmployeeService;

@Controller
public class HomeController {

	@Autowired
	EmployeeService service;
	List<Employee> employeeList;

	@RequestMapping(value = "/addemployee", method = RequestMethod.GET)
	public String getEmployeeForm() {
		return "addemployee";
	}

	@RequestMapping(value = "/insertData", method = RequestMethod.POST)
	public String saveRecord(Employee e, Map map) {
		boolean b = service.isAddEmployee(e);
		if (b) {
			map.put("msg", "Record Saved Successfully.........");
			return "redirect:/";
		} else {
			map.put("msg", "Please fill the form with CORRECT Details........");
			return "addemployee";
		}
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String viewAllEmployee(Map map) {
		employeeList = service.getAllEmployee();
		map.put("employeeRecord", employeeList);
		return "ViewAllEmployee";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homePage() {
		return "redirect:/";
	}

	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public String getLoginPage() {
		return "loginPage";
	}

	@RequestMapping(value = "/empLogin", method = RequestMethod.POST)
	public String getLogin(String empMail, String password, Map map) {
		boolean b = service.getLogin(empMail, password);
		if (b) {
			employeeList = service.getEmployee(empMail);
			map.put("employeeRecord", employeeList);
			map.put("msg", "Login Successfully.........");
			return "viewEmployee";
		} else {
			map.put("msg", "Incorrect Mail Id or Password........");
			return "loginPage";
		}
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String searchByName(@RequestParam("empName") String name, Map map) {
		employeeList= service.getEmployeeByName(name);
		map.put("employeeRecord", employeeList);
		return "viewEmployee";
		
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteEmployee(@RequestParam("id") int id, Map map) {
		boolean b = service.isDeleteById(id);
		if (b) {
			map.put("msg", "Record Deleted Successfully.........");
			return "redirect:/";
		} else {
			map.put("msg", "Issue happened.........");
			return "redirect:/";
		}
	}
	
	static int uniId;
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateEmployee(@RequestParam("id") int id, Map map) {
		employeeList = service.getEmployeeById(id);
		map.put("employeeList", employeeList);
		uniId=id;
		return "UpdateEmployee";
	}

	@RequestMapping(value = "/updatenext", method = RequestMethod.POST)
	public String updateNextEmployee(@RequestParam("empName") String name,
			@RequestParam("empMail") String email, @RequestParam("empContact") String contact,
			@RequestParam("empGender") String gender, @RequestParam("password") String password,@RequestParam("empSal") double sal, Map map) {
		boolean b = service.isUpdateEmployee(uniId, name, email, contact, gender, password, uniId, sal);
		if (b) {
			map.put("msg", "Record Updated Successfully.........");
			return "redirect:/";
		} else {
			map.put("msg", "Some Problem is there........");
			return "UpdateEmployee";
		}
	}
}

