package com.realstate.RS.controller;

import com.realstate.RS.entity.User;
import com.realstate.RS.repository.UserRepository;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder =
            new BCryptPasswordEncoder();

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // =========================
    // REGISTER
    // =========================
    @PostMapping("/register")
    public String register(@RequestBody User user) {

        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return "Email already registered";
        }

        user.setPassword(
                passwordEncoder.encode(user.getPassword())
        );

        if (user.getRole() == null || user.getRole().isEmpty()) {
            user.setRole("TENANT");
        }

        userRepository.save(user);

        return "Registration successful";
    }

    // =========================
    // LOGIN
    // =========================
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody User user) {

        Map<String, Object> response = new HashMap<>();

        User existingUser = userRepository
                .findByEmail(user.getEmail())
                .orElse(null);

        if (existingUser == null) {
            response.put("success", false);
            response.put("message", "Invalid email or password");
            return response;
        }

        if (!passwordEncoder.matches(
                user.getPassword(),
                existingUser.getPassword())) {

            response.put("success", false);
            response.put("message", "Invalid email or password");
            return response;
        }

        response.put("success", true);
        response.put("message", "Login successful");
        response.put("id", existingUser.getId());
        response.put("name", existingUser.getName());
        response.put("email", existingUser.getEmail());
        response.put("role", existingUser.getRole());

        return response;
    }

    // =========================
    // MAKE USER ADMIN + RESET PASSWORD
    // =========================
    @PutMapping("/make-admin")
    public String makeAdmin(
            @RequestParam String email,
            @RequestParam String newPassword) {

        User user = userRepository
                .findByEmail(email)
                .orElse(null);

        if (user == null) {
            return "User not found";
        }

        user.setRole("ADMIN");

        user.setPassword(
                passwordEncoder.encode(newPassword)
        );

        userRepository.save(user);

        return "Admin account updated successfully";
    }
}