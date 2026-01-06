package com.example.stew.core.api.resource.entity;

import java.time.LocalDateTime;

import com.example.stew.core.base.entity.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * ユーザ基本情報テーブル（CORE_USER）エンティティクラス
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CoreUserEntity extends BaseEntity {

    // ユーザID
    private String userId;

    // 姓
    private String sei;

    // 名
    private String mei;

    // パスワード
    private String password;

    // 最終ログイン日時
    private LocalDateTime lastLogin;

    // 登録日
    private LocalDateTime joinedDate;

    // 役職
    private String position;
}
