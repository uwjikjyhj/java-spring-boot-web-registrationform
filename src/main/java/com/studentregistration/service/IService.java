package com.studentregistration.service;

import java.util.List;

import com.studentregistration.dto.Student;

public interface IService {
	Student saveStudent(Student student);
	
	List<Student> getAllStudents();
	Student getStudent(int id);
	Student getStudentByMobileNo(String mobileNo);
		
	Student deleteStudent(int id);
}
