package com.studentregistration.dto;

public class Student {
	private String name;
	private Integer age;
	private String mobileNo;
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
}
