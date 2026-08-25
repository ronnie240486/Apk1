package p041d7;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import p020b7.AbstractC1332b;

public final class C2224j0 implements Iterator {

    public int f7953a;

    public int f7954b;

    public int f7955c = -1;

    public final C2231k0 f7956d;

    public C2224j0(C2231k0 c2231k0) {
        this.f7956d = c2231k0;
        this.f7953a = c2231k0.f7966d;
        this.f7954b = c2231k0.f7970h;
    }

    @Override
    public final boolean hasNext() {
        return this.f7954b >= 0;
    }

    @Override
    public final Object next() {
        C2231k0 c2231k0 = this.f7956d;
        if (c2231k0.f7966d != this.f7953a) {
            throw new ConcurrentModificationException();
        }
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i6 = this.f7954b;
        this.f7955c = i6;
        Object obj = c2231k0.m5230g()[i6];
        int i10 = this.f7954b;
        int[] iArr = c2231k0.f7969g;
        Objects.requireNonNull(iArr);
        this.f7954b = iArr[i10] - 1;
        return obj;
    }

    @Override
    public final void remove() {
        C2231k0 c2231k0 = this.f7956d;
        if (c2231k0.f7966d != this.f7953a) {
            throw new ConcurrentModificationException();
        }
        AbstractC1332b.m3223n("no calls to next() since the last call to remove()", this.f7955c >= 0);
        this.f7953a += 32;
        c2231k0.remove(c2231k0.m5230g()[this.f7955c]);
        int i6 = this.f7954b;
        int i10 = this.f7955c;
        if (i6 >= c2231k0.size()) {
            i6 = i10;
        }
        this.f7954b = i6;
        this.f7955c = -1;
    }
}
