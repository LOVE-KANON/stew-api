package com.example.stew.core.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 日付ユーティリティクラス
 */
public final class DateUtils {

    /**
     * 型変換(文字列⇒日付)
     * 変換失敗時はnullをリターン
     * @param str 対象文字列
     * @param formatter 日付フォーマット
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
