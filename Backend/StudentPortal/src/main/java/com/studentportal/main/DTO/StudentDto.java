package com.studentportal.main.DTO;

import java.util.HashSet;
import java.util.Set;

import com.studentportal.main.entity.Role;
import com.studentportal.main.entity.Subject;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StudentDto {

	private String name;

	private String address;

	private String password;

	private Set<String> subjectNames = new HashSet<>();
}
