package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    private String username;

    private String hashedPassword;

    public User() {}

    public String getUsername()
    {
        return username;
    }
    public void setUsername(String userName)
    {
        this.username = userName;
    }

    public String getHashedPassword()
    {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword)
    {
        this.hashedPassword = hashedPassword;
    }


}
