package p180q8;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
import p000a.AbstractC0004e;
import p004a3.C0036a;

public final class ThreadFactoryC3536k extends AtomicLong implements ThreadFactory {

    public final String f11923a;

    public final int f11924b;

    public final boolean f11925c;

    public ThreadFactoryC3536k(String str) {
        this(str, false, 5);
    }

    @Override
    public final Thread newThread(Runnable runnable) {
        String str = this.f11923a + '-' + incrementAndGet();
        Thread c0036a = this.f11925c ? new C0036a(runnable, str) : new Thread(runnable, str);
        c0036a.setPriority(this.f11924b);
        c0036a.setDaemon(true);
        return c0036a;
    }

    @Override
    public final String toString() {
        return AbstractC0004e.m26t(new StringBuilder("RxThreadFactory["), this.f11923a, "]");
    }

    public ThreadFactoryC3536k(String str, boolean z7, int i6) {
        this.f11923a = str;
        this.f11924b = i6;
        this.f11925c = z7;
    }
}
