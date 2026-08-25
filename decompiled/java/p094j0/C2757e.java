package p094j0;

public final class C2757e {

    public boolean f9470a;

    public InterfaceC2756d f9471b;

    public boolean f9472c;

    public final void m5724a(InterfaceC2756d interfaceC2756d) {
        synchronized (this) {
            while (this.f9472c) {
                try {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.f9471b == interfaceC2756d) {
                return;
            }
            this.f9471b = interfaceC2756d;
            if (this.f9470a) {
                interfaceC2756d.mo125a();
            }
        }
    }
}
