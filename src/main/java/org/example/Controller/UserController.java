package org.example.Controller;

import org.example.signup.SignUpData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class UserController {

    @GetMapping("/signup")
    public String showRegistrationForm(WebRequest request, Model model) {
        SignUpData signUpData = new SignUpData();
        model.addAttribute("user", signUpData);
        return "signup";
    }

    @PostMapping("/signup")
    public String registerUserAccount(@ModelAttribute("user") @Validated SignUpData user, Model model) {
        try {
            authService.registerUser(user);
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
            return "registration";
        }

        return "redirect:/login";
    }
}
