package p275z9;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.leanback.widget.C0486o;
import androidx.media3.exoplayer.Renderer;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import p000a.AbstractC0004e;
import p055ea.AbstractC2460q;
import p103j9.AbstractC2796i;
import p213t9.AbstractC3865u;
import p215u.AbstractC3885h;
import p222u7.C3926b;
import p254x9.C4175q;

public final class ExecutorC4360b implements Executor, Closeable {

    public static final AtomicLongFieldUpdater f14811h = AtomicLongFieldUpdater.newUpdater(ExecutorC4360b.class, "parkedWorkersStack");

    public static final AtomicLongFieldUpdater f14812i = AtomicLongFieldUpdater.newUpdater(ExecutorC4360b.class, "controlState");

    public static final AtomicIntegerFieldUpdater f14813j = AtomicIntegerFieldUpdater.newUpdater(ExecutorC4360b.class, "_isTerminated");

    public static final C3926b f14814k = new C3926b("NOT_IN_STACK", 1);
    private volatile int _isTerminated;

    public final int f14815a;

    public final int f14816b;

    public final long f14817c;
    private volatile long controlState;

    public final String f14818d;

    public final C4363e f14819e;

    public final C4363e f14820f;

    public final C4175q f14821g;
    private volatile long parkedWorkersStack;

