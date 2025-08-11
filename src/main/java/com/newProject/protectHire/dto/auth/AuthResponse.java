package com.newProject.protectHire.dto.auth;

import java.util.UUID;

public class AuthResponse {
    private String token;
    private UserDTO user;
    
    // Constructors, getters, setters


public class UserDTO {
    private UUID id;
    private String name; // Display name based on user type
    private String email;
    private String userType;
    
    // Constructors, getters, setters
}
}