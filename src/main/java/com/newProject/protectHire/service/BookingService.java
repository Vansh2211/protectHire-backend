package com.newProject.protectHire.service;

import com.newProject.protectHire.dto.booking.BookingDTO;
import com.newProject.protectHire.dto.booking.BookingRequest;
import com.newProject.protectHire.dto.booking.BookingResponse;
import com.newProject.protectHire.dto.booking.BookingStatsDTO;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.UUID;

public interface BookingService {
    BookingResponse createBooking(BookingRequest request, String userEmail);
    BookingDTO getBookingById(UUID bookingId);
    List<BookingDTO> getClientBookings(UUID clientId, Pageable pageable);
    List<BookingDTO> getGuardBookings(UUID guardId, Pageable pageable);
    void updateBookingStatus(UUID bookingId, String status, String userEmail);
    void cancelBooking(UUID bookingId);
    BookingStatsDTO getBookingStats(String userEmail);
    List<BookingDTO> getBookingsForDate(String date);
    boolean isGuardAvailable(UUID guardId, String startDate, String endDate);
}