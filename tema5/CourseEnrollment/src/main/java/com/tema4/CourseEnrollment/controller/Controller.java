package com.tema4.CourseEnrollment.controller;

import com.tema4.CourseEnrollment.model.Course;
import com.tema4.CourseEnrollment.model.Student;
import com.tema4.CourseEnrollment.service.CourseService;
import com.tema4.CourseEnrollment.service.EnrollmentService;
import com.tema4.CourseEnrollment.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {
    @Autowired
    CourseService courseService;
    @Autowired
    StudentService studentService;
    @Autowired
    EnrollmentService enrollmentService;


    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }


    @PostMapping("/courses")
    public Course createCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @PostMapping("/enroll")
    public void enrollStudent(@RequestParam Integer studentId, @RequestParam Integer courseId) {
        enrollmentService.enrollStudent(studentId, courseId);
    }

    @GetMapping("/students/{id}/courses")
    public List<Course> getStudentCourses(@PathVariable Integer id) {
        return enrollmentService.getStudentCourses(id);
    }

}
