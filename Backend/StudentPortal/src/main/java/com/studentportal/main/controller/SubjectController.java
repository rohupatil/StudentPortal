package com.studentportal.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentportal.main.DTO.SubjectDto;
import com.studentportal.main.DTO.SubjectResponseDto;
import com.studentportal.main.service.SubjectService;

@RestController
@Controller
@RequestMapping("/subject")
public class SubjectController {
	
	@Autowired
	private SubjectService service;
	
	@PostMapping
	public ResponseEntity<SubjectResponseDto> addSubject(@RequestBody SubjectDto dto){
		
		return ResponseEntity.ok(service.addSubject(dto));
	}

}
