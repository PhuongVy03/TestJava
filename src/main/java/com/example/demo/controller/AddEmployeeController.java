package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import com.example.demo.model.Employee;
import com.example.demo.validator.EmployeeValidator;

import jakarta.validation.Valid;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
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
	@InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new EmployeeValidator());
    }	
	@PostMapping("/addEmployee")
	    public String doAddEmployee(@ModelAttribute("employee") @Validated Employee employee, BindingResult result, ModelMap modelMap) {
	        if (result.hasErrors()) {
	            return "view-employee"; 
	        }

	        modelMap.addAttribute("employee", employee);
	        return "secondview-employee";
	    }

	
	
	
	
	
}
