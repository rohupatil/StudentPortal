package com.studentportal.main.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.studentportal.main.DTO.StudentDto;
import com.studentportal.main.DTO.StudentResponseDto;

public interface StudentService {
	
	ResponseEntity<?> createStudent(StudentDto student);
	
	List<StudentResponseDto> getallStudents();
}
