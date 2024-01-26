package com.example.primevideoskeletonapp.services;

import com.example.primevideoskeletonapp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(String googleUserId, String username, String email) {
        User user = new User();
        user.setGoogleUserId(googleUserId);
        user.setUserName(username);
        user.setEmail(email);
        user.setAdmin(isAdminUser(googleUserId));

        // Save the user to the database
        return userRepository.save(user);
    }

    public User getUserByGoogleUserId(String googleUserId) {
        return userRepository.findByGoogleUserId(googleUserId);
    }

    private boolean isAdminUser(String googleUserId) {
        // Implement your logic to check if the user is an admin based on their Google ID
        return "yourAdminGoogleId".equals(googleUserId);
    }

}
