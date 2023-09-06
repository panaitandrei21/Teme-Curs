package com.tema4.CourseEnrollment.service;

import com.tema4.CourseEnrollment.model.Student;
import com.tema4.CourseEnrollment.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public Student addStudent(Student student) {
        studentRepository.save(student);
        return student;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

}
