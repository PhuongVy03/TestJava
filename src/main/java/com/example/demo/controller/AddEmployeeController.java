package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import com.example.demo.model.Employee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class AddEmployeeController {
//	@GetMapping("/","/addEmployeeForm")
	@RequestMapping(value = { "/", "/addEmployeeForm" }, method = RequestMethod.GET)
	public String showForm(Model model) {
		model.addAttribute("employee", new Employee());
		return "view-employee";
		
	}
	
	@PostMapping("/addEmployee")
	public String doAddEmployee(@ModelAttribute("employee") Employee employee, ModelMap modelMap) {
		modelMap.addAttribute("employee", employee);
		
		
		return "secondview-employee";
	}
	
}
