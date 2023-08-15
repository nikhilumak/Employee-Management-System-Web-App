package org.techhub.SpringMVC.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.techhub.SpringMVC.model.Employee;
import org.techhub.SpringMVC.service.EmployeeService;

@Controller
public class NewController {
	
	@Autowired
	EmployeeService service;
	
	
	@RequestMapping(value="/gender", method=RequestMethod.GET)
	public String getByGender(@RequestParam("empGender") String gender, Map map) {
		List<Employee> empList= service.getByGender(gender);
		map.put("employeeRecord", empList);
		return "viewEmployee";
		
	}

}
