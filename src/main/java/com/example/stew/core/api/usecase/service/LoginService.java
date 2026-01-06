package com.example.stew.core.api.usecase.service;

import com.example.stew.core.api.resource.entity.CoreUserEntity;
import com.example.stew.core.api.resource.mapper.CoreUserMapper;
import com.example.stew.core.api.usecase.controller.dto.login.LoginRequest;
import com.example.stew.core.api.usecase.controller.dto.login.LoginResponse;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final CoreUserMapper coreUserMapper;

    public LoginResponse login(LoginRequest request) {

        // ユーザ情報取得
        CoreUserEntity user = coreUserMapper.findByPk(CoreUserEntity.builder().userId(request.getUserId()).build());

        if (user == null || !user.getPassword().equals(request.getPassword())) {
            return new LoginResponse(false, "ログイン情報が不正です");
        }

        // TODO: Redis にセッション or JWT 発行
        return new LoginResponse(true, "ログイン成功");
    }
}
