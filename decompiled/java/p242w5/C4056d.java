package p242w5;

import p018b5.AbstractC1312l;
import p109k3.C2888t;
import p176q4.C3477d;

public final class C4056d {

    public final C3477d f13720a = new C3477d();

    public final void m8058a(Exception exc) {
        C3477d c3477d = this.f13720a;
        c3477d.getClass();
        synchronized (c3477d.f11769b) {
            c3477d.m7133f();
            c3477d.f11768a = true;
            c3477d.f11772e = exc;
        }
        ((C2888t) c3477d.f11770c).m5892i(c3477d);
    }

    public final void m8059b(Object obj) {
        C3477d c3477d = this.f13720a;
        synchronized (c3477d.f11769b) {
            c3477d.m7133f();
            c3477d.f11768a = true;
            c3477d.f11771d = obj;
        }
        ((C2888t) c3477d.f11770c).m5892i(c3477d);
    }

    public final void m8060c(Exception exc) {
        C3477d c3477d = this.f13720a;
        c3477d.getClass();
        AbstractC1312l.m3199f(exc, "Exception must not be null");
        synchronized (c3477d.f11769b) {
            try {
                if (c3477d.f11768a) {
                    return;
                }
                c3477d.f11768a = true;
                c3477d.f11772e = exc;
                ((C2888t) c3477d.f11770c).m5892i(c3477d);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void m8061d(Boolean bool) {
        C3477d c3477d = this.f13720a;
        synchronized (c3477d.f11769b) {
            try {
                if (c3477d.f11768a) {
                    return;
                }
                c3477d.f11768a = true;
                c3477d.f11771d = bool;
                ((C2888t) c3477d.f11770c).m5892i(c3477d);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
