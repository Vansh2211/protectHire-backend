package com.newProject.protectHire.dto.user;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class GuardProfileDTO {
    private UUID id;
    private String name;
    private String role;
    private String location;
    private BigDecimal hourlyRate;
    private BigDecimal dailyRate;
    private BigDecimal monthlyRate;
    private BigDecimal rating;
    private Integer experience;
    private List<String> skills;
    private String bio;
    private String profilePictureUrl;
    
    // Constructors, getters, setters
}