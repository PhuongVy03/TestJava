
package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Transactional
    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll(); 
    }

    @Override
    public void saveEmployee(EmployeeDto employedto, String password) {
        Employee employee = new Employee();
        employee.setId(employedto.getId());
        employee.setName(employedto.getName());
        employee.setBirthday(employedto.getBirthday());
        employee.setEmail(employedto.getEmail());
        employee.setPassword(password);  

        employeeRepository.save(employee);
    }
}
