package com.user_management.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true) // Name can be optional
    private String name;

    @Column(nullable = false, unique = true) // Username must be unique and required
    private String username;

    @Column(nullable = false, unique = true) // Email must be unique and required
    @Email
    private String email;

    @Column(nullable = false) // Password is required
    private String password;

    @Column(nullable = true) // Role can be optional (e.g., default role assigned elsewhere)
    private String role;

    @Column(nullable = false) // Active status is required, with a default value
    private boolean active = true;

    @Column(nullable = true) // Mobile can be optional
    private String mobile;

}
