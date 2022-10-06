package com.registrationform.dao;

import com.registrationform.dto.User;

public interface UserDao {
	void saveUser(User user);
	User getUserByMobileNo(String mobileNo);
}
