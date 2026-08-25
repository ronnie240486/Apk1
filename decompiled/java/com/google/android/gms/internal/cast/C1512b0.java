package com.google.android.gms.internal.cast;

import android.content.Context;
import android.os.Looper;
import p230v4.C3988b;
import p261y4.C4258f;

public final class C1512b0 {

    public static final C3988b f5213d = new C3988b("AnalyticsConsent", null);

    public final long f5214a;

    public final HandlerC1731y0 f5215b = new HandlerC1731y0(Looper.getMainLooper(), 0);

    public final C1523c1 f5216c;

    public C1512b0(Context context, long j10) {
        this.f5216c = new C1523c1(context, AbstractC1503a1.f5200c, new C1553f1(), C4258f.f14454c);
        this.f5214a = j10;
    }
}
