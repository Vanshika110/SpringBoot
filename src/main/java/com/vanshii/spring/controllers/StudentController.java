package com.vanshii.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vanshii.spring.entities.Student;
import com.vanshii.spring.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/student/add")
    public Student addStudent(@RequestBody Student student) {
        return this.studentService.addStudent(student);
    }

    @GetMapping("/student/{studentid}")
    public Student getStudentByid(@PathVariable(name="studentid") long student) {
        return this.studentService.getStudentById(student);
    }

    @PutMapping("/student/{studentid}")
    public Student updateStudent(@PathVariable long studentid, @RequestBody long studentid){
        if(studentid != student.getId()){
            //error
        }
        return this.studentService.updateStudent(student);
    }
  

    @DeleteMapping("/student/{studentid}")
    public void deleteStudent(@PathVariable long studentid) {
        this.studentService.deleteStudent(studentid);
    }
}
