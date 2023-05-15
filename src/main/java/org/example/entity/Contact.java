package org.example.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Email> emails = new HashSet<>();
    // private String postalAdresses;

    // private String mailAdresse;

    public Contact() {}

    public Contact(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        // this.postalAdresses = postalAdresse;
        // this.mailAdresse = mailAdresse;
    }

    @Override
    public String toString() {
        return String.format(
                // "Customer[id=%d, firstName='%s', lastName='%s', postalAdresses='%s', mailAdresse='%s']",
                "Customer[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
                // postalAdresses, mailAdresse);
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    // public String getPostalAdresses() {return postalAdresses;}

    // public String getMailAdresse() {return mailAdresse;}
}