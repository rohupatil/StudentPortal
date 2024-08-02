package com.studentportal.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentportal.main.DAO.StudentDao;
import com.studentportal.main.DTO.StudentDto;
import com.studentportal.main.entity.Student;
import com.studentportal.main.service.StudentService;

@RestController
@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@PostMapping("/add")
	public ResponseEntity<?> createStudent(@RequestBody StudentDto student)
	{
		return ResponseEntity.ok(service.createStudent(student));
	}
	

}
