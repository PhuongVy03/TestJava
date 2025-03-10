package com.example.demo.model;

import java.time.LocalDate;

public class Employee {
	private int id;
	private String name;
	private LocalDate birthday;
	private String email;
	public Employee(int id, String name, LocalDate birthday, String email) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.email = email;
	}
	public Employee() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
}
