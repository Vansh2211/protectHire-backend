package com.newProject.protectHire.service;

import com.newProject.protectHire.dto.user.UserDTO;
import com.newProject.protectHire.dto.user.UserRegistrationRequest;
import com.newProject.protectHire.dto.user.UserUpdateRequest;
import java.util.UUID;

public interface UserService {
    UserDTO registerUser(UserRegistrationRequest request);
    UserDTO getUserById(UUID userId);
    UserDTO getUserByEmail(String email);
    UserDTO updateUser(UUID userId, UserUpdateRequest request);
    void deactivateUser(UUID userId);
    void activateUser(UUID userId);
    boolean existsByEmail(String email);
}