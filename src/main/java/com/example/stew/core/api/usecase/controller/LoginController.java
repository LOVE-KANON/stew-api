package com.example.stew.core.api.usecase.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.stew.core.api.usecase.controller.dto.login.LoginRequest;
import com.example.stew.core.api.usecase.controller.dto.login.LoginResponse;
import com.example.stew.core.api.usecase.controller.dto.login.LogoutRequest;
import com.example.stew.core.api.usecase.controller.dto.login.LogoutResponse;
import com.example.stew.core.api.usecase.service.LoginService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/core/usecase")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request, HttpSession session) {
        return loginService.login(request, session);
    }

    @PostMapping("/logout")
    public LogoutResponse logout(@RequestBody LogoutRequest request, HttpSession session) {
        return loginService.logout(request, session);
    }
}
