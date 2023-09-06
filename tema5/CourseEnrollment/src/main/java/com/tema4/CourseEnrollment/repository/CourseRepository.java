package com.tema4.CourseEnrollment.repository;

import com.tema4.CourseEnrollment.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
}
