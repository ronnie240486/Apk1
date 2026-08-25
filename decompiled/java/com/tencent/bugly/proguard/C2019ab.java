package com.tencent.bugly.proguard;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import p000a.AbstractC0004e;

public final class C2019ab {

    private static final ArrayList<C2045b0> f7251a;

    private static final Map<Integer, String> f7252b;

    private static final String[] f7253c;

    static {
        C2068c c2068c = new C2068c();
        c2068c.add(new C2045b0(10));
        c2068c.add(new C2045b0(4));
        c2068c.add(new C2045b0(5));
        c2068c.add(new C2045b0(11));
        c2068c.add(new C2045b0(6));
        c2068c.add(new C2045b0(7));
        c2068c.add(new C2045b0(9));
        c2068c.add(new C2045b0(3));
        c2068c.add(new C2045b0(8));
        c2068c.add(new C2045b0(0));
        c2068c.add(new C2045b0(2));
        c2068c.add(new C2045b0(1));
        f7251a = c2068c;
        C2017a0 c2017a0 = new C2017a0();
        c2017a0.put(1, "GPRS");
        c2017a0.put(2, "EDGE");
        c2017a0.put(3, "UMTS");
        c2017a0.put(8, "HSDPA");
        c2017a0.put(9, "HSUPA");
        c2017a0.put(10, "HSPA");
        c2017a0.put(4, "CDMA");
        c2017a0.put(5, "EVDO_0");
        c2017a0.put(6, "EVDO_A");
        c2017a0.put(7, "1xRTT");
        c2017a0.put(11, "iDen");
        c2017a0.put(12, "EVDO_B");
        c2017a0.put(13, "LTE");
        c2017a0.put(14, "eHRPD");
        c2017a0.put(15, "HSPA+");
        f7252b = c2017a0;
        f7253c = new String[]{"/su", "/su/bin/su", "/sbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/data/local/su", "/system/xbin/su", "/system/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/system/bin/cufsdosck", "/system/xbin/cufsdosck", "/system/bin/cufsmgr", "/system/xbin/cufsmgr", "/system/bin/cufaevdd", "/system/xbin/cufaevdd", "/system/bin/conbb", "/system/xbin/conbb"};
    }

