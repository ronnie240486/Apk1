package com.google.android.gms.internal.cast;

import androidx.leanback.widget.C0486o;
import java.util.concurrent.atomic.AtomicInteger;

public final class C1561g {

    public final long f5302a;

    public long f5303b;

    public long f5304c;

    public final AtomicInteger f5305d;

    public final int f5306e;

    public C1561g(C0486o c0486o) {
        this.f5306e = c0486o.f2374a;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f5302a = jCurrentTimeMillis;
        this.f5303b = jCurrentTimeMillis;
        this.f5305d = new AtomicInteger(1);
    }
}
