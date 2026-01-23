package com.example.stew.core.api.resource.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.stew.core.api.dto.ApiResponse;
import com.example.stew.core.api.resource.controller.dto.user.GetMaxSeqUserByUserIdRequest;
import com.example.stew.core.api.resource.controller.dto.user.GetMaxSeqUserByUserIdResponse;
import com.example.stew.core.api.resource.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/core/resource/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/getMaxSeqUserByUserId")
    public ApiResponse<GetMaxSeqUserByUserIdResponse> getMaxSeqUserByUserId(GetMaxSeqUserByUserIdRequest request) {
        return new ApiResponse<GetMaxSeqUserByUserIdResponse>(userService.getMaxSeqUserByUserId(request));
    }
}
