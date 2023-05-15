package org.example.entity;

import jakarta.persistence.Id;

public class User {

    @Id
    private String username;

    private String hashedPassword;

    public User() {}

    public void setUsername(String userName)
    {
        this.username = userName;
    }

    public String getHashedPassword()
    {
        return hashedPassword;
    }

    public void setHashedPassword(String userName)
    {
        this.username = userName;
    }


}
