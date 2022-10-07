package com.studentregistration.service;

import java.util.List;

import com.studentregistration.dto.Student;

public interface IService {
	Student saveStudent(Student student);
	List<Student> getAllStudents();
	Student getStudentById(int id);
	Student getStudentByMobileNo(String mobileNo);
	void updateStudent(Student student);
	void removeStudent(Student student);
}
