package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import android.util.Pair;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import com.lzy.okgo.model.Progress;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class RunnableC2027aj implements Runnable {

    protected int f7292a;

    protected long f7293b;

    protected long f7294c;

    private int f7295d;

    private int f7296e;

    private final Context f7297f;

    private final int f7298g;

    private final byte[] f7299h;

    private final C2018aa f7300i;

    private final C2020ac f7301j;

    private final C2023af f7302k;

    private final C2026ai f7303l;

    private final int f7304m;

    private final InterfaceC2025ah f7305n;

    private final InterfaceC2025ah f7306o;

    private String f7307p;

    private final String f7308q;

    private final Map<String, String> f7309r;

    private boolean f7310s;

    public RunnableC2027aj(Context context, int i6, int i10, byte[] bArr, String str, String str2, InterfaceC2025ah interfaceC2025ah, boolean z7) {
        this(context, i6, i10, bArr, str, str2, interfaceC2025ah, 2, 30000, z7);
    }

    private static void m4625a(String str) {
        C2029al.m4646e("[Upload] Failed to upload(%d): %s", 1, str);
    }

    public final void m4630b(long j10) {
        this.f7294c += j10;
    }

    @Override
    public final void run() {
        String str;
        C2020ac c2020ac;
        Pair pair;
        boolean zBooleanValue;
        try {
            this.f7292a = 0;
            this.f7293b = 0L;
            this.f7294c = 0L;
            if (C2019ab.m4551c(this.f7297f) == null) {
                str = "network is not available";
            } else {
                byte[] bArr = this.f7299h;
                if (bArr == null || bArr.length == 0) {
                    str = "request package is empty!";
                } else if (this.f7297f == null || this.f7300i == null || (c2020ac = this.f7301j) == null || this.f7302k == null) {
                    str = "illegal access error";
                } else {
                    str = c2020ac.m4579c() == null ? "illegal local strategy" : null;
                }
            }
            if (str != null) {
                m4626a(false, 0, str);
                return;
            }
            byte[] bArrM4694a = C2033ap.m4694a(this.f7299h);
            if (bArrM4694a == null) {
                m4626a(false, 0, "failed to zip request body");
                return;
            }
            HashMap map = new HashMap(10);
            map.put("tls", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE);
            map.put("prodId", this.f7300i.m4522e());
            map.put("bundleId", this.f7300i.f7227c);
            map.put("appVer", this.f7300i.f7239o);
            Map<String, String> map2 = this.f7309r;
            if (map2 != null) {
                map.putAll(map2);
            }
            map.put("cmd", Integer.toString(this.f7298g));
            map.put("platformId", Byte.toString((byte) 1));
            map.put("sdkVer", this.f7300i.f7232h);
            map.put("strategylastUpdateTime", Long.toString(this.f7301j.m4579c().f7083o));
            this.f7303l.m4618a(this.f7304m, System.currentTimeMillis());
            String strM4628b = this.f7307p;
            this.f7301j.m4579c();
            int i6 = 0;
            int i10 = 0;
            while (true) {
                int i11 = i6 + 1;
                if (i6 >= this.f7295d) {
                    m4626a(false, i10, "failed after many attempts");
                    return;
                }
                if (i11 > 1) {
                    C2029al.m4645d("[Upload] Failed to upload last time, wait and try(%d) again.", Integer.valueOf(i11));
                    C2033ap.m4699b(this.f7296e);
                    if (i11 == this.f7295d) {
                        C2029al.m4645d("[Upload] Use the back-up url at the last time: %s", this.f7308q);
                        strM4628b = this.f7308q;
                    }
                }
                C2029al.m4644c("[Upload] Send %d bytes", Integer.valueOf(bArrM4694a.length));
                strM4628b = m4628b(strM4628b);
                C2029al.m4644c("[Upload] Upload to %s with cmd %d (pid=%d | tid=%d).", strM4628b, Integer.valueOf(this.f7298g), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                byte[] bArrM4594a = this.f7302k.m4594a(strM4628b, bArrM4694a, this, map);
                Map<String, String> map3 = this.f7302k.f7266c;
                Pair<Boolean, Boolean> pairM4624a = m4624a(bArrM4594a, map3);
                if (((Boolean) pairM4624a.first).booleanValue()) {
                    Pair<Boolean, Boolean> pairM4623a = m4623a(map3);
                    if (((Boolean) pairM4623a.first).booleanValue()) {
                        byte[] bArrM4704b = C2033ap.m4704b(bArrM4594a);
                        if (bArrM4704b != null) {
                            bArrM4594a = bArrM4704b;
                        }
                        C2063br c2063brM4585a = C2022ae.m4585a(bArrM4594a);
                        if (c2063brM4585a == null) {
                            m4626a(false, 1, "failed to decode response package");
                            Boolean bool = Boolean.FALSE;
                            pair = new Pair(bool, bool);
                        } else {
                            Integer numValueOf = Integer.valueOf(c2063brM4585a.f7551b);
                            byte[] bArr2 = c2063brM4585a.f7552c;
                            C2029al.m4644c("[Upload] Response cmd is: %d, length of sBuffer is: %d", numValueOf, Integer.valueOf(bArr2 == null ? 0 : bArr2.length));
                            if (m4627a(c2063brM4585a, this.f7300i, this.f7301j)) {
                                m4626a(true, 2, "successfully uploaded");
                                Boolean bool2 = Boolean.TRUE;
                                pair = new Pair(bool2, bool2);
                            } else {
                                m4626a(false, 2, "failed to process response package");
                                Boolean bool3 = Boolean.FALSE;
                                pair = new Pair(bool3, bool3);
                            }
                        }
                        zBooleanValue = !((Boolean) pair.first).booleanValue() ? ((Boolean) pair.second).booleanValue() : false;
                    } else {
                        zBooleanValue = ((Boolean) pairM4623a.second).booleanValue();
                    }
                } else {
                    zBooleanValue = ((Boolean) pairM4624a.second).booleanValue();
                }
                if (!zBooleanValue) {
                    return;
                }
                i6 = i11;
                i10 = 1;
            }
        } catch (Throwable th) {
            if (C2029al.m4641a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public RunnableC2027aj(Context context, int i6, int i10, byte[] bArr, String str, String str2, InterfaceC2025ah interfaceC2025ah, int i11, int i12, boolean z7) {
        this.f7295d = 2;
        this.f7296e = 30000;
        this.f7307p = null;
        this.f7292a = 0;
        this.f7293b = 0L;
        this.f7294c = 0L;
        this.f7310s = false;
        this.f7297f = context;
        this.f7300i = C2018aa.m4507a(context);
        this.f7299h = bArr;
        this.f7301j = C2020ac.m4570a();
        if (C2023af.f7264a == null) {
            C2023af.f7264a = new C2023af(context);
        }
        this.f7302k = C2023af.f7264a;
        C2026ai c2026aiM4605a = C2026ai.m4605a();
        this.f7303l = c2026aiM4605a;
        this.f7304m = i6;
        this.f7307p = str;
        this.f7308q = str2;
        this.f7305n = interfaceC2025ah;
        this.f7306o = c2026aiM4605a.f7281a;
        this.f7298g = i10;
        if (i11 > 0) {
            this.f7295d = i11;
        }
        if (i12 > 0) {
            this.f7296e = i12;
        }
        this.f7310s = z7;
        this.f7309r = null;
    }

    private void m4626a(boolean z7, int i6, String str) {
        String strValueOf;
        int i10 = this.f7298g;
        if (i10 == 630) {
            strValueOf = "crash";
        } else if (i10 == 640) {
            strValueOf = "userinfo";
        } else if (i10 == 830) {
            strValueOf = "crash";
        } else if (i10 != 840) {
            strValueOf = String.valueOf(i10);
        } else {
            strValueOf = "userinfo";
        }
        if (z7) {
            C2029al.m4640a("[Upload] Success: %s", strValueOf);
        } else {
            C2029al.m4646e("[Upload] Failed to upload(%d) %s: %s", Integer.valueOf(i6), strValueOf, str);
        }
        if (this.f7293b + this.f7294c > 0) {
            this.f7303l.m4621a(this.f7303l.m4617a(this.f7310s) + this.f7293b + this.f7294c, this.f7310s);
        }
        InterfaceC2025ah interfaceC2025ah = this.f7305n;
        if (interfaceC2025ah != null) {
            interfaceC2025ah.mo227a(z7, str);
        }
        InterfaceC2025ah interfaceC2025ah2 = this.f7306o;
        if (interfaceC2025ah2 != null) {
            interfaceC2025ah2.mo227a(z7, str);
        }
    }

    private static String m4628b(String str) {
        if (C2033ap.m4703b(str)) {
            return str;
        }
        try {
            return str + "?aid=" + UUID.randomUUID().toString();
        } catch (Throwable th) {
            C2029al.m4641a(th);
            return str;
        }
    }

    private static boolean m4627a(C2063br c2063br, C2018aa c2018aa, C2020ac c2020ac) {
        if (c2063br == null) {
            C2029al.m4645d("resp == null!", new Object[0]);
            return false;
        }
        byte b8 = c2063br.f7550a;
        if (b8 != 0) {
            C2029al.m4646e("resp result error %d", Byte.valueOf(b8));
            return false;
        }
        try {
            if (!C2033ap.m4703b(c2063br.f7556g) && !C2018aa.m4509b().m4529i().equals(c2063br.f7556g)) {
                C2103w.m5011a().m5031a(C2020ac.f7254a, "device", c2063br.f7556g.getBytes("UTF-8"), true);
                c2018aa.m4521d(c2063br.f7556g);
            }
        } catch (Throwable th) {
            C2029al.m4641a(th);
        }
        c2018aa.f7237m = c2063br.f7554e;
        int i6 = c2063br.f7551b;
        if (i6 == 510) {
            byte[] bArr = c2063br.f7552c;
            if (bArr == null) {
                C2029al.m4646e("[Upload] Strategy data is null. Response cmd: %d", Integer.valueOf(i6));
                return false;
            }
            C2065bt c2065bt = (C2065bt) C2022ae.m4587a(bArr, C2065bt.class);
            if (c2065bt == null) {
                C2029al.m4646e("[Upload] Failed to decode strategy from server. Response cmd: %d", Integer.valueOf(c2063br.f7551b));
                return false;
            }
            c2020ac.m4577a(c2065bt);
        }
        return true;
    }

    private Pair<Boolean, Boolean> m4624a(byte[] bArr, Map<String, String> map) {
        if (bArr == null) {
            m4625a("Failed to upload for no response!");
            return new Pair<>(Boolean.FALSE, Boolean.TRUE);
        }
        C2029al.m4644c("[Upload] Received %d bytes", Integer.valueOf(bArr.length));
        if (bArr.length == 0) {
            m4626a(false, 1, "response data from server is empty");
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    C2029al.m4644c("[Upload] HTTP headers from server: key = %s, value = %s", entry.getKey(), entry.getValue());
                }
            }
            Boolean bool = Boolean.FALSE;
            return new Pair<>(bool, bool);
        }
        Boolean bool2 = Boolean.TRUE;
        return new Pair<>(bool2, bool2);
    }

    public final void m4629a(long j10) {
        this.f7292a++;
        this.f7293b += j10;
    }

    private Pair<Boolean, Boolean> m4623a(Map<String, String> map) {
        int i6;
        if (map != null && map.size() != 0) {
            if (!map.containsKey(Progress.STATUS)) {
                C2029al.m4645d("[Upload] Headers does not contain %s", Progress.STATUS);
            } else if (!map.containsKey("Bugly-Version")) {
                C2029al.m4645d("[Upload] Headers does not contain %s", "Bugly-Version");
            } else {
                String str = map.get("Bugly-Version");
                if (!str.contains("bugly")) {
                    C2029al.m4645d("[Upload] Bugly version is not valid: %s", str);
                } else {
                    C2029al.m4644c("[Upload] Bugly version from headers is: %s", str);
                    try {
                        i6 = Integer.parseInt(map.get(Progress.STATUS));
                        try {
                            C2029al.m4644c("[Upload] Status from server is %d (pid=%d | tid=%d).", Integer.valueOf(i6), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                            if (i6 != 0) {
                                m4626a(false, 1, "status of server is ".concat(String.valueOf(i6)));
                                Boolean bool = Boolean.FALSE;
                                return new Pair<>(bool, bool);
                            }
                            Boolean bool2 = Boolean.TRUE;
                            return new Pair<>(bool2, bool2);
                        } catch (Throwable unused) {
                            m4625a("[Upload] Failed to upload for format of status header is invalid: " + Integer.toString(i6));
                            return new Pair<>(Boolean.FALSE, Boolean.TRUE);
                        }
                    } catch (Throwable unused2) {
                        i6 = -1;
                    }
                }
            }
        } else {
            C2029al.m4645d("[Upload] Headers is empty.", new Object[0]);
        }
        C2029al.m4644c("[Upload] Headers from server is not valid, just try again (pid=%d | tid=%d).", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        m4625a("[Upload] Failed to upload for no status header.");
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                C2029al.m4644c(String.format("[key]: %s, [value]: %s", entry.getKey(), entry.getValue()), new Object[0]);
            }
        }
        C2029al.m4644c("[Upload] Failed to upload for no status header.", new Object[0]);
        return new Pair<>(Boolean.FALSE, Boolean.TRUE);
    }
}
