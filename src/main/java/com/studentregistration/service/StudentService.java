package com.studentregistration.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentregistration.dao.IDao;
import com.studentregistration.dto.Student;

@Service
public class StudentService implements IService {
	@Autowired
	IDao dao;

	@Override
	public Student saveStudent(Student student) {
		return dao.save(student);
	}

	@Override
	public List<Student> getAllStudents() {
		return dao.findAll();
	}
	
	@Override
	public Student getStudent(int id) {
		Optional<Student> student = dao.findById(id);
		return student.isPresent() ? student.get() : null;
	}

	@Override
	public Student getStudentByMobileNo(String mobileNo) {
		Optional<Student> student = dao.findByMoibleNo(mobileNo);
		return student.isPresent() ? student.get() : null;
	}

	@Override
	public Student updateStudent(int id, Student student) {
		Optional<Student> foundStudent = dao.findById(id);
		Student updatedStudent = foundStudent.isPresent() ? foundStudent.get() : null;
		
		if (updatedStudent != null) {
			updatedStudent.setName(student.getName());
			updatedStudent.setAge(student.getAge());
			updatedStudent.setMobileNo(student.getMobileNo());
			updatedStudent.setAddress(student.getAddress());
			
			updatedStudent = dao.save(updatedStudent);
		}
		
		return updatedStudent;
	}	

	@Override
	public Student deleteStudent(int id) {
		return dao.deleteById(id);
	}
}