    public static String m4546a() {
        try {
            return Build.MODEL;
        } catch (Throwable th) {
            if (C2029al.m4641a(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    public static String m4549b() {
        try {
            return Build.VERSION.RELEASE;
        } catch (Throwable th) {
            if (C2029al.m4641a(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    public static int m4550c() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (Throwable th) {
            if (C2029al.m4641a(th)) {
                return -1;
            }
            th.printStackTrace();
            return -1;
        }
    }

    public static String m4552d() {
        try {
            return String.valueOf(System.getProperty("os.arch"));
        } catch (Throwable th) {
            if (C2029al.m4641a(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    public static long m4553e() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            if (!C2029al.m4641a(th)) {
                th.printStackTrace();
            }
            return -1L;
        }
    }

    public static long m4554f() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            if (!C2029al.m4641a(th)) {
                th.printStackTrace();
            }
            return -1L;
        }
    }

    public static long m4555g() {
        BufferedReader bufferedReader;
        Throwable th;
        long j10 = 0;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader("/proc/self/status"));
                try {
                    for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                        if (line.startsWith("VmSize")) {
                            j10 = Long.parseLong(line.replaceAll("[^\\d]", ""));
                            break;
                        }
                    }
                    bufferedReader.close();
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        C2029al.m4641a(th);
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return j10 * 1024;
                    } catch (Throwable th3) {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable th4) {
                                th4.printStackTrace();
                            }
                        }
                        throw th3;
                    }
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        } catch (Throwable th6) {
            bufferedReader = null;
            th = th6;
        }
        return j10 * 1024;
    }

    public static long m4556h() {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    public static long m4557i() {
        FileReader fileReader;
        Throwable th;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 2048);
                try {
                    String line = bufferedReader.readLine();
                    if (line != null) {
                        long j10 = Long.parseLong(line.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) * 1024;
                        try {
                            bufferedReader.close();
                        } catch (IOException e5) {
                            if (!C2029al.m4641a(e5)) {
                                e5.printStackTrace();
                            }
                        }
                        try {
                            fileReader.close();
                        } catch (IOException e10) {
                            if (!C2029al.m4641a(e10)) {
                                e10.printStackTrace();
                            }
                        }
                        return j10;
                    }
                    try {
                        bufferedReader.close();
                    } catch (IOException e11) {
                        if (!C2029al.m4641a(e11)) {
                            e11.printStackTrace();
                        }
                    }
                    try {
                        fileReader.close();
                        return -1L;
                    } catch (IOException e12) {
                        if (C2029al.m4641a(e12)) {
                            return -1L;
                        }
                        e12.printStackTrace();
                        return -1L;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        if (!C2029al.m4641a(th)) {
                            th.printStackTrace();
                        }
                        if (fileReader == null) {
                            return -2L;
                        }
                        try {
                            return -2L;
                        } catch (IOException e13) {
                        }
                    } finally {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e14) {
                                if (!C2029al.m4641a(e14)) {
                                    e14.printStackTrace();
                                }
                            }
                        }
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (IOException e15) {
                                if (!C2029al.m4641a(e15)) {
                                    e15.printStackTrace();
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (Throwable th4) {
            fileReader = null;
            th = th4;
            bufferedReader = null;
        }
    }

    public static long m4558j() {
        FileReader fileReader;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                BufferedReader bufferedReader2 = new BufferedReader(fileReader, 2048);
                try {
                    bufferedReader2.readLine();
                    String line = bufferedReader2.readLine();
                    if (line == null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e5) {
                            if (!C2029al.m4641a(e5)) {
                                e5.printStackTrace();
                            }
                        }
                        try {
                            fileReader.close();
                        } catch (IOException e10) {
                            if (!C2029al.m4641a(e10)) {
                                e10.printStackTrace();
                            }
                        }
                        return -1L;
                    }
                    long j10 = Long.parseLong(line.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) * 1024;
                    String line2 = bufferedReader2.readLine();
                    if (line2 == null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e11) {
                            if (!C2029al.m4641a(e11)) {
                                e11.printStackTrace();
                            }
                        }
                        try {
                            fileReader.close();
                        } catch (IOException e12) {
                            if (!C2029al.m4641a(e12)) {
                                e12.printStackTrace();
                            }
                        }
                        return -1L;
                    }
                    long j11 = Long.parseLong(line2.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim());
                    Long.signum(j11);
                    long j12 = (j11 * 1024) + j10;
                    String line3 = bufferedReader2.readLine();
                    if (line3 == null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e13) {
                            if (!C2029al.m4641a(e13)) {
                                e13.printStackTrace();
                            }
                        }
                        try {
                            fileReader.close();
                        } catch (IOException e14) {
                            if (!C2029al.m4641a(e14)) {
                                e14.printStackTrace();
                            }
                        }
                        return -1L;
                    }
                    long j13 = (Long.parseLong(line3.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) * 1024) + j12;
                    try {
                        bufferedReader2.close();
                    } catch (IOException e15) {
                        if (!C2029al.m4641a(e15)) {
                            e15.printStackTrace();
                        }
                    }
                    try {
                        fileReader.close();
                    } catch (IOException e16) {
                        if (!C2029al.m4641a(e16)) {
                            e16.printStackTrace();
                        }
                    }
                    return j13;
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    try {
                        if (!C2029al.m4641a(th)) {
                            th.printStackTrace();
                        }
                        if (fileReader == null) {
                            return -2L;
                        }
                        try {
                            return -2L;
                        } catch (IOException e17) {
                        }
                    } finally {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e18) {
                                if (!C2029al.m4641a(e18)) {
                                    e18.printStackTrace();
                                }
                            }
                        }
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (IOException e19) {
                                if (!C2029al.m4641a(e19)) {
                                    e19.printStackTrace();
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            fileReader = null;
        }
    }

    public static long m4559k() {
        if (!m4567s()) {
            return 0L;
        }
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            if (C2029al.m4641a(th)) {
                return -2L;
            }
            th.printStackTrace();
            return -2L;
        }
    }

    public static long m4560l() {
        if (!m4567s()) {
            return 0L;
        }
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            if (C2029al.m4641a(th)) {
                return -2L;
            }
            th.printStackTrace();
            return -2L;
        }
    }

