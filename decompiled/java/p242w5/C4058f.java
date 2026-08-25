package p242w5;

import java.util.concurrent.Executor;
import p005a4.ExecutorC0059r;
import p176q4.C3477d;
import ua.RunnableC3940a;

public final class C4058f {

    public final int f13722a = 1;

    public final Object f13723b = new Object();

    public final Executor f13724c;

    public final Object f13725d;

    public C4058f(ExecutorC0059r executorC0059r, InterfaceC4054b interfaceC4054b) {
        this.f13724c = executorC0059r;
        this.f13725d = interfaceC4054b;
    }

    private final void m8062b(C3477d c3477d) {
        synchronized (this.f13723b) {
        }
        this.f13724c.execute(new RunnableC3940a(4, this, c3477d, false));
    }

    private final void m8063c(C3477d c3477d) {
        if (c3477d.m7132e()) {
            return;
        }
        synchronized (this.f13723b) {
        }
        ((ExecutorC0059r) this.f13724c).execute(new RunnableC3940a(5, this, c3477d, false));
    }

    public final void m8064a(C3477d c3477d) {
        switch (this.f13722a) {
            case 0:
                m8062b(c3477d);
                return;
            case 1:
                m8063c(c3477d);
                return;
            default:
                if (c3477d.m7132e()) {
                    synchronized (this.f13723b) {
                        break;
                    }
                    ((ExecutorC0059r) this.f13724c).execute(new RunnableC3940a(6, this, c3477d, false));
                    return;
                }
                return;
        }
    }

    public C4058f(ExecutorC0059r executorC0059r, InterfaceC4055c interfaceC4055c) {
        this.f13724c = executorC0059r;
        this.f13725d = interfaceC4055c;
    }

    public C4058f(Executor executor, InterfaceC4053a interfaceC4053a) {
        this.f13724c = executor;
        this.f13725d = interfaceC4053a;
    }
}
