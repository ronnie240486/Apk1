package p275z9;

import android.support.v4.media.session.PlaybackStateCompat;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import p103j9.AbstractC2796i;
import p103j9.C2801n;
import p136m9.AbstractC3090d;
import p222u7.C3926b;

public final class C4359a extends Thread {

    public static final AtomicIntegerFieldUpdater f14802i = AtomicIntegerFieldUpdater.newUpdater(C4359a.class, "workerCtl");

    public final C4370l f14803a;

    public final C2801n f14804b;

    public int f14805c;

    public long f14806d;

    public long f14807e;

    public int f14808f;

    public boolean f14809g;

    public final ExecutorC4360b f14810h;
    private volatile int indexInArray;
    private volatile Object nextParkedWorker;
    private volatile int workerCtl;

    public C4359a(ExecutorC4360b executorC4360b, int i6) {
        this.f14810h = executorC4360b;
        setDaemon(true);
        this.f14803a = new C4370l();
        this.f14804b = new C2801n();
        this.f14805c = 4;
        this.nextParkedWorker = ExecutorC4360b.f14814k;
        AbstractC3090d.f10552a.getClass();
        this.f14808f = AbstractC3090d.f10553b.mo6116a().nextInt();
        m8406f(i6);
    }

    public final AbstractRunnableC4366h m8401a(boolean z7) {
        AbstractRunnableC4366h abstractRunnableC4366hM8405e;
        AbstractRunnableC4366h abstractRunnableC4366hM8405e2;
        ExecutorC4360b executorC4360b;
        long j10;
        int i6 = this.f14805c;
        AbstractRunnableC4366h abstractRunnableC4366h = null;
        C4370l c4370l = this.f14803a;
        ExecutorC4360b executorC4360b2 = this.f14810h;
        if (i6 != 1) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = ExecutorC4360b.f14812i;
            do {
                executorC4360b = this.f14810h;
                j10 = atomicLongFieldUpdater.get(executorC4360b);
                if (((int) ((9223367638808264704L & j10) >> 42)) == 0) {
                    c4370l.getClass();
                    loop1: while (true) {
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = C4370l.f14839b;
                        AbstractRunnableC4366h abstractRunnableC4366h2 = (AbstractRunnableC4366h) atomicReferenceFieldUpdater.get(c4370l);
                        if (abstractRunnableC4366h2 == null || abstractRunnableC4366h2.f14828b.f2374a != 1) {
                            int i10 = C4370l.f14841d.get(c4370l);
                            int i11 = C4370l.f14840c.get(c4370l);
                            while (i10 != i11 && C4370l.f14842e.get(c4370l) != 0) {
                                i11--;
                                AbstractRunnableC4366h abstractRunnableC4366hM8418c = c4370l.m8418c(i11, true);
                                if (abstractRunnableC4366hM8418c != null) {
                                    abstractRunnableC4366h = abstractRunnableC4366hM8418c;
                                    break;
                                }
                            }
                            break;
                        }
                        do {
                            if (atomicReferenceFieldUpdater.compareAndSet(c4370l, abstractRunnableC4366h2, null)) {
                                abstractRunnableC4366h = abstractRunnableC4366h2;
                                break loop1;
                            }
                        } while (atomicReferenceFieldUpdater.get(c4370l) == abstractRunnableC4366h2);
                    }
                    if (abstractRunnableC4366h != null) {
                        return abstractRunnableC4366h;
                    }
                    AbstractRunnableC4366h abstractRunnableC4366h3 = (AbstractRunnableC4366h) executorC4360b2.f14820f.m8222d();
                    return abstractRunnableC4366h3 == null ? m8409i(1) : abstractRunnableC4366h3;
                }
            } while (!ExecutorC4360b.f14812i.compareAndSet(executorC4360b, j10, j10 - 4398046511104L));
            this.f14805c = 1;
        }
        if (z7) {
            boolean z10 = m8404d(executorC4360b2.f14815a * 2) == 0;
            if (z10 && (abstractRunnableC4366hM8405e2 = m8405e()) != null) {
                return abstractRunnableC4366hM8405e2;
            }
            c4370l.getClass();
            AbstractRunnableC4366h abstractRunnableC4366hM8417b = (AbstractRunnableC4366h) C4370l.f14839b.getAndSet(c4370l, null);
            if (abstractRunnableC4366hM8417b == null) {
                abstractRunnableC4366hM8417b = c4370l.m8417b();
            }
            if (abstractRunnableC4366hM8417b != null) {
                return abstractRunnableC4366hM8417b;
            }
            if (!z10 && (abstractRunnableC4366hM8405e = m8405e()) != null) {
                return abstractRunnableC4366hM8405e;
            }
        } else {
            AbstractRunnableC4366h abstractRunnableC4366hM8405e3 = m8405e();
            if (abstractRunnableC4366hM8405e3 != null) {
                return abstractRunnableC4366hM8405e3;
            }
        }
        return m8409i(3);
    }

    public final int m8402b() {
        return this.indexInArray;
    }

    public final Object m8403c() {
        return this.nextParkedWorker;
    }

    public final int m8404d(int i6) {
        int i10 = this.f14808f;
        int i11 = i10 ^ (i10 << 13);
        int i12 = i11 ^ (i11 >> 17);
        int i13 = i12 ^ (i12 << 5);
        this.f14808f = i13;
        int i14 = i6 - 1;
        return (i14 & i6) == 0 ? i13 & i14 : (i13 & Integer.MAX_VALUE) % i6;
    }

    public final AbstractRunnableC4366h m8405e() {
        int iM8404d = m8404d(2);
        ExecutorC4360b executorC4360b = this.f14810h;
        if (iM8404d == 0) {
            AbstractRunnableC4366h abstractRunnableC4366h = (AbstractRunnableC4366h) executorC4360b.f14819e.m8222d();
            return abstractRunnableC4366h != null ? abstractRunnableC4366h : (AbstractRunnableC4366h) executorC4360b.f14820f.m8222d();
        }
        AbstractRunnableC4366h abstractRunnableC4366h2 = (AbstractRunnableC4366h) executorC4360b.f14820f.m8222d();
        return abstractRunnableC4366h2 != null ? abstractRunnableC4366h2 : (AbstractRunnableC4366h) executorC4360b.f14819e.m8222d();
    }

    public final void m8406f(int i6) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f14810h.f14818d);
        sb.append("-worker-");
        sb.append(i6 == 0 ? "TERMINATED" : String.valueOf(i6));
        setName(sb.toString());
        this.indexInArray = i6;
    }

    public final void m8407g(Object obj) {
        this.nextParkedWorker = obj;
    }

    public final boolean m8408h(int i6) {
        int i10 = this.f14805c;
        boolean z7 = i10 == 1;
        if (z7) {
            ExecutorC4360b.f14812i.addAndGet(this.f14810h, 4398046511104L);
        }
        if (i10 != i6) {
            this.f14805c = i6;
        }
        return z7;
    }

    public final AbstractRunnableC4366h m8409i(int i6) {
        int i10;
        AbstractRunnableC4366h abstractRunnableC4366hM8418c;
        long j10;
        AtomicLongFieldUpdater atomicLongFieldUpdater = ExecutorC4360b.f14812i;
        ExecutorC4360b executorC4360b = this.f14810h;
        int i11 = (int) (atomicLongFieldUpdater.get(executorC4360b) & 2097151);
        AbstractRunnableC4366h abstractRunnableC4366h = null;
        if (i11 < 2) {
            return null;
        }
        int iM8404d = m8404d(i11);
        int i12 = 0;
        long jMin = Long.MAX_VALUE;
        while (i12 < i11) {
            int i13 = iM8404d + 1;
            if (i13 > i11) {
                i13 = 1;
            }
            C4359a c4359a = (C4359a) executorC4360b.f14821g.m8228b(i13);
            if (c4359a == null || c4359a == this) {
                i10 = i13;
            } else {
                C4370l c4370l = c4359a.f14803a;
                if (i6 != 3) {
                    c4370l.getClass();
                    int i14 = C4370l.f14841d.get(c4370l);
                    int i15 = C4370l.f14840c.get(c4370l);
                    boolean z7 = i6 == 1;
                    while (true) {
                        if (i14 != i15 && (!z7 || C4370l.f14842e.get(c4370l) != 0)) {
                            int i16 = i14 + 1;
                            abstractRunnableC4366hM8418c = c4370l.m8418c(i14, z7);
                            if (abstractRunnableC4366hM8418c != null) {
                                break;
                            }
                            i14 = i16;
                        } else {
                            abstractRunnableC4366hM8418c = abstractRunnableC4366h;
                            break;
                        }
                    }
                } else {
                    abstractRunnableC4366hM8418c = c4370l.m8417b();
                }
                C2801n c2801n = this.f14804b;
                if (abstractRunnableC4366hM8418c != null) {
                    c2801n.f9540a = abstractRunnableC4366hM8418c;
                    i10 = i13;
                } else {
                    while (true) {
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = C4370l.f14839b;
                        AbstractRunnableC4366h abstractRunnableC4366h2 = (AbstractRunnableC4366h) atomicReferenceFieldUpdater.get(c4370l);
                        if (abstractRunnableC4366h2 != null) {
                            if (((abstractRunnableC4366h2.f14828b.f2374a == 1 ? 1 : 2) & i6) != 0) {
                                AbstractC4368j.f14835f.getClass();
                                i10 = i13;
                                long jNanoTime = System.nanoTime() - abstractRunnableC4366h2.f14827a;
                                long j11 = AbstractC4368j.f14831b;
                                if (jNanoTime < j11) {
                                    j10 = j11 - jNanoTime;
                                    abstractRunnableC4366h = null;
                                    break;
                                }
                                while (true) {
                                    abstractRunnableC4366h = null;
                                    if (atomicReferenceFieldUpdater.compareAndSet(c4370l, abstractRunnableC4366h2, null)) {
                                        c2801n.f9540a = abstractRunnableC4366h2;
                                    } else if (atomicReferenceFieldUpdater.get(c4370l) != abstractRunnableC4366h2) {
                                        i13 = i10;
                                        abstractRunnableC4366h = null;
                                    }
                                }
                            }
                        }
                        i10 = i13;
                        j10 = -2;
                        break;
                    }
                    if (j10 == -1) {
                        AbstractRunnableC4366h abstractRunnableC4366h3 = (AbstractRunnableC4366h) c2801n.f9540a;
                        c2801n.f9540a = abstractRunnableC4366h;
                        return abstractRunnableC4366h3;
                    }
                    if (j10 > 0) {
                        jMin = Math.min(jMin, j10);
                    }
                }
                j10 = -1;
                if (j10 == -1) {
                    AbstractRunnableC4366h abstractRunnableC4366h4 = (AbstractRunnableC4366h) c2801n.f9540a;
                    c2801n.f9540a = abstractRunnableC4366h;
                    return abstractRunnableC4366h4;
                }
                if (j10 > 0) {
                    jMin = Math.min(jMin, j10);
                }
            }
            i12++;
            iM8404d = i10;
            abstractRunnableC4366h = null;
        }
        if (jMin == Long.MAX_VALUE) {
            jMin = 0;
        }
        this.f14807e = jMin;
        return null;
    }

    @Override
    public final void run() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j10;
        long j11;
        int i6;
        loop0: while (true) {
            boolean z7 = false;
            while (true) {
                ExecutorC4360b executorC4360b = this.f14810h;
                executorC4360b.getClass();
                int i10 = 5;
                if (ExecutorC4360b.f14813j.get(executorC4360b) != 0 || this.f14805c == 5) {
                    break loop0;
                }
                AbstractRunnableC4366h abstractRunnableC4366hM8401a = m8401a(this.f14809g);
                int i11 = 3;
                if (abstractRunnableC4366hM8401a == null) {
                    this.f14809g = false;
                    if (this.f14807e == 0) {
                        Object obj = this.nextParkedWorker;
                        C3926b c3926b = ExecutorC4360b.f14814k;
                        if (obj != c3926b) {
                            f14802i.set(this, -1);
                            while (this.nextParkedWorker != ExecutorC4360b.f14814k) {
                                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f14802i;
                                if (atomicIntegerFieldUpdater.get(this) != -1) {
                                    break;
                                }
                                ExecutorC4360b executorC4360b2 = this.f14810h;
                                executorC4360b2.getClass();
                                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater2 = ExecutorC4360b.f14813j;
                                if (atomicIntegerFieldUpdater2.get(executorC4360b2) != 0 || this.f14805c == i10) {
                                    break;
                                }
                                m8408h(i11);
                                Thread.interrupted();
                                if (this.f14806d == 0) {
                                    this.f14806d = System.nanoTime() + this.f14810h.f14817c;
                                }
                                LockSupport.parkNanos(this.f14810h.f14817c);
                                if (System.nanoTime() - this.f14806d >= 0) {
                                    this.f14806d = 0L;
                                    ExecutorC4360b executorC4360b3 = this.f14810h;
                                    synchronized (executorC4360b3.f14821g) {
                                        try {
                                            if (!(atomicIntegerFieldUpdater2.get(executorC4360b3) != 0)) {
                                                AtomicLongFieldUpdater atomicLongFieldUpdater2 = ExecutorC4360b.f14812i;
                                                if (((int) (atomicLongFieldUpdater2.get(executorC4360b3) & 2097151)) > executorC4360b3.f14815a) {
                                                    if (atomicIntegerFieldUpdater.compareAndSet(this, -1, 1)) {
                                                        int i12 = this.indexInArray;
                                                        m8406f(0);
                                                        executorC4360b3.m8412c(this, i12, 0);
                                                        int andDecrement = (int) (atomicLongFieldUpdater2.getAndDecrement(executorC4360b3) & 2097151);
                                                        if (andDecrement != i12) {
                                                            Object objM8228b = executorC4360b3.f14821g.m8228b(andDecrement);
                                                            AbstractC2796i.m5782c(objM8228b);
                                                            C4359a c4359a = (C4359a) objM8228b;
                                                            executorC4360b3.f14821g.m8229c(i12, c4359a);
                                                            c4359a.m8406f(i12);
                                                            executorC4360b3.m8412c(c4359a, andDecrement, i12);
                                                        }
                                                        executorC4360b3.f14821g.m8229c(andDecrement, null);
                                                        this.f14805c = 5;
                                                    }
                                                }
                                            }
                                        } catch (Throwable th) {
                                            throw th;
                                        }
                                    }
                                }
                                i10 = 5;
                                i11 = 3;
                            }
                        } else {
                            ExecutorC4360b executorC4360b4 = this.f14810h;
                            executorC4360b4.getClass();
                            if (this.nextParkedWorker == c3926b) {
                                do {
                                    atomicLongFieldUpdater = ExecutorC4360b.f14811h;
                                    j10 = atomicLongFieldUpdater.get(executorC4360b4);
                                    j11 = (j10 + PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) & (-2097152);
                                    i6 = this.indexInArray;
                                    this.nextParkedWorker = executorC4360b4.f14821g.m8228b((int) (j10 & 2097151));
                                } while (!atomicLongFieldUpdater.compareAndSet(executorC4360b4, j10, j11 | ((long) i6)));
                            }
                        }
                    } else {
                        if (z7) {
                            m8408h(3);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.f14807e);
                            this.f14807e = 0L;
                            break;
                        }
                        z7 = true;
                    }
                } else {
                    this.f14807e = 0L;
                    int i13 = abstractRunnableC4366hM8401a.f14828b.f2374a;
                    this.f14806d = 0L;
                    if (this.f14805c == 3) {
                        this.f14805c = 2;
                    }
                    ExecutorC4360b executorC4360b5 = this.f14810h;
                    if (i13 != 0 && m8408h(2) && !executorC4360b5.m8414e() && !executorC4360b5.m8413d(ExecutorC4360b.f14812i.get(executorC4360b5))) {
                        executorC4360b5.m8414e();
                    }
                    executorC4360b5.getClass();
                    try {
                        abstractRunnableC4366hM8401a.run();
                    } catch (Throwable th2) {
                        Thread threadCurrentThread = Thread.currentThread();
                        threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th2);
                    }
                    if (i13 != 0) {
                        ExecutorC4360b.f14812i.addAndGet(executorC4360b5, -2097152L);
                        if (this.f14805c == 5) {
                            break;
                        }
                        this.f14805c = 4;
                        break;
                    }
                    break;
                }
            }
        }
        m8408h(5);
    }
}
