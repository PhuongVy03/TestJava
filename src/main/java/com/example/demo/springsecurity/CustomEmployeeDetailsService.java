package com.example.demo.springsecurity;

import java.util.Collections;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class CustomEmployeeDetailsService implements UserDetailsService {
	
	private final EmployeeRepository employeeRepository;
	
	public CustomEmployeeDetailsService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		 Employee employee = employeeRepository.findByEmail(email)
	                .orElseThrow(() -> new UsernameNotFoundException("Email không tồn tại: " + email));
		return new User(employee.getEmail(),employee.getPassword(),Collections.emptyList());
	}
//	Collections.emptyList(): Không có quyền hạn (roles) nào được gán.

}