    public ExecutorC4360b(int i6, int i10, long j10, String str) {
        this.f14815a = i6;
        this.f14816b = i10;
        this.f14817c = j10;
        this.f14818d = str;
        if (i6 < 1) {
            throw new IllegalArgumentException(AbstractC2460q.m5492f(i6, "Core pool size ", " should be at least 1").toString());
        }
        if (i10 < i6) {
            throw new IllegalArgumentException(AbstractC0004e.m19m(i10, i6, "Max pool size ", " should be greater than or equals to core pool size ").toString());
        }
        if (i10 > 2097150) {
            throw new IllegalArgumentException(AbstractC2460q.m5492f(i10, "Max pool size ", " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (j10 <= 0) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j10 + " must be positive").toString());
        }
        this.f14819e = new C4363e();
        this.f14820f = new C4363e();
        this.f14821g = new C4175q((i6 + 1) * 2);
        this.controlState = ((long) i6) << 42;
        this._isTerminated = 0;
    }

    public final int m8410a() {
        synchronized (this.f14821g) {
            try {
                if (f14813j.get(this) != 0) {
                    return -1;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater = f14812i;
                long j10 = atomicLongFieldUpdater.get(this);
                int i6 = (int) (j10 & 2097151);
                int i10 = i6 - ((int) ((j10 & 4398044413952L) >> 21));
                if (i10 < 0) {
                    i10 = 0;
                }
                if (i10 >= this.f14815a) {
                    return 0;
                }
                if (i6 >= this.f14816b) {
                    return 0;
                }
                int i11 = ((int) (atomicLongFieldUpdater.get(this) & 2097151)) + 1;
                if (i11 <= 0 || this.f14821g.m8228b(i11) != null) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                C4359a c4359a = new C4359a(this, i11);
                this.f14821g.m8229c(i11, c4359a);
                if (i11 != ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                int i12 = i10 + 1;
                c4359a.start();
                return i12;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void m8411b(Runnable runnable, C0486o c0486o, boolean z7) {
        AbstractRunnableC4366h c4367i;
        int i6;
        AbstractC4368j.f14835f.getClass();
        long jNanoTime = System.nanoTime();
        if (runnable instanceof AbstractRunnableC4366h) {
            c4367i = (AbstractRunnableC4366h) runnable;
            c4367i.f14827a = jNanoTime;
            c4367i.f14828b = c0486o;
        } else {
            c4367i = new C4367i(runnable, jNanoTime, c0486o);
        }
        boolean z10 = false;
        boolean z11 = c4367i.f14828b.f2374a == 1;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f14812i;
        long jAddAndGet = z11 ? atomicLongFieldUpdater.addAndGet(this, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) : 0L;
        Thread threadCurrentThread = Thread.currentThread();
        C4359a c4359a = threadCurrentThread instanceof C4359a ? (C4359a) threadCurrentThread : null;
        if (c4359a == null || !AbstractC2796i.m5780a(c4359a.f14810h, this)) {
            c4359a = null;
        }
        if (c4359a != null && (i6 = c4359a.f14805c) != 5 && (c4367i.f14828b.f2374a != 0 || i6 != 2)) {
            c4359a.f14809g = true;
            C4370l c4370l = c4359a.f14803a;
            if (z7) {
                c4367i = c4370l.m8416a(c4367i);
            } else {
                c4370l.getClass();
                AbstractRunnableC4366h abstractRunnableC4366h = (AbstractRunnableC4366h) C4370l.f14839b.getAndSet(c4370l, c4367i);
                c4367i = abstractRunnableC4366h == null ? null : c4370l.m8416a(abstractRunnableC4366h);
            }
        }
        if (c4367i != null) {
            if (!(c4367i.f14828b.f2374a == 1 ? this.f14820f.m8219a(c4367i) : this.f14819e.m8219a(c4367i))) {
                throw new RejectedExecutionException(AbstractC0004e.m26t(new StringBuilder(), this.f14818d, " was terminated"));
            }
        }
        if (z7 && c4359a != null) {
            z10 = true;
        }
        if (z11) {
            if (z10 || m8414e() || m8413d(jAddAndGet)) {
                return;
            }
            m8414e();
            return;
        }
        if (z10 || m8414e() || m8413d(atomicLongFieldUpdater.get(this))) {
            return;
        }
        m8414e();
    }

    public final void m8412c(C4359a c4359a, int i6, int i10) {
        while (true) {
            long j10 = f14811h.get(this);
            int iM8402b = (int) (2097151 & j10);
            long j11 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j10) & (-2097152);
            if (iM8402b == i6) {
                if (i10 == 0) {
                    Object objM8403c = c4359a.m8403c();
                    while (true) {
                        if (objM8403c == f14814k) {
                            iM8402b = -1;
                            break;
                        }
                        if (objM8403c == null) {
                            iM8402b = 0;
                            break;
                        }
                        C4359a c4359a2 = (C4359a) objM8403c;
                        iM8402b = c4359a2.m8402b();
                        if (iM8402b != 0) {
                            break;
                        } else {
                            objM8403c = c4359a2.m8403c();
                        }
                    }
                } else {
                    iM8402b = i10;
                }
            }
            if (iM8402b >= 0) {
                if (f14811h.compareAndSet(this, j10, j11 | ((long) iM8402b))) {
                    return;
                }
            }
        }
    }

    @Override
    public final void close() throws InterruptedException {
        int i6;
        AbstractRunnableC4366h abstractRunnableC4366hM8401a;
        if (f14813j.compareAndSet(this, 0, 1)) {
            Thread threadCurrentThread = Thread.currentThread();
            C4359a c4359a = threadCurrentThread instanceof C4359a ? (C4359a) threadCurrentThread : null;
            if (c4359a == null || !AbstractC2796i.m5780a(c4359a.f14810h, this)) {
                c4359a = null;
            }
            synchronized (this.f14821g) {
                i6 = (int) (f14812i.get(this) & 2097151);
            }
            if (1 <= i6) {
                int i10 = 1;
                while (true) {
                    Object objM8228b = this.f14821g.m8228b(i10);
                    AbstractC2796i.m5782c(objM8228b);
                    C4359a c4359a2 = (C4359a) objM8228b;
                    if (c4359a2 != c4359a) {
                        while (c4359a2.isAlive()) {
                            LockSupport.unpark(c4359a2);
                            c4359a2.join(Renderer.DEFAULT_DURATION_TO_PROGRESS_US);
                        }
                        C4370l c4370l = c4359a2.f14803a;
                        C4363e c4363e = this.f14820f;
                        c4370l.getClass();
                        AbstractRunnableC4366h abstractRunnableC4366h = (AbstractRunnableC4366h) C4370l.f14839b.getAndSet(c4370l, null);
                        if (abstractRunnableC4366h != null) {
                            c4363e.m8219a(abstractRunnableC4366h);
                        }
                        while (true) {
                            AbstractRunnableC4366h abstractRunnableC4366hM8417b = c4370l.m8417b();
                            if (abstractRunnableC4366hM8417b == null) {
                                break;
                            } else {
                                c4363e.m8219a(abstractRunnableC4366hM8417b);
                            }
                        }
                    }
                    if (i10 == i6) {
                        break;
                    } else {
                        i10++;
                    }
                }
            }
            this.f14820f.m8220b();
            this.f14819e.m8220b();
            while (true) {
                if (c4359a != null) {
                    abstractRunnableC4366hM8401a = c4359a.m8401a(true);
                    if (abstractRunnableC4366hM8401a == null) {
                        abstractRunnableC4366hM8401a = (AbstractRunnableC4366h) this.f14819e.m8222d();
                        if (abstractRunnableC4366hM8401a == null) {
                            break;
                            break;
                        }
                    }
                } else {
                    abstractRunnableC4366hM8401a = (AbstractRunnableC4366h) this.f14819e.m8222d();
                    if (abstractRunnableC4366hM8401a == null && (abstractRunnableC4366hM8401a = (AbstractRunnableC4366h) this.f14820f.m8222d()) == null) {
                        break;
                    }
                }
                try {
                    abstractRunnableC4366hM8401a.run();
                } catch (Throwable th) {
                    Thread threadCurrentThread2 = Thread.currentThread();
                    threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th);
                }
            }
            if (c4359a != null) {
                c4359a.m8408h(5);
            }
            f14811h.set(this, 0L);
            f14812i.set(this, 0L);
        }
    }

    public final boolean m8413d(long j10) {
        int i6 = ((int) (2097151 & j10)) - ((int) ((j10 & 4398044413952L) >> 21));
        if (i6 < 0) {
            i6 = 0;
        }
        int i10 = this.f14815a;
        if (i6 < i10) {
            int iM8410a = m8410a();
            if (iM8410a == 1 && i10 > 1) {
                m8410a();
            }
            if (iM8410a > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean m8414e() {
        C3926b c3926b;
        int iM8402b;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f14811h;
            long j10 = atomicLongFieldUpdater.get(this);
            C4359a c4359a = (C4359a) this.f14821g.m8228b((int) (2097151 & j10));
            if (c4359a == null) {
                c4359a = null;
            } else {
                long j11 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j10) & (-2097152);
                Object objM8403c = c4359a.m8403c();
                while (true) {
                    c3926b = f14814k;
                    if (objM8403c == c3926b) {
                        iM8402b = -1;
                        break;
                    }
                    if (objM8403c == null) {
                        iM8402b = 0;
                        break;
                    }
                    C4359a c4359a2 = (C4359a) objM8403c;
                    iM8402b = c4359a2.m8402b();
                    if (iM8402b != 0) {
                        break;
                    }
                    objM8403c = c4359a2.m8403c();
                }
                if (iM8402b >= 0 && atomicLongFieldUpdater.compareAndSet(this, j10, j11 | ((long) iM8402b))) {
                    c4359a.m8407g(c3926b);
                }
            }
            if (c4359a == null) {
                return false;
            }
            if (C4359a.f14802i.compareAndSet(c4359a, -1, 0)) {
                LockSupport.unpark(c4359a);
                return true;
            }
        }
    }

    @Override
    public final void execute(Runnable runnable) {
        m8411b(runnable, AbstractC4368j.f14836g, false);
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        C4175q c4175q = this.f14821g;
        int iM8227a = c4175q.m8227a();
        int i6 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 1; i14 < iM8227a; i14++) {
            C4359a c4359a = (C4359a) c4175q.m8228b(i14);
            if (c4359a != null) {
                C4370l c4370l = c4359a.f14803a;
                c4370l.getClass();
                int i15 = C4370l.f14839b.get(c4370l) != null ? (C4370l.f14840c.get(c4370l) - C4370l.f14841d.get(c4370l)) + 1 : C4370l.f14840c.get(c4370l) - C4370l.f14841d.get(c4370l);
                int iM7785a = AbstractC3885h.m7785a(c4359a.f14805c);
                if (iM7785a == 0) {
                    i6++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(i15);
                    sb.append('c');
                    arrayList.add(sb.toString());
                } else if (iM7785a == 1) {
                    i10++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i15);
                    sb2.append('b');
                    arrayList.add(sb2.toString());
                } else if (iM7785a == 2) {
                    i11++;
                } else if (iM7785a == 3) {
                    i12++;
                    if (i15 > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(i15);
                        sb3.append('d');
                        arrayList.add(sb3.toString());
                    }
                } else if (iM7785a == 4) {
                    i13++;
                }
            }
        }
        long j10 = f14812i.get(this);
        StringBuilder sb4 = new StringBuilder();
        sb4.append(this.f14818d);
        sb4.append('@');
        sb4.append(AbstractC3865u.m7691f(this));
        sb4.append("[Pool Size {core = ");
        int i16 = this.f14815a;
        sb4.append(i16);
        sb4.append(", max = ");
        sb4.append(this.f14816b);
        sb4.append("}, Worker States {CPU = ");
        sb4.append(i6);
        sb4.append(", blocking = ");
        sb4.append(i10);
        sb4.append(", parked = ");
        sb4.append(i11);
        sb4.append(", dormant = ");
        sb4.append(i12);
        sb4.append(", terminated = ");
        sb4.append(i13);
        sb4.append("}, running workers queues = ");
        sb4.append(arrayList);
        sb4.append(", global CPU queue size = ");
        sb4.append(this.f14819e.m8221c());
        sb4.append(", global blocking queue size = ");
        sb4.append(this.f14820f.m8221c());
        sb4.append(", Control State {created workers= ");
        sb4.append((int) (2097151 & j10));
        sb4.append(", blocking tasks = ");
        sb4.append((int) ((4398044413952L & j10) >> 21));
        sb4.append(", CPUs acquired = ");
        sb4.append(i16 - ((int) ((j10 & 9223367638808264704L) >> 42)));
        sb4.append("}]");
        return sb4.toString();
    }
}
