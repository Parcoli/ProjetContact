package org.example.entity;

import jakarta.persistence.Id;

public class User {

    @Id
    private String username;

    private String hashedPassword;

    public User() {}
}
