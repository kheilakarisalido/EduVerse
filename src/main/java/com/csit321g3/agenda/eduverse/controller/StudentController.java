package com.csit321g3.agenda.eduverse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csit321g3.agenda.eduverse.entity.Student;
import com.csit321g3.agenda.eduverse.service.StudentService;

@RestController
@RequestMapping(path = "/api/students")
public class StudentController {

    @Autowired
    StudentService sserv;

    // C
    @PostMapping
    public Student create(@RequestBody Student student) {
        return sserv.postStudent(student);
    }

    // R all
    @GetMapping
    public List<Student> getAll() {
        return sserv.getAllStudents();
    }

    // R one
    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {
        return sserv.getStudentById(id);
    }
    
    // U
    @PutMapping("/{id}")
    public Student update(
            @PathVariable Long id,
            @RequestBody Student student) {

        return sserv.putStudent(id, student);
    }

    // D
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        sserv.deleteStudent(id);
    }
}