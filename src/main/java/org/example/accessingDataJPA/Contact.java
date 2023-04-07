package org.example.accessingDataJPA;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    private String postalAdresses;

    private String mailAdresse;

    protected Contact() {}

    public Contact(String firstName, String lastName, String postalAdresse, String mailAdresse) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalAdresses = postalAdresse;
        this.mailAdresse = mailAdresse;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s', postalAdresses='%s', mailAdresse='%s']",
                id, firstName, lastName, postalAdresses, mailAdresse);
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

    public String getPostalAdresses() {return postalAdresses;}

    public String getMailAdresse() {return mailAdresse;}
}