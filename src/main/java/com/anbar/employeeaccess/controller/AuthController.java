package com.anbar.employeeaccess.controller;

import com.anbar.employeeaccess.dto.*;
import com.anbar.employeeaccess.factory.Notification;
import com.anbar.employeeaccess.factory.NotificationFactory;
import com.anbar.employeeaccess.model.User;
import com.anbar.employeeaccess.security.JwtUtil;
import com.anbar.employeeaccess.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        if (userService.findByUsername(request.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Username already exists");
        }

        userService.saveUser(request.getUsername(), request.getPassword(), request.getRole());

        // Send notification using Factory Pattern
        Notification notifier = NotificationFactory.getNotification("email");
        notifier.send(request.getUsername(), "Welcome to Employee Access Service!");

        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        User user = userService.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!userService.isPasswordMatch(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtUtil.generateToken(user.getUsername(), user.getRoles());
        return ResponseEntity.ok(new LoginResponse(token));
    }
}
