package com.example.stew.core.api.resource.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.stew.core.api.resource.controller.dto.user.GetMaxSeqUserByUserIdRequest;
import com.example.stew.core.api.resource.controller.dto.user.GetMaxSeqUserByUserIdResponse;
import com.example.stew.core.api.resource.entity.CoreUserEntity;
import com.example.stew.core.api.resource.mapper.CoreUserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final CoreUserMapper coreUserMapper;

    public GetMaxSeqUserByUserIdResponse getMaxSeqUserByUserId(GetMaxSeqUserByUserIdRequest request) {

        GetMaxSeqUserByUserIdResponse response = new GetMaxSeqUserByUserIdResponse();

        // ユーザIDに紐づくMAX(ユーザ連番)のレコード取得
        CoreUserEntity user = coreUserMapper.findMaxSeqUserByUserId(CoreUserEntity.builder()
                .userId(request.getUserId())
                .build());
        if (user == null) {
            return response;
        }
        BeanUtils.copyProperties(user, response);
        return response;
    }
}
