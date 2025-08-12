package com.newProject.protectHire.service;

import com.newProject.protectHire.dto.auth.AuthResponse;
import com.newProject.protectHire.dto.auth.ClientRegistrationRequest;
import com.newProject.protectHire.dto.auth.CompanyRegistrationRequest;
import com.newProject.protectHire.dto.auth.GuardRegistrationRequest;
import com.newProject.protectHire.dto.auth.LoginRequest;

import jakarta.validation.Valid;

public class AuthService {

    public AuthResponse login(LoginRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }

    public AuthResponse registerClient(ClientRegistrationRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'registerClient'");
    }

    public AuthResponse registerGuard(GuardRegistrationRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'registerGuard'");
    }

    public AuthResponse registerCompany(CompanyRegistrationRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'registerCompany'");
    }

    public AuthResponse refreshToken(String token) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'refreshToken'");
    }
    
}
