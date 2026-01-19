package com.example.stew.core.api.usecase.service;

import org.springframework.stereotype.Service;

import com.example.stew.core.api.resource.entity.CoreUserEntity;
import com.example.stew.core.api.usecase.controller.dto.auth.GetAuthenticatedUserRequest;
import com.example.stew.core.api.usecase.controller.dto.auth.GetAuthenticatedUserResponse;
import com.example.stew.core.api.usecase.controller.dto.auth.LoginRequest;
import com.example.stew.core.api.usecase.controller.dto.auth.LoginResponse;
import com.example.stew.core.api.usecase.controller.dto.auth.LogoutRequest;
import com.example.stew.core.api.usecase.controller.dto.auth.LogoutResponse;
import com.example.stew.core.api.usecase.mapper.AuthMapper;
import com.example.stew.core.dto.session.SessionInfo;
import com.example.stew.core.helper.SessionHelper;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthMapper authMapper;

    public LoginResponse login(LoginRequest request, HttpSession session) {

        LoginResponse response = new LoginResponse();

        // ユーザ情報取得
        CoreUserEntity user = authMapper.getMaxSeqAuthUser(CoreUserEntity.builder().mailAddress(request.getLoginId()).build());
        if (user == null || !user.getPassword().equals(request.getPassword())) {
            response.setSuccess(false);
            response.setMessage("ログイン情報が不正です");
            return response;
        }

        // セッション保存
        SessionInfo sessionInfo = new SessionInfo(
                user.getUserId(),
                user.getUserSeq(),
                user.getMailAddress(),
                user.getSei(),
                user.getMei(),
                user.getPosition()
        );
        session.setAttribute("SESSION_INFO", sessionInfo);

        response.setSuccess(true);
        response.setMessage("ログイン成功");
        return response;
    }

    public LogoutResponse logout(LogoutRequest request, HttpSession session) {

        LogoutResponse response = new LogoutResponse();

        // セッション破棄
        session.invalidate();
        return response;
    }

    public GetAuthenticatedUserResponse getAuthenticatedUser(GetAuthenticatedUserRequest request) {

        GetAuthenticatedUserResponse response = new GetAuthenticatedUserResponse();

        // セッション情報に保持されているユーザ情報を取得
        SessionInfo sessionInfo = SessionHelper.getSessionInfo();
        if (sessionInfo != null) {
            // セッション情報が存在する(ログイン済みの)場合
            response.setUserId(sessionInfo.getUserId());
            response.setUserName(sessionInfo.getUserName());
        }
        return response;
    }
}
