package com.newProject.protectHire.service;

import com.newProject.protectHire.dto.user.GuardProfileDTO;
import com.newProject.protectHire.dto.user.GuardRegistrationRequest;
import com.newProject.protectHire.dto.user.GuardUpdateRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
}
