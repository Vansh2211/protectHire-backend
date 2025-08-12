package com.newProject.protectHire.dto.booking;

import java.math.BigDecimal;

public class BookingStatsDTO {
    
    private long totalBookings;
    private long pendingBookings;
    private long acceptedBookings;
    private long completedBookings;
    private long cancelledBookings;
    private BigDecimal totalEarnings;
    private BigDecimal monthlyEarnings;
    private BigDecimal averageBookingValue;
    private double acceptanceRate;
    
    // Constructors
    public BookingStatsDTO() {}
    
    public BookingStatsDTO(long totalBookings, long pendingBookings, long acceptedBookings, 
                          long completedBookings, long cancelledBookings, BigDecimal totalEarnings, 
                          BigDecimal monthlyEarnings) {
        this.totalBookings = totalBookings;
        this.pendingBookings = pendingBookings;
        this.acceptedBookings = acceptedBookings;
        this.completedBookings = completedBookings;
        this.cancelledBookings = cancelledBookings;
        this.totalEarnings = totalEarnings;
        this.monthlyEarnings = monthlyEarnings;
        
        // Calculate derived values
        if (totalBookings > 0) {
            this.averageBookingValue = totalEarnings.divide(BigDecimal.valueOf(totalBookings), 2, BigDecimal.ROUND_HALF_UP);
            this.acceptanceRate = (double) acceptedBookings / totalBookings * 100;
        } else {
            this.averageBookingValue = BigDecimal.ZERO;
            this.acceptanceRate = 0.0;
        }
    }
    
    // Getters and Setters
    public long getTotalBookings() {
        return totalBookings;
    }
    
    public void setTotalBookings(long totalBookings) {
        this.totalBookings = totalBookings;
    }
    
    public long getPendingBookings() {
        return pendingBookings;
    }
    
    public void setPendingBookings(long pendingBookings) {
        this.pendingBookings = pendingBookings;
    }
    
    public long getAcceptedBookings() {
        return acceptedBookings;
    }
    
    public void setAcceptedBookings(long acceptedBookings) {
        this.acceptedBookings = acceptedBookings;
    }
    
    public long getCompletedBookings() {
        return completedBookings;
    }
    
    public void setCompletedBookings(long completedBookings) {
        this.completedBookings = completedBookings;
    }
    
    public long getCancelledBookings() {
        return cancelledBookings;
    }
    
    public void setCancelledBookings(long cancelledBookings) {
        this.cancelledBookings = cancelledBookings;
    }
    
    public BigDecimal getTotalEarnings() {
        return totalEarnings;
    }
    
    public void setTotalEarnings(BigDecimal totalEarnings) {
        this.totalEarnings = totalEarnings;
    }
    
    public BigDecimal getMonthlyEarnings() {
        return monthlyEarnings;
    }
    
    public void setMonthlyEarnings(BigDecimal monthlyEarnings) {
        this.monthlyEarnings = monthlyEarnings;
    }
    
    public BigDecimal getAverageBookingValue() {
        return averageBookingValue;
    }
    
    public void setAverageBookingValue(BigDecimal averageBookingValue) {
        this.averageBookingValue = averageBookingValue;
    }
    
    public double getAcceptanceRate() {
        return acceptanceRate;
    }
    
    public void setAcceptanceRate(double acceptanceRate) {
        this.acceptanceRate = acceptanceRate;
    }
}