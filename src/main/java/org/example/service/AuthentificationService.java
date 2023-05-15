package org.example.service;

import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class AuthentificationService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
}
