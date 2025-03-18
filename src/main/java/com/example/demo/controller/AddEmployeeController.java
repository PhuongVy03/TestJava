package com.example.demo.controller;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Address;
import com.example.demo.entity.Employee;
import com.example.demo.repository.AddressRepository;

import jakarta.validation.Valid;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.EmployeeServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class AddEmployeeController {
	
	 @Autowired
	    private EmployeeService employeeService;
	 @Autowired
	    private AddressRepository addressRepository; 

	 //Hiện thị from 
    @GetMapping({"/", "/addEmployeeForm"})
    public String showForm(Model model) {
        model.addAttribute("employee", new Employee());
        
        List<Address> addresses = addressRepository.findAll();
        model.addAttribute("addresses", addresses);

        return "view-employee"; 
    }
   
    //Thêm nhân viên
    @PostMapping("/addEmployee")
    public String doAddEmployee(@ModelAttribute("employee") @Valid Employee employee, 
                                BindingResult result, Model model) {
        if (result.hasErrors()) {
        	 
            return "view-employee"; 
        }

        try {
         
        	
        	EmployeeDto employeeDto = new EmployeeDto(
                    employee.getId(),
                    employee.getName(),
                    employee.getBirthday(),
                    employee.getEmail(),
                    employee.getAddress().getId() 
                );

                employeeService.saveEmployee(employeeDto, employee.getPassword());
                List<Employee> employees = employeeService.getAllEmployee();
                model.addAttribute("employees", employees); 

        } catch (Exception e) {
            model.addAttribute("errorMessage", "Lỗi khi thêm nhân viên: " + e.getMessage());
            return "view-employee"; 
        }
        return "secondview-employee";  
    }
    

    @GetMapping("/edit-employee/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Employee employee = employeeService.findById(id);
        if (employee == null) {
            return "redirect:/listemployee"; 
        }
        model.addAttribute("employee", employee);
        return "edit-employee";
    }

    @PostMapping("/updateEmployee/{id}")
    public String updateEmployee(@PathVariable Long id, @ModelAttribute EmployeeDto employeeDto,String password) {
        employeeService.updateEmployee(id, employeeDto,password); 
        return "redirect:/listemployee"; 
    }
    
    //XÓA NHÂN VIÊN
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        try {
        	employeeService.deleteEmployeeById(id);
            return ResponseEntity.ok("Xóa thành công");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy nhân viên này!");
        }
    }


    //hiện thị list nhân viên
    @GetMapping("/listemployee")
    public String show(Model model) {
    	List<Employee> employees = employeeService.getAllEmployee();
        model.addAttribute("employees", employees);
        return "secondview-employee";  
    }
    //login 
    @GetMapping("/login")
    public String loginForm() {
        return "login"; // Hiển thị trang login.html
    }
    @PostMapping("/login")
    public String doLogin(@RequestParam String email, 
                          @RequestParam String password, 
                          Model model) {
        // Tìm employee theo email
        Employee employee = employeeService.findByEmail(email);

        // Kiểm tra nếu employee tồn tại và mật khẩu đúng
        if (employee != null && employee.getPassword().equals(password)) {
            return "redirect:/addEmployeeForm"; 
        } else {
            model.addAttribute("errorMessage", "Sai email hoặc mật khẩu!");
            return "login";
        }
    }
}


