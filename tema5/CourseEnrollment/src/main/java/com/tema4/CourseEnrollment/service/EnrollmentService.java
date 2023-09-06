package com.tema4.CourseEnrollment.service;

import com.tema4.CourseEnrollment.model.Course;
import com.tema4.CourseEnrollment.model.Enrollment;
import com.tema4.CourseEnrollment.model.Student;
import com.tema4.CourseEnrollment.repository.CourseRepository;
import com.tema4.CourseEnrollment.repository.EnrollmentRepository;
import com.tema4.CourseEnrollment.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnrollmentService {
    @Autowired
    EnrollmentRepository enrollmentRepository;

    @Autowired
    CourseRepository courseRepository;  // Assuming you have this repository.

    @Autowired
    StudentRepository studentRepository;  // Assuming you have this repository.

    public void enrollStudent(Integer studentId, Integer courseId) {
        // Validate if the student and course exist (for simplicity, we're assuming that if findById doesn't find the entity, it returns null)
        Student student = studentRepository.findById(studentId).orElse(null);
        Course course = courseRepository.findById(courseId).orElse(null);

        if (student != null && course != null) {
            Enrollment enrollment = new Enrollment();
            enrollment.setStudent(student);
            enrollment.setCourse(course);
            enrollmentRepository.save(enrollment);
        } else {
            throw new IllegalArgumentException("Either the student or course does not exist.");
        }
    }
    public List<Course> getStudentCourses(Integer studentId) {
        List<Enrollment> enrollments = enrollmentRepository.findByStudentId(studentId);
        return enrollments.stream().map(Enrollment::getCourse).collect(Collectors.toList());
    }
}
