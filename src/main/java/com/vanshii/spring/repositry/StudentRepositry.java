package com.vanshii.spring.repositry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vanshii.spring.entities.Student;

@Repository
public interface StudentRepositry extends JpaRepository<Student,Long>{


}

    

