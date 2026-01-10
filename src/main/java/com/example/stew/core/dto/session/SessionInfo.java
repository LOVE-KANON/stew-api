package com.example.stew.core.dto.session;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 認証済みユーザのセッション情報DTOクラス
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SessionInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /** ユーザID */
    private String userId;

    /** 姓 */
    private String sei;

    /** 名 */
    private String mei;

    /** 役職 */
    private String position;

    /**
     * ユーザ名取得
     * @return String ユーザ名(姓 + {全角スペース} + 名)
     */
    public String getUserName() {
        return String.join("　", this.sei, this.mei);
    }
}
