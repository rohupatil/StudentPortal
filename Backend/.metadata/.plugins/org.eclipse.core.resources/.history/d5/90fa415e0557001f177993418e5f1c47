package com.studentportal.main.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Subject extends BaseEntity {
    
	@Column(unique = true)
	private String name;

	public Subject() {
		// TODO Auto-generated constructor stub
	}

	@ManyToMany(mappedBy = "subjects" ,fetch = FetchType.LAZY)
	@JsonIgnore    //  used this to avoid recurrecursion 
	private Set<Student> students = new HashSet<>();

	public void addStudent(Student student) {
		students.add(student);
		student.getSubjects().add(this); 
	}
}
