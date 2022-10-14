package com.studentregistration.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name")
	@Size(min = 2, message = "Name must have at least 2 characters")
	@NotBlank(message = "Name must not be blank")
	private String name;
	
	@Column(name = "age")
	private Integer age;
	
	@Column(name = "mobileno", unique = true)
	@NotNull(message = "Mobile number is required")
	private String mobileNo;
	
	@Column(name = "address")
	private String address;
	
	public Student() {
	}
	public Student(String name, Integer age, String mobileNo, String address) {
		super();
		this.name = name;
		this.age = age;
		this.mobileNo = mobileNo;
		this.address = address;
	}
	
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", mobileNo=" + mobileNo + ", address="
				+ address + "]";
	}
}
