package com.tencent.bugly.crashreport;

import android.util.Log;
import com.tencent.bugly.proguard.C2032ao;
import com.tencent.bugly.proguard.C2094p;

public class BuglyLog {
    public static void m4470d(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (C2094p.f7657c) {
            Log.d(str, str2);
        }
        C2032ao.m4657a("D", str, str2);
    }

    public static void m4471e(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (C2094p.f7657c) {
            Log.e(str, str2);
        }
        C2032ao.m4657a("E", str, str2);
    }

    public static void m4473i(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (C2094p.f7657c) {
            Log.i(str, str2);
        }
        C2032ao.m4657a("I", str, str2);
    }

    public static void setCache(int i6) {
        C2032ao.m4655a(i6);
    }

    public static void m4474v(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (C2094p.f7657c) {
            Log.v(str, str2);
        }
        C2032ao.m4657a("V", str, str2);
    }

    public static void m4475w(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (C2094p.f7657c) {
            Log.w(str, str2);
        }
        C2032ao.m4657a("W", str, str2);
    }

    public static void m4472e(String str, String str2, Throwable th) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (C2094p.f7657c) {
            Log.e(str, str2, th);
        }
        C2032ao.m4658a("E", str, th);
    }
}
