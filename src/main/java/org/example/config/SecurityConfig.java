package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests()
                // API is not secured for simple purpose
                // .anyRequest().permitAll().and().build();
                .requestMatchers("/contacts").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin((formLogin) -> formLogin.loginPage("/signin"))
                /*.
                .permitAll()
                .and()*/
                .logout()
                .and()
                // .userDetailsService(authService)
                .csrf().disable().build();
    }
}
