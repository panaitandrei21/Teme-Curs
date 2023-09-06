package com.tema4.CourseEnrollment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    @OneToMany
    List<Enrollment> enrollments;

}
