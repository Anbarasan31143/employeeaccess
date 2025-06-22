package com.anbar.employeeaccess.dto;

import lombok.*;

@Data
public class RegisterRequest {
    private String username;
    private String password;
    private String role; // e.g., USER or ADMIN
}