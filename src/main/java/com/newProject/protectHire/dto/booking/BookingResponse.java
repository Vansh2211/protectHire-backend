package com.newProject.protectHire.dto.booking;

import java.util.UUID;

public class BookingResponse {
    
    private UUID bookingId;
    private String message;
    private String status;
    
    // Constructors
    public BookingResponse() {}
    
    public BookingResponse(UUID bookingId, String message) {
        this.bookingId = bookingId;
        this.message = message;
        this.status = "SUCCESS";
    }
    
    public BookingResponse(UUID bookingId, String message, String status) {
        this.bookingId = bookingId;
        this.message = message;
        this.status = status;
    }
    
    // Static factory methods
    public static BookingResponse success(UUID bookingId, String message) {
        return new BookingResponse(bookingId, message, "SUCCESS");
    }
    
    public static BookingResponse error(String message) {
        return new BookingResponse(null, message, "ERROR");
    }
    
    // Getters and Setters
    public UUID getBookingId() {
        return bookingId;
    }
    
    public void setBookingId(UUID bookingId) {
        this.bookingId = bookingId;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
}