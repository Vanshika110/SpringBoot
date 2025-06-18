package com.vanshii.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vanshii.spring.entities.Course;
import com.vanshii.spring.repositry.CourseRepository;
@Service
public class CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course addCourse(Course course) {
        return this.courseRepository.save(course);
    }

    public Course getCourseById(long courseId) {
        return this.courseRepository.findById(courseId).orElse(null);
    }
}
