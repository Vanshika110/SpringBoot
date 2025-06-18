package com.vanshii.spring.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vanshii.spring.entities.Course;
import com.vanshii.spring.entities.Enrollment;
import com.vanshii.spring.entities.Student;

@Repository
public interface enrollmentRepository extends JpaRepository<Enrollment, Long> {
    long countByCourse(Course course);

    List<Enrollment> findByStudent(Student student);

    // List<Enrollment> findByStudentandStatus(Student student, EnrollmentStatus
    // status );
}
