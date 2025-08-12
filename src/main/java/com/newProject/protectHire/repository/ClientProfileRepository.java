package com.newProject.protectHire.repository;

import com.newProject.protectHire.entity.ClientProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface ClientProfileRepository extends JpaRepository<ClientProfile, UUID> {
    List<ClientProfile> findByIsVerifiedTrue();
    List<ClientProfile> findByIsVerifiedFalse();
}