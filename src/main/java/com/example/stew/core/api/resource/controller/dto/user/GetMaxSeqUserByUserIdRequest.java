package com.example.stew.core.api.resource.controller.dto.user;

import java.util.UUID;

import lombok.Data;

@Data
public class GetMaxSeqUserByUserIdRequest {
    private UUID userId;
}
