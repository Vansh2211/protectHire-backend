package com.newProject.protectHire.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "guard_profiles")
public class GuardProfile {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;
    
    @Column(name = "full_name", nullable = false)
    private String fullName;
    
    @Column(nullable = false)
    private String phone;
    
    @Column(nullable = false)
    private String role;
    
    @Column(nullable = false)
    private Integer experience;
    
    @Column(nullable = false)
    private String location;
    
    @Column(name = "hourly_rate", precision = 10, scale = 2)
    private BigDecimal hourlyRate;
    
    @Column(name = "daily_rate", precision = 10, scale = 2)
    private BigDecimal dailyRate;
    
    @Column(name = "monthly_rate", precision = 10, scale = 2)
    private BigDecimal monthlyRate;
    
    @Column(columnDefinition = "TEXT")
    private String bio;
    
    @Column(columnDefinition = "TEXT")
    private String skills; // JSON array or comma-separated
    
    @Column(name = "profile_picture_url", length = 500)
    private String profilePictureUrl;
    
    @Column(precision = 3, scale = 2)
    private BigDecimal rating = BigDecimal.ZERO;
    
    @Column(name = "total_ratings")
    private Integer totalRatings = 0;
    
    @Column(name = "is_available")
    private Boolean isAvailable = true;
    
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    
    // Constructors
    public GuardProfile() {}
    
    public GuardProfile(User user, String fullName, String phone, String role, 
                       Integer experience, String location) {
        this.user = user;
        this.fullName = fullName;
        this.phone = phone;
        this.role = role;
        this.experience = experience;
        this.location = location;
    }
    
    // Getters and Setters
    public UUID getId() {
        return id;
    }
    
    public void setId(UUID id) {
        this.id = id;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public String getFullName() {
        return fullName;
    }
    
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getRole() {
        return role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    
    public Integer getExperience() {
        return experience;
    }
    
    public void setExperience(Integer experience) {
        this.experience = experience;
    }
    
    public String getLocation() {
        return location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public BigDecimal getHourlyRate() {
        return hourlyRate;
    }
    
    public void setHourlyRate(BigDecimal hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
    
    public BigDecimal getDailyRate() {
        return dailyRate;
    }
    
    public void setDailyRate(BigDecimal dailyRate) {
        this.dailyRate = dailyRate;
    }
    
    public BigDecimal getMonthlyRate() {
        return monthlyRate;
    }
    
    public void setMonthlyRate(BigDecimal monthlyRate) {
        this.monthlyRate = monthlyRate;
    }
    
    public String getBio() {
        return bio;
    }
    
    public void setBio(String bio) {
        this.bio = bio;
    }
    
    public String getSkills() {
        return skills;
    }
    
    public void setSkills(String skills) {
        this.skills = skills;
    }
    
    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }
    
    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }
    
    public BigDecimal getRating() {
        return rating;
    }
    
    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }
    
    public Integer getTotalRatings() {
        return totalRatings;
    }
    
    public void setTotalRatings(Integer totalRatings) {
        this.totalRatings = totalRatings;
    }
    
    public Boolean getIsAvailable() {
        return isAvailable;
    }
    
    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}