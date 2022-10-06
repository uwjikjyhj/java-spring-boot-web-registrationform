package com.registrationform.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.registrationform.dto.User;

@Component(value = "dao")
public class UserDaoTemplateImpl implements UserDao {
	@Autowired
	private JdbcTemplate template;

	@Override
	public void saveUser(User user) {
		String insert = "INSERT INTO users(name, age, mobileno, address) VALUES(?, ?, ?, ?)";
		template.update(insert, user.getName(), user.getAge(), user.getMobileNo(), user.getAddress());
	}

	@Override
	public User getUserByMobileNo(String mobileNo) {
		String query = "SELECT * FROM users WHERE mobileno=?";
		return template.queryForObject(query, new UserRowMapper(), new Object[]{mobileNo});
	}
}
