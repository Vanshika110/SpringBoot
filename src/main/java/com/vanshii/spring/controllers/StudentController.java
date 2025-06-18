package com.vanshii.spring.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vanshii.spring.Exceptions.NotFoundExceptions;
import com.vanshii.spring.entities.Student;
import com.vanshii.spring.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addStudent(@RequestBody Student student) {
        try {
            return ResponseEntity.ok(this.studentService.addStudent(student));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(Map.of("error", e.getMessage()));
        }
    }

    @GetMapping("/{sid}")
    public ResponseEntity<?> getStudentByid(@PathVariable(name = "sid") long student) {
        try {
            Student stud = this.studentService.getStudentById(student);
            // return ResponseEntity.ok(stud);
            return new ResponseEntity<>(stud, HttpStatus.OK);
        } catch (com.vanshii.spring.Exceptions.NotFoundExceptions e) {
            return new ResponseEntity<>(Map.of("msg", e.getMessage()), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(Map.of("error", e.getMessage()));
        }
    }

    @PutMapping("/{studentid}")
    public ResponseEntity<?> updateStudent(@PathVariable long studentid, @RequestBody @Valid Student student) {
        try {
            if (studentid != student.getId()) {
                // error
                return ResponseEntity.badRequest().body(Map.of("msg", "body in path and body not same"));
            }
            Student updatedstudent = this.studentService.updateStudent(student);
            return ResponseEntity.ok(updatedstudent);
        } catch (NotFoundExceptions e) {
            return new ResponseEntity<>(Map.of("msg", e.getMessage()), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(Map.of("error", e.getMessage()));

        }
    }

    @DeleteMapping("/{studentid}")
    public ResponseEntity<?> deleteStudent(@PathVariable long studentid) {
        try {
            this.studentService.deleteStudent(studentid);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(Map.of("error", e.getMessage()));
        }
    }
}
