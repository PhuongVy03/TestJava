
package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;

public interface EmployeeService {
    List<Employee> getAllEmployee();  

    void saveEmployee(EmployeeDto employedto, String password);
    public void deleteEmployeeById(Long id) ;
    Employee findById(Long id);
    public void updateEmployee(Long id, EmployeeDto employeeDto,String password);
    public Employee findByEmail(String email);
        
    
}
