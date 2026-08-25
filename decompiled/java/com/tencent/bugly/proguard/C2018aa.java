package com.tencent.bugly.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public final class C2018aa {

    private static final Map<String, String> f7174W = new HashMap();

    private static C2018aa f7175aq = null;

    public boolean f7179D;

    public String f7180E;

    public String f7181F;

    public String f7182G;

    public String f7183H;

    public boolean f7185J;

    public final SharedPreferences f7190O;

    public final SharedPreferences f7191P;

    private final Context f7198X;

    private String f7199Y;

    private String f7200Z;

    private String f7202aa;

    private String f7211aj;

    public String f7227c;

    public final String f7228d;

    public String f7229e;

    public final String f7235k;

    public String f7239o;

    public int f7240p;

    public String f7241q;

    public String f7242r;

    public String f7243s;

    public List<String> f7246v;

    public boolean f7230f = true;

    public final String f7231g = "com.tencent.bugly";

    public String f7232h = "4.1.9.3";

    public final String f7233i = "";

    @Deprecated
    public final String f7234j = "";

    public String f7236l = "unknown";

    private String f7203ab = "unknown";

    private String f7204ac = "";

    public long f7237m = 0;

    private String f7205ad = null;

    private long f7206ae = -1;

    private long f7207af = -1;

    private long f7208ag = -1;

    private String f7209ah = null;

    private String f7210ai = null;

    private Map<String, PlugInBean> f7212ak = null;

    public boolean f7238n = false;

    private String f7213al = null;

    private Boolean f7214am = null;

    private String f7215an = null;

    public String f7244t = null;

    public String f7245u = null;

    private Map<String, PlugInBean> f7216ao = null;

    private Map<String, PlugInBean> f7217ap = null;

    public int f7247w = -1;

    public int f7248x = -1;

    private final Map<String, String> f7218ar = new HashMap();

    private final Map<String, String> f7219as = new HashMap();

    private final Map<String, String> f7220at = new HashMap();

    public String f7249y = "unknown";

    public long f7250z = 0;

    public long f7176A = 0;

    public long f7177B = 0;

    public long f7178C = 0;

    public boolean f7184I = false;

    public HashMap<String, String> f7186K = new HashMap<>();

    public List<String> f7187L = new ArrayList();

    public boolean f7188M = false;

    public InterfaceC2096q f7189N = null;

    public boolean f7192Q = true;

    public boolean f7193R = true;

    public boolean f7194S = false;

    private final Object f7221au = new Object();

    public final Object f7195T = new Object();

    private final Object f7222av = new Object();

    private final Object f7223aw = new Object();

    public final Object f7196U = new Object();

    public final Object f7197V = new Object();

    private final Object f7224ax = new Object();

    private final List<Integer> f7225ay = new ArrayList();

    public final long f7201a = System.currentTimeMillis();

    public final byte f7226b = 1;

    private C2018aa(Context context) {
        this.f7211aj = null;
        this.f7239o = null;
        this.f7241q = null;
        this.f7242r = null;
        this.f7243s = null;
        this.f7246v = null;
        this.f7179D = false;
        this.f7180E = null;
        this.f7181F = null;
        this.f7182G = null;
        this.f7183H = "";
        this.f7185J = false;
        this.f7198X = C2033ap.m4670a(context);
        PackageInfo packageInfoM5040b = C2106z.m5040b(context);
        if (packageInfoM5040b != null) {
            try {
                String str = packageInfoM5040b.versionName;
                this.f7239o = str;
                this.f7180E = str;
                this.f7181F = Integer.toString(packageInfoM5040b.versionCode);
            } catch (Throwable th) {
                if (!C2029al.m4641a(th)) {
                    th.printStackTrace();
                }
            }
        }
        this.f7227c = C2106z.m5036a(context);
        this.f7228d = C2106z.m5035a(Process.myPid());
        this.f7241q = C2106z.m5041c(context);
        this.f7235k = "Android " + C2019ab.m4549b() + ",level " + C2019ab.m4550c();
        Map<String, String> mapM5042d = C2106z.m5042d(context);
        if (mapM5042d != null) {
            try {
                this.f7246v = C2106z.m5037a(mapM5042d);
                String str2 = mapM5042d.get("BUGLY_APPID");
                if (str2 != null) {
                    this.f7242r = str2;
                    m4517b("APP_ID", str2);
                }
                String str3 = mapM5042d.get("BUGLY_APP_VERSION");
                if (str3 != null) {
                    this.f7239o = str3;
                }
                String str4 = mapM5042d.get("BUGLY_APP_CHANNEL");
                if (str4 != null) {
                    this.f7243s = str4;
                }
                String str5 = mapM5042d.get("BUGLY_ENABLE_DEBUG");
                if (str5 != null) {
                    this.f7179D = str5.equalsIgnoreCase("true");
                }
                String str6 = mapM5042d.get("com.tencent.rdm.uuid");
                if (str6 != null) {
                    this.f7182G = str6;
                }
                String str7 = mapM5042d.get("BUGLY_APP_BUILD_NO");
                if (!TextUtils.isEmpty(str7)) {
                    this.f7240p = Integer.parseInt(str7);
                }
                String str8 = mapM5042d.get("BUGLY_AREA");
                if (str8 != null) {
                    this.f7183H = str8;
                }
            } catch (Throwable th2) {
                if (!C2029al.m4641a(th2)) {
                    th2.printStackTrace();
                }
            }
        }
        try {
            if (!context.getDatabasePath("bugly_db_").exists()) {
                this.f7185J = true;
                C2029al.m4644c("App is first time to be installed on the device.", new Object[0]);
            }
        } catch (Throwable th3) {
            if (C2094p.f7657c) {
                th3.printStackTrace();
            }
        }
        this.f7190O = C2033ap.m4671a("BUGLY_COMMON_VALUES", context);
        this.f7191P = C2033ap.m4671a("BUGLY_RESERVED_VALUES", context);
        this.f7211aj = C2019ab.m4547a(context);
        m4504E();
        C2029al.m4644c("com info create end", new Object[0]);
    }

    public static int m4501B() {
        return C2019ab.m4550c();
    }

    @Deprecated
    public static boolean m4502C() {
        C2029al.m4640a("Detect if the emulator is unavailable", new Object[0]);
        return false;
    }

    @Deprecated
    public static boolean m4503D() {
        C2029al.m4640a("Detect if the device hook is unavailable", new Object[0]);
        return false;
    }

    private void m4504E() {
        try {
            for (Map.Entry<String, ?> entry : this.f7191P.getAll().entrySet()) {
                C2029al.m4644c("put reserved request data from sp, key:%s value:%s", entry.getKey(), entry.getValue());
                m4508a(entry.getKey(), entry.getValue().toString(), false);
            }
            for (Map.Entry<String, String> entry2 : f7174W.entrySet()) {
                C2029al.m4644c("put reserved request data from cache, key:%s value:%s", entry2.getKey(), entry2.getValue());
                m4508a(entry2.getKey(), entry2.getValue(), true);
            }
            f7174W.clear();
        } catch (Throwable th) {
            C2029al.m4643b(th);
        }
    }

    private String m4505F() {
        if (TextUtils.isEmpty(this.f7205ad)) {
            this.f7205ad = C2033ap.m4710d("androidid", null);
        }
        return this.f7205ad;
    }

    private static String m4506G() {
        String string = UUID.randomUUID().toString();
        return !C2033ap.m4703b(string) ? string.replaceAll("-", "") : string;
    }

    public static synchronized C2018aa m4509b() {
        return f7175aq;
    }

    @Deprecated
    public static String m4510n() {
        return "";
    }

    public final synchronized Map<String, PlugInBean> m4511A() {
        Map<String, PlugInBean> map;
        map = this.f7216ao;
        Map<String, PlugInBean> map2 = this.f7217ap;
        if (map2 != null) {
            map.putAll(map2);
        }
        return map;
    }

    public final boolean m4515a() {
        boolean z7 = this.f7225ay.size() > 0;
        C2029al.m4644c("isAppForeground:%s", Boolean.valueOf(z7));
        return z7;
    }

    public final void m4518c() {
        synchronized (this.f7221au) {
            this.f7199Y = UUID.randomUUID().toString();
        }
    }

    public final String m4520d() {
        String str;
        synchronized (this.f7221au) {
            try {
                if (this.f7199Y == null) {
                    m4518c();
                }
                str = this.f7199Y;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    public final String m4522e() {
        return !C2033ap.m4703b(this.f7229e) ? this.f7229e : this.f7242r;
    }

    public final String m4524f() {
        String str;
        synchronized (this.f7197V) {
            str = this.f7236l;
        }
        return str;
    }

    public final String m4526g() {
        String str = this.f7202aa;
        if (str != null) {
            return str;
        }
        String strM4710d = C2033ap.m4710d("deviceId", null);
        this.f7202aa = strM4710d;
        if (strM4710d != null) {
            return strM4710d;
        }
        String strM4505F = m4505F();
        this.f7202aa = strM4505F;
        if (TextUtils.isEmpty(strM4505F)) {
            this.f7202aa = m4506G();
        }
        String str2 = this.f7202aa;
        if (str2 == null) {
            return "";
        }
        C2033ap.m4707c("deviceId", str2);
        return this.f7202aa;
    }

    public final synchronized String m4528h() {
        String str = this.f7200Z;
        if (str != null) {
            return str;
        }
        String strM4710d = C2033ap.m4710d("deviceModel", null);
        this.f7200Z = strM4710d;
        if (strM4710d != null) {
            C2029al.m4644c("collect device model from sp:%s", strM4710d);
            return this.f7200Z;
        }
        if (!this.f7238n) {
            C2029al.m4644c("not allow collect device model", new Object[0]);
            return "fail";
        }
        String strM4546a = C2019ab.m4546a();
        this.f7200Z = strM4546a;
        C2029al.m4644c("collect device model:%s", strM4546a);
        C2033ap.m4707c("deviceModel", this.f7200Z);
        return this.f7200Z;
    }

    public final synchronized String m4529i() {
        return this.f7204ac;
    }

    public final long m4530j() {
        if (this.f7206ae <= 0) {
            this.f7206ae = C2019ab.m4553e();
        }
        return this.f7206ae;
    }

    public final long m4531k() {
        if (this.f7207af <= 0) {
            this.f7207af = C2019ab.m4557i();
        }
        return this.f7207af;
    }

    public final long m4532l() {
        if (this.f7208ag <= 0) {
            this.f7208ag = C2019ab.m4559k();
        }
        return this.f7208ag;
    }

    public final String m4533m() {
        if (!TextUtils.isEmpty(this.f7210ai)) {
            C2029al.m4644c("get cpu type from so:%s", this.f7210ai);
            return this.f7210ai;
        }
        if (TextUtils.isEmpty(this.f7211aj)) {
            return "unknown";
        }
        C2029al.m4644c("get cpu type from lib dir:%s", this.f7211aj);
        return this.f7211aj;
    }

    public final String m4534o() {
        try {
            Map<String, ?> all = this.f7198X.getSharedPreferences("BuglySdkInfos", 0).getAll();
            if (!all.isEmpty()) {
                synchronized (this.f7195T) {
                    try {
                        for (Map.Entry<String, ?> entry : all.entrySet()) {
                            try {
                                this.f7186K.put(entry.getKey(), entry.getValue().toString());
                            } catch (Throwable th) {
                                C2029al.m4641a(th);
                            }
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        } catch (Throwable th3) {
            C2029al.m4641a(th3);
        }
        if (this.f7186K.isEmpty()) {
            C2029al.m4644c("SDK_INFO is empty", new Object[0]);
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry2 : this.f7186K.entrySet()) {
            sb.append("[");
            sb.append(entry2.getKey());
            sb.append(",");
            sb.append(entry2.getValue());
            sb.append("] ");
        }
        C2029al.m4644c("SDK_INFO = %s", sb.toString());
        m4517b("SDK_INFO", sb.toString());
        return sb.toString();
    }

    public final synchronized Map<String, PlugInBean> m4535p() {
        Map<String, PlugInBean> map = this.f7212ak;
        if (map != null && map.size() > 0) {
            HashMap map2 = new HashMap(this.f7212ak.size());
            map2.putAll(this.f7212ak);
            return map2;
        }
        return null;
    }

    public final String m4536q() {
        if (this.f7213al == null) {
            this.f7213al = C2019ab.m4561m();
        }
        return this.f7213al;
    }

    public final Boolean m4537r() {
        if (this.f7214am == null) {
            this.f7214am = Boolean.valueOf(C2019ab.m4565q());
        }
        return this.f7214am;
    }

    public final String m4538s() {
        if (this.f7215an == null) {
            String str = C2019ab.m4562n();
            this.f7215an = str;
            C2029al.m4640a("ROM ID: %s", str);
        }
        return this.f7215an;
    }

    public final Map<String, String> m4539t() {
        synchronized (this.f7222av) {
            try {
                if (this.f7218ar.size() <= 0) {
                    return null;
                }
                return new HashMap(this.f7218ar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void m4540u() {
        synchronized (this.f7222av) {
            this.f7218ar.clear();
        }
    }

    public final int m4541v() {
        int size;
        synchronized (this.f7222av) {
            size = this.f7218ar.size();
        }
        return size;
    }

    public final Set<String> m4542w() {
        Set<String> setKeySet;
        synchronized (this.f7222av) {
            setKeySet = this.f7218ar.keySet();
        }
        return setKeySet;
    }

    public final Map<String, String> m4543x() {
        synchronized (this.f7224ax) {
            try {
                if (this.f7219as.size() <= 0) {
                    return null;
                }
                return new HashMap(this.f7219as);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Map<String, String> m4544y() {
        synchronized (this.f7223aw) {
            try {
                if (this.f7220at.size() <= 0) {
                    return null;
                }
                return new HashMap(this.f7220at);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final int m4545z() {
        int i6;
        synchronized (this.f7196U) {
            i6 = this.f7247w;
        }
        return i6;
    }

    public final void m4516b(String str) {
        C2029al.m4640a("change deviceModel，old:%s new:%s", this.f7200Z, str);
        this.f7200Z = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        C2033ap.m4707c("deviceModel", str);
    }

    public final void m4512a(int i6, boolean z7) {
        C2029al.m4644c("setActivityForeState, hash:%s isFore:%s", Integer.valueOf(i6), Boolean.valueOf(z7));
        if (z7) {
            this.f7225ay.add(Integer.valueOf(i6));
        } else {
            this.f7225ay.remove(Integer.valueOf(i6));
            this.f7225ay.remove((Object) 0);
        }
        InterfaceC2096q interfaceC2096q = this.f7189N;
        if (interfaceC2096q != null) {
            interfaceC2096q.setNativeIsAppForeground(this.f7225ay.size() > 0);
        }
    }

    public final synchronized void m4519c(String str) {
        this.f7203ab = String.valueOf(str);
    }

    public final void m4523e(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f7210ai = str.trim();
    }

    public final String m4525f(String str) {
        String strRemove;
        if (C2033ap.m4703b(str)) {
            C2029al.m4645d("key should not be empty %s", String.valueOf(str));
            return null;
        }
        synchronized (this.f7222av) {
            strRemove = this.f7218ar.remove(str);
        }
        return strRemove;
    }

    public final void m4517b(String str, String str2) {
        if (!C2033ap.m4703b(str) && !C2033ap.m4703b(str2)) {
            synchronized (this.f7223aw) {
                this.f7220at.put(str, str2);
            }
            return;
        }
        C2029al.m4645d("server key&value should not be empty %s %s", String.valueOf(str), String.valueOf(str2));
    }

    public final synchronized void m4521d(String str) {
        this.f7204ac = String.valueOf(str);
    }

    public static synchronized C2018aa m4507a(Context context) {
        try {
            if (f7175aq == null) {
                f7175aq = new C2018aa(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f7175aq;
    }

    public final String m4527g(String str) {
        String str2;
        if (C2033ap.m4703b(str)) {
            C2029al.m4645d("key should not be empty %s", String.valueOf(str));
            return null;
        }
        synchronized (this.f7222av) {
            str2 = this.f7218ar.get(str);
        }
        return str2;
    }

    public final void m4513a(String str) {
        this.f7202aa = str;
        if (!TextUtils.isEmpty(str)) {
            C2033ap.m4707c("deviceId", str);
        }
        synchronized (this.f7224ax) {
            this.f7219as.put("E8", str);
        }
    }

    public final void m4514a(String str, String str2) {
        if (!C2033ap.m4703b(str) && !C2033ap.m4703b(str2)) {
            synchronized (this.f7222av) {
                this.f7218ar.put(str, str2);
            }
            return;
        }
        C2029al.m4645d("key&value should not be empty %s %s", String.valueOf(str), String.valueOf(str2));
    }

    private void m4508a(String str, String str2, boolean z7) {
        if (C2033ap.m4703b(str)) {
            C2029al.m4645d("key should not be empty %s", str);
            return;
        }
        C2029al.m4644c("putExtraRequestData key:%s value:%s save:%s", str, str2, Boolean.valueOf(z7));
        synchronized (this.f7224ax) {
            try {
                if (TextUtils.isEmpty(str2)) {
                    this.f7219as.remove(str);
                    this.f7191P.edit().remove(str).apply();
                } else {
                    this.f7219as.put(str, str2);
                    if (z7) {
                        this.f7191P.edit().putString(str, str2).apply();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
