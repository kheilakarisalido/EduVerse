package com.csit321g3.agenda.eduverse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csit321g3.agenda.eduverse.entity.Student;
public interface StudentRepository extends JpaRepository<Student, Long>
{}