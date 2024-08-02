package com.studentportal.main.DTO;

import com.studentportal.main.entity.Role;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StudentResponseDto {
	
	private String name;

	private String address;

	private Role role;
	
	public StudentResponseDto() {
		// TODO Auto-generated constructor stub
	}

}
