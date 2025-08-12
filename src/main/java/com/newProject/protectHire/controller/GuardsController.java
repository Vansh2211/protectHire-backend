package com.newProject.protectHire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.newProject.protectHire.dto.auth.GuardRegistrationRequest;
import com.newProject.protectHire.dto.user.GuardProfileDTO;
import com.newProject.protectHire.service.GuardService;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/guards")
@CrossOrigin(origins = {"http://localhost:3000", "https://your-frontend-domain.com"})
public class GuardsController {
    
    @Autowired
    private GuardService guardService;
    
    @GetMapping
    public ResponseEntity<List<GuardProfileDTO>> getAllGuards(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size,
            @RequestParam(defaultValue = "createdAt") String sortBy,
            @RequestParam(defaultValue = "desc") String sortDir,
            @RequestParam(required = false) String location,
            @RequestParam(required = false) String role,
            @RequestParam(required = false) BigDecimal minRate,
            @RequestParam(required = false) BigDecimal maxRate,
            @RequestParam(required = false) Integer minExperience,
            @RequestParam(required = false) String skills) {
        
        Sort sort = sortDir.equalsIgnoreCase("desc") 
            ? Sort.by(sortBy).descending() 
            : Sort.by(sortBy).ascending();
        
        Pageable pageable = PageRequest.of(page, size, sort);
        
        try {
            List<GuardProfileDTO> guards = guardService.searchGuards(
                location, role, minRate, maxRate, minExperience, skills, pageable);
            return ResponseEntity.ok(guards);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<GuardProfileDTO> getGuardById(@PathVariable UUID id) {
        try {
            GuardProfileDTO guard = guardService.getGuardById(id);
            return ResponseEntity.ok(guard);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/featured")
    public ResponseEntity<List<GuardProfileDTO>> getFeaturedGuards(
            @RequestParam(defaultValue = "10") int limit) {
        try {
            List<GuardProfileDTO> guards = guardService.getFeaturedGuards(limit);
            return ResponseEntity.ok(guards);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
    
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('GUARD') and @guardService.isOwner(#id, authentication.name)")
    public ResponseEntity<GuardProfileDTO> updateGuardProfile(
            @PathVariable UUID id,
            @ModelAttribute GuardRegistrationRequest request) {
        try {
            GuardProfileDTO updatedGuard = guardService.updateGuardProfile(id, request);
            return ResponseEntity.ok(updatedGuard);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PutMapping("/{id}/availability")
    @PreAuthorize("hasRole('GUARD') and @guardService.isOwner(#id, authentication.name)")
    public ResponseEntity<Void> updateAvailability(
            @PathVariable UUID id,
            @RequestParam boolean available) {
        try {
            guardService.updateAvailability(id, available);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PostMapping("/{id}/profile-picture")
    @PreAuthorize("hasRole('GUARD') and @guardService.isOwner(#id, authentication.name)")
    public ResponseEntity<String> updateProfilePicture(
            @PathVariable UUID id,
            @RequestParam("file") MultipartFile file) {
        try {
            String imageUrl = guardService.updateProfilePicture(id, file);
            return ResponseEntity.ok(imageUrl);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}