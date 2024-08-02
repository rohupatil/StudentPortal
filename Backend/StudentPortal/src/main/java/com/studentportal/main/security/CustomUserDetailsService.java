package com.studentportal.main.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.studentportal.main.DAO.AdminDao;
import com.studentportal.main.DAO.StudentDao;
import com.studentportal.main.entity.Admin;
import com.studentportal.main.entity.Student;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private StudentDao studentRepo;

    @Autowired
    private AdminDao adminRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student = studentRepo.findByName(username);
        if (student != null) {
            return new org.springframework.security.core.userdetails.User(student.getUsername(), student.getPassword(), student.getAuthorities());
        }

        Admin admin = adminRepo.findByName(username);
        System.out.println("Admin name="+admin);
        if (admin != null) {
            return new org.springframework.security.core.userdetails.User(admin.getUsername(), admin.getPassword(), admin.getAuthorities());
        }

        throw new UsernameNotFoundException("User not found");
    }
}
