package com.example.stew.core.base.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * 共通カラムを定義する基底エンティティクラス
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class BaseEntity {

    private String createUser;
    private LocalDateTime createAt;
    private String updateUser;
    private LocalDateTime updateAt;
    private Boolean deleteFlg;
    private Long version;

}
