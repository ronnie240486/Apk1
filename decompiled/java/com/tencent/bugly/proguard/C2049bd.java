package com.tencent.bugly.proguard;

import android.app.ActivityManager;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler;
import java.util.HashMap;
import java.util.Map;
import p000a.AbstractC0004e;

public final class C2049bd implements NativeExceptionHandler {

    private final Context f7458a;

    private final C2036as f7459b;

    private final C2018aa f7460c;

    private final C2020ac f7461d;

    public C2049bd(Context context, C2018aa c2018aa, C2036as c2036as, C2020ac c2020ac) {
        this.f7458a = context;
        this.f7459b = c2036as;
        this.f7460c = c2018aa;
        this.f7461d = c2020ac;
    }

    private static Map<String, String> m4822a(String[] strArr) {
        HashMap map = new HashMap(strArr == null ? 1 : strArr.length);
        if (strArr != null) {
            for (int i6 = 0; i6 < strArr.length; i6++) {
                String str = strArr[i6];
                if (str != null) {
                    C2029al.m4640a("Extra message[%d]: %s", Integer.valueOf(i6), str);
                    String[] strArrSplit = str.split("=");
                    if (strArrSplit.length == 2) {
                        map.put(strArrSplit[0], strArrSplit[1]);
                    } else {
                        C2029al.m4645d("bad extraMsg %s", str);
                    }
                }
            }
        } else {
            C2029al.m4644c("not found extraMsg", new Object[0]);
        }
        return map;
    }

    @Override
    public final boolean getAndUpdateAnrState() {
        if (C2042ay.m4799a() == null) {
            return false;
        }
        C2042ay c2042ayM4799a = C2042ay.m4799a();
        if (c2042ayM4799a.f7425a.get()) {
            C2029al.m4644c("anr is processing, return", new Object[0]);
            return false;
        }
        ActivityManager activityManager = c2042ayM4799a.f7426b;
        if (C2106z.m5039a(activityManager) || C2043az.m4817a(activityManager, 0L) == null) {
            C2029al.m4644c("proc is not in anr, wait next check", new Object[0]);
            return false;
        }
        if (c2042ayM4799a.m4813a(System.currentTimeMillis())) {
            return false;
        }
        return c2042ayM4799a.m4814a(true);
    }

    @Override
    public final void handleNativeException(int i6, int i10, long j10, long j11, String str, String str2, String str3, String str4, int i11, String str5, int i12, int i13, int i14, String str6, String str7) {
        C2029al.m4640a("Native Crash Happen v1", new Object[0]);
        handleNativeException2(i6, i10, j10, j11, str, str2, str3, str4, i11, str5, i12, i13, i14, str6, str7, null);
    }

