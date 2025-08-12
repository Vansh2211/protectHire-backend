package com.newProject.protectHire.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Pageable;

import com.newProject.protectHire.dto.booking.BookingDTO;
import com.newProject.protectHire.dto.booking.BookingRequest;
import com.newProject.protectHire.dto.booking.BookingResponse;
import com.newProject.protectHire.dto.booking.BookingStatsDTO;

import jakarta.validation.Valid;

public class BookingService {

    public BookingResponse createBooking(BookingRequest request, String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createBooking'");
    }

    public List<BookingDTO> getClientBookings(UUID clientId, Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getClientBookings'");
    }

    public List<BookingDTO> getGuardBookings(UUID guardId, Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getGuardBookings'");
    }

    public BookingDTO getBookingById(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBookingById'");
    }

    public void updateBookingStatus(UUID id, String status, String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateBookingStatus'");
    }

    public void cancelBooking(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cancelBooking'");
    }

    public BookingStatsDTO getBookingById(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBookingById'");
    }

}
