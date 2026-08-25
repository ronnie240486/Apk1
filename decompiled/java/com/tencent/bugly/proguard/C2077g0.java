package com.tencent.bugly.proguard;

import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import java.util.List;

public final class C2077g0 implements InterfaceC2025ah {

    public final long f7620a;

    public final List f7621b;

    public final boolean f7622c;

    public C2077g0(long j10, List list, boolean z7) {
        this.f7620a = j10;
        this.f7621b = list;
        this.f7622c = z7;
    }

    @Override
    public final void mo227a(boolean z7, String str) {
        C2036as.m4737a(this.f7621b, z7, System.currentTimeMillis() - this.f7620a, this.f7622c ? "realtime" : "cache", str);
        C2036as.m4739a(z7, (List<CrashDetailBean>) this.f7621b);
    }
}
