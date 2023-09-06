package com.tema4.CourseEnrollment.repository;

import com.tema4.CourseEnrollment.model.Enrollment;
import com.tema4.CourseEnrollment.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {
    public List<Enrollment> findByStudentId(Integer Id);
}
