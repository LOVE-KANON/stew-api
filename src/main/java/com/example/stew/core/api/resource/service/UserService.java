package com.example.stew.core.api.resource.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.stew.core.api.resource.controller.dto.user.GetMaxSeqUserByUserIdRequest;
import com.example.stew.core.api.resource.controller.dto.user.GetMaxSeqUserByUserIdResponse;
import com.example.stew.core.api.resource.controller.dto.user.UpdateRequest;
import com.example.stew.core.api.resource.controller.dto.user.UpdateResponse;
import com.example.stew.core.api.resource.entity.CoreUserEntity;
import com.example.stew.core.api.resource.mapper.CoreUserMapper;
import com.example.stew.core.exception.ConflictException;
import com.example.stew.core.helper.DefaultDatabaseHelper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final CoreUserMapper coreUserMapper;
    private final DefaultDatabaseHelper<CoreUserEntity> databaseHelper;

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

    public UpdateResponse update(UpdateRequest request) {

        UpdateResponse response = new UpdateResponse();

        // PK更新
        CoreUserEntity updateEntity = new CoreUserEntity();
        BeanUtils.copyProperties(request, updateEntity);
        int count = databaseHelper.update(updateEntity, coreUserMapper);
        if (count == 0) {
            throw new ConflictException("他のユーザによって更新された可能性があります");
        }
        response.setProcessedCount(count);

        return response;
    }
}
