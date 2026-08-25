package p192r9;

import com.bumptech.glide.AbstractC1465c;
import java.util.Iterator;
import java.util.NoSuchElementException;
import p055ea.AbstractC2460q;
import p103j9.AbstractC2796i;
import p115k9.InterfaceC2905a;
import p156o9.C3284h;
import p243w8.C4064f;

public final class C3644b implements Iterator, InterfaceC2905a {

    public int f12239a = -1;

    public int f12240b;

    public int f12241c;

    public C3284h f12242d;

    public int f12243e;

    public final C3645c f12244f;

    public C3644b(C3645c c3645c) {
        this.f12244f = c3645c;
        int i6 = c3645c.f12246b;
        int length = c3645c.f12245a.length();
        if (length < 0) {
            throw new IllegalArgumentException(AbstractC2460q.m5492f(length, "Cannot coerce value to an empty range: maximum ", " is less than minimum 0."));
        }
        if (i6 < 0) {
            i6 = 0;
        } else if (i6 > length) {
            i6 = length;
        }
        this.f12240b = i6;
        this.f12241c = i6;
    }

    public final void m7374a() {
        C4064f c4064f;
        int i6 = this.f12241c;
        if (i6 < 0) {
            this.f12239a = 0;
            this.f12242d = null;
            return;
        }
        C3645c c3645c = this.f12244f;
        int i10 = c3645c.f12247c;
        String str = c3645c.f12245a;
        if (i10 > 0) {
            int i11 = this.f12243e + 1;
            this.f12243e = i11;
            if (i11 >= i10) {
                this.f12242d = new C3284h(this.f12240b, AbstractC3648f.m7378Z(str), 1);
                this.f12241c = -1;
            } else if (i6 > str.length() && (c4064f = (C4064f) c3645c.f12248d.invoke(str, Integer.valueOf(this.f12241c))) != null) {
                int iIntValue = ((Number) c4064f.f13727a).intValue();
                int iIntValue2 = ((Number) c4064f.f13728b).intValue();
                this.f12242d = AbstractC1465c.m3480o(this.f12240b, iIntValue);
                int i12 = iIntValue + iIntValue2;
                this.f12240b = i12;
                this.f12241c = i12 + (iIntValue2 == 0 ? 1 : 0);
            } else {
                this.f12242d = new C3284h(this.f12240b, AbstractC3648f.m7378Z(str), 1);
                this.f12241c = -1;
            }
        } else if (i6 > str.length()) {
            this.f12242d = new C3284h(this.f12240b, AbstractC3648f.m7378Z(str), 1);
            this.f12241c = -1;
        } else {
            int iIntValue3 = ((Number) c4064f.f13727a).intValue();
            int iIntValue4 = ((Number) c4064f.f13728b).intValue();
            this.f12242d = AbstractC1465c.m3480o(this.f12240b, iIntValue3);
            int i13 = iIntValue3 + iIntValue4;
            this.f12240b = i13;
            this.f12241c = i13 + (iIntValue4 == 0 ? 1 : 0);
        }
        this.f12239a = 1;
    }

    @Override
    public final boolean hasNext() {
        if (this.f12239a == -1) {
            m7374a();
        }
        return this.f12239a == 1;
    }

    @Override
    public final Object next() {
        if (this.f12239a == -1) {
            m7374a();
        }
        if (this.f12239a == 0) {
            throw new NoSuchElementException();
        }
        C3284h c3284h = this.f12242d;
        AbstractC2796i.m5783d(c3284h, "null cannot be cast to non-null type kotlin.ranges.IntRange");
        this.f12242d = null;
        this.f12239a = -1;
        return c3284h;
    }

    @Override
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
