package org.bitspark.android.utils;

import android.content.Context;
import com.nmmedit.protect.NativeUtil;
import java.util.Formatter;
import java.util.HashSet;
import java.util.Locale;
import okhttp3.OkHttpClient;

public abstract class AbstractC3331m {

    public static long f11243a;

    public static boolean f11244b;

    public static final StringBuilder f11245c;

    public static final Formatter f11246d;

    public static final C3321c f11247e;

    public static native String m6751a(Long l9);

    public static native String m6752b(long j10);

    public static native long m6753c(long j10);

    public static native OkHttpClient m6754d(String str);

    public static native Boolean m6755e(String str, boolean z7);

    public static native Integer m6756f(int i6, String str);

    public static native String m6757g(String str, String str2);

    public static native String m6758h(Long l9);

    public static native void m6759i(String str, String str2);

    public static native long m6760j(Long l9);

    public static native void m6761k();

    public static native void m6762l(String str);

    public static native void m6763m(int i6, String str);

    public static native void m6764n(String str, String str2);

    public static native void m6765o(String str, HashSet hashSet);

    public static native Boolean m6766p(Context context);

    public static native String m6767q(long j10);

    static {
        NativeUtil.classesInit0(5);
        StringBuilder sb = new StringBuilder();
        f11245c = sb;
        f11246d = new Formatter(sb, Locale.getDefault());
        f11247e = new C3321c();
    }
}
