package com.tencent.bugly.proguard;

import android.util.Log;
import java.util.Locale;

public final class C2029al {

    public static String f7314a = "CrashReportInfo";

    public static String f7315b = "CrashReport";

    public static boolean f7316c;

    private static boolean m4637a(int i6, String str, Object... objArr) {
        if (!f7316c) {
            return false;
        }
        if (str == null) {
            str = "null";
        } else if (objArr != null && objArr.length != 0) {
            str = String.format(Locale.US, str, objArr);
        }
        if (i6 == 0) {
            Log.i(f7315b, str);
            return true;
        }
        if (i6 == 1) {
            Log.d(f7315b, str);
            return true;
        }
        if (i6 == 2) {
            Log.w(f7315b, str);
            return true;
        }
        if (i6 == 3) {
            Log.e(f7315b, str);
            return true;
        }
        if (i6 != 5) {
            return false;
        }
        Log.i(f7314a, str);
        return true;
    }

    public static boolean m4642b(String str, Object... objArr) {
        return m4637a(5, str, objArr);
    }

    public static boolean m4644c(String str, Object... objArr) {
        return m4637a(1, str, objArr);
    }

    public static boolean m4645d(String str, Object... objArr) {
        return m4637a(2, str, objArr);
    }

    public static boolean m4646e(String str, Object... objArr) {
        return m4637a(3, str, objArr);
    }

    public static boolean m4643b(Throwable th) {
        return m4638a(3, th);
    }

    private static boolean m4638a(int i6, Throwable th) {
        if (f7316c) {
            return m4637a(i6, C2033ap.m4681a(th), new Object[0]);
        }
        return false;
    }

    public static boolean m4640a(String str, Object... objArr) {
        return m4637a(0, str, objArr);
    }

    public static boolean m4639a(Class cls, String str, Object... objArr) {
        Locale locale = Locale.US;
        return m4637a(0, "[" + cls.getSimpleName() + "] " + str, objArr);
    }

    public static boolean m4641a(Throwable th) {
        return m4638a(2, th);
    }
}
