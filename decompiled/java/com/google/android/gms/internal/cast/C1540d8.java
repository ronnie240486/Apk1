package com.google.android.gms.internal.cast;

import android.text.TextUtils;
import androidx.appcompat.app.C0161t0;
import androidx.leanback.widget.C0486o;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.internal.zzaa;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p176q4.C3475c;
import p230v4.C3988b;

public final class C1540d8 {

    public static final C3988b f5253v = new C3988b("SessionFlowSummary", null);

    public static final String f5254w = "22.1.0";

    public static long f5255x = System.currentTimeMillis();

    public final C1678s1 f5261f;

    public final String f5262g;

    public final long f5264i;

    public C3475c f5265j;

    public String f5266k;

    public String f5267l;

    public C0161t0 f5268m;

    public String f5269n;

    public String f5270o;

    public String f5271p;

    public String f5272q;

    public String f5273r;

    public String f5274s;

    public int f5276u;

    public final C1660q1 f5256a = new C1660q1(new C1661q2(24));

    public final List f5257b = Collections.synchronizedList(new ArrayList());

    public final List f5258c = Collections.synchronizedList(new ArrayList());

    public final List f5259d = Collections.synchronizedList(new ArrayList());

    public final Map f5260e = Collections.synchronizedMap(new HashMap());

    public int f5275t = 0;

    public final long f5263h = System.currentTimeMillis();

    public C1540d8(C1678s1 c1678s1, String str) {
        this.f5261f = c1678s1;
        this.f5262g = str;
        long j10 = f5255x;
        f5255x = 1 + j10;
        this.f5264i = j10;
    }

    public final void m3805a(C3475c c3475c) {
        if (c3475c == null) {
            m3806b(2);
            return;
        }
        CastDevice castDeviceM7124e = c3475c.m7124e();
        if (castDeviceM7124e == null) {
            m3806b(3);
            return;
        }
        this.f5265j = c3475c;
        String str = this.f5267l;
        String str2 = castDeviceM7124e.f4611l;
        if (str != null) {
            if (TextUtils.equals(str, str2)) {
                return;
            }
            m3806b(5);
            return;
        }
        this.f5267l = str2;
        this.f5269n = castDeviceM7124e.f4604e;
        this.f5275t = castDeviceM7124e.m3586m();
        zzaa zzaaVarM3587n = castDeviceM7124e.m3587n();
        if (zzaaVarM3587n != null) {
            this.f5270o = zzaaVarM3587n.f4950d;
            this.f5271p = zzaaVarM3587n.f4951e;
            this.f5272q = zzaaVarM3587n.f4952f;
            this.f5273r = zzaaVarM3587n.f4953g;
            this.f5274s = zzaaVarM3587n.f4954h;
        }
        c3475c.m7138c();
    }

    public final void m3806b(int i6) {
        Integer numValueOf = Integer.valueOf(i6 - 1);
        Map map = this.f5260e;
        C1561g c1561g = (C1561g) map.get(numValueOf);
        if (c1561g != null) {
            c1561g.f5305d.incrementAndGet();
            c1561g.f5303b = System.currentTimeMillis();
        } else {
            C1561g c1561g2 = new C1561g(new C0486o(i6));
            c1561g2.f5304c = this.f5263h;
            map.put(numValueOf, c1561g2);
        }
    }
}
