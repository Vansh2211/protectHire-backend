package com.newProject.protectHire.controller;

import com.newProject.protectHire.dto.auth.AuthResponse;
import com.newProject.protectHire.dto.auth.LoginRequest;
import com.newProject.protectHire.dto.auth.ClientRegistrationRequest;
import com.newProject.protectHire.dto.auth.GuardRegistrationRequest;
import com.newProject.protectHire.dto.auth.CompanyRegistrationRequest;
import com.newProject.protectHire.service.AuthService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = {"http://localhost:3000", "https://your-frontend-domain.com"})
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request) {
        try {
            AuthResponse response = authService.login(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new AuthResponse(null, null, "Invalid credentials"));
        }
    }

    @PostMapping("/register/client")
    public ResponseEntity<AuthResponse> registerClient(@Valid @RequestBody ClientRegistrationRequest request) {
        try {
            AuthResponse response = authService.registerClient(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new AuthResponse(null, null, "Registration failed: " + e.getMessage()));
        }
    }

    @PostMapping("/register/guard")
    public ResponseEntity<AuthResponse> registerGuard(@ModelAttribute GuardRegistrationRequest request) {
        try {
            AuthResponse response = authService.registerGuard(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new AuthResponse(null, null, "Registration failed: " + e.getMessage()));
        }
    }

    @PostMapping("/register/company")
    public ResponseEntity<AuthResponse> registerCompany(@Valid @RequestBody CompanyRegistrationRequest request) {
        try {
            AuthResponse response = authService.registerCompany(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new AuthResponse(null, null, "Registration failed: " + e.getMessage()));
        }
    }

    @PostMapping("/refresh")
    public ResponseEntity<AuthResponse> refreshToken(@RequestHeader("Authorization") String authHeader) {
        try {
            String token = authHeader.substring(7); // Remove "Bearer " prefix
            AuthResponse response = authService.refreshToken(token);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new AuthResponse(null, null, "Invalid token"));
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@RequestHeader("Authorization") String authHeader) {
        // JWT logout is stateless; handle on client side.
        // Optional: implement token blacklist.
        return ResponseEntity.ok().build();
    }
}
