package com.studentportal.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentportal.main.DAO.AdminDao;
import com.studentportal.main.DAO.StudentDao;
import com.studentportal.main.entity.Admin;
import com.studentportal.main.entity.Role;
import com.studentportal.main.service.StudentService;
import com.studentportal.main.service.SubjectService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {
	
	@Autowired
	private StudentService stuserive;
	
	@Autowired
	private StudentDao studentdao;
	
	@Autowired
	private SubjectService subservice;
	
	@Autowired
	private AdminDao admindao;
	
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@PostMapping("/addadmin")
	public ResponseEntity<?> addAdmin( @RequestBody Admin admin)
	{
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		List<Admin> adm=admindao.findAll();
		
		if(adm.isEmpty())
		{
			String pass=	passwordEncoder.encode(admin.getPassword());
			admin.setPassword(pass);
				admin.setRole(Role.ADMIN);
				return ResponseEntity.ok(admindao.save(admin));
		}else {
	        return ResponseEntity.badRequest().body("Only one admin is allowed.");
		}

	
	}
	
	@GetMapping
	public ResponseEntity<?> getAllstudents()
	{
		return ResponseEntity.ok(stuserive.getallStudents());
	}
	
	@GetMapping("/allsubject")
	public ResponseEntity<?> getAllsubjects()
	{
		return ResponseEntity.ok(subservice.getAllSubject());
	}
	
	
	@GetMapping("/{id}")
	public String deleteUser(@PathVariable Long id)
	{
		studentdao.deleteById(id);
		return "deleted";
	}
	

}
