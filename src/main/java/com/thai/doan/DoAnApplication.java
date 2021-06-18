package com.thai.doan;

import com.thai.doan.dao.model.User;
import com.thai.doan.dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DoAnApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DoAnApplication.class, args);
    }

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        String adminAccount = "admin";
        String password = "1";
        User user = userRepository.findByUsername(adminAccount).orElseGet(() -> {
            User newAdmin = new User();
            newAdmin.setAdmin(true);
            newAdmin.setUsername(adminAccount);
            newAdmin.setPassword(passwordEncoder.encode(password));
            return newAdmin;
        });
        userRepository.save(user);
    }
}
