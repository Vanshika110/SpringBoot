package com.vanshii.spring.entities;

import java.time.LocalDateTime;

import com.vanshii.spring.enums.CourseStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "enrollment")
@Getter
@Setter
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "Id", nullable = false)
    private long id;

    @ManyToOne
    @JoinColumn(name = "studentid", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "courseid", nullable = false)
    private Course course;

    @Column(name = "enroldate", nullable = false)
    private LocalDateTime enroldate;

    @Column(name = "status", nullable = false)
    private CourseStatus status = CourseStatus.ACTIVE;
}
