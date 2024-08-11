package com.studentportal.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.studentportal.main.DAO.SubjectDao;
import com.studentportal.main.DTO.SubjectDto;
import com.studentportal.main.DTO.SubjectResponseDto;
import com.studentportal.main.entity.Subject;

@Service
public class SubjcetServiceImpl implements SubjectService {
	@Autowired
	private SubjectDao subdao;

	@Override
	public ResponseEntity<?> addSubject(SubjectDto subDto) {
		// TODO Auto-generated method stub
		SubjectResponseDto responsedto = new SubjectResponseDto();
		Subject sub = new Subject();
		
		if (subDto != null) {
			try {
				responsedto.setSubjeactname(subDto.getName());
				sub.setName(subDto.getName());
				subdao.save(sub);
	            return ResponseEntity.ok(responsedto);
			} catch (DataIntegrityViolationException e) {
				// TODO: handle exception
                return ResponseEntity.badRequest().body("Subject name already exists. Please choose a different name.");

			}
		}
		return null;
	}

	@Override
	public List<Subject> getAllSubject() {
		// TODO Auto-generated method stub
		
		return subdao.findAll();
	}

}
