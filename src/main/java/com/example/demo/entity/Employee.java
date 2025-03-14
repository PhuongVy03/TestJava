package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

import com.example.demo.entity.Address; 

@Entity
@Table(name = "employee")
public class Employee {
	
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
    @NotBlank(message = "Password không được để trống")
   	private String password;
   	// Tham chiếu bảng
   	@ManyToOne
   	@JoinColumn(name="address_id")
   	private Address address;
   	
   	public Address getAddress() {
   		return address;
   	}
   	public void setAddress(Address address) {
   		this.address= address;
   	}

    public Employee() {}

    public Employee(Long id, String name, LocalDate birthday, String email, String password) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.email = email;
        this.password = password;
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
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
    	this.password = password;
    }
   
}


