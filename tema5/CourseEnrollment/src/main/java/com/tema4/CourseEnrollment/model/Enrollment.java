package com.tema4.CourseEnrollment.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Enrollment {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Course course;
    @ManyToOne
    private Student student;
    private Date enrollmentDate;


}
