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
@RequestMapping(path="/contacts", produces={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
public class APIContact {

    @Autowired
    private ContactRepository contactRepository;

    @GetMapping("/list")
    public Iterable<Contact> getContactsList()
    {
        return contactRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable("id") long id)
    {
        Optional<Contact> contact = contactRepository.findById(id);
        if (contact.isPresent()) {
            return new ResponseEntity<>(contact.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact)
    {
        Contact newContact = contactRepository.save(contact);
        return new ResponseEntity<>(newContact, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contact> modifyContact(@PathVariable("modify/id") long id, @RequestBody Contact contact)
    {
        Optional<Contact> Optcontact = contactRepository.findById(id);

        if (Optcontact.isPresent()) {
            Contact realContact = Optcontact.get();
            realContact.setLastName(contact.getLastName());
            realContact.setFirstName(contact.getFirstName());
            realContact.setEmails(contact.getEmails());

            Contact modifiedContact = contactRepository.save(realContact);
            return new ResponseEntity<>(modifiedContact, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}
