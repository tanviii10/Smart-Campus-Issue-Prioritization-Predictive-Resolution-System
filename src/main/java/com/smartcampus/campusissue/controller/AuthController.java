package com.smartcampus.campusissue.controller;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartcampus.campusissue.model.User;
import com.smartcampus.campusissue.repository.UserRepository;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public User register(@RequestBody User user) {

        User existingUser =
                userRepository.findByEmail(user.getEmail());

        if (existingUser != null) {
            throw new RuntimeException("Email already exists");
        }

        user.setRole("STUDENT");

        return userRepository.save(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody User loginUser) {

        System.out.println("===== LOGIN ATTEMPT =====");
        System.out.println("Email: " + loginUser.getEmail());
        System.out.println("Password: " + loginUser.getPassword());

        User user = userRepository.findByEmail(loginUser.getEmail());

        System.out.println("User Found: " + user);

        if(user != null && user.getPassword().equals(loginUser.getPassword())) {
            System.out.println("LOGIN SUCCESS");
            return user;
        }

        System.out.println("LOGIN FAILED");
        throw new ResponseStatusException(
                HttpStatus.UNAUTHORIZED,
                "Invalid email or password"
        );
    }
}