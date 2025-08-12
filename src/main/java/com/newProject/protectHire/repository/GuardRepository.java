package com.newProject.protectHire.repository;

import com.newProject.protectHire.entity.GuardProfile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Repository
public interface GuardRepository extends JpaRepository<GuardProfile, UUID> {
    
    List<GuardProfile> findByIsAvailableTrue();
    
    Page<GuardProfile> findByIsAvailableTrue(Pageable pageable);
    
    @Query("SELECT g FROM Guard g WHERE g.isAvailable = true AND g.hourlyRate BETWEEN :minRate AND :maxRate")
    Page<GuardProfile> findAvailableGuardsByHourlyRateRange(
        @Param("minRate") BigDecimal minRate, 
        @Param("maxRate") BigDecimal maxRate, 
        Pageable pageable
    );
    
    // @Query("SELECT g FROM Guard g WHERE g.isAvailable = true AND :specialization MEMBER OF g.specializations")
    // Page<GuardProfile> findAvailableGuardsBySpecialization(
    //     @Param("specialization") Specialization specialization, 
    //     Pageable pageable
    // );
    
    @Query("SELECT g FROM Guard g WHERE g.isAvailable = true AND g.averageRating >= :minRating")
    Page<GuardProfile> findAvailableGuardsByMinRating(
        @Param("minRating") Double minRating, 
        Pageable pageable
    );
    
    @Query("SELECT g FROM Guard g WHERE g.isAvailable = true AND g.experienceYears >= :minExperience")
    Page<GuardProfile> findAvailableGuardsByMinExperience(
        @Param("minExperience") Integer minExperience, 
        Pageable pageable
    );
}