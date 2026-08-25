package com.tvbus.engine;

import android.content.Context;
import com.nmmedit.protect.NativeUtil;

public class TVCore {
    static final int RM_CLIENT = 2;
    static final int RM_MASTER = 1;
    static final int RM_STANDALONE = 0;
    private static TVCore inst;
    private static long nativeHandle;
    private TVListener tvListener = null;
    private String mkBroker = null;

    private TVCore() {
    }

    private native String description(long j10);

    private native void diagnose(long j10);

    private native String err2String(long j10, int i6);

    public static native synchronized TVCore getInstance();

    private native String getVersion(long j10);

    private native String getVersion2(long j10);

    private native int init(long j10, Context context);

    private native long initialise();

    private native void quit(long j10);

    private native int run(long j10);

    private native void setAuthItems(long j10, String str, String str2, String str3);

    private native void setAuthUrl(long j10, String str);

    private native void setDomainSuffix(long j10, String str);

    private native void setListener(long j10, TVListener tVListener);

    private native void setMKBroker(long j10, String str);

    private native void setOption(long j10, String str, String str2);

    private native void setPassword(long j10, String str);

    private native void setPlayPort(long j10, int i6);

    private native void setRunningMode(long j10, int i6);

    private native void setServPort(long j10, int i6);

    private native void setUsername(long j10, String str);

    private native void start(long j10, String str);

    private native void start2(long j10, String str, String str2);

    private native void stop(long j10);

    private native void stop2(long j10, int i6);

    public native String description();

    public native void diagnose();

    public native String err2String(int i6);

    public native String getVersion();

    public native String getVersion(int i6);

    public native int init(Context context);

    public native void quit();

    public native int run();

    public native void setAuthItems(String str, String str2, String str3);

    public native void setAuthUrl(String str);

    public native void setDomainSuffix(String str);

    public native void setMKBroker(String str);

    public native void setOption(String str, String str2);

    public native void setPassword(String str);

    public native void setPlayPort(int i6);

    public native void setRunningMode(int i6);

    public native void setServPort(int i6);

    public native void setTVListener(TVListener tVListener);

    public native void setUsername(String str);

    public native void start(String str);

    public native void start(String str, String str2);

    public native void stop();

    public native void stop(int i6);

    static {
        NativeUtil.classesInit0(37);
        try {
            System.loadLibrary("tvcore");
        } catch (Throwable unused) {
        }
    }
}
