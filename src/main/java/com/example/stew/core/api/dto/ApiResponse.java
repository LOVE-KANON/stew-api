package com.example.stew.core.api.dto;

import java.util.List;

import lombok.Data;

/**
 * 汎用APIレスポンスクラス
 */
@Data
public class ApiResponse<T> {
    private T detail;
    private List<Message> messages;

    public ApiResponse(T detail) {
        this.detail = detail;
    }
}
