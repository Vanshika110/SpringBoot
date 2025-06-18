package com.vanshii.spring.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vanshii.spring.entities.Enrollment;
@Repository
public interface enrollmentRepository extends JpaRepository<Enrollment,Long>{

}
