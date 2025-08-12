package com.newProject.protectHire.repository;

import com.newProject.protectHire.entity.Booking;
import com.newProject.protectHire.entity.enums.BookingStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface BookingRepository extends JpaRepository<Booking, UUID> {
    
    Page<Booking> findByClientId(UUID clientId, Pageable pageable);
    
    Page<Booking> findByGuardId(UUID guardId, Pageable pageable);
    
    List<Booking> findByStatus(BookingStatus status);
    
    @Query("SELECT b FROM Booking b WHERE b.guard.id = :guardId AND b.status = :status")
    List<Booking> findByGuardIdAndStatus(@Param("guardId") UUID guardId, @Param("status") BookingStatus status);
    
    @Query("SELECT b FROM Booking b WHERE b.client.id = :clientId AND b.status = :status")
    List<Booking> findByClientIdAndStatus(@Param("clientId") UUID clientId, @Param("status") BookingStatus status);
    
    @Query("SELECT COUNT(b) FROM Booking b WHERE b.guard.id = :guardId AND b.status = :status")
    Long countByGuardIdAndStatus(@Param("guardId") UUID guardId, @Param("status") BookingStatus status);
    
    @Query("SELECT COUNT(b) FROM Booking b WHERE b.client.id = :clientId AND b.status = :status")
    Long countByClientIdAndStatus(@Param("clientId") UUID clientId, @Param("status") BookingStatus status);
    
    @Query("SELECT SUM(b.actualCost) FROM Booking b WHERE b.guard.id = :guardId AND b.status = 'COMPLETED'")
    BigDecimal getTotalEarningsByGuardId(@Param("guardId") UUID guardId);
    
    @Query("SELECT SUM(b.actualCost) FROM Booking b WHERE b.client.id = :clientId AND b.status = 'COMPLETED'")
    BigDecimal getTotalSpentByClientId(@Param("clientId") UUID clientId);
    
    @Query("SELECT SUM(b.actualCost) FROM Booking b WHERE b.guard.id = :guardId AND b.status = 'COMPLETED' AND b.updatedAt >= :startDate")
    BigDecimal getMonthlyEarningsByGuardId(@Param("guardId") UUID guardId, @Param("startDate") LocalDateTime startDate);
    
    @Query("SELECT b FROM Booking b WHERE b.guard.id = :guardId AND " +
           "((b.startDate BETWEEN :startDate AND :endDate) OR " +
           "(b.endDate BETWEEN :startDate AND :endDate) OR " +
           "(b.startDate <= :startDate AND b.endDate >= :endDate)) AND " +
           "b.status IN ('CONFIRMED', 'IN_PROGRESS')")
    List<Booking> findConflictingBookings(@Param("guardId") UUID guardId, 
                                         @Param("startDate") LocalDate startDate, 
                                         @Param("endDate") LocalDate endDate);
    
    @Query("SELECT b FROM Booking b WHERE b.startDate = :date AND b.status IN ('CONFIRMED', 'IN_PROGRESS')")
    List<Booking> findBookingsForDate(@Param("date") LocalDate date);
}
