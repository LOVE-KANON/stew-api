package com.example.stew.core.api.usecase.controller.dto.auth;

import lombok.Data;

@Data
public class LoginResponse {
    private boolean success;
    private String message;
}
