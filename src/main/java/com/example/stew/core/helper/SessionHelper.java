package com.example.stew.core.helper;

import com.example.stew.core.dto.session.SessionInfo;

/**
 * セッション情報をスレッドローカルで管理するクラス
 */
public class SessionHelper {

    private static final ThreadLocal<SessionInfo> HOLDER = new ThreadLocal<>();

    private SessionHelper() {}

    /**
     * セッションをスレッドローカルに保存する
     *
     * @param sessionInfo セッション情報
     * @return セッションID
     */
    public static void setSessionInfo(SessionInfo sessionInfo) {
        HOLDER.set(sessionInfo);
    };

    /**
     * スレッドローカルに保存されたセッション情報を取得する
     * @return SessionInfo セッション情報
     */
    public static SessionInfo getSessionInfo() {
        return HOLDER.get();
    };

    /**
     * スレッドローカル上のセッション情報をクリアする
     */
    public static void clear() {
        HOLDER.remove();
    };
}
