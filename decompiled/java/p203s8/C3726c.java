package p203s8;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class C3726c implements InterfaceC3725b {

    public static final int f12483i = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();

    public static final Object f12484j = new Object();

    public final AtomicLong f12485a;

    public final int f12486b;

    public long f12487c;

    public final int f12488d;

    public AtomicReferenceArray f12489e;

    public final int f12490f;

    public AtomicReferenceArray f12491g;

    public final AtomicLong f12492h;

    public C3726c(int i6) {
        AtomicLong atomicLong = new AtomicLong();
        this.f12485a = atomicLong;
        this.f12492h = new AtomicLong();
        int iNumberOfLeadingZeros = 1 << (32 - Integer.numberOfLeadingZeros(Math.max(8, i6) - 1));
        int i10 = iNumberOfLeadingZeros - 1;
        AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(iNumberOfLeadingZeros + 1);
        this.f12489e = atomicReferenceArray;
        this.f12488d = i10;
        this.f12486b = Math.min(iNumberOfLeadingZeros / 4, f12483i);
        this.f12491g = atomicReferenceArray;
        this.f12490f = i10;
        this.f12487c = iNumberOfLeadingZeros - 2;
        atomicLong.lazySet(0L);
    }

    @Override
    public final void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override
    public final boolean isEmpty() {
        return this.f12485a.get() == this.f12492h.get();
    }

    @Override
    public final boolean offer(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray atomicReferenceArray = this.f12489e;
        AtomicLong atomicLong = this.f12485a;
        long j10 = atomicLong.get();
        int i6 = this.f12488d;
        int i10 = ((int) j10) & i6;
        if (j10 < this.f12487c) {
            atomicReferenceArray.lazySet(i10, obj);
            atomicLong.lazySet(j10 + 1);
            return true;
        }
        long j11 = ((long) this.f12486b) + j10;
        if (atomicReferenceArray.get(((int) j11) & i6) == null) {
            this.f12487c = j11 - 1;
            atomicReferenceArray.lazySet(i10, obj);
            atomicLong.lazySet(j10 + 1);
            return true;
        }
        long j12 = j10 + 1;
        if (atomicReferenceArray.get(((int) j12) & i6) == null) {
            atomicReferenceArray.lazySet(i10, obj);
            atomicLong.lazySet(j12);
            return true;
        }
        AtomicReferenceArray atomicReferenceArray2 = new AtomicReferenceArray(atomicReferenceArray.length());
        this.f12489e = atomicReferenceArray2;
        this.f12487c = (j10 + ((long) i6)) - 1;
        atomicReferenceArray2.lazySet(i10, obj);
        atomicReferenceArray.lazySet(atomicReferenceArray.length() - 1, atomicReferenceArray2);
        atomicReferenceArray.lazySet(i10, f12484j);
        atomicLong.lazySet(j12);
        return true;
    }

    @Override
    public final Object poll() {
        AtomicReferenceArray atomicReferenceArray = this.f12491g;
        AtomicLong atomicLong = this.f12492h;
        long j10 = atomicLong.get();
        int i6 = this.f12490f;
        int i10 = ((int) j10) & i6;
        Object obj = atomicReferenceArray.get(i10);
        boolean z7 = obj == f12484j;
        if (obj != null && !z7) {
            atomicReferenceArray.lazySet(i10, null);
            atomicLong.lazySet(j10 + 1);
            return obj;
        }
        if (!z7) {
            return null;
        }
        int i11 = i6 + 1;
        AtomicReferenceArray atomicReferenceArray2 = (AtomicReferenceArray) atomicReferenceArray.get(i11);
        atomicReferenceArray.lazySet(i11, null);
        this.f12491g = atomicReferenceArray2;
        Object obj2 = atomicReferenceArray2.get(i10);
        if (obj2 != null) {
            atomicReferenceArray2.lazySet(i10, null);
            atomicLong.lazySet(j10 + 1);
        }
        return obj2;
    }
}
