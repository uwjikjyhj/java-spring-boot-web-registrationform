package com.studentregistration.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.studentregistration.dto.Student;

public class StudentRowMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		String name = rs.getString("name");
		int age = rs.getInt("age");
		String mobileNo = rs.getString("mobileno");
		String address = rs.getString("address");
		return new Student(name, age, mobileNo, address);
	}
	
}
