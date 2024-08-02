package com.studentportal.main.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentportal.main.entity.Subject;
import java.util.List;


public interface SubjectDao extends JpaRepository<Subject, Long>{
	
	Subject findByName(String name);

}
