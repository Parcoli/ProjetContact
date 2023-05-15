package org.example.config;

import org.example.service.AuthentificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Autowired
    private AuthentificationService authentificationService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests()
                // API is not secured for simple purpose
                .requestMatchers("/contacts/**").authenticated()
                //.requestMatchers("contacts/add").authenticated()
                //.requestMatchers("contacts/{id}/modify").authenticated()
                //.requestMatchers("contacts/{id}/delete").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .logout()
                .and()
                .userDetailsService(authentificationService)
                .csrf().disable().build();
                /*
                .csrf().requireCsrfProtectionMatcher(new AntPathRequestMatcher("/contacts/**"))
                .and()
                .build();
                 */

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}