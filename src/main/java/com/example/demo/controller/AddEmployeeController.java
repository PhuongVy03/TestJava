package com.example.demo.controller;

import com.example.demo.model.Employee;
import jakarta.validation.Valid;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class AddEmployeeController {


    @GetMapping({"/", "/addEmployeeForm"})
    public String showForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "view-employee"; // Hiển thị form nhập
    }

    @PostMapping("/addEmployee")
    public String doAddEmployee(@ModelAttribute("employee") @Valid @RequestBody Employee employee, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "view-employee"; // Nếu có lỗi thì quay lại form và hiển thị lỗi
        }

        model.addAttribute("employee", employee);
        return "secondview-employee"; // Chuyển hướng sau khi nhập thành công
    }
    @GetMapping({"/", "/addEmployee"})
    public String show(Model model) {
        model.addAttribute("employee", new Employee());
        return "view-employee"; // Hiển thị form nhập nhân viên
    }
}


