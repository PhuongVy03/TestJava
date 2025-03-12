package com.example.demo.controller;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;
import jakarta.validation.Valid;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import com.example.demo.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class AddEmployeeController {
	
	 @Autowired
	    private EmployeeService employeeService;

	 //Hiện thị from 
    @GetMapping({"/", "/addEmployeeForm"})
    public String showForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "view-employee"; 
    }

    @PostMapping("/addEmployee")
    public String doAddEmployee(@ModelAttribute("employee") @Valid Employee employee, 
                                BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "view-employee"; 
        }

        try {
           
            EmployeeDto employeeDto = new EmployeeDto(employee.getId(), employee.getName(), 
                                                      employee.getBirthday(), employee.getEmail()); 
            employeeService.saveEmployee(employeeDto, employee.getPassword());
            List<Employee> employees = employeeService.getAllEmployee();
            model.addAttribute("employees", employees); 

        } catch (Exception e) {
            model.addAttribute("errorMessage", "Lỗi khi thêm nhân viên: " + e.getMessage());
            return "view-employee"; 
        }
        return "secondview-employee";  
    }


    //hiện thị list nhân viên
    @GetMapping("/listemployee")
    public String show(Model model) {
    	List<Employee> employees = employeeService.getAllEmployee();
        model.addAttribute("employees", employees);
        return "secondview-employee";  
    }
}


