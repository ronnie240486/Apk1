package p213t9;

import androidx.lifecycle.C0542p0;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import p008a9.InterfaceC0074d;
import p008a9.InterfaceC0079i;
import p030c9.AbstractC1439i;
import p091i9.InterfaceC2728p;
import p156o9.AbstractC3280d;
import p243w8.C4070l;

public final class C3850m0 extends AbstractC1439i implements InterfaceC2728p {

    public Object f12941b;

    public final C0542p0 f12942c;

    public C3850m0(C0542p0 c0542p0, InterfaceC0074d interfaceC0074d) {
        super(interfaceC0074d);
        this.f12942c = c0542p0;
    }

    @Override
    public final InterfaceC0074d create(Object obj, InterfaceC0074d interfaceC0074d) {
        C3850m0 c3850m0 = new C3850m0(this.f12942c, interfaceC0074d);
        c3850m0.f12941b = obj;
        return c3850m0;
    }

    @Override
    public final Object invoke(Object obj, Object obj2) {
        return ((C3850m0) create((InterfaceC3861s) obj, (InterfaceC0074d) obj2)).invokeSuspend(C4070l.f13734a);
    }

    @Override
    public final Object invokeSuspend(Object obj) throws Throwable {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i6;
        AbstractC3280d.m6570I(obj);
        InterfaceC0079i interfaceC0079iMo1512d = ((InterfaceC3861s) this.f12941b).mo1512d();
        C0542p0 c0542p0 = this.f12942c;
        try {
            InterfaceC3858q0 interfaceC3858q0M7692g = AbstractC3865u.m7692g(interfaceC0079iMo1512d);
            C3835g1 c3835g1 = new C3835g1(interfaceC3858q0M7692g);
            c3835g1.f12921b = ((C3874y0) interfaceC3858q0M7692g).m7730y(true, true, c3835g1);
            do {
                atomicIntegerFieldUpdater = C3835g1.f12919c;
                i6 = atomicIntegerFieldUpdater.get(c3835g1);
                if (i6 != 0) {
                    if (i6 == 2 || i6 == 3) {
                        break;
                        break;
                    }
                    C3835g1.m7675b(i6);
                    throw null;
                }
            } while (!atomicIntegerFieldUpdater.compareAndSet(c3835g1, i6, 0));
            try {
                return c0542p0.invoke();
            } finally {
                c3835g1.m7676a();
            }
        } catch (InterruptedException e5) {
            throw new CancellationException("Blocking call was interrupted due to parent cancellation").initCause(e5);
        }
    }
}
