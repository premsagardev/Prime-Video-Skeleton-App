package com.example.primevideoskeletonapp.services;

import com.example.primevideoskeletonapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Custom query method, if needed
    User findByGoogleUserId(String googleUserId);
}
