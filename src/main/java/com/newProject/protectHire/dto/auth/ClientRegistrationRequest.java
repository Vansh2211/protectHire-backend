package com.newProject.protectHire.dto.auth;

import software.amazon.awssdk.services.s3.endpoints.internal.Value.Str;

public class ClientRegistrationRequest {
    
    private String name;
    private String email;
    private String password;
    private String address;
    private String phoneNumber;


    // Constructors
    public ClientRegistrationRequest(String name,String email,String password, String address,String phoneNumber ) {}


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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
