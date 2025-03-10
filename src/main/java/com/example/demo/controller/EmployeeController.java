package com.example.demo.controller;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.Employee;

@Controller

public class EmployeeController {
	//@RequestMapping(value="/", method = RequestMethod.GET)
	//@RequestMapping(value="/employees", method=RequestMethod.GET)
	@GetMapping("/employees")
	public String getEmployees(Model model) {
		List<Employee> employees = Arrays.asList(
				new Employee(1,"Nguyễn Văn A",LocalDate.of(1990, 5, 10),"AAA@gmail.com"),
				new Employee(2,"Nguyễn Văn B",LocalDate.of(1991, 5, 10),"BBB@gmail.com"),
				new Employee(3,"Nguyễn Văn C",LocalDate.of(1992, 5, 10),"CCC@gmail.com"),
				new Employee(4,"Nguyễn Văn D",LocalDate.of(1993, 5, 10),"DDD@gmail.com")
				
				);
		model.addAttribute("employees",employees);
		return "EmployeeList" ;
		
	}
	

}
