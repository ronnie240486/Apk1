package p041d7;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import p020b7.AbstractC1332b;

public final class C2196f0 implements Iterator {

    public int f7889a;

    public int f7890b;

    public int f7891c;

    public final C2217i0 f7892d;

    public final int f7893e;

    public final C2217i0 f7894f;

    public C2196f0(C2217i0 c2217i0, int i6) {
        this.f7893e = i6;
        this.f7894f = c2217i0;
        this.f7892d = c2217i0;
        this.f7889a = c2217i0.f7937e;
        this.f7890b = c2217i0.isEmpty() ? -1 : 0;
        this.f7891c = -1;
    }

    @Override
    public final boolean hasNext() {
        return this.f7890b >= 0;
    }

    @Override
    public final Object next() {
        Object c2210h0;
        C2217i0 c2217i0 = this.f7892d;
        if (c2217i0.f7937e != this.f7889a) {
            throw new ConcurrentModificationException();
        }
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i6 = this.f7890b;
        this.f7891c = i6;
        switch (this.f7893e) {
            case 0:
                c2210h0 = this.f7894f.m5217j()[i6];
                break;
            case 1:
                c2210h0 = new C2210h0(this.f7894f, i6);
                break;
            default:
                c2210h0 = this.f7894f.m5218k()[i6];
                break;
        }
        int i10 = this.f7890b + 1;
        if (i10 >= c2217i0.f7938f) {
            i10 = -1;
        }
        this.f7890b = i10;
        return c2210h0;
    }

    @Override
    public final void remove() {
        C2217i0 c2217i0 = this.f7892d;
        if (c2217i0.f7937e != this.f7889a) {
            throw new ConcurrentModificationException();
        }
        AbstractC1332b.m3223n("no calls to next() since the last call to remove()", this.f7891c >= 0);
        this.f7889a += 32;
        c2217i0.remove(c2217i0.m5217j()[this.f7891c]);
        this.f7890b--;
        this.f7891c = -1;
    }
}
