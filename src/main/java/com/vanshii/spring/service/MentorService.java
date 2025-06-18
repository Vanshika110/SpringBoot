package com.vanshii.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vanshii.spring.entities.Mentor;
import com.vanshii.spring.repositry.MentorRepository;

@Service
public class MentorService {
private final MentorRepository mentorRepository;
@Autowired
public MentorService(MentorRepository mentorRepository){
    this.mentorRepository=mentorRepository;
}
public Mentor addMentor(Mentor mentor){
    return this.mentorRepository.save(mentor);
}
}