    @Override
    public final void handleNativeException2(int i6, int i10, long j10, long j11, String str, String str2, String str3, String str4, int i11, String str5, int i12, int i13, int i14, String str6, String str7, String[] strArr) {
        String str8;
        String string;
        boolean z7;
        String str9;
        String str10;
        C2029al.m4640a("Native Crash Happen v2", new Object[0]);
        if (i11 > 0) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("(");
                str8 = str5;
                sb.append(str8);
                sb.append(")");
                string = sb.toString();
            } catch (Throwable th) {
                th = th;
                if (C2029al.m4641a(th)) {
                }
                th.printStackTrace();
            }
        } else {
            str8 = str5;
            string = str;
        }
        String strM4827a = C2050be.m4827a(str3);
        Map<String, String> mapM4822a = m4822a(strArr);
        String str11 = mapM4822a.get("HasPendingException");
        if (str11 == null || !str11.equals("true")) {
            z7 = false;
        } else {
            C2029al.m4640a("Native crash happened with a Java pending exception.", new Object[0]);
            z7 = true;
        }
        C2018aa c2018aa = this.f7460c;
        String str12 = mapM4822a.get("ExceptionProcessName");
        if (str12 == null || str12.length() == 0) {
            str12 = c2018aa.f7228d;
        } else {
            C2029al.m4644c("Name of crash process: %s", str12);
        }
        String str13 = str12;
        String str14 = mapM4822a.get("ExceptionThreadName");
        C2029al.m4644c("crash thread name:%s tid:%s", str14, Integer.valueOf(i10));
        if (TextUtils.isEmpty(str14)) {
            str9 = Thread.currentThread().getName() + "(" + i10 + ")";
        } else {
            str9 = str14 + "(" + i10 + ")";
        }
        long j12 = (j11 / 1000) + (j10 * 1000);
        String str15 = mapM4822a.get("SysLogPath");
        String str16 = mapM4822a.get("JniLogPath");
        if (!this.f7461d.m4578b()) {
            C2029al.m4645d("no remote but still store!", new Object[0]);
        }
        if (!this.f7461d.m4579c().f7074f && this.f7461d.m4578b()) {
            C2029al.m4646e("crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
            C2036as.m4730a("NATIVE_CRASH", C2033ap.m4675a(), str13, str9, string + "\n" + str2 + "\n" + strM4827a, null);
            C2033ap.m4706c(str4);
            return;
        }
        String str17 = i11 > 0 ? "KERNEL" : str8;
        String strM5035a = "UNKNOWN";
        if (i11 > 0) {
            str10 = strM5035a;
        } else {
            strM5035a = i12 > 0 ? C2106z.m5035a(i12) : "UNKNOWN";
            if (strM5035a.equals(String.valueOf(i12))) {
                str10 = strM5035a;
            } else {
                str10 = strM5035a + "(" + i12 + ")";
            }
        }
        String str18 = string;
        try {
            CrashDetailBean crashDetailBeanPackageCrashDatas = packageCrashDatas(str13, str9, j12, string, str2, strM4827a, str17, str10, str4, str15, str16, str7, null, null, true, z7);
            if (crashDetailBeanPackageCrashDatas == null) {
                C2029al.m4646e("pkg crash datas fail!", new Object[0]);
                return;
            }
            C2036as.m4730a("NATIVE_CRASH", C2033ap.m4675a(), str13, str9, str18 + "\n" + str2 + "\n" + strM4827a, crashDetailBeanPackageCrashDatas);
            try {
                C2036as c2036as = this.f7459b;
                if (c2036as == null) {
                    C2029al.m4645d("crashHandler is null. Won't upload native crash.", new Object[0]);
                    return;
                }
                boolean zM4759a = c2036as.m4759a(crashDetailBeanPackageCrashDatas, true);
                C2050be.m4831a(true, NativeCrashHandler.getInstance() != null ? NativeCrashHandler.getDumpFilePath() : null);
                if (!zM4759a) {
                    this.f7459b.m4761b(crashDetailBeanPackageCrashDatas, true);
                }
                this.f7459b.m4757a(crashDetailBeanPackageCrashDatas);
                C2037at.m4762a().f7387t.m4794b();
            } catch (Throwable th2) {
                th = th2;
                if (C2029al.m4641a(th)) {
                    th.printStackTrace();
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    @Override
    public final CrashDetailBean packageCrashDatas(String str, String str2, long j10, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, byte[] bArr, Map<String, String> map, boolean z7, boolean z10) {
        int i6;
        String str12;
        int iIndexOf;
        boolean zM4776i = C2037at.m4762a().m4776i();
        if (zM4776i) {
            C2029al.m4646e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.f7120b = 1;
        crashDetailBean.f7123e = this.f7460c.m4526g();
        C2018aa c2018aa = this.f7460c;
        crashDetailBean.f7124f = c2018aa.f7239o;
        crashDetailBean.f7125g = c2018aa.m4536q();
        crashDetailBean.f7131m = this.f7460c.m4524f();
        crashDetailBean.f7132n = str3;
        crashDetailBean.f7133o = zM4776i ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]" : "";
        crashDetailBean.f7134p = str4;
        String str13 = str5 != null ? str5 : "";
        crashDetailBean.f7135q = str13;
        crashDetailBean.f7136r = j10;
        crashDetailBean.f7139u = C2033ap.m4705c(str13.getBytes());
        crashDetailBean.f7092A = str;
        crashDetailBean.f7093B = str2;
        crashDetailBean.f7103L = this.f7460c.m4538s();
        crashDetailBean.f7126h = this.f7460c.m4535p();
        crashDetailBean.f7127i = this.f7460c.m4511A();
        crashDetailBean.f7140v = str8;
        String dumpFilePath = NativeCrashHandler.getInstance() != null ? NativeCrashHandler.getDumpFilePath() : null;
        String strM4829a = C2050be.m4829a(dumpFilePath, str8);
        if (!C2033ap.m4703b(strM4829a)) {
            crashDetailBean.f7117Z = strM4829a;
        }
        crashDetailBean.f7119aa = C2050be.m4833b(dumpFilePath);
        crashDetailBean.f7141w = C2050be.m4828a(str9, C2037at.f7369f, C2037at.f7374k, C2037at.f7379p);
        crashDetailBean.f7142x = C2050be.m4828a(str10, C2037at.f7369f, null, true);
        crashDetailBean.f7105N = str7;
        crashDetailBean.f7106O = str6;
        crashDetailBean.f7107P = str11;
        crashDetailBean.f7097F = this.f7460c.m4531k();
        crashDetailBean.f7098G = this.f7460c.m4530j();
        crashDetailBean.f7099H = this.f7460c.m4532l();
        crashDetailBean.f7100I = C2019ab.m4548b(this.f7458a);
        crashDetailBean.f7101J = C2019ab.m4555g();
        crashDetailBean.f7102K = C2019ab.m4556h();
        if (z7) {
            crashDetailBean.f7094C = C2019ab.m4558j();
            crashDetailBean.f7095D = C2019ab.m4554f();
            crashDetailBean.f7096E = C2019ab.m4560l();
            crashDetailBean.f7143y = C2032ao.m4659a();
            C2018aa c2018aa2 = this.f7460c;
            crashDetailBean.f7108Q = c2018aa2.f7201a;
            crashDetailBean.f7109R = c2018aa2.m4515a();
            crashDetailBean.f7144z = C2033ap.m4686a(this.f7460c.f7192Q, C2037at.f7371h);
            int iIndexOf2 = crashDetailBean.f7135q.indexOf("java:\n");
            if (iIndexOf2 > 0 && (i6 = iIndexOf2 + 6) < crashDetailBean.f7135q.length()) {
                String str14 = crashDetailBean.f7135q;
                String strSubstring = str14.substring(i6, str14.length() - 1);
                if (strSubstring.length() > 0 && crashDetailBean.f7144z.containsKey(crashDetailBean.f7093B) && (iIndexOf = (str12 = crashDetailBean.f7144z.get(crashDetailBean.f7093B)).indexOf(strSubstring)) > 0) {
                    String strSubstring2 = str12.substring(iIndexOf);
                    crashDetailBean.f7144z.put(crashDetailBean.f7093B, strSubstring2);
                    crashDetailBean.f7135q = crashDetailBean.f7135q.substring(0, i6);
                    crashDetailBean.f7135q = AbstractC0004e.m26t(new StringBuilder(), crashDetailBean.f7135q, strSubstring2);
                }
            }
            if (str == null) {
                crashDetailBean.f7092A = this.f7460c.f7228d;
            }
            crashDetailBean.f7112U = this.f7460c.m4545z();
            C2018aa c2018aa3 = this.f7460c;
            crashDetailBean.f7113V = c2018aa3.f7248x;
            crashDetailBean.f7114W = c2018aa3.m4539t();
            crashDetailBean.f7115X = this.f7460c.m4544y();
        } else {
            crashDetailBean.f7094C = -1L;
            crashDetailBean.f7095D = -1L;
            crashDetailBean.f7096E = -1L;
            if (crashDetailBean.f7141w == null) {
                crashDetailBean.f7141w = "This crash occurred at last process! Log is miss, when get an terrible ABRT Native Exception etc.";
            }
            crashDetailBean.f7108Q = -1L;
            crashDetailBean.f7112U = -1;
            crashDetailBean.f7113V = -1;
            crashDetailBean.f7114W = map;
            crashDetailBean.f7115X = this.f7460c.m4544y();
            crashDetailBean.f7144z = null;
            if (str == null) {
                crashDetailBean.f7092A = "unknown(record)";
            }
            if (bArr != null) {
                crashDetailBean.f7143y = bArr;
            }
        }
        return crashDetailBean;
    }
}
