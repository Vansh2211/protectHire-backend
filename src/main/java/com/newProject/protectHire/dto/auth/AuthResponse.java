package com.newProject.protectHire.dto.auth;

import java.util.UUID;

public class AuthResponse {
    public AuthResponse(Object object, Object object2, String string) {
        //TODO Auto-generated constructor stub
    }

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