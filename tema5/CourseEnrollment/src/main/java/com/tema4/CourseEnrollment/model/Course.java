package com.tema4.CourseEnrollment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Data
public class Course {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;

    @OneToMany
    List<Enrollment> enrollments;



}
