package com.example.stew.core.api.usecase.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.stew.core.api.usecase.controller.dto.auth.GetAuthenticatedUserRequest;
import com.example.stew.core.api.usecase.controller.dto.auth.GetAuthenticatedUserResponse;
import com.example.stew.core.api.usecase.controller.dto.auth.LoginRequest;
import com.example.stew.core.api.usecase.controller.dto.auth.LoginResponse;
import com.example.stew.core.api.usecase.controller.dto.auth.LogoutRequest;
import com.example.stew.core.api.usecase.controller.dto.auth.LogoutResponse;
import com.example.stew.core.api.usecase.service.AuthService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/core/usecase/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request, HttpSession session) {
        return authService.login(request, session);
    }

    @PostMapping("/logout")
    public LogoutResponse logout(@RequestBody LogoutRequest request, HttpSession session) {
        return authService.logout(request, session);
    }

    @GetMapping("/getAuthenticatedUser")
    public GetAuthenticatedUserResponse getAuthenticatedUser(GetAuthenticatedUserRequest request) {
        return authService.getAuthenticatedUser(request);
    }
}
