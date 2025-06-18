package com.vanshii.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vanshii.spring.Dto.EnrollmentDto;
import com.vanshii.spring.entities.Enrollment;
import com.vanshii.spring.mapper.Enrollmentmapper;
import com.vanshii.spring.service.EnrolmentService;

@RestController
@RequestMapping("/enrolment")
public class EnrollmentController {
    private final EnrolmentService enrolmentService;
    private final Enrollmentmapper enrollmentmapper;

    @Autowired
    public EnrollmentController(EnrolmentService enrolmentService, Enrollmentmapper enrollmentmapper) {
        this.enrolmentService = enrolmentService;
        this.enrollmentmapper = enrollmentmapper;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addEnrollment(@RequestBody EnrollmentDto enrollmentDto) {
        Enrollment enrollment = this.enrollmentmapper.mapToModel(enrollmentDto);
        return new ResponseEntity<>(this.enrolmentService.addEnrollment(enrollment), HttpStatus.CREATED);
    }
}
