package com.studentportal.main.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentportal.main.entity.Student;
import java.util.List;


public interface StudentDao extends JpaRepository<Student, Long >{
	
	Student findByName(String name);

}
