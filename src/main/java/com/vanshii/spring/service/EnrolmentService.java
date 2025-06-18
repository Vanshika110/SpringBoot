package com.vanshii.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vanshii.spring.entities.Enrollment;
import com.vanshii.spring.repositry.enrollmentRepository;

@Service
public class EnrolmentService {
    private final enrollmentRepository enrollmentrepository;

    @Autowired
    public EnrolmentService(enrollmentRepository enrollmentrepository) {
        this.enrollmentrepository = enrollmentrepository;
    }

    public Enrollment addEnrollment(Enrollment enrollment) {
        if(enrollment.getEnroldate().isAfter(enrollment.getCourse().getStartdate())){
//throw an exception
        }
        if(this.enrollmentrepository.countByCourse(enrollment.getCourse()) +1  >= enrollment.getCourse().getCapacity()){
            //throw an exception
        }
        return this.enrollmentrepository.save(enrollment);
    }
}
