package com.example.stew.core.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.example.stew.core.dto.session.SessionInfo;
import com.example.stew.core.exception.UnauthorizedException;
import com.example.stew.core.helper.SessionHelper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * セッション関連インターセプター
 */
@Component
public class SessionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) {

        HttpSession session = request.getSession(false);
        if (session == null) {
            throw new UnauthorizedException("セッション情報が取得できませんでした。");
        }
        SessionInfo info =
                (SessionInfo) session.getAttribute("SESSION_INFO");
        SessionHelper.setSessionInfo(info);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex) {
        SessionHelper.clear();
    }
}
