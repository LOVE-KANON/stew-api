package com.example.stew.core.api.usecase.service;

import org.springframework.stereotype.Service;

import com.example.stew.core.api.resource.entity.CoreUserEntity;
import com.example.stew.core.api.resource.mapper.CoreUserMapper;
import com.example.stew.core.api.usecase.controller.dto.login.LoginRequest;
import com.example.stew.core.api.usecase.controller.dto.login.LoginResponse;
import com.example.stew.core.api.usecase.controller.dto.login.LogoutRequest;
import com.example.stew.core.api.usecase.controller.dto.login.LogoutResponse;
import com.example.stew.core.dto.session.SessionInfo;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final CoreUserMapper coreUserMapper;

    public LoginResponse login(LoginRequest request, HttpSession session) {

        // ユーザ情報取得
        CoreUserEntity user = coreUserMapper.findByPk(CoreUserEntity.builder().userId(request.getUserId()).build());

        if (user == null || !user.getPassword().equals(request.getPassword())) {
            return new LoginResponse(false, "ログイン情報が不正です");
        }

        // セッション保存
        SessionInfo sessionInfo = new SessionInfo(
                user.getUserId(),
                user.getSei(),
                user.getMei(),
                user.getPosition()
        );
        session.setAttribute("SESSION_INFO", sessionInfo);

        return new LoginResponse(true, "ログイン成功");
    }

    public LogoutResponse logout(LogoutRequest request, HttpSession session) {
        // セッション破棄
        session.invalidate();
        return new LogoutResponse();
    }
}
