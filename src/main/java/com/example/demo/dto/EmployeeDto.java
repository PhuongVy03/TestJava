package com.example.demo.dto;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class EmployeeDto {
	@Valid
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
   @Valid
    @NotBlank(message = "Tên không được để trống")
    @Size(min = 2, max = 50, message = "Tên phải từ 2 đến 50 ký tự")
    private String name;
    
   
   @Valid
    @NotNull(message = "Ngày sinh không được để trống")
    @Past(message = "Ngày sinh phải là ngày trong quá khứ")
    private LocalDate birthday;
   
   	@Valid
    @NotBlank(message = "Email không được để trống")
    @Column(unique = true, nullable = false)
    @Email(message = "Email không hợp lệ")
    private String email;
   	@Valid
    @NotNull(message = "Địa chỉ không được để trống")
    private Long addressId; // ID của Address
 
   	

    public EmployeeDto() {}

    public EmployeeDto(Long id, String name, LocalDate birthday, String email,Long addressId) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.email = email;
        this.addressId = addressId;
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
   
    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }
   
   

}
