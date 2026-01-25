package com.example.stew.core.helper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Repository;

import com.example.stew.core.base.entity.BaseEntity;
import com.example.stew.core.base.mapper.BaseMapper;

/**
 * BaseEntity/BaseMapperを利用したMyBatisマッパーインターフェースに対しての
 * 共通カラム設定の補助クラス
 *
 * <p>
 * 登録/更新/論理削除 時の共通カラム設定を一元管理する
 * </p>
 */
@Repository
public class DefaultDatabaseHelper<E extends BaseEntity> {

    /**
     * 登録
     * @param <E> エンティティ(クラス)
     * @param entity エンティティ
     * @param mapper BaseMapperを継承したマッパー
     * @return 登録件数
     */
    public int insert(E entity, BaseMapper<E> mapper) {

        LocalDateTime now = LocalDateTime.now();
        entity.setCreateUser("anonymous");
        entity.setCreateAt(now);
        entity.setUpdateUser("anonymous");
        entity.setUpdateAt(now);
        entity.setDeleteFlg(false);
        entity.setVersion(0L);

        return mapper.insert(entity);
    }

    /**
     * 更新
     * @param <E> エンティティ(クラス)
     * @param entity エンティティ
     * @param mapper BaseMapperを継承したマッパー
     * @return 更新件数
     */
    public int update(E entity, BaseMapper<E> mapper) {

        entity.setUpdateUser("anonymous");
        entity.setUpdateAt(LocalDateTime.now());

        return mapper.updateByPk(entity);
    }

    /**
     * 論理削除
     * @param <E> エンティティ(クラス)
     * @param entity エンティティ
     * @param mapper BaseMapperを継承したマッパー
     * @return 論理削除件数
     */
    public int logicalDelete(E entity, BaseMapper<E> mapper) {

        entity.setDeleteFlg(true);

        return update(entity, mapper);
    }
}
