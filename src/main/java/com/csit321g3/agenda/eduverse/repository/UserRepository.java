package com.csit321g3.agenda.eduverse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csit321g3.agenda.eduverse.entity.User;
public interface UserRepository extends JpaRepository<User, Long>
{}