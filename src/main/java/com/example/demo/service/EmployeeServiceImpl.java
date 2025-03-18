
package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Address;
import com.example.demo.entity.Employee;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
   
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public void deleteEmployeeById(Long id) {
    	if(employeeRepository.existsById(id)) {
    		employeeRepository.deleteById(id);
    	}else {
    		throw new RuntimeException("Không tìm thấy nhân viên với ID: "+ id  );
    	}
    }
  
    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAllWithAddress(); 
    }

    @Override
    public void saveEmployee(EmployeeDto employedto, String password) {
        Employee employee = new Employee();
        employee.setId(employedto.getId());
        employee.setName(employedto.getName());
        employee.setBirthday(employedto.getBirthday());
        employee.setEmail(employedto.getEmail());
        employee.setPassword(passwordEncoder.encode(password));
        if(employedto.getAddressId()!= null) {
        Address address = addressRepository.findById(employedto.getAddressId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy địa chỉ!"));
        		employee.setAddress(address); 
        }else {
        	employee.setAddress(null);
        }
       
        employeeRepository.save(employee);
    }

	@Override
	public Employee findById(Long id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id).orElse(null);
		
		
	}
	@Override
	public void updateEmployee(Long id, EmployeeDto employeeDto,String password) {
	    Employee employee = employeeRepository.findById(id)
	        .orElseThrow(() -> new RuntimeException("Không tìm thấy nhân viên với ID: " + id));
	    
	    employee.setName(employeeDto.getName());
	    employee.setBirthday(employeeDto.getBirthday());
	    employee.setEmail(employeeDto.getEmail());
	    if (password != null && !password.isEmpty()) {
            employee.setPassword(passwordEncoder.encode(password));
        }

	    employeeRepository.save(employee);
	}

	@Override
	public Employee findByEmail(String email) {
		// TODO Auto-generated method stub
		return employeeRepository.findByEmail(email).orElse(null);
	}
    
}
