package p030c9;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p008a9.C0075e;
import p008a9.InterfaceC0074d;
import p008a9.InterfaceC0076f;
import p008a9.InterfaceC0077g;
import p008a9.InterfaceC0079i;
import p103j9.AbstractC2796i;
import p213t9.AbstractC3855p;
import p213t9.C3827e;
import p254x9.AbstractC4159a;
import p254x9.C4165g;

public abstract class AbstractC1433c extends AbstractC1431a {
    private final InterfaceC0079i _context;
    private transient InterfaceC0074d<Object> intercepted;

    public AbstractC1433c(InterfaceC0074d interfaceC0074d) {
        super(interfaceC0074d);
        InterfaceC0079i context = interfaceC0074d != null ? interfaceC0074d.getContext() : null;
        this._context = context;
    }

    @Override
    public InterfaceC0079i getContext() {
        InterfaceC0079i interfaceC0079i = this._context;
        AbstractC2796i.m5782c(interfaceC0079i);
        return interfaceC0079i;
    }

    public final InterfaceC0074d<Object> intercepted() {
        InterfaceC0074d<Object> c4165g = this.intercepted;
        if (c4165g == null) {
            InterfaceC0076f interfaceC0076f = (InterfaceC0076f) getContext().mo252e(C0075e.f205a);
            c4165g = interfaceC0076f != null ? new C4165g((AbstractC3855p) interfaceC0076f, this) : this;
            this.intercepted = c4165g;
        }
        return c4165g;
    }

    @Override
    public void releaseIntercepted() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        InterfaceC0074d<Object> interfaceC0074d = this.intercepted;
        if (interfaceC0074d != null && interfaceC0074d != this) {
            InterfaceC0077g interfaceC0077gMo252e = getContext().mo252e(C0075e.f205a);
            AbstractC2796i.m5782c(interfaceC0077gMo252e);
            C4165g c4165g = (C4165g) interfaceC0074d;
            do {
                atomicReferenceFieldUpdater = C4165g.f14089h;
            } while (atomicReferenceFieldUpdater.get(c4165g) == AbstractC4159a.f14080d);
            Object obj = atomicReferenceFieldUpdater.get(c4165g);
            C3827e c3827e = obj instanceof C3827e ? (C3827e) obj : null;
            if (c3827e != null) {
                c3827e.m7655k();
            }
        }
        this.intercepted = C1432b.f4367a;
    }
}
