package org.example.Controller;

import org.example.service.AuthentificationService;
import org.example.signup.SignUpData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private AuthentificationService authentificationService;

    @GetMapping("/")
    public String index() {
        return "redirect:/contacts/list";
    }
    @GetMapping("/signup")
    public String getSignUpTemplate(Model model) {
        SignUpData signUpData = new SignUpData();
        model.addAttribute("user", signUpData);
        return "signup";
    }

    @PostMapping("/signup")
    public String userSignUp(@ModelAttribute("user") @Validated SignUpData user, Model model) {
        try {
            authentificationService.registerUser(user);
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
            return "signup";
        }

        return "redirect:/login";
    }
}
