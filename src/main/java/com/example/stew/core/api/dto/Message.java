package com.example.stew.core.api.dto;

import lombok.Data;

/**
 * 汎用APIレスポンスクラス
 */
@Data
public class Message {
    private String level;
    private String message;
}
