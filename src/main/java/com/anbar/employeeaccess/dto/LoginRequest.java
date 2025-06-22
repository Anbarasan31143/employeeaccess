package com.anbar.employeeaccess.dto;

import lombok.*;

@Data
public class LoginRequest {
    private String username;
    private String password;
}