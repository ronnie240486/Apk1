package com.google.android.gms.internal.cast;

import android.os.Looper;
import com.google.android.gms.cast.framework.CastOptions;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import p018b5.AbstractC1312l;
import p176q4.C3482h;
import p230v4.C3988b;

public final class C1730y {

    public static final C3988b f5727g = new C3988b("SessionTransController", null);

    public final CastOptions f5728a;

    public final Set f5729b = Collections.synchronizedSet(new HashSet());

    public final HandlerC1731y0 f5730c = new HandlerC1731y0(Looper.getMainLooper(), 0);

    public final RunnableC1721x f5731d = new RunnableC1721x(this, 0);

    public boolean f5732e;

    public C3482h f5733f;

    public C1730y(CastOptions castOptions) {
        this.f5728a = castOptions;
    }

    public final void m4055a() {
        HandlerC1731y0 handlerC1731y0 = this.f5730c;
        AbstractC1312l.m3198e(handlerC1731y0);
        RunnableC1721x runnableC1721x = this.f5731d;
        AbstractC1312l.m3198e(runnableC1721x);
        handlerC1731y0.removeCallbacks(runnableC1721x);
    }
}
