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

    @OneToMany(mappedBy = "contact")
    private Set<Email> emails = new HashSet<>();


    @ManyToMany(mappedBy = "contacts")
    private List<Address> addresses = new ArrayList<>();

    // private String postalAdresses;

    // private String mailAdresse;

    public Contact() {}

    public Contact(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        // this.postalAdresses = postalAdresse;
        // this.mailAdresse = mailAdresse;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Email> getEmails() {
        return emails;
    }

    public void setEmails(Set<Email> emails) {
        this.emails = emails;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
    /*  @Override
    public String toString() {
        return String.format(
                // "Customer[id=%d, firstName='%s', lastName='%s', postalAdresses='%s', mailAdresse='%s']",
                "Customer[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
                // postalAdresses, mailAdresse);
    }*/


    // public String getPostalAdresses() {return postalAdresses;}

    // public String getMailAdresse() {return mailAdresse;}
}