package com.example.stew.core.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * 日付ユーティリティクラス
 */
public final class DateUtils {

    public static final String FORMAT_HYPHEN_YMD_COLON_HMS = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_SLASH_YMD_COLON_HMS = "yyyy/MM/dd HH:mm:ss";

    /**
     * 型変換(文字列⇒日付)
     * 変換失敗時はnullをリターン
     * @param str 対象文字列
     * @param format 日付フォーマット
     * @return LocalDateTime
     */
    public static LocalDateTime toLocalDateTime(String str, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            Date formatDate = sdf.parse(str);
            return LocalDateTime.ofInstant(formatDate.toInstant(), ZoneId.systemDefault());
        } catch (Exception e) {
            return null;
        }
    }
}
