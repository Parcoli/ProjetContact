package org.example.Controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Enumeration;
import java.util.List;

@Controller
@RequestMapping("/contacts")
//@EnableWebSecurity
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    @GetMapping("")
    public String listContacts(Model model) {
        List<Contact> contacts = contactRepository.findAll();
        model.addAttribute("contacts", contacts);
        return "contacts/list";
    }

    @GetMapping("/{id}")
    public String viewContact(@PathVariable Long id, Model model) {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid contact Id:" + id));
        model.addAttribute("contact", contact);
        return "contacts/view";
    }

    @GetMapping("/add")
    public String newContactForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "contacts/add";
    }

    @PostMapping("")
    public String createContact(@ModelAttribute Contact contact) {
        contactRepository.save(contact);
        return "redirect:/contacts";
    }

    @GetMapping("/{id}/edit")
    public String editContactForm(@PathVariable Long id, Model model) {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid contact Id:" + id));
        model.addAttribute("contact", contact);
        return "contacts/edit";
    }

    @PostMapping("/{id}")
    public String updateContact(@PathVariable Long id, @ModelAttribute Contact contact) {
        Contact existingContact = contactRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid contact Id:" + id));
        existingContact.setFirstName(contact.getFirstName());
        existingContact.setLastName(contact.getLastName());
        existingContact.setEmails(contact.getEmails());
        existingContact.setAddresses(contact.getAddresses());
        contactRepository.save(existingContact);
        return "redirect:/contacts";
    }

    @GetMapping("/{id}/delete")
    public String deleteContact(@PathVariable Long id) {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid contact Id:" + id));
        contactRepository.delete(contact);
        return "redirect:/contacts";
    }
}