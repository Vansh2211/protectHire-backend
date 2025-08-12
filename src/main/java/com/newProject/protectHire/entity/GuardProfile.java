package com.newProject.protectHire.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.newProject.protectHire.entity.enums.Specialization;

@Entity
@DiscriminatorValue("GUARD")
public class GuardProfile extends User {
    
    @Column(name = "hourly_rate")
    private BigDecimal hourlyRate;
    
    @Column(name = "experience_years")
    private Integer experienceYears;
    
    @Column(name = "license_number")
    private String licenseNumber;
    
    @Column(name = "license_expiry")
    private LocalDate licenseExpiry;
    
    @Column(name = "is_available")
    private Boolean isAvailable = true;
    
    @Column(columnDefinition = "TEXT")
    private String description;
    
    @Column(name = "profile_image_url")
    private String profileImageUrl;
    
    @ElementCollection
    @CollectionTable(name = "guard_specializations")
    @Enumerated(EnumType.STRING)
    private List<Specialization> specializations;
    
    @ElementCollection
    @CollectionTable(name = "guard_certifications")
    private List<String> certifications;
    
    @Column(name = "average_rating")
    private Double averageRating = 0.0;
    
    @Column(name = "total_reviews")
    private Integer totalReviews = 0;
    
    // Constructors, getters, and setters
    public GuardProfile() {}
    
    // Getters and Setters
    public BigDecimal getHourlyRate() { return hourlyRate; }
    public void setHourlyRate(BigDecimal hourlyRate) { this.hourlyRate = hourlyRate; }
    
    public Integer getExperienceYears() { return experienceYears; }
    public void setExperienceYears(Integer experienceYears) { this.experienceYears = experienceYears; }
    
    public String getLicenseNumber() { return licenseNumber; }
    public void setLicenseNumber(String licenseNumber) { this.licenseNumber = licenseNumber; }
    
    public LocalDate getLicenseExpiry() { return licenseExpiry; }
    public void setLicenseExpiry(LocalDate licenseExpiry) { this.licenseExpiry = licenseExpiry; }
    
    public Boolean getIsAvailable() { return isAvailable; }
    public void setIsAvailable(Boolean isAvailable) { this.isAvailable = isAvailable; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public String getProfileImageUrl() { return profileImageUrl; }
    public void setProfileImageUrl(String profileImageUrl) { this.profileImageUrl = profileImageUrl; }
    
    public List<Specialization> getSpecializations() { return specializations; }
    public void setSpecializations(List<Specialization> specializations) { this.specializations = specializations; }
    
    public List<String> getCertifications() { return certifications; }
    public void setCertifications(List<String> certifications) { this.certifications = certifications; }
    
    public Double getAverageRating() { return averageRating; }
    public void setAverageRating(Double averageRating) { this.averageRating = averageRating; }
    
    public Integer getTotalReviews() { return totalReviews; }
    public void setTotalReviews(Integer totalReviews) { this.totalReviews = totalReviews; }
}