package com.google.android.gms.internal.cast;

import android.content.Context;
import androidx.appcompat.widget.RunnableC0261r0;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import p002a1.C0026b;
import p176q4.C3482h;
import p230v4.C3988b;
import p230v4.C4004r;

public final class C1678s1 {

    public static final C3988b f5602j = new C3988b("ClientCastAnalytics", null);

    public static boolean f5603k = true;

    public final C3482h f5604a;

    public final C1730y f5605b;

    public final BinderC1571h f5606c;

    public Long f5608e;

    public C0026b f5610g;

    public C1512b0 f5611h;

    public int f5612i = 1;

    public final String f5607d = UUID.randomUUID().toString();

    public final ExecutorService f5609f = Executors.unconfigurableExecutorService(Executors.newCachedThreadPool());

    public C1678s1(Context context, C4004r c4004r, C3482h c3482h, C1730y c1730y, BinderC1571h binderC1571h) {
        this.f5604a = c3482h;
        this.f5605b = c1730y;
        this.f5606c = binderC1571h;
    }

    public final void m4015a(C1585i3 c1585i3, int i6) {
        this.f5609f.execute(new RunnableC0261r0(this, c1585i3, i6, 4));
    }
}
