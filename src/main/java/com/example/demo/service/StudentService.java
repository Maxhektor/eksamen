package com.example.demo.service;


import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;

    //Get all students
    public ResponseEntity<List<Student>> getAllStudents()
    {
        List<Student> studentList = studentRepo.findAll();
        if(studentList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(studentList,HttpStatus.OK);
    }

    //Get a student by id
    public ResponseEntity<Student> getStudentById(int id) {
        Student student = studentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));

        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    //Create a student
    public ResponseEntity<Student> createStudent(Student student) {
        return new ResponseEntity<>(studentRepo.save(student), HttpStatus.CREATED);
    }

    //Update a student
    public ResponseEntity<Student> updateStudent(int id, Student student) {
        Student _student = studentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));
        _student.setStudentName(student.getStudentName());
        _student.setStudentEmail(student.getStudentEmail());

        return new ResponseEntity<>(studentRepo.save(_student), HttpStatus.OK);
    }

    //Delete a student
    public ResponseEntity<HttpStatus> deleteStudent(int id) {
        studentRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
