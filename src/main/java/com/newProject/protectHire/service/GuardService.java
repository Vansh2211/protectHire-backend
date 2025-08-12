package com.newProject.protectHire.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import com.newProject.protectHire.dto.auth.GuardRegistrationRequest;
import com.newProject.protectHire.dto.user.GuardProfileDTO;

public class GuardService {

    public List<GuardProfileDTO> searchGuards(String location, String role, BigDecimal minRate, BigDecimal maxRate,
            Integer minExperience, String skills, Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchGuards'");
    }

    public GuardProfileDTO getGuardById(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getGuardById'");
    }

    public List<GuardProfileDTO> getFeaturedGuards(int limit) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFeaturedGuards'");
    }

    public GuardProfileDTO updateGuardProfile(UUID id, GuardRegistrationRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateGuardProfile'");
    }

    public void updateAvailability(UUID id, boolean available) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateAvailability'");
    }

    public String updateProfilePicture(UUID id, MultipartFile file) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateProfilePicture'");
    }
    
}
