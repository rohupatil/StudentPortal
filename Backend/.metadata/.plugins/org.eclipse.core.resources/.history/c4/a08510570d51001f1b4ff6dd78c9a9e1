package com.studentportal.main.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.studentportal.main.DAO.StudentDao;
import com.studentportal.main.DAO.SubjectDao;
import com.studentportal.main.DTO.StudentDto;
import com.studentportal.main.entity.Role;
import com.studentportal.main.entity.Student;
import com.studentportal.main.entity.Subject;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentServiceImpl implements  StudentService{
	

	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Autowired
	private StudentDao dao;
	
	@Autowired
	private SubjectDao subdao;

	@Override
	@Transactional
	public ResponseEntity<?> createStudent(StudentDto studentDto) {
		String pass=	passwordEncoder.encode(studentDto.getPassword());

        try {
            if (studentDto != null) {
                Student stu = new Student();
                stu.setAddress(studentDto.getAddress());
                stu.setName(studentDto.getName());
                stu.setPassword(pass);
                stu.setRole(Role.STUDENT);

                Set<Subject> subjects = new HashSet<>();
                
                if (studentDto.getSubjectNames() != null) {
                    for (String subjectName : studentDto.getSubjectNames()) {
                        Subject su = subdao.findByName(subjectName);
                        if (su == null) {
                            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Subject with name " + subjectName + " does not exist.");
                        }
                        subjects.add(su);
                    }
                }

                stu.setSubjects(subjects);
                Student savedStudent = dao.save(stu);

                for (Subject subject : subjects) {
                    subject.getStudents().add(savedStudent);
                    subdao.save(subject);
                }

                return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Student data is not provided.");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + ex.getMessage());
        }
    }

	@Override
	public List<Student> getallStudents() {
		// TODO Auto-generated method stub
		
		return dao.findAll();
	}

}
