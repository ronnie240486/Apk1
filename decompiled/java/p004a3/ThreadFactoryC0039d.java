package p004a3;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class ThreadFactoryC0039d implements ThreadFactory {

    public final ThreadFactoryC0037b f110a;

    public final String f111b;

    public final C0040e f112c;

    public final boolean f113d;

    public final AtomicInteger f114e;

    public ThreadFactoryC0039d(ThreadFactoryC0037b threadFactoryC0037b, String str, boolean z7) {
        C0040e c0040e = C0040e.f115a;
        this.f114e = new AtomicInteger();
        this.f110a = threadFactoryC0037b;
        this.f111b = str;
        this.f112c = c0040e;
        this.f113d = z7;
    }

    @Override
    public final Thread newThread(Runnable runnable) {
        RunnableC0038c runnableC0038c = new RunnableC0038c(this, 0, runnable);
        this.f110a.getClass();
        C0036a c0036a = new C0036a(runnableC0038c);
        c0036a.setName("glide-" + this.f111b + "-thread-" + this.f114e.getAndIncrement());
        return c0036a;
    }
}
