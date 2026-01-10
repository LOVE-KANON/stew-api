package com.example.stew.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * SpringSessionを利用するための明示的な設定クラス
 * 
 * <p>
 * セッションストア: Redis
 * </p>
 */
@Configuration
@EnableRedisHttpSession
public class SessionConfig {
}
