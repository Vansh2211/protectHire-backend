package com.newProject.protectHire.service.impl;

import com.newProject.protectHire.dto.booking.BookingDTO;
import com.newProject.protectHire.dto.booking.BookingRequest;
import com.newProject.protectHire.dto.booking.BookingResponse;
import com.newProject.protectHire.dto.booking.BookingStatsDTO;
import com.newProject.protectHire.entity.*;
import com.newProject.protectHire.entity.enums.BookingStatus;
import com.newProject.protectHire.repository.BookingRepository;
import com.newProject.protectHire.repository.ClientProfileRepository;
import com.newProject.protectHire.repository.GuardRepository;
import com.newProject.protectHire.repository.UserRepository;
import com.newProject.protectHire.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {
    
    @Autowired
    private BookingRepository bookingRepository;
    
    @Autowired
    private GuardRepository guardRepository;
    
    @Autowired
    private ClientProfileRepository clientRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public BookingResponse createBooking(BookingRequest request, String userEmail) {
        // Validate guard availability
        List<Booking> conflictingBookings = bookingRepository.findConflictingBookings(
            request.getGuardId(), request.getStartDate(), request.getEndDate()
        );
        
        if (!conflictingBookings.isEmpty()) {
            throw new RuntimeException("Guard is not available for the selected time period");
        }
        
        GuardProfile guard = guardRepository.findById(request.getGuardId())
            .orElseThrow(() -> new RuntimeException("Guard not found"));
        
        ClientProfile client = clientRepository.findById(request.getClientId())
            .orElseThrow(() -> new RuntimeException("Client not found"));
        
        Booking booking = new Booking();
        booking.setGuard(guard);
        booking.setClient(client);
        booking.setStartDate(request.getStartDate());
        booking.setEndDate(request.getEndDate());
        booking.setStartTime(request.getStartTime());
        booking.setEndTime(request.getEndTime());
        booking.setAddress(request.getAddress());
        booking.setInstructions(request.getInstructions());
        booking.setEstimatedCost(request.getEstimatedCost());
        booking.setStatus(BookingStatus.PENDING);
        
        Booking savedBooking = bookingRepository.save(booking);
        
        return new BookingResponse(
            savedBooking.getId(),
            "Booking created successfully. Waiting for guard confirmation.",
            "PENDING"
        );
    }
    
    @Override
    @Transactional(readOnly = true)
    public BookingDTO getBookingById(UUID bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
            .orElseThrow(() -> new RuntimeException("Booking not found"));
        
        return convertToDTO(booking);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<BookingDTO> getClientBookings(UUID clientId, Pageable pageable) {
        return bookingRepository.findByClientId(clientId, pageable)
            .stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<BookingDTO> getGuardBookings(UUID guardId, Pageable pageable) {
        return bookingRepository.findByGuardId(guardId, pageable)
            .stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }
    
    @Override
    public void updateBookingStatus(UUID bookingId, String status, String userEmail) {
        Booking booking = bookingRepository.findById(bookingId)
            .orElseThrow(() -> new RuntimeException("Booking not found"));
        
        BookingStatus newStatus = BookingStatus.valueOf(status.toUpperCase());
        booking.setStatus(newStatus);
        
        if (newStatus == BookingStatus.CANCELLED) {
            booking.setCancelledAt(LocalDateTime.now());
        }
        
        bookingRepository.save(booking);
    }
    
    @Override
    public void cancelBooking(UUID bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
            .orElseThrow(() -> new RuntimeException("Booking not found"));
        
        booking.setStatus(BookingStatus.CANCELLED);
        booking.setCancelledAt(LocalDateTime.now());
        
        bookingRepository.save(booking);
    }
    
    @Override
    @Transactional(readOnly = true)
    public BookingStatsDTO getBookingStats(String userEmail) {
        User user = userRepository.findByEmail(userEmail)
            .orElseThrow(() -> new RuntimeException("User not found"));
        
        BookingStatsDTO stats = new BookingStatsDTO();
        
        if (user instanceof GuardProfile) {
            GuardProfile guard = (GuardProfile) user;
            stats.setTotalBookings(bookingRepository.countByGuardIdAndStatus(guard.getId(), null));
            stats.setPendingBookings(bookingRepository.countByGuardIdAndStatus(guard.getId(), BookingStatus.PENDING));
            stats.setConfirmedBookings(bookingRepository.countByGuardIdAndStatus(guard.getId(), BookingStatus.CONFIRMED));
            stats.setCompletedBookings(bookingRepository.countByGuardIdAndStatus(guard.getId(), BookingStatus.COMPLETED));
            stats.setCancelledBookings(bookingRepository.countByGuardIdAndStatus(guard.getId(), BookingStatus.CANCELLED));
            stats.setTotalEarnings(bookingRepository.getTotalEarningsByGuardId(guard.getId()));
            stats.setMonthlyEarnings(bookingRepository.getMonthlyEarningsByGuardId(guard.getId(), LocalDateTime.now().minusMonths(1)));
            stats.setAverageRating(guard.getAverageRating());
        } else if (user instanceof ClientProfile) {
            ClientProfile client = (ClientProfile) user;
            stats.setTotalBookings(bookingRepository.countByClientIdAndStatus(client.getId(), null));
            stats.setPendingBookings(bookingRepository.countByClientIdAndStatus(client.getId(), BookingStatus.PENDING));
            stats.setConfirmedBookings(bookingRepository.countByClientIdAndStatus(client.getId(), BookingStatus.CONFIRMED));
            stats.setCompletedBookings(bookingRepository.countByClientIdAndStatus(client.getId(), BookingStatus.COMPLETED));
            stats.setCancelledBookings(bookingRepository.countByClientIdAndStatus(client.getId(), BookingStatus.CANCELLED));
            stats.setTotalEarnings(bookingRepository.getTotalSpentByClientId(client.getId()));
        }
        
        return stats;
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<BookingDTO> getBookingsForDate(String date) {
        LocalDate bookingDate = LocalDate.parse(date);
        return bookingRepository.findBookingsForDate(bookingDate)
            .stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }
    
    @Override
    @Transactional(readOnly = true)
    public boolean isGuardAvailable(UUID guardId, String startDate, String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        
        List<Booking> conflictingBookings = bookingRepository.findConflictingBookings(guardId, start, end);
        return conflictingBookings.isEmpty();
    }
    
    private BookingDTO convertToDTO(Booking booking) {
        BookingDTO dto = new BookingDTO();
        dto.setId(booking.getId());
        dto.setGuardId(booking.getGuard().getId());
        dto.setGuardName(booking.getGuard().getFirstName() + " " + booking.getGuard().getLastName());
        dto.setGuardPhone(booking.getGuard().getPhoneNumber());
        dto.setClientId(booking.getClient().getId());
        dto.setClientName(booking.getClient().getFirstName() + " " + booking.getClient().getLastName());
        dto.setClientPhone(booking.getClient().getPhoneNumber());
        dto.setStartDate(booking.getStartDate());
        dto.setEndDate(booking.getEndDate());
        dto.setStartTime(booking.getStartTime());
        dto.setEndTime(booking.getEndTime());
        dto.setAddress(booking.getAddress());
        dto.setInstructions(booking.getInstructions());
        dto.setEstimatedCost(booking.getEstimatedCost());
        dto.setActualCost(booking.getActualCost());
        dto.setStatus(booking.getStatus().toString());
        dto.setCreatedAt(booking.getCreatedAt());
        dto.setUpdatedAt(booking.getUpdatedAt());
        
        return dto;
    }
}
