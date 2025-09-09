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

    public UserDTO(UUID id, String name, String email, String userType) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.userType = userType;
    }

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;   
        
    }


    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email; 
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

}
}