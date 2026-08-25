package com.google.android.gms.internal.cast;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractC1608k6 extends AbstractC1503a1 implements ListenableFuture {

    public static final Object f5387g = new Object();

    public static final C1660q1 f5388h = new C1660q1();

    public static final boolean f5389i;

    public static final AbstractC1503a1 f5390j;

    public volatile Object f5391d;

    public volatile C1548e6 f5392e;

    public volatile C1598j6 f5393f;

    static {
        boolean z7;
        AbstractC1503a1 c1578h6;
        Throwable th;
        Throwable th2;
        AbstractC1503a1 c1588i6;
        try {
            z7 = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z7 = false;
        }
        f5389i = z7;
        String property = System.getProperty("java.runtime.name", "");
        Throwable e5 = null;
        if (property == null || property.contains("Android")) {
            try {
                c1588i6 = new C1588i6(10);
            } catch (Error | Exception e10) {
                try {
                    c1578h6 = new C1568g6(10);
                } catch (Error | Exception e11) {
                    e5 = e11;
                    c1578h6 = new C1578h6(10);
                }
                th = e10;
                th2 = e5;
                c1588i6 = c1578h6;
            }
        } else {
            try {
                c1588i6 = new C1568g6(10);
            } catch (NoClassDefFoundError unused2) {
                c1588i6 = new C1578h6(10);
            }
        }
        th2 = null;
        th = null;
        f5390j = c1588i6;
        if (th2 != null) {
            C1660q1 c1660q1 = f5388h;
            Logger loggerM3973b = c1660q1.m3973b();
            Level level = Level.SEVERE;
            loggerM3973b.logp(level, "com.google.common.util.concurrent.AbstractFutureState", "<clinit>", "UnsafeAtomicHelper is broken!", th);
            c1660q1.m3973b().logp(level, "com.google.common.util.concurrent.AbstractFutureState", "<clinit>", "AtomicReferenceFieldUpdaterAtomicHelper is broken!", th2);
        }
    }

    public final void m3923t(C1598j6 c1598j6) {
        c1598j6.f5366a = null;
        while (true) {
            C1598j6 c1598j7 = this.f5393f;
            if (c1598j7 != C1598j6.f5365c) {
                C1598j6 c1598j8 = null;
                while (c1598j7 != null) {
                    C1598j6 c1598j9 = c1598j7.f5367b;
                    if (c1598j7.f5366a != null) {
                        c1598j8 = c1598j7;
                    } else if (c1598j8 != null) {
                        c1598j8.f5367b = c1598j9;
                        if (c1598j8.f5366a == null) {
                        }
                    } else if (!f5390j.mo3709s(this, c1598j7, c1598j9)) {
                    }
                    c1598j7 = c1598j9;
                }
                return;
            }
            return;
        }
    }
}
