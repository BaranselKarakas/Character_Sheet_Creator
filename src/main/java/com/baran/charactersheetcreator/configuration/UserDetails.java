package com.baran.charactersheetcreator.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserDetails {

    @Value("${user.password}")
    private String userPassword;

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder(); // password encoder is necessary since spring security 5: https://www.baeldung.com/spring-security-5-default-password-encoder
        org.springframework.security.core.userdetails.UserDetails admin = User.withUsername("admin")
                .password(encoder.encode(userPassword))
                .roles("ADMIN", "USER")
                .build();
        org.springframework.security.core.userdetails.UserDetails user1 = User.withUsername("user1")
                .password(encoder.encode(userPassword))
                .roles("USER")
                .build();
        org.springframework.security.core.userdetails.UserDetails user2 = User.withUsername("user2")
                .password(encoder.encode(userPassword))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(admin, user1, user2);
    }
}