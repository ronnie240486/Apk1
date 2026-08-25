package p254x9;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p222u7.C3926b;

public final class C4171m {

    public static final AtomicReferenceFieldUpdater f14105e = AtomicReferenceFieldUpdater.newUpdater(C4171m.class, Object.class, "_next");

    public static final AtomicLongFieldUpdater f14106f = AtomicLongFieldUpdater.newUpdater(C4171m.class, "_state");

    public static final C3926b f14107g = new C3926b("REMOVE_FROZEN", 1);
    private volatile Object _next;
    private volatile long _state;

    public final int f14108a;

    public final boolean f14109b;

    public final int f14110c;

    public final AtomicReferenceArray f14111d;

    public C4171m(int i6, boolean z7) {
        this.f14108a = i6;
        this.f14109b = z7;
        int i10 = i6 - 1;
        this.f14110c = i10;
        this.f14111d = new AtomicReferenceArray(i6);
        if (i10 > 1073741823) {
            throw new IllegalStateException("Check failed.");
        }
        if ((i6 & i10) != 0) {
            throw new IllegalStateException("Check failed.");
        }
    }

    public final int m8223a(Runnable runnable) {
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f14106f;
            long j10 = atomicLongFieldUpdater.get(this);
            if ((3458764513820540928L & j10) != 0) {
                return (2305843009213693952L & j10) != 0 ? 2 : 1;
            }
            int i6 = (int) (1073741823 & j10);
            int i10 = (int) ((1152921503533105152L & j10) >> 30);
            int i11 = this.f14110c;
            if (((i10 + 2) & i11) == (i6 & i11)) {
                return 1;
            }
            AtomicReferenceArray atomicReferenceArray = this.f14111d;
            if (!this.f14109b && atomicReferenceArray.get(i10 & i11) != null) {
                int i12 = this.f14108a;
                if (i12 < 1024 || ((i10 - i6) & 1073741823) > (i12 >> 1)) {
                    return 1;
                }
            } else if (atomicLongFieldUpdater.compareAndSet(this, j10, ((-1152921503533105153L) & j10) | (((long) ((i10 + 1) & 1073741823)) << 30))) {
                atomicReferenceArray.set(i10 & i11, runnable);
                C4171m c4171mM8225c = this;
                while ((atomicLongFieldUpdater.get(c4171mM8225c) & 1152921504606846976L) != 0) {
                    c4171mM8225c = c4171mM8225c.m8225c();
                    AtomicReferenceArray atomicReferenceArray2 = c4171mM8225c.f14111d;
                    int i13 = c4171mM8225c.f14110c & i10;
                    Object obj = atomicReferenceArray2.get(i13);
                    if ((obj instanceof C4170l) && ((C4170l) obj).f14104a == i10) {
                        atomicReferenceArray2.set(i13, runnable);
                    } else {
                        c4171mM8225c = null;
                    }
                    if (c4171mM8225c == null) {
                        return 0;
                    }
                }
                return 0;
            }
        }
    }

    public final boolean m8224b() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j10;
        do {
            atomicLongFieldUpdater = f14106f;
            j10 = atomicLongFieldUpdater.get(this);
            if ((j10 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j10) != 0) {
                return false;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j10, 2305843009213693952L | j10));
        return true;
    }

    public final C4171m m8225c() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j10;
        while (true) {
            atomicLongFieldUpdater = f14106f;
            j10 = atomicLongFieldUpdater.get(this);
            if ((j10 & 1152921504606846976L) != 0) {
                break;
            }
            long j11 = j10 | 1152921504606846976L;
            if (atomicLongFieldUpdater.compareAndSet(this, j10, j11)) {
                j10 = j11;
                break;
            }
        }
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f14105e;
            C4171m c4171m = (C4171m) atomicReferenceFieldUpdater.get(this);
            if (c4171m != null) {
                return c4171m;
            }
            C4171m c4171m2 = new C4171m(this.f14108a * 2, this.f14109b);
            int i6 = (int) (1073741823 & j10);
            int i10 = (int) ((1152921503533105152L & j10) >> 30);
            while (true) {
                int i11 = this.f14110c;
                int i12 = i6 & i11;
                if (i12 == (i11 & i10)) {
                    break;
                }
                Object c4170l = this.f14111d.get(i12);
                if (c4170l == null) {
                    c4170l = new C4170l(i6);
                }
                c4171m2.f14111d.set(c4171m2.f14110c & i6, c4170l);
                i6++;
            }
            atomicLongFieldUpdater.set(c4171m2, (-1152921504606846977L) & j10);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, null, c4171m2) && atomicReferenceFieldUpdater.get(this) == null) {
            }
        }
    }

    public final Object m8226d() {
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f14106f;
            long j10 = atomicLongFieldUpdater.get(this);
            if ((j10 & 1152921504606846976L) != 0) {
                return f14107g;
            }
            int i6 = (int) (j10 & 1073741823);
            int i10 = (int) ((1152921503533105152L & j10) >> 30);
            int i11 = this.f14110c;
            int i12 = i6 & i11;
            if ((i10 & i11) == i12) {
                return null;
            }
            AtomicReferenceArray atomicReferenceArray = this.f14111d;
            Object obj = atomicReferenceArray.get(i12);
            boolean z7 = this.f14109b;
            if (obj == null) {
                if (z7) {
                    return null;
                }
            } else {
                if (obj instanceof C4170l) {
                    return null;
                }
                long j11 = (i6 + 1) & 1073741823;
                if (atomicLongFieldUpdater.compareAndSet(this, j10, (j10 & (-1073741824)) | j11)) {
                    atomicReferenceArray.set(i12, null);
                    return obj;
                }
                if (z7) {
                    C4171m c4171mM8225c = this;
                    while (true) {
                        AtomicLongFieldUpdater atomicLongFieldUpdater2 = f14106f;
                        long j12 = atomicLongFieldUpdater2.get(c4171mM8225c);
                        int i13 = (int) (j12 & 1073741823);
                        if ((j12 & 1152921504606846976L) != 0) {
                            c4171mM8225c = c4171mM8225c.m8225c();
                        } else {
                            if (atomicLongFieldUpdater2.compareAndSet(c4171mM8225c, j12, (j12 & (-1073741824)) | j11)) {
                                c4171mM8225c.f14111d.set(c4171mM8225c.f14110c & i13, null);
                                c4171mM8225c = null;
                            } else {
                                continue;
                            }
                        }
                        if (c4171mM8225c == null) {
                            return obj;
                        }
                    }
                }
            }
        }
    }
}
