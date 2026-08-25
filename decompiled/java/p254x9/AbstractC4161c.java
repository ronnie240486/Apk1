package p254x9;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p103j9.AbstractC2796i;
import p222u7.C3926b;

public abstract class AbstractC4161c {

    public static final AtomicReferenceFieldUpdater f14084a = AtomicReferenceFieldUpdater.newUpdater(AbstractC4161c.class, Object.class, "_next");

    public static final AtomicReferenceFieldUpdater f14085b = AtomicReferenceFieldUpdater.newUpdater(AbstractC4161c.class, Object.class, "_prev");
    private volatile Object _next;
    private volatile Object _prev;

    public AbstractC4161c(AbstractC4177s abstractC4177s) {
        this._prev = abstractC4177s;
    }

    public abstract boolean mo8211a();

    public final void m8212b() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f14084a;
        Object obj = atomicReferenceFieldUpdater.get(this);
        C3926b c3926b = AbstractC4159a.f14078b;
        if ((obj == c3926b ? null : (AbstractC4161c) obj) == null) {
            return;
        }
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f14085b;
            AbstractC4161c abstractC4161c = (AbstractC4161c) atomicReferenceFieldUpdater2.get(this);
            while (abstractC4161c != null && abstractC4161c.mo8211a()) {
                abstractC4161c = (AbstractC4161c) atomicReferenceFieldUpdater2.get(abstractC4161c);
            }
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            AbstractC4161c abstractC4161c2 = obj2 == c3926b ? null : (AbstractC4161c) obj2;
            AbstractC2796i.m5782c(abstractC4161c2);
            while (abstractC4161c2.mo8211a()) {
                Object obj3 = atomicReferenceFieldUpdater.get(abstractC4161c2);
                AbstractC4161c abstractC4161c3 = obj3 == c3926b ? null : (AbstractC4161c) obj3;
                if (abstractC4161c3 == null) {
                    break;
                } else {
                    abstractC4161c2 = abstractC4161c3;
                }
            }
            while (true) {
                Object obj4 = atomicReferenceFieldUpdater2.get(abstractC4161c2);
                AbstractC4161c abstractC4161c4 = ((AbstractC4161c) obj4) == null ? null : abstractC4161c;
                while (true) {
                    if (atomicReferenceFieldUpdater2.compareAndSet(abstractC4161c2, obj4, abstractC4161c4)) {
                        break;
                    } else if (atomicReferenceFieldUpdater2.get(abstractC4161c2) != obj4) {
                    }
                }
            }
            if (abstractC4161c != null) {
                atomicReferenceFieldUpdater.set(abstractC4161c, abstractC4161c2);
            }
            if (abstractC4161c2.mo8211a()) {
                Object obj5 = atomicReferenceFieldUpdater.get(abstractC4161c2);
                if ((obj5 == c3926b ? null : (AbstractC4161c) obj5) != null) {
                    continue;
                }
            }
            if (abstractC4161c == null || !abstractC4161c.mo8211a()) {
                return;
            }
        }
    }
}
