package com.studentregistration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.studentregistration.dto.Student;
import com.studentregistration.service.IService;

@RestController
public class StudentController {
	@Autowired
	IService service;
	
	@PostMapping(path = "/student")
	public Student createStudent(@RequestBody Student student) {
		Student savedStudent = service.saveStudent(student);
		return savedStudent;
	}
	
	@GetMapping(path = "/student")
	public List<Student> retrieveAllStudents() {
		List<Student> studentList = service.getAllStudents();
		return studentList;
	}

	@GetMapping(path = "/student/{id}")
	public Student retriveStudent(@PathVariable int id) {
		Student student = service.getStudent(id);
		return student;
	}
	
	@PutMapping(path = "/student/{id}")
	public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
		Student updatedStudent = service.updateStudent(id, student);
		return updatedStudent;
	}
	
	@DeleteMapping(path = "/student/{id}")
	public Student deleteStudent(@PathVariable int id) {
		Student deletedStudent = service.deleteStudent(id);
		return deletedStudent;
	}
}