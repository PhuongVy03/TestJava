//package com.example.demo.service;
//
//import java.util.List;
//
//import com.example.demo.dto.EmployeeDto;
//import com.example.demo.entity.Employee;
//
//public interface EmployeeService {
//	List<EmployeeDto> getAllEmployee();
//	void saveEmployee(EmployeeDto employedto, String password);
//}
package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;

public interface EmployeeService {
    List<Employee> getAllEmployee();  

    void saveEmployee(EmployeeDto employedto, String password);
}
