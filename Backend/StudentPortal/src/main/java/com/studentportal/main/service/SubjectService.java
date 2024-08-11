package com.studentportal.main.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.studentportal.main.DTO.SubjectDto;
import com.studentportal.main.DTO.SubjectResponseDto;
import com.studentportal.main.entity.Subject;

public interface SubjectService {
	
	ResponseEntity<?> addSubject(SubjectDto subDto);
	
	List<Subject> getAllSubject();

}