    public static String m4561m() {
        return "";
    }

    public static String m4562n() {
        String string;
        Iterator<C2045b0> it = f7251a.iterator();
        while (it.hasNext()) {
            switch (it.next().f7439a) {
                case 0:
                    String strM4679a = C2033ap.m4679a("ro.gn.gnromvernumber");
                    if (C2033ap.m4703b(strM4679a) || strM4679a.equals("fail")) {
                        string = null;
                    } else {
                        StringBuilder sbM30x = AbstractC0004e.m30x("amigo/", strM4679a, "/");
                        sbM30x.append(C2033ap.m4679a("ro.build.display.id"));
                        string = sbM30x.toString();
                    }
                    break;
                case 1:
                    string = C2033ap.m4679a("ro.build.fingerprint") + "/" + C2033ap.m4679a("ro.build.rom.id");
                    break;
                case 2:
                    String strM4679a2 = C2033ap.m4679a("ro.build.tyd.kbstyle_version");
                    if (C2033ap.m4703b(strM4679a2) || strM4679a2.equals("fail")) {
                        string = null;
                    } else {
                        string = "dido/".concat(strM4679a2);
                    }
                    break;
                case 3:
                    String strM4679a3 = C2033ap.m4679a("ro.aa.romver");
                    if (C2033ap.m4703b(strM4679a3) || strM4679a3.equals("fail")) {
                        string = null;
                    } else {
                        StringBuilder sbM30x2 = AbstractC0004e.m30x("htc/", strM4679a3, "/");
                        sbM30x2.append(C2033ap.m4679a("ro.build.description"));
                        string = sbM30x2.toString();
                    }
                    break;
                case 4:
                    String strM4679a4 = C2033ap.m4679a("ro.build.version.emui");
                    if (C2033ap.m4703b(strM4679a4) || strM4679a4.equals("fail")) {
                        string = null;
                    } else {
                        string = "HuaWei/EMOTION/".concat(strM4679a4);
                    }
                    break;
                case 5:
                    String strM4679a5 = C2033ap.m4679a("ro.lenovo.series");
                    if (C2033ap.m4703b(strM4679a5) || strM4679a5.equals("fail")) {
                        string = null;
                    } else {
                        string = "Lenovo/VIBE/".concat(String.valueOf(C2033ap.m4679a("ro.build.version.incremental")));
                    }
                    break;
                case 6:
                    String strM4679a6 = C2033ap.m4679a("ro.meizu.product.model");
                    if (C2033ap.m4703b(strM4679a6) || strM4679a6.equals("fail")) {
                        string = null;
                    } else {
                        string = "Meizu/FLYME/" + C2033ap.m4679a("ro.build.display.id");
                    }
                    break;
                case 7:
                    String strM4679a7 = C2033ap.m4679a("ro.build.version.opporom");
                    if (C2033ap.m4703b(strM4679a7) || strM4679a7.equals("fail")) {
                        string = null;
                    } else {
                        string = "Oppo/COLOROS/".concat(strM4679a7);
                    }
                    break;
                case 8:
                    String strM4679a8 = C2033ap.m4679a("ro.lewa.version");
                    if (C2033ap.m4703b(strM4679a8) || strM4679a8.equals("fail")) {
                        string = null;
                    } else {
                        StringBuilder sbM30x3 = AbstractC0004e.m30x("tcl/", strM4679a8, "/");
                        sbM30x3.append(C2033ap.m4679a("ro.build.display.id"));
                        string = sbM30x3.toString();
                    }
                    break;
                case 9:
                    String strM4679a9 = C2033ap.m4679a("ro.vivo.os.build.display.id");
                    if (C2033ap.m4703b(strM4679a9) || strM4679a9.equals("fail")) {
                        string = null;
                    } else {
                        string = "vivo/FUNTOUCH/".concat(strM4679a9);
                    }
                    break;
                case 10:
                    String strM4679a10 = C2033ap.m4679a("ro.miui.ui.version.name");
                    if (C2033ap.m4703b(strM4679a10) || strM4679a10.equals("fail")) {
                        string = null;
                    } else {
                        string = "XiaoMi/MIUI/".concat(strM4679a10);
                    }
                    break;
                default:
                    String strM4679a11 = C2033ap.m4679a("ro.build.nubia.rom.name");
                    if (C2033ap.m4703b(strM4679a11) || strM4679a11.equals("fail")) {
                        string = null;
                    } else {
                        StringBuilder sbM30x4 = AbstractC0004e.m30x("Zte/NUBIA/", strM4679a11, "_");
                        sbM30x4.append(C2033ap.m4679a("ro.build.nubia.rom.code"));
                        string = sbM30x4.toString();
                    }
                    break;
            }
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
        }
        return null;
    }

