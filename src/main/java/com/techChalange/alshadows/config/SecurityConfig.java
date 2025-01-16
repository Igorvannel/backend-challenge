package com.techChalange.alshadows.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configuration de sécurité pour l'application.
 * Auteur : Igor Sibemou
 * Date de création : 2025-01-15
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Injection des propriétés définies dans le fichier application.yml
    @Value("${spring.security.user.name}")
    private String username;

    @Value("${spring.security.user.password}")
    private String password;

    @Value("${spring.security.user.roles}")
    private String roles;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeHttpRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();

        return httpSecurity.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        // Utilisation des variables injectées pour créer l'utilisateur
        UserDetails user = User.withDefaultPasswordEncoder()
                .username(username)
                .password(password)
                .roles(roles)
                .build();
        return new InMemoryUserDetailsManager(user);
    }
}