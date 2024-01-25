package com.example.primevideoskeletonapp.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userRoleId; // Primary Key

    @ManyToOne
    @JoinColumn(name = "user_userId")
    private User user; // ManyToOne relationship with User entity

    @ManyToOne
    @JoinColumn(name = "role_roleId")
    private Role role; // ManyToOne relationship with Role entity
}
