package com.studentregistration.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.studentregistration.dto.Student;

@Component(value = "dao")
public class StudentDaoTemplateImpl implements StudentDao {
	@Autowired
	private JdbcTemplate template;

	@Override
	public void saveStudent(Student student) {
		String insert = "INSERT INTO students(name, age, mobileno, address) VALUES(?, ?, ?, ?)";
		template.update(insert, student.getName(), student.getAge(), student.getMobileNo(), student.getAddress());
	}

	@Override
	public Student getStudentByMobileNo(String mobileNo) {
		String query = "SELECT * FROM students WHERE mobileno=?";
		return template.queryForObject(query, new StudentRowMapper(), new Object[]{mobileNo});
	}
}
