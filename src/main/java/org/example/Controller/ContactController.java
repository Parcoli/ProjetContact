package org.example.Controller;

import org.example.entity.Contact;
import org.example.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/contacts")
@EnableWebSecurity
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    @GetMapping("")
    public String redirectToList() {
        return "redirect:/contacts/list";
    }
    @GetMapping("/list")
    public String allContacts(Model model) {
        Iterable<Contact> contacts = contactRepository.findAll();
        model.addAttribute("contacts", contacts);
        return "contacts/list";
    }

    @GetMapping("/add")
    public String getAddContactTemplate(Model model) {
        model.addAttribute("contact", new Contact());
        return "contacts/add";
    }

    @PostMapping("")
    public String createContact(@ModelAttribute Contact contact) {
        contactRepository.save(contact);
        return "redirect:/contacts/list";
    }

    @GetMapping("/{id}/modify")
    public String getModifyContactTemplate(@PathVariable Long id, Model model) {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid contact Id:" + id));
        model.addAttribute("contact", contact);
        return "contacts/modify";
    }

    @PostMapping("/{id}")
    public String updateContactById(@PathVariable Long id, @ModelAttribute Contact contact) {
        Contact existingContact = contactRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid contact Id:" + id));
        existingContact.setFirstName(contact.getFirstName());
        existingContact.setLastName(contact.getLastName());
        existingContact.setEmails(contact.getEmails());
        existingContact.setAddresses(contact.getAddresses());
        contactRepository.save(existingContact);
        return "redirect:/contacts/list";
    }

    @GetMapping("/{id}/delete")
    public String deleteContactById(@PathVariable Long id) {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid contact Id:" + id));
        contactRepository.delete(contact);
        return "redirect:/contacts/list";
    }
}