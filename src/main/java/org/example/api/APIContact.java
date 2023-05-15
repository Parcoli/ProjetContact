package org.example.api;

import org.example.entity.Contact;
import org.example.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/api", produces={MediaType.APPLICATION_XML_VALUE})
public class APIContact {

    @Autowired
    private ContactRepository contactRepository;

    @GetMapping("/listContacts")
    public Iterable<Contact> getContactsList()
    {
        return contactRepository.findAll();
    }

    @GetMapping("/getContact/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable("id") long id)
    {
        Optional<Contact> contact = contactRepository.findById(id);
        if (contact.isPresent()) {
            return new ResponseEntity<>(contact.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    // Je n'arrive pas a faire fonctionner la méthode de suppression, j''ai une erreur 405 quoique je fasse
    // Pourtant je ne rencontre pas ce problème avec la méthode pour récupérer tout les contacts et pour récupérer un contact par ID
    @DeleteMapping("/delContact/{id}")
    public ResponseEntity<Contact> deleteContactById(@PathVariable("id") long id)
    {
        Optional<Contact> contact = contactRepository.findById(id);
        if (contact.isPresent()) {
            contactRepository.deleteById(id);
            return new ResponseEntity<>(contact.get(),HttpStatus.NO_CONTENT);
        }
        else
        {
            return new ResponseEntity<>(contact.get(),HttpStatus.NOT_FOUND);
        }
    }





}
