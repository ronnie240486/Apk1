package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.util.Pair;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.cast.C1613l1;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import p000a.AbstractC0004e;
import p018b5.AbstractC1312l;
import p143n5.AbstractC3198d;
import p187r4.C3633w;
import p261y4.InterfaceC4264l;
import p271z4.HandlerC4333d;

@KeepName
public abstract class BasePendingResult<R extends InterfaceC4264l> extends AbstractC3198d {

    public static final int f4998q = 0;

    public C3633w f5003k;

    public InterfaceC4264l f5005m;

    public volatile boolean f5006n;

    public boolean f5007o;

    public boolean f5008p;

    public final Object f4999g = new Object();

    public final CountDownLatch f5001i = new CountDownLatch(1);

    public final ArrayList f5002j = new ArrayList();

    public final AtomicReference f5004l = new AtomicReference();

    public final HandlerC4333d f5000h = new HandlerC4333d(Looper.getMainLooper(), 4);

    static {
        new C1613l1(4);
    }

    public BasePendingResult() {
        new WeakReference(null);
    }

    public final void m3638b0() {
        synchronized (this.f4999g) {
            try {
                if (!this.f5007o && !this.f5006n) {
                    this.f5007o = true;
                    m3646j0(mo3639c0(Status.f4993g));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract InterfaceC4264l mo3639c0(Status status);

    public final void m3640d0(Status status) {
        synchronized (this.f4999g) {
            try {
                if (!m3642f0()) {
                    m3643g0(mo3639c0(status));
                    this.f5008p = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean m3641e0() {
        boolean z7;
        synchronized (this.f4999g) {
            z7 = this.f5007o;
        }
        return z7;
    }

    public final boolean m3642f0() {
        return this.f5001i.getCount() == 0;
    }

    public final void m3643g0(InterfaceC4264l interfaceC4264l) {
        synchronized (this.f4999g) {
            try {
                if (this.f5008p || this.f5007o) {
                    return;
                }
                m3642f0();
                AbstractC1312l.m3200g("Results have already been set", !m3642f0());
                AbstractC1312l.m3200g("Result has already been consumed", !this.f5006n);
                m3646j0(interfaceC4264l);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void m3644h0(C3633w c3633w) {
        synchronized (this.f4999g) {
            try {
                AbstractC1312l.m3200g("Result has already been consumed.", !this.f5006n);
                if (m3641e0()) {
                    return;
                }
                if (m3642f0()) {
                    HandlerC4333d handlerC4333d = this.f5000h;
                    InterfaceC4264l interfaceC4264lM3645i0 = m3645i0();
                    handlerC4333d.getClass();
                    handlerC4333d.sendMessage(handlerC4333d.obtainMessage(1, new Pair(c3633w, interfaceC4264lM3645i0)));
                } else {
                    this.f5003k = c3633w;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final InterfaceC4264l m3645i0() {
        InterfaceC4264l interfaceC4264l;
        synchronized (this.f4999g) {
            AbstractC1312l.m3200g("Result has already been consumed.", !this.f5006n);
            AbstractC1312l.m3200g("Result is not ready.", m3642f0());
            interfaceC4264l = this.f5005m;
            this.f5005m = null;
            this.f5003k = null;
            this.f5006n = true;
        }
        if (this.f5004l.getAndSet(null) != null) {
            throw new ClassCastException();
        }
        AbstractC1312l.m3198e(interfaceC4264l);
        return interfaceC4264l;
    }

    public final void m3646j0(InterfaceC4264l interfaceC4264l) {
        this.f5005m = interfaceC4264l;
        interfaceC4264l.getClass();
        this.f5001i.countDown();
        if (this.f5007o) {
            this.f5003k = null;
        } else {
            C3633w c3633w = this.f5003k;
            if (c3633w != null) {
                HandlerC4333d handlerC4333d = this.f5000h;
                handlerC4333d.removeMessages(2);
                handlerC4333d.sendMessage(handlerC4333d.obtainMessage(1, new Pair(c3633w, m3645i0())));
            }
        }
        ArrayList arrayList = this.f5002j;
        if (arrayList.size() > 0) {
            throw AbstractC0004e.m17k(0, arrayList);
        }
        arrayList.clear();
    }
}
