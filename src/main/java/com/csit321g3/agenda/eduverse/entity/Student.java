package com.csit321g3.agenda.eduverse.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;

@Entity
public class Student extends User {
    private String displayName;
    private Integer dailyStreakCount;
    private Double coinBalance;
    private LocalDateTime lastStudyDate;

    public String getDisplayName() {
        return displayName;
    }
    public Integer getDailyStreakCount() {
        return dailyStreakCount;
    }
    public Double getCoinBalance() {
        return coinBalance;
    }
    public LocalDateTime getLastStudyDate() {
        return lastStudyDate;
    }
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    public void setDailyStreakCount(Integer dailyStreakCount) {
        this.dailyStreakCount = dailyStreakCount;
    }
    public void setCoinBalance(Double coinBalance) {
        this.coinBalance = coinBalance;
    }
    public void setLastStudyDate(LocalDateTime lastStudyDate) {
        this.lastStudyDate = lastStudyDate;
    }
}