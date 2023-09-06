package com.tema4.CourseEnrollment.controller;

import com.tema4.CourseEnrollment.model.Course;
import com.tema4.CourseEnrollment.model.Student;
import com.tema4.CourseEnrollment.service.CourseService;
import com.tema4.CourseEnrollment.service.EnrollmentService;
import com.tema4.CourseEnrollment.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ControllerTest {

    @InjectMocks
    Controller controller;

    @MockBean
    CourseService courseService;

    @MockBean
    StudentService studentService;

    @MockBean
    EnrollmentService enrollmentService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateStudent() {
        Student student = new Student();
        student.setName("a");
        when(studentService.addStudent(any(Student.class))).thenReturn(student);
        Student result = controller.createStudent(student);
        assertEquals("a", result.getName());
    }

    @Test
    public void testGetAllStudents() {
        Student student1 = new Student();
        student1.setName("a");
        Student student2 = new Student();
        student2.setName("b");

        when(studentService.getAllStudents()).thenReturn(Arrays.asList(student1, student2));
        List<Student> students = controller.getAllStudents();
        assertEquals(2, students.size());
        assertEquals("a", students.get(0).getName());
        assertEquals("b", students.get(1).getName());
    }
    @Test
    public void testCreateCourse() {
        Course course = new Course();
        course.setTitle("c1");
        when(courseService.addCourse(any(Course.class))).thenReturn(course);
        Course result = controller.createCourse(course);
        assertEquals("c1", result.getTitle());
    }

    @Test
    public void testGetAllCourses() {
        Course course1 = new Course();
        course1.setTitle("c1");
        Course course2 = new Course();
        course2.setTitle("c2");

        when(courseService.getAllCourses()).thenReturn(Arrays.asList(course1, course2));
        List<Course> courses = controller.getAllCourses();
        assertEquals(2, courses.size());
        assertEquals("c1", courses.get(0).getTitle());
        assertEquals("c2", courses.get(1).getTitle());
    }

    @Test
    public void testEnrollStudent() {
        // Assuming the method enrollStudent does not have a return type, we'll focus on verifying the call
        doNothing().when(enrollmentService).enrollStudent(anyInt(), anyInt());
        controller.enrollStudent(1, 1);
        verify(enrollmentService, times(1)).enrollStudent(1, 1);
    }

    @Test
    public void testGetStudentCourses() {
        Course course1 = new Course();
        course1.setTitle("c1");
        Course course2 = new Course();
        course2.setTitle("c2");

        when(enrollmentService.getStudentCourses(1)).thenReturn(Arrays.asList(course1, course2));
        List<Course> courses = controller.getStudentCourses(1);
        assertEquals(2, courses.size());
        assertEquals("c1", courses.get(0).getTitle());
        assertEquals("c2", courses.get(1).getTitle());
    }


}
