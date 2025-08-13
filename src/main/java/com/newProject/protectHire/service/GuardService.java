package com.newProject.protectHire.service;

import com.newProject.protectHire.dto.user.GuardProfileDTO;
import com.newProject.protectHire.dto.user.GuardRegistrationRequest;
import com.newProject.protectHire.dto.user.GuardUpdateRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface GuardService {
    GuardProfileDTO registerGuard(GuardRegistrationRequest request);
    GuardProfileDTO getGuardById(UUID guardId);
    Page<GuardProfileDTO> getAvailableGuards(Pageable pageable);
    // Page<GuardDTO> searchGuards(GuardFilterRequest filterRequest, Pageable pageable);
    GuardProfileDTO updateGuard(UUID guardId, GuardUpdateRequest request);
    void updateAvailabilityStatus(UUID guardId, boolean isAvailable);
    List<GuardProfileDTO> getGuardsBySpecialization(String specialization);
    void updateGuardRating(UUID guardId, Double newRating);
    List<GuardProfileDTO> searchGuards(String location, String role, BigDecimal minRate, BigDecimal maxRate,
            Integer minExperience, String skills, Pageable pageable);
    List<GuardProfileDTO> getFeaturedGuards(int limit);
    GuardProfileDTO updateGuardProfile(UUID id, com.newProject.protectHire.dto.auth.GuardRegistrationRequest request);
    void updateAvailability(UUID id, boolean available);
    String updateProfilePicture(UUID id, MultipartFile file);
}
