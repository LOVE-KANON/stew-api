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

    /**
     * 型変換(日時⇒日時文字列)
     * 変換失敗時はnullをリターン
     * @param dt 対象日時
     * @param formatter 日時フォーマット
     * @return String
     */
    public static String toString(LocalDateTime dt, DateTimeFormatter formatter) {
        try {
            return dt.format(formatter);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 日時文字列のフォーマット変換(日時文字列⇒日時文字列)
     * 変換失敗時はnullをリターン
     * @param str 対象文字列
     * @param srcFormatter 対象文字列の日時フォーマット(変換前)
     * @param destFormatter 対象文字列の日時フォーマット(変換後)
     * @return String
     */
    public static String convertDateTimeFormat(String str, DateTimeFormatter srcFormatter, DateTimeFormatter destFormatter) {
        try {
            LocalDateTime localDateTime = toLocalDateTime(str, srcFormatter);
            return toString(localDateTime, destFormatter);
        } catch (Exception e) {
            return null;
        }
    }
}
