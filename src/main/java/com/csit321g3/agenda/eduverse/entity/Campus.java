package com.csit321g3.agenda.eduverse.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
public class Campus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long campusId;
    private String name;
    private String domain;
    private LocalDateTime createdAt;

    public Campus(Long campusId, String name, String domain, LocalDateTime createdAt) {
        this.campusId = campusId;
        this.name = name;
        this.domain = domain;
        this.createdAt = createdAt;
    }
    public Campus() {
    }
    public Long getCampusId() {
        return campusId;
    }
    public String getName() {
        return name;
    }
    public String getDomain() {
        return domain;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCampusId(Long campusId) {
        this.campusId = campusId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDomain(String domain) {
        this.domain = domain;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    
}