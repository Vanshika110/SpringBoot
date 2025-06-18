package com.vanshii.spring.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vanshii.spring.entities.Mentor;

@Repository
public interface MentorRepository extends JpaRepository<Mentor,Long>{


}
