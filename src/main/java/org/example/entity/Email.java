package org.example.entity;

import jakarta.persistence.*;

@Entity
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    private Contact contact;
}
