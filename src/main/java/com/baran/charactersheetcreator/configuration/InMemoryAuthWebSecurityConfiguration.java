package com.baran.charactersheetcreator.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class InMemoryAuthWebSecurityConfiguration {
        @Bean
        public InMemoryUserDetailsManager userDetailsService() {
            PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder(); // password encoder is necessary since spring security 5: https://www.baeldung.com/spring-security-5-default-password-encoder
            UserDetails admin = User.withUsername("admin")
                    .password(encoder.encode("password"))
                    .roles("USER")
                    .build();
            UserDetails user = User.withUsername("user")
                    .password(encoder.encode("password"))
                    .roles("USER")
                    .build();
            return new InMemoryUserDetailsManager(admin, user);
        }
    }