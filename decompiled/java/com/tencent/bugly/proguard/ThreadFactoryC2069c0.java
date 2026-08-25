package com.tencent.bugly.proguard;

import java.util.concurrent.ThreadFactory;
import p005a4.RunnableC0058q;
import p106k0.C2860h;

public final class ThreadFactoryC2069c0 implements ThreadFactory {

    public final int f7591a;

    public ThreadFactoryC2069c0(int i6) {
        this.f7591a = i6;
    }

    @Override
    public final Thread newThread(Runnable runnable) {
        switch (this.f7591a) {
            case 0:
                Thread thread = new Thread(runnable);
                thread.setName("BuglyThread-" + C2028ak.f7311a.getAndIncrement());
                return thread;
            case 1:
                return new C2860h(runnable);
            default:
                return new Thread(new RunnableC0058q(runnable, 1), "glide-active-resources");
        }
    }
}
