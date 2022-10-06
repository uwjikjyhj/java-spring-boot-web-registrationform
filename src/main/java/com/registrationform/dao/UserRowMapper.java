package com.registrationform.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.registrationform.dto.User;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		String name = rs.getString("name");
		int age = rs.getInt("age");
		String mobileNo = rs.getString("mobileno");
		String address = rs.getString("address");
		return new User(name, age, mobileNo, address);
	}
	
}
