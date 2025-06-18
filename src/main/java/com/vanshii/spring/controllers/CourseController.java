package com.vanshii.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vanshii.spring.Dto.CourseDto;
import com.vanshii.spring.entities.Course;
import com.vanshii.spring.mapper.Coursemapper;
import com.vanshii.spring.service.CourseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/course")
public class CourseController {
    private final CourseService courseService;
    private final Coursemapper coursemapper;

    @Autowired
    public CourseController(CourseService courseService, Coursemapper coursemapper) {
        this.courseService = courseService;
        this.coursemapper = coursemapper;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCourse(@RequestBody @Valid CourseDto coursedto) {
        Course course = this.coursemapper.mapToModel(coursedto);
        return new ResponseEntity<>(this.courseService.addCourse(course), HttpStatus.CREATED);
    }
}
