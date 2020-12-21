package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;


    //Get all students
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents(){
        return studentService.getAllStudents();
    }

    //Get Student by id
    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") int id){
        return studentService.getStudentById(id);
    }

    //Create a student
    @PostMapping("/students")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    //Update a student
    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") int id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    //Delete a Student
    @DeleteMapping("/students/{id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable("id") int id) {
        return studentService.deleteStudent(id);
    }
}