    public static boolean m4563o() {
        String strM4679a = C2033ap.m4679a("ro.build.version.opporom");
        return !TextUtils.isEmpty((C2033ap.m4703b(strM4679a) || strM4679a.equals("fail")) ? null : "Oppo/COLOROS/".concat(strM4679a));
    }

    public static boolean m4564p() {
        String strM4679a = C2033ap.m4679a("ro.vivo.os.build.display.id");
        return !TextUtils.isEmpty((C2033ap.m4703b(strM4679a) || strM4679a.equals("fail")) ? null : "vivo/FUNTOUCH/".concat(strM4679a));
    }

    public static boolean m4565q() {
        boolean z7;
        String[] strArr = f7253c;
        int length = strArr.length;
        int i6 = 0;
        while (true) {
            if (i6 >= length) {
                z7 = false;
                break;
            }
            if (new File(strArr[i6]).exists()) {
                z7 = true;
                break;
            }
            i6++;
        }
        String str = Build.TAGS;
        return (str != null && str.contains("test-keys")) || z7;
    }

    public static boolean m4566r() {
        float fMaxMemory = (float) ((Runtime.getRuntime().maxMemory() * 1.0d) / 1048576.0d);
        float f = (float) ((Runtime.getRuntime().totalMemory() * 1.0d) / 1048576.0d);
        float f3 = fMaxMemory - f;
        C2029al.m4644c("maxMemory : %f", Float.valueOf(fMaxMemory));
        C2029al.m4644c("totalMemory : %f", Float.valueOf(f));
        C2029al.m4644c("freeMemory : %f", Float.valueOf(f3));
        return f3 < 10.0f;
    }

    private static boolean m4567s() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Throwable th) {
            if (C2029al.m4641a(th)) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    public static String m4551c(Context context) {
        TelephonyManager telephonyManager;
        String str = "unknown";
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return null;
            }
            if (activeNetworkInfo.getType() == 1) {
                return "WIFI";
            }
            if (activeNetworkInfo.getType() == 0 && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
                int networkType = telephonyManager.getNetworkType();
                String str2 = f7252b.get(Integer.valueOf(networkType));
                if (str2 == null) {
                    try {
                        str = "MOBILE(" + networkType + ")";
                    } catch (Exception e5) {
                        e = e5;
                        str = str2;
                        if (!C2029al.m4641a(e)) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    str = str2;
                }
            }
            return str;
        } catch (Exception e10) {
            e = e10;
        }
        if (!C2029al.m4641a(e)) {
            e.printStackTrace();
        }
        return str;
    }

    public static String m4547a(Context context) {
        if (context != null && context.getApplicationInfo() != null) {
            String str = context.getApplicationInfo().nativeLibraryDir;
            if (TextUtils.isEmpty(str)) {
                return "fail";
            }
            if (str.endsWith("arm")) {
                return "armeabi-v7a";
            }
            if (str.endsWith("arm64")) {
                return "arm64-v8a";
            }
            if (str.endsWith("x86")) {
                return "x86";
            }
            if (str.endsWith("x86_64")) {
                return "x86_64";
            }
        }
        return "fail";
    }

    public static long m4548b(Context context) {
        long pss;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                return 0L;
            }
            pss = activityManager.getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss();
        } catch (Throwable unused) {
            pss = Debug.getPss();
        }
        return pss * 1024;
    }
}
