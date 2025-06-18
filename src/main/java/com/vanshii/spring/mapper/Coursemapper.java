package com.vanshii.spring.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vanshii.spring.Dto.CourseDto;
import com.vanshii.spring.Exceptions.NotFoundExceptions;
import com.vanshii.spring.entities.Course;
import com.vanshii.spring.entities.Mentor;
import com.vanshii.spring.repositry.MentorRepository;

@Component
public class Coursemapper {
private final MentorRepository mentorRepository;
@Autowired
public Coursemapper(MentorRepository mentorRepository){
    this.mentorRepository=mentorRepository;
}
public Course mapToModel(CourseDto dto){
Course c=new Course();
Mentor m=this.mentorRepository.findById(dto.getMentorId()).orElseThrow(()-> new NotFoundExceptions("Cannot find mentor with Id:" +dto.getMentorId()));
c.setName(dto.getName());
c.setPrice(dto.getPrice());
c.setCapacity(dto.getCapacity());
c.setNoOfDays(dto.getNoOfDays());
c.setStartdate(dto.getStartdate());
c.setDescen(dto.getDescen());
c.setMentor(m);
c.setEnroldate(dto.getEnroldate());
return c;
}
}
