package com.studentportal.main.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentportal.main.entity.Admin;
import java.util.List;


public interface AdminDao extends JpaRepository<Admin, Long> {
	
	Admin findByName(String name);

}
