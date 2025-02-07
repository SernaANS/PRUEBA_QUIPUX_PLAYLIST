package com.quipux.playlist.configs.security;

import com.quipux.playlist.repository.auth.UserRepository;
import com.quipux.playlist.repository.entitys.UserEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserInitializer {

    @Bean
    private CommandLineRunner init(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.findByUsername("admin") == null) {
                UserEntity admin = new UserEntity();
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("12345a"));
                admin.setRole("ADMIN");
                userRepository.save(admin);
            }
        };
    }
}