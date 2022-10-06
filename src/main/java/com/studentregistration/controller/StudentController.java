package com.studentregistration.controller;

import java.util.Map;

import javax.servlet.RequestDispatcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.studentregistration.dao.StudentDao;
import com.studentregistration.dto.Student;

@Controller
@RequestMapping("/")
public class StudentController {
	@Autowired
	StudentDao dao;
	
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String getRegistrationForm(Map<String, Student> map) {
		return "registrationform";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/")
	public String saveStudent(
			String name, int age,
			@RequestParam(value = "mobile") String mobileNo,
			@RequestParam(value = "addr") String address,
			Map<String, Student> map) {
		Student student = new Student(name, age, mobileNo, address);
		dao.saveStudent(student);
		Student savedUser = dao.getStudentByMobileNo(student.getMobileNo());
		map.put("student", savedUser);
		return "studentdetails";
	}
}