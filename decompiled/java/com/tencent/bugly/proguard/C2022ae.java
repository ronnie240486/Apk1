package com.tencent.bugly.proguard;

import android.content.Context;
import android.text.TextUtils;
import androidx.media3.exoplayer.rtsp.SessionDescription;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class C2022ae {
    public static C2066bu m4586a(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        C2066bu c2066bu = new C2066bu();
        c2066bu.f7576a = userInfoBean.f7051e;
        c2066bu.f7580e = userInfoBean.f7056j;
        c2066bu.f7579d = userInfoBean.f7049c;
        c2066bu.f7578c = userInfoBean.f7050d;
        c2066bu.f7583h = userInfoBean.f7061o == 1;
        int i6 = userInfoBean.f7048b;
        if (i6 == 1) {
            c2066bu.f7577b = (byte) 1;
        } else if (i6 == 2) {
            c2066bu.f7577b = (byte) 4;
        } else if (i6 == 3) {
            c2066bu.f7577b = (byte) 2;
        } else if (i6 == 4) {
            c2066bu.f7577b = (byte) 3;
        } else if (i6 == 8) {
            c2066bu.f7577b = (byte) 8;
        } else {
            if (i6 < 10 || i6 >= 20) {
                C2029al.m4646e("unknown uinfo type %d ", Integer.valueOf(i6));
                return null;
            }
            c2066bu.f7577b = (byte) i6;
        }
        HashMap map = new HashMap();
        c2066bu.f7581f = map;
        if (userInfoBean.f7062p >= 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(userInfoBean.f7062p);
            map.put("C01", sb.toString());
        }
        if (userInfoBean.f7063q >= 0) {
            Map<String, String> map2 = c2066bu.f7581f;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(userInfoBean.f7063q);
            map2.put("C02", sb2.toString());
        }
        Map<String, String> map3 = userInfoBean.f7064r;
        if (map3 != null && map3.size() > 0) {
            for (Map.Entry<String, String> entry : userInfoBean.f7064r.entrySet()) {
                c2066bu.f7581f.put("C03_" + entry.getKey(), entry.getValue());
            }
        }
        Map<String, String> map4 = userInfoBean.f7065s;
        if (map4 != null && map4.size() > 0) {
            for (Map.Entry<String, String> entry2 : userInfoBean.f7065s.entrySet()) {
                c2066bu.f7581f.put("C04_" + entry2.getKey(), entry2.getValue());
            }
        }
        Map<String, String> map5 = c2066bu.f7581f;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(!userInfoBean.f7058l);
        map5.put("A36", sb3.toString());
        Map<String, String> map6 = c2066bu.f7581f;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(userInfoBean.f7053g);
        map6.put("F02", sb4.toString());
        Map<String, String> map7 = c2066bu.f7581f;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(userInfoBean.f7054h);
        map7.put("F03", sb5.toString());
        c2066bu.f7581f.put("F04", userInfoBean.f7056j);
        Map<String, String> map8 = c2066bu.f7581f;
        StringBuilder sb6 = new StringBuilder();
        sb6.append(userInfoBean.f7055i);
        map8.put("F05", sb6.toString());
        c2066bu.f7581f.put("F06", userInfoBean.f7059m);
        Map<String, String> map9 = c2066bu.f7581f;
        StringBuilder sb7 = new StringBuilder();
        sb7.append(userInfoBean.f7057k);
        map9.put("F10", sb7.toString());
        C2029al.m4644c("summary type %d vm:%d", Byte.valueOf(c2066bu.f7577b), Integer.valueOf(c2066bu.f7581f.size()));
        return c2066bu;
    }

    public static <T extends AbstractC2088m> T m4587a(byte[] bArr, Class<T> cls) {
        if (bArr != null && bArr.length > 0) {
            try {
                T tNewInstance = cls.newInstance();
                C2084k c2084k = new C2084k(bArr);
                c2084k.m4907a("utf-8");
                tNewInstance.mo4851a(c2084k);
                return tNewInstance;
            } catch (Throwable th) {
                if (!C2029al.m4643b(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static C2062bq m4584a(Context context, int i6, byte[] bArr) {
        String str;
        C2018aa c2018aaM4509b = C2018aa.m4509b();
        StrategyBean strategyBeanM4579c = C2020ac.m4570a().m4579c();
        if (c2018aaM4509b != null && strategyBeanM4579c != null) {
            try {
                C2062bq c2062bq = new C2062bq();
                synchronized (c2018aaM4509b) {
                    try {
                        c2062bq.f7524a = c2018aaM4509b.f7226b;
                        c2062bq.f7525b = c2018aaM4509b.m4522e();
                        c2062bq.f7526c = c2018aaM4509b.f7227c;
                        c2062bq.f7527d = c2018aaM4509b.f7239o;
                        c2062bq.f7528e = c2018aaM4509b.f7243s;
                        c2062bq.f7529f = c2018aaM4509b.f7232h;
                        c2062bq.f7530g = i6;
                        if (bArr == null) {
                            bArr = "".getBytes();
                        }
                        c2062bq.f7531h = bArr;
                        c2062bq.f7532i = c2018aaM4509b.m4528h();
                        c2062bq.f7533j = c2018aaM4509b.f7235k;
                        c2062bq.f7534k = new HashMap();
                        c2062bq.f7535l = c2018aaM4509b.m4520d();
                        c2062bq.f7536m = strategyBeanM4579c.f7083o;
                        c2062bq.f7538o = c2018aaM4509b.m4526g();
                        c2062bq.f7539p = C2019ab.m4551c(context);
                        c2062bq.f7540q = System.currentTimeMillis();
                        c2062bq.f7542s = c2018aaM4509b.m4529i();
                        c2062bq.f7545v = c2018aaM4509b.m4526g();
                        c2062bq.f7546w = c2062bq.f7539p;
                        c2062bq.f7537n = "com.tencent.bugly";
                        c2062bq.f7534k.put("A26", c2018aaM4509b.m4538s());
                        Map<String, String> map = c2062bq.f7534k;
                        StringBuilder sb = new StringBuilder();
                        sb.append(C2018aa.m4502C());
                        map.put("A62", sb.toString());
                        Map<String, String> map2 = c2062bq.f7534k;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(C2018aa.m4503D());
                        map2.put("A63", sb2.toString());
                        Map<String, String> map3 = c2062bq.f7534k;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(c2018aaM4509b.f7185J);
                        map3.put("F11", sb3.toString());
                        Map<String, String> map4 = c2062bq.f7534k;
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(c2018aaM4509b.f7184I);
                        map4.put("F12", sb4.toString());
                        c2062bq.f7534k.put("D3", c2018aaM4509b.f7241q);
                        List<AbstractC2092o> list = C2094p.f7656b;
                        if (list != null) {
                            for (AbstractC2092o abstractC2092o : list) {
                                String str2 = abstractC2092o.versionKey;
                                if (str2 != null && (str = abstractC2092o.version) != null) {
                                    c2062bq.f7534k.put(str2, str);
                                }
                            }
                        }
                        c2062bq.f7534k.put("G15", C2033ap.m4710d("G15", ""));
                        c2062bq.f7534k.put("G10", C2033ap.m4710d("G10", ""));
                        c2062bq.f7534k.put("D4", C2033ap.m4710d("D4", SessionDescription.SUPPORTED_SDP_VERSION));
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                Map<String, String> mapM4543x = c2018aaM4509b.m4543x();
                if (mapM4543x != null) {
                    for (Map.Entry<String, String> entry : mapM4543x.entrySet()) {
                        if (!TextUtils.isEmpty(entry.getValue())) {
                            c2062bq.f7534k.put(entry.getKey(), entry.getValue());
                        }
                    }
                }
                return c2062bq;
            } catch (Throwable th2) {
                if (!C2029al.m4643b(th2)) {
                    th2.printStackTrace();
                }
                return null;
            }
        }
        C2029al.m4646e("Can not create request pkg for parameters is invalid.", new Object[0]);
        return null;
    }

    public static byte[] m4589a(Object obj) {
        try {
            C2072e c2072e = new C2072e();
            c2072e.mo4860b();
            c2072e.m4855a("utf-8");
            c2072e.m4862c();
            c2072e.m4861b("RqdServer");
            c2072e.m4863c("sync");
            c2072e.mo4856a("detail", obj);
            return c2072e.mo4858a();
        } catch (Throwable th) {
            if (C2029al.m4643b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public static C2063br m4585a(byte[] bArr) {
        if (bArr != null) {
            try {
                C2072e c2072e = new C2072e();
                c2072e.mo4860b();
                c2072e.m4855a("utf-8");
                c2072e.mo4857a(bArr);
                Object objM4859b = c2072e.m4859b("detail", new C2063br());
                if (C2063br.class.isInstance(objM4859b)) {
                    return (C2063br) C2063br.class.cast(objM4859b);
                }
                return null;
            } catch (Throwable th) {
                if (!C2029al.m4643b(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static byte[] m4588a(AbstractC2088m abstractC2088m) {
        try {
            C2086l c2086l = new C2086l();
            c2086l.m4928a("utf-8");
            abstractC2088m.mo4852a(c2086l);
            byte[] bArr = new byte[c2086l.f7641a.position()];
            System.arraycopy(c2086l.f7641a.array(), 0, bArr, 0, c2086l.f7641a.position());
            return bArr;
        } catch (Throwable th) {
            if (C2029al.m4643b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }
}
