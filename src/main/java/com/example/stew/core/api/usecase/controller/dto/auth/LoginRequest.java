package com.example.stew.core.api.usecase.controller.dto.auth;

import lombok.Data;

@Data
public class LoginRequest {
    private String loginId;
    private String password;
}
