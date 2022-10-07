package com.studentregistration.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.studentregistration.dto.Student;

@Component(value = "dao")
public class StudentDao implements IDao {
	@Autowired
	private JdbcTemplate template;

	@Override
	public Student save(Student student) {
		String insert = "INSERT INTO students(name, age, mobileno, address) VALUES(?, ?, ?, ?)";
		template.update(insert, student.getName(), student.getAge(), student.getMobileNo(), student.getAddress());
		return student;
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Optional<Student> findById(int id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Student> findByMoibleNo(String mobileNo) {
		String query = "SELECT * FROM students WHERE id=?";
		Student foundStudent = template.queryForObject(query, new StudentRowMapper(), new Object[]{mobileNo});
		return Optional.ofNullable(foundStudent);
	}

	@Override
	public Student deleteByMobileNo(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
