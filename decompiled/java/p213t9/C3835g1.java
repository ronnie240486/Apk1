package p213t9;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import p091i9.InterfaceC2724l;
import p243w8.C4070l;

public final class C3835g1 implements InterfaceC2724l {

    public static final AtomicIntegerFieldUpdater f12919c = AtomicIntegerFieldUpdater.newUpdater(C3835g1.class, "_state");
    private volatile int _state;

    public final Thread f12920a = Thread.currentThread();

    public InterfaceC3822c0 f12921b;

    public C3835g1(InterfaceC3858q0 interfaceC3858q0) {
    }

    public static void m7675b(int i6) {
        throw new IllegalStateException(("Illegal state " + i6).toString());
    }

    public final void m7676a() {
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f12919c;
            int i6 = atomicIntegerFieldUpdater.get(this);
            if (i6 != 0) {
                if (i6 != 2) {
                    if (i6 == 3) {
                        Thread.interrupted();
                        return;
                    } else {
                        m7675b(i6);
                        throw null;
                    }
                }
            } else if (atomicIntegerFieldUpdater.compareAndSet(this, i6, 1)) {
                InterfaceC3822c0 interfaceC3822c0 = this.f12921b;
                if (interfaceC3822c0 != null) {
                    interfaceC3822c0.mo7644a();
                    return;
                }
                return;
            }
        }
    }

    @Override
    public final Object invoke(Object obj) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i6;
        do {
            atomicIntegerFieldUpdater = f12919c;
            i6 = atomicIntegerFieldUpdater.get(this);
            if (i6 != 0) {
                if (i6 != 1 && i6 != 2 && i6 != 3) {
                    m7675b(i6);
                    throw null;
                }
            }
            return C4070l.f13734a;
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i6, 2));
        this.f12920a.interrupt();
        atomicIntegerFieldUpdater.set(this, 3);
        return C4070l.f13734a;
    }
}
