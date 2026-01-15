package com.example.stew.core.api.usecase.controller.dto.auth;

import lombok.Data;

@Data
public class GetAuthenticatedUserResponse {

    /** ユーザID */
    private String userId;

    /** ユーザ名 */
    private String userName;
}
