package com.studentportal.main.DTO;

import java.util.Set;

import com.studentportal.main.entity.Student;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class SubjectDto {

	
	public SubjectDto() {
		// TODO Auto-generated constructor stub
	}

	private String name;
}
