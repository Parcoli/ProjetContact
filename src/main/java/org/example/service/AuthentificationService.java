package org.example.service;

import org.example.entity.User;
import org.example.exception.PasswordException;
import org.example.exception.UserException;
import org.example.repository.UserRepository;
import org.example.signup.SignUpData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class AuthentificationService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> potentialUser = userRepository.findById(username);
        if (!potentialUser.isPresent()) {
            throw new UsernameNotFoundException(String.format("Username %s was not found in registered users", username));
        }
        User user = potentialUser.get();
        return  org.springframework.security.core.userdetails.User
                .withUsername(username)
                .password(user.getHashedPassword())
                .authorities("USER")
                .build();
    }

    public void registerUser(SignUpData signUpData) throws Exception {
        if (userRepository.findById(signUpData.getUsername()).isPresent()) {
            throw new UserException();
        }

        if (signUpData.getPassword() == null || signUpData.getPassword().isEmpty()) {
            throw new PasswordException();
        }

        if (!Objects.equals(signUpData.getPassword(), signUpData.getConfirmPassword())) {
            throw new PasswordException();
        }

        String hashedPassword = new BCryptPasswordEncoder().encode(signUpData.getPassword()); //passwordEncoder.encode(userDTO.getPassword());
        User user = new User();
        user.setUsername(signUpData.getUsername());
        user.setHashedPassword(hashedPassword);
        userRepository.save(user);
    }
}
