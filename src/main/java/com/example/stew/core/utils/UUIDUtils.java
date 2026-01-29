package com.example.stew.core.utils;

import java.util.UUID;

/**
 * UUIDユーティリティクラス
 */
public final class UUIDUtils {

    /**
     * 型変換(文字列⇒UUID)
     * 変換失敗時はnullをリターン
     * @param str 対象文字列
     * @return Integer
     */
    public static UUID toUUID(String str) {
        try {
            return UUID.fromString(str);
        } catch (Exception e) {
            return null;
        }
    }
}
