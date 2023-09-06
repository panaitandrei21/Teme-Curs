package com.tema4.CourseEnrollment.service;

import com.tema4.CourseEnrollment.model.Course;
import com.tema4.CourseEnrollment.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;
    public Course addCourse(Course course) {
        courseRepository.save(course);
        return course;
    }
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
}
