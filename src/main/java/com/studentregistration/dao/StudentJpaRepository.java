package com.studentregistration.dao;

import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.studentregistration.dto.Student;

@Repository(value = "datajpa")
@Profile("dev")
public interface StudentJpaRepository extends IDao, JpaRepository<Student, Integer> {
	@Query("select s from Student s where s.mobileNo = ?1")
	public Optional<Student> findByMoibleNo(String mobileNo);
	
	@Query("delete from Student s where s.mobileNo = ?1")
	public Student deleteByMobileNo(String mobileNo);
}
