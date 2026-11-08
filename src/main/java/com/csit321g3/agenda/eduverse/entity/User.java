package com.csit321g3.agenda.eduverse.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;
    private String email;
    private String password;
    private LocalDateTime createdAt; 
    private LocalDateTime lastLoginTime;
    private String role;

    @ManyToOne
    @JoinColumn(name = "campus_id")
    private Campus campus;

    public Long getUserID() {
        return userID;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getLastLoginTime() {
        return lastLoginTime;
    }

    public String getRole() {
        return role;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setLastLoginTime(LocalDateTime lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }
}