package com.studentregistration.dao;

import com.studentregistration.dto.Student;

public interface StudentDao {
	void saveStudent(Student user);
	Student getStudentByMobileNo(String mobileNo);
}
