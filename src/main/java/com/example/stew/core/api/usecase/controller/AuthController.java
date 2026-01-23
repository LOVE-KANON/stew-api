package com.example.stew.core.api.usecase.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.stew.core.api.dto.ApiResponse;
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
    public ApiResponse<LoginResponse> login(@RequestBody LoginRequest request, HttpSession session) {
        return new ApiResponse<LoginResponse>(authService.login(request, session));
    }

    @PostMapping("/logout")
    public ApiResponse<LogoutResponse> logout(@RequestBody LogoutRequest request, HttpSession session) {
        return new ApiResponse<LogoutResponse>(authService.logout(request, session));
    }

    @GetMapping("/getAuthenticatedUser")
    public ApiResponse<GetAuthenticatedUserResponse> getAuthenticatedUser(GetAuthenticatedUserRequest request) {
        return new ApiResponse<GetAuthenticatedUserResponse>(authService.getAuthenticatedUser(request));
    }
}
