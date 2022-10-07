package com.studentregistration.dao;

import java.util.List;
import java.util.Optional;

import com.studentregistration.dto.Student;

public interface IDao {
	public Student save(Student student);
	public List<Student> findAll();
	public Optional<Student> findById(int id);
	public Optional<Student> findByMoibleNo(String mobileNo);
	public Student deleteByMobileNo(int id);
}
