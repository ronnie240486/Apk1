package com.tencent.bugly.crashreport.crash.anr;

import com.tencent.bugly.proguard.C2029al;
import java.util.HashMap;

public final class C2012a implements TraceFileHelper.InterfaceC2011b {

    public final TraceFileHelper.C2010a f7149a;

    public final String f7150b;

    public final boolean f7151c;

    public C2012a(TraceFileHelper.C2010a c2010a, String str, boolean z7) {
        this.f7149a = c2010a;
        this.f7150b = str;
        this.f7151c = z7;
    }

    @Override
    public final boolean mo4486a(String str, int i6, String str2, String str3) {
        C2029al.m4644c("new thread %s", str);
        TraceFileHelper.C2010a c2010a = this.f7149a;
        if (c2010a.f7145a > 0 && c2010a.f7147c > 0 && c2010a.f7146b != null) {
            if (c2010a.f7148d == null) {
                c2010a.f7148d = new HashMap();
            }
            c2010a.f7148d.put(str, new String[]{str2, str3, String.valueOf(i6)});
        }
        return true;
    }

    @Override
    public final boolean mo4485a(long j10, long j11, String str) {
        C2029al.m4644c("new process %s", str);
        if (!str.equals(this.f7150b)) {
            return true;
        }
        TraceFileHelper.C2010a c2010a = this.f7149a;
        c2010a.f7145a = j10;
        c2010a.f7146b = str;
        c2010a.f7147c = j11;
        return this.f7151c;
    }

    @Override
    public final boolean mo4484a(long j10) {
        C2029al.m4644c("process end %d", Long.valueOf(j10));
        TraceFileHelper.C2010a c2010a = this.f7149a;
        return c2010a.f7145a <= 0 || c2010a.f7147c <= 0 || c2010a.f7146b == null;
    }
}
