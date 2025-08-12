package com.newProject.protectHire.dto.booking;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class BookingRequest {
    
    @NotNull
    private UUID guardId;
    
    @NotNull
    private UUID clientId;
    
    @NotNull
    private LocalDate startDate;
    
    @NotNull
    private LocalDate endDate;
    
    @NotNull
    private LocalTime startTime;
    
    @NotNull
    private LocalTime endTime;
    
    @NotBlank
    private String address;
    
    private String instructions;
    
    @NotNull
    private BigDecimal estimatedCost;
    
    // Constructors
    public BookingRequest() {}
    
    public BookingRequest(UUID guardId, UUID clientId, LocalDate startDate, LocalDate endDate, 
                         LocalTime startTime, LocalTime endTime, String address, BigDecimal estimatedCost) {
        this.guardId = guardId;
        this.clientId = clientId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.address = address;
        this.estimatedCost = estimatedCost;
    }
    
    // Getters and Setters
    public UUID getGuardId() {
        return guardId;
    }
    
    public void setGuardId(UUID guardId) {
        this.guardId = guardId;
    }
    
    public UUID getClientId() {
        return clientId;
    }
    
    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }
    
    public LocalDate getStartDate() {
        return startDate;
    }
    
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    
    public LocalDate getEndDate() {
        return endDate;
    }
    
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    
    public LocalTime getStartTime() {
        return startTime;
    }
    
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }
    
    public LocalTime getEndTime() {
        return endTime;
    }
    
    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getInstructions() {
        return instructions;
    }
    
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
    
    public BigDecimal getEstimatedCost() {
        return estimatedCost;
    }
    
    public void setEstimatedCost(BigDecimal estimatedCost) {
        this.estimatedCost = estimatedCost;
    }
}