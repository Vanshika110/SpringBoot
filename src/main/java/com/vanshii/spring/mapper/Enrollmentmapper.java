package com.vanshii.spring.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vanshii.spring.Dto.EnrollmentDto;
import com.vanshii.spring.Exceptions.NotFoundExceptions;
import com.vanshii.spring.entities.Course;
import com.vanshii.spring.entities.Enrollment;
import com.vanshii.spring.entities.Student;
import com.vanshii.spring.repositry.CourseRepository;
import com.vanshii.spring.repositry.StudentRepositry;

@Component
public class Enrollmentmapper {
    private final StudentRepositry studentRepositry;
    private final CourseRepository courseRepository;

    @Autowired
    public Enrollmentmapper(StudentRepositry studentRepositry, CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
        this.studentRepositry = studentRepositry;
    }

    public Enrollment mapToModel(EnrollmentDto dto) {
        Student s = this.studentRepositry.findById(dto.getStudentid())
                .orElseThrow(() -> new NotFoundExceptions("Student with id:" + dto.getStudentid() + "doesn't exist"));
        Course c = this.courseRepository.findById(dto.getCourseid())
                .orElseThrow(() -> new NotFoundExceptions("course with id:" + dto.getCourseid() + "doesn't exist"));
    Enrollment e=new Enrollment();
    e.setCourse(c);
    e.setStudent(s);
    e.setStatus(dto.getStatus());
    e.setEnroldate(dto.getEnroldate());
    return e;

            }
}
