package com.tencent.bugly.crashreport.inner;

import com.tencent.bugly.proguard.C2029al;
import com.tencent.bugly.proguard.C2038au;
import java.util.Map;

public class InnerApi {
    public static void postCocos2dxCrashAsync(int i6, String str, String str2, String str3) {
        if (str == null || str2 == null || str3 == null) {
            C2029al.m4646e("post cocos2d-x fail args null", new Object[0]);
        } else if (i6 != 5 && i6 != 6) {
            C2029al.m4646e("post cocos2d-x fail category illeagle: %d", Integer.valueOf(i6));
        } else {
            C2029al.m4640a("post cocos2d-x crash %s %s", str, str2);
            C2038au.m4783a(Thread.currentThread(), i6, str, str2, str3, null);
        }
    }

    public static void postH5CrashAsync(Thread thread, String str, String str2, String str3, Map<String, String> map) {
        if (str == null || str2 == null || str3 == null) {
            C2029al.m4646e("post h5 fail args null", new Object[0]);
        } else {
            C2029al.m4640a("post h5 crash %s %s", str, str2);
            C2038au.m4783a(thread, 8, str, str2, str3, map);
        }
    }

    public static void postU3dCrashAsync(String str, String str2, String str3) {
        if (str == null || str2 == null || str3 == null) {
            C2029al.m4646e("post u3d fail args null", new Object[0]);
        }
        C2029al.m4640a("post u3d crash %s %s", str, str2);
        C2038au.m4783a(Thread.currentThread(), 4, str, str2, str3, null);
    }
}
