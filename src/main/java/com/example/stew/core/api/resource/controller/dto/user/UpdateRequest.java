package com.example.stew.core.api.resource.controller.dto.user;

import lombok.Data;

@Data
public class UpdateRequest {
    private String userId;
    private String userSeq;
    private String joinedDate;
    private String retiredDate;
    private String sei;
    private String mei;
    private String mailAddress;
    private String password;
    private String position;
    private String version;
}
