package com.example.stew.core.api.resource.controller.dto.user;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class GetMaxSeqUserByUserIdResponse {
    private UUID userId;
    private Integer userSeq;
    private String joinedDate;
    private String retiredDate;
    private String sei;
    private String mei;
    private String mailAddress;
    private String password;
    private String position;
    private LocalDateTime lastLogin;
    private Long version;
}
