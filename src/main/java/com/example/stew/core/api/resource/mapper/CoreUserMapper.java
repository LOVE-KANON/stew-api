package com.example.stew.core.api.resource.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.stew.core.api.resource.entity.CoreUserEntity;
import com.example.stew.core.base.mapper.BaseMapper;

@Mapper
public interface CoreUserMapper extends BaseMapper<CoreUserEntity> {

    CoreUserEntity findByPk(CoreUserEntity entity);

    List<CoreUserEntity> find(CoreUserEntity entity);

    int insert(CoreUserEntity entity);

    int updateByPk(CoreUserEntity entity);

    int logicalDeleteByPk(CoreUserEntity entity);

    CoreUserEntity findMaxSeqUserByUserId(CoreUserEntity entity);
}
