package p235v9;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p103j9.AbstractC2796i;
import p244w9.AbstractC4072a;

public final class C4024b extends AbstractC4072a implements InterfaceC4023a {

    public static final AtomicReferenceFieldUpdater f13641c = AtomicReferenceFieldUpdater.newUpdater(C4024b.class, Object.class, "_state");
    private volatile Object _state;

    public int f13642b;

    public C4024b(Object obj) {
        this._state = obj;
    }

    public final void m8012a(Object obj) {
        int i6;
        if (obj == null) {
            obj = AbstractC4072a.f13737a;
        }
        synchronized (this) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f13641c;
            if (AbstractC2796i.m5780a(atomicReferenceFieldUpdater.get(this), obj)) {
                return;
            }
            atomicReferenceFieldUpdater.set(this, obj);
            int i10 = this.f13642b;
            if ((i10 & 1) != 0) {
                this.f13642b = i10 + 2;
                return;
            }
            int i11 = i10 + 1;
            this.f13642b = i11;
            while (true) {
                synchronized (this) {
                    i6 = this.f13642b;
                    if (i6 == i11) {
                        this.f13642b = i11 + 1;
                        return;
                    }
                }
                i11 = i6;
            }
        }
    }
}
