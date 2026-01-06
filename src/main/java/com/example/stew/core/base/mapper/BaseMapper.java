package com.example.stew.core.base.mapper;

import com.example.stew.core.base.entity.BaseEntity;

/**
 * 単一エンティティの基底マッパーインターフェース
 * @param <E> BaseEntityを継承したエンティティクラス
 */
public interface BaseMapper<E extends BaseEntity> {

    /**
     * 検索(PK)
     * @param entity
     * @return 検索結果
     */
    E findByPk(E entity);

    /**
     * 登録
     * @param entity
     * @return 登録件数
     */
    int insert(E entity);

    /**
     * 更新(PK)
     * @param entity
     * @return 更新件数
     */
    int updateByPk(E entity);

    /**
     * 論理削除(PK)
     * @param entity
     * @return 論理削除件数
     */
    int logicalDeleteByPk(E entity);
}
