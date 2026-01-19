package com.example.stew.core.api.usecase.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.stew.core.api.resource.entity.CoreUserEntity;
import com.example.stew.core.base.mapper.BaseMapper;

@Mapper
public interface AuthMapper extends BaseMapper<CoreUserEntity> {

    CoreUserEntity getMaxSeqAuthUser(CoreUserEntity entity);

}
