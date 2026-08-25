package me.jessyan.autosize.utils;

import android.util.Log;

public class AutoSizeLog {
    private static final String TAG = "AndroidAutoSize";
    private static boolean debug;

    private AutoSizeLog() {
        throw new IllegalStateException("you can't instantiate me!");
    }

    public static void m6118d(String str) {
        if (debug) {
            Log.d(TAG, str);
        }
    }

    public static void m6119e(String str) {
        if (debug) {
            Log.e(TAG, str);
        }
    }

    public static boolean isDebug() {
        return debug;
    }

    public static void setDebug(boolean z7) {
        debug = z7;
    }

    public static void m6120w(String str) {
        if (debug) {
            Log.w(TAG, str);
        }
    }
}
