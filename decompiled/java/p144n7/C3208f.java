package p144n7;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import p000a.AbstractC0004e;
import p125l7.AbstractC3011r;
import p125l7.C3004k;
import p125l7.InterfaceC3012s;
import p202s7.C3723a;

public final class C3208f implements InterfaceC3012s, Cloneable {

    public static final C3208f f10787c;

    public List f10788a;

    public List f10789b;

    static {
        C3208f c3208f = new C3208f();
        c3208f.f10788a = Collections.emptyList();
        c3208f.f10789b = Collections.emptyList();
        f10787c = c3208f;
    }

    public static boolean m6497c(Class cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.getModifiers() & 8) == 0 && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    @Override
    public final AbstractC3011r mo6089a(C3004k c3004k, C3723a c3723a) {
        boolean z7;
        boolean z10;
        boolean zM6497c = m6497c(c3723a.f12480a);
        if (zM6497c) {
            z7 = true;
        } else {
            m6498b(true);
            z7 = false;
        }
        if (zM6497c) {
            z10 = true;
        } else {
            m6498b(false);
            z10 = false;
        }
        if (z7 || z10) {
            return new C3207e(this, z10, z7, c3004k, c3723a);
        }
        return null;
    }

    public final void m6498b(boolean z7) {
        Iterator it = (z7 ? this.f10788a : this.f10789b).iterator();
        if (it.hasNext()) {
            throw AbstractC0004e.m18l(it);
        }
    }

    public final Object clone() {
        try {
            return (C3208f) super.clone();
        } catch (CloneNotSupportedException e5) {
            throw new AssertionError(e5);
        }
    }
}
