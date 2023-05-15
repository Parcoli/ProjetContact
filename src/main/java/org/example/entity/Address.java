package org.example.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String street;

    private String city;

    private String postalCode;

    @ManyToMany
    private Set<Contact> contacts;

    public Address() {}
}
