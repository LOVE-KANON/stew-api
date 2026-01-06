package com.example.stew.core.api.usecase.service;

import org.springframework.stereotype.Service;

import com.example.stew.core.api.usecase.controller.dto.login.LoginRequest;
import com.example.stew.core.api.usecase.controller.dto.login.LoginResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService {

    public LoginResponse login(LoginRequest request) {
        return new LoginResponse(true, "ログイン成功");
    }
}
