package com.example.stew.core.api.usecase.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.example.stew.core.api.usecase.controller.dto.login.LoginRequest;
import com.example.stew.core.api.usecase.controller.dto.login.LoginResponse;
import com.example.stew.core.api.usecase.service.LoginService;

@RestController
@RequestMapping("/api/core/usecase")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return loginService.login(request);
    }
}
