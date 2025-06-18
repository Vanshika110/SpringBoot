package com.vanshii.spring.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vanshii.spring.entities.Course;
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
