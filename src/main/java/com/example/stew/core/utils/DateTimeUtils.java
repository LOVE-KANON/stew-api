package com.example.stew.core.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 日時ユーティリティクラス
 */
public final class DateTimeUtils {

    /**
     * 型変換(日時文字列⇒日時)
     * 変換失敗時はnullをリターン
     * @param str 対象文字列
     * @param formatter 日時フォーマット
     * @return LocalDateTime
     */
    public static LocalDateTime toLocalDateTime(String str, DateTimeFormatter formatter) {
        try {
            return LocalDateTime.parse(str, formatter);
        } catch (Exception e) {
            return null;
        }
    }
}
