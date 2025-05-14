package com.vanshii.spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vanshii.spring.entities.Student;
import com.vanshii.spring.repositry.StudentRepositry;

@Service
public class StudentService {
    private final StudentRepositry studentRepositry;

    @Autowired
    public StudentService(StudentRepositry studentRepositry) {
        this.studentRepositry = studentRepositry;
    }

    public Student addStudent(Student student) {
        return this.studentRepositry.save(student);
    }

    public Student getStudentById(long studentid) {
        Optional<Student> optionalValue = this.studentRepositry.findById(studentid);
        if (optionalValue.isEmpty()) {
            return null;
        }
        return optionalValue.get();
    }

  public Student updateStudent(Student student){
        Student existingStudent=this.getStudentById(student.getId());
        if(existingStudent==null)
        return null;
existingStudent.setFirstn(student.getFirstn());
existingStudent.setLastn(student.getLastn());
return this.studentRepositry.save(existingStudent);
    }

    public void deleteStudent(long studentid) {
        this.studentRepositry.deleteById(studentid);
    }
}
