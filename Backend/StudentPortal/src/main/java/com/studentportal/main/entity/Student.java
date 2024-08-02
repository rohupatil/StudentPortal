package com.studentportal.main.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Student extends BaseEntity implements UserDetails{
	
	@Column(unique = true)
	private String name;
	
	private String address;
	
	private String password;
	
    @Enumerated(EnumType.STRING)
    private Role role;

public Student() {
	// TODO Auto-generated constructor stub
}
	
	  @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(
	        name = "student_subject",
	        joinColumns = @JoinColumn(name = "student_id"),
	        inverseJoinColumns = @JoinColumn(name = "subject_id")
	        )
	    private Set<Subject> subjects = new HashSet<>();
	  
	  
	  public void addSubject(Subject subject) {
	        subjects.add(subject);
	        subject.getStudents().add(this); 
	    }


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		  Set<GrantedAuthority> authorities = new HashSet<>();
	        authorities.add(new SimpleGrantedAuthority("ROLE_STUDENT"));
	        return authorities;
	}


	@Override
	@JsonIgnore
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.name;
	}
}
