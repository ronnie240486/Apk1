package com.google.android.gms.internal.cast;

import java.util.logging.Logger;
import p000a.AbstractC0004e;

public final class C1660q1 implements InterfaceC1651p1 {

    public static final C1661q2 f5545e = new C1661q2(21);

    public final int f5546a;

    public final C1669r1 f5547b;

    public Object f5548c;

    public volatile Object f5549d;

    public C1660q1() {
        this.f5546a = 1;
        this.f5547b = new C1669r1();
        this.f5548c = AbstractC1558f6.class.getName();
    }

    @Override
    public Object mo3969a() {
        InterfaceC1651p1 interfaceC1651p1 = (InterfaceC1651p1) this.f5549d;
        C1661q2 c1661q2 = f5545e;
        if (interfaceC1651p1 != c1661q2) {
            synchronized (this.f5547b) {
                try {
                    if (((InterfaceC1651p1) this.f5549d) != c1661q2) {
                        Object objMo3969a = ((InterfaceC1651p1) this.f5549d).mo3969a();
                        this.f5548c = objMo3969a;
                        this.f5549d = c1661q2;
                        return objMo3969a;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f5548c;
    }

    public Logger m3973b() {
        Logger logger = (Logger) this.f5549d;
        if (logger != null) {
            return logger;
        }
        synchronized (this.f5547b) {
            try {
                Logger logger2 = (Logger) this.f5549d;
                if (logger2 != null) {
                    return logger2;
                }
                Logger logger3 = Logger.getLogger((String) this.f5548c);
                this.f5549d = logger3;
                return logger3;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String toString() {
        switch (this.f5546a) {
            case 0:
                Object objM24r = (InterfaceC1651p1) this.f5549d;
                if (objM24r == f5545e) {
                    objM24r = AbstractC0004e.m24r("<supplier that returned ", String.valueOf(this.f5548c), ">");
                }
                return AbstractC0004e.m24r("Suppliers.memoize(", String.valueOf(objM24r), ")");
            default:
                return super.toString();
        }
    }

    public C1660q1(C1661q2 c1661q2) {
        this.f5546a = 0;
        this.f5547b = new C1669r1();
        this.f5549d = c1661q2;
    }
}
