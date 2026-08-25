package com.google.android.gms.internal.cast;

import p000a.AbstractC0004e;

public final class RunnableC1692t6 extends AbstractC1558f6 implements Runnable {

    public final Runnable f5683k;

    public RunnableC1692t6(Runnable runnable) {
        super(12);
        runnable.getClass();
        this.f5683k = runnable;
    }

    @Override
    public final void run() {
        try {
            this.f5683k.run();
        } catch (Throwable th) {
            if (AbstractC1608k6.f5390j.mo3708r(this, null, new C1538d6(th))) {
                AbstractC1558f6.m3820z(this);
            }
            throw th;
        }
    }

    @Override
    public final String mo3821v() {
        return AbstractC0004e.m24r("task=[", this.f5683k.toString(), "]");
    }
}
