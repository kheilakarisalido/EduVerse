package com.csit321g3.agenda.eduverse.entity;

import jakarta.persistence.*;
@Entity
public class Achievement {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long achievementId;
    private String achievementName;
    private Double rewardCoins;
    private String description;
    private String icon;
    public Achievement() {
    }
    public Long getAchievementId() {
        return achievementId;
    }
    public String getAchievementName() {
        return achievementName;
    }
    public Double getRewardCoins() {
        return rewardCoins;
    }
    public String getDescription() {
        return description;
    }
    public String getIcon() {
        return icon;
    }
    public void setAchievementId(Long achievementId) {
        this.achievementId = achievementId;
    }
    public void setAchievementName(String achievementName) {
        this.achievementName = achievementName;
    }
    public void setRewardCoins(Double rewardCoins) {
        this.rewardCoins = rewardCoins;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }
}