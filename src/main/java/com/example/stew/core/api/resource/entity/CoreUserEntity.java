package com.example.stew.core.api.resource.entity;

import java.time.LocalDateTime;
import java.util.UUID;

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
    private UUID userId;

    // ユーザ連番
    private Integer userSeq;

    // 入社日
    private String joinedDate;

    // 退社日
    private String retiredDate;

    // 姓
    private String sei;

    // 名
    private String mei;

    // メールアドレス
    private String mailAddress;

    // パスワード
    private String password;

    // 役職
    private String position;

    // 最終ログイン日時
    private LocalDateTime lastLogin;
}
