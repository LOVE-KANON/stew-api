package com.example.stew.core.utils;

/**
 * 数値ユーティリティクラス
 */
public final class NumberUtils {

    /**
     * 型変換(文字列⇒数値)
     * 変換失敗時はnullをリターン
     * @param str 対象文字列
     * @return Integer
     */
    public static Integer toInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 型変換(文字列⇒数値)
     * 変換失敗時はnullをリターン
     * @param str 対象文字列
     * @return Long
     */
    public static Long toLong(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            return null;
        }
    }
}
