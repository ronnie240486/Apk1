package com.lzy.okgo.utils;

import android.util.Log;

public class OkLogger {
    private static boolean isLogEnable = true;
    private static String tag = "OkGo";

    public static void m4459d(String str) {
        m4460d(tag, str);
    }

    public static void debug(boolean z7) {
        debug(tag, z7);
    }

    public static void m4461e(String str) {
        m4462e(tag, str);
    }

    public static void m4463i(String str) {
        m4464i(tag, str);
    }

    public static void printStackTrace(Throwable th) {
        if (!isLogEnable || th == null) {
            return;
        }
        th.printStackTrace();
    }

    public static void m4465v(String str) {
        m4466v(tag, str);
    }

    public static void m4467w(String str) {
        m4468w(tag, str);
    }

    public static void m4460d(String str, String str2) {
        if (isLogEnable) {
            Log.d(str, str2);
        }
    }

    public static void debug(String str, boolean z7) {
        tag = str;
        isLogEnable = z7;
    }

    public static void m4462e(String str, String str2) {
        if (isLogEnable) {
            Log.e(str, str2);
        }
    }

    public static void m4464i(String str, String str2) {
        if (isLogEnable) {
            Log.i(str, str2);
        }
    }

    public static void m4466v(String str, String str2) {
        if (isLogEnable) {
            Log.v(str, str2);
        }
    }

    public static void m4468w(String str, String str2) {
        if (isLogEnable) {
            Log.w(str, str2);
        }
    }
}
