package com.csit321g3.agenda.eduverse.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
public class StudyGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupId;
    private String name;
    private Integer groupStreak;
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "campus_id")
    private Campus campus;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    public StudyGroup(){
    }

    public Long getGroupId() {
        return groupId;
    }

    public String getName() {
        return name;
    }

    public Integer getGroupStreak() {
        return groupStreak;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Campus getCampus() {
        return campus;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGroupStreak(Integer groupStreak) {
        this.groupStreak = groupStreak;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }
}