package com.newProject.protectHire.controller;

import com.newProject.protectHire.dto.booking.BookingDTO;
import com.newProject.protectHire.dto.booking.BookingRequest;
import com.newProject.protectHire.dto.booking.BookingResponse;
import com.newProject.protectHire.dto.booking.BookingStatsDTO;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = {"http://localhost:3000", "https://your-frontend-domain.com"})
public class BookingsController {
    
    @Autowired
    private BookingService bookingService;
    
    @PostMapping
    @PreAuthorize("hasRole('CLIENT')")
    public ResponseEntity<BookingResponse> createBooking(
            @Valid @RequestBody BookingRequest request,
            Authentication authentication) {
        try {
            BookingResponse response = bookingService.createBooking(request, authentication.getName());
            return ResponseEntity.status(201).body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @GetMapping("/client/{clientId}")
    @PreAuthorize("hasRole('CLIENT')")
    public ResponseEntity<List<BookingDTO>> getClientBookings(
            @PathVariable UUID clientId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        
        Pageable pageable = PageRequest.of(page, size);
        try {
            List<BookingDTO> bookings = bookingService.getClientBookings(clientId, pageable);
            return ResponseEntity.ok(bookings);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
    
    @GetMapping("/guard/{guardId}")
    @PreAuthorize("hasRole('GUARD')")
    public ResponseEntity<List<BookingDTO>> getGuardBookings(
            @PathVariable UUID guardId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        
        Pageable pageable = PageRequest.of(page, size);
        try {
            List<BookingDTO> bookings = bookingService.getGuardBookings(guardId, pageable);
            return ResponseEntity.ok(bookings);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<BookingDTO> getBookingById(@PathVariable UUID id) {
        try {
            BookingDTO booking = bookingService.getBookingById(id);
            return ResponseEntity.ok(booking);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PutMapping("/{id}/status")
    public ResponseEntity<Void> updateBookingStatus(
            @PathVariable UUID id,
            @RequestParam String status,
            Authentication authentication) {
        try {
            bookingService.updateBookingStatus(id, status, authentication.getName());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelBooking(@PathVariable UUID id) {
        try {
            bookingService.cancelBooking(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @GetMapping("/dashboard/stats")
    @PreAuthorize("hasAnyRole('CLIENT', 'GUARD')")
    public ResponseEntity<BookingStatsDTO> getBookingStats(Authentication authentication) {
        try {
            BookingStatsDTO stats = bookingService.getBookingStats(authentication.getName());
            return ResponseEntity.ok(stats);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}