package com.example.demo.validator;

import java.time.LocalDate;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.demo.model.Employee;

public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Employee.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Employee employee = (Employee) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.empty", "Tên không được để trống");
        if (employee.getName() != null && employee.getName().length() < 2) {
            errors.rejectValue("name", "name.short", "Tên phải có ít nhất 2 ký tự");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.empty", "Email không được để trống");
        if (employee.getEmail() != null && !employee.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            errors.rejectValue("email", "email.invalid", "Email không hợp lệ");
        }
//        if (employee.getBirthday() != null && employee.getBirthday().isAfter(LocalDate.now())) {
//            errors.rejectValue("birthday", "birthday.future", "Ngày sinh không được ở tương lai");
//        }
	}

}
