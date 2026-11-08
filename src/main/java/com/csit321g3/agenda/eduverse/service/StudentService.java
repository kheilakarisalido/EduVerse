package com.csit321g3.agenda.eduverse.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csit321g3.agenda.eduverse.entity.Student;
import com.csit321g3.agenda.eduverse.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    StudentRepository srepo;

    // C
    public Student postStudent(Student student) {
        return srepo.save(student);
    }

    // R all
    public List<Student> getAllStudents() {
        return srepo.findAll();
    }

    // R one
    public Student getStudentById(Long id) {
        return srepo.findById(id).get();
    }

    // U
    public Student putStudent(Long id, Student newStudentDetails) {
        Student student = newStudentDetails;

        try {
            student = srepo.findById(id).get();

            // Inherited User fields
            student.setEmail(newStudentDetails.getEmail());
            student.setPassword(newStudentDetails.getPassword());
            student.setRole(newStudentDetails.getRole());
            student.setCreatedAt(newStudentDetails.getCreatedAt());
            student.setLastLoginTime(newStudentDetails.getLastLoginTime());
            student.setCampus(newStudentDetails.getCampus());

            // Student-specific fields
            student.setDisplayName(newStudentDetails.getDisplayName());
            student.setDailyStreakCount(newStudentDetails.getDailyStreakCount());
            student.setCoinBalance(newStudentDetails.getCoinBalance());
            student.setLastStudyDate(newStudentDetails.getLastStudyDate());

        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Student ID " + id + " not found.");
        }

        return srepo.save(student);
    }

    // D
    public String deleteStudent(Long id) {
        String msg = "";

        if (srepo.findById(id).isPresent()) {
            srepo.deleteById(id);
            msg = "Student ID " + id + " successfully deleted.";
        } else {
            msg = "Student ID " + id + " not found.";
        }

        return msg;
    }
}