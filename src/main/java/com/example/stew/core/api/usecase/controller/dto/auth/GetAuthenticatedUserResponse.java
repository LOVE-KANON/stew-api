package com.example.stew.core.api.usecase.controller.dto.auth;

import java.util.UUID;

import lombok.Data;

@Data
public class GetAuthenticatedUserResponse {

    /** ユーザID */
    private UUID userId;

    /** ユーザ名 */
    private String userName;
}
