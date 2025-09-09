package com.newProject.protectHire.dto.auth;

public class LoginRequest {

    private String email;
    private String password;
    private int number;

    // Constructors
    public LoginRequest() {}

    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Getters and Setters
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

    public int getnumber() {
        return number;
    }

    public void setnumber(int number) {
        this.number = number;
    }


    // Validation method
    public boolean isValid() {
        return email != null && !email.isEmpty() && password != null && !password.isEmpty();
    }

}
