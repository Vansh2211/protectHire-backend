package com.newProject.protectHire.dto.booking;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

public class BookingDTO {
    
    private UUID id;
    private UUID guardId;
    private String guardName;
    private UUID clientId;
    private String clientName;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private String address;
    private String instructions;
    private BigDecimal estimatedCost;
    private String status;
    private LocalDateTime createdAt;
    
    // Constructors
    public BookingDTO() {}
    
    public BookingDTO(UUID id, UUID guardId, String guardName, UUID clientId, String clientName,
                     LocalDate startDate, LocalDate endDate, LocalTime startTime, LocalTime endTime,
                     String address, String instructions, BigDecimal estimatedCost, String status,
                     LocalDateTime createdAt) {
        this.id = id;
        this.guardId = guardId;
        this.guardName = guardName;
        this.clientId = clientId;
        this.clientName = clientName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.address = address;
        this.instructions = instructions;
        this.estimatedCost = estimatedCost;
        this.status = status;
        this.createdAt = createdAt;
    }
    
    // Getters and Setters
    public UUID getId() {
        return id;
    }
    
    public void setId(UUID id) {
        this.id = id;
    }
    
    public UUID getGuardId() {
        return guardId;
    }
    
    public void setGuardId(UUID guardId) {
        this.guardId = guardId;
    }
    
    public String getGuardName() {
        return guardName;
    }
    
    public void setGuardName(String guardName) {
        this.guardName = guardName;
    }
    
    public UUID getClientId() {
        return clientId;
    }
    
    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }
    
    public String getClientName() {
        return clientName;
    }
    
    public void setClientName(String clientName) {
        this.clientName = clientName;
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
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setGuardPhone(Object phoneNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setGuardPhone'");
    }

    public void setClientPhone(Object phoneNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setClientPhone'");
    }

    public void setActualCost(BigDecimal actualCost) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setActualCost'");
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setUpdatedAt'");
    }
}