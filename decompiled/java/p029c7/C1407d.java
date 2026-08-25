package p029c7;

import p000a.AbstractC0004e;
import p002a1.C0026b;
import p020b7.AbstractC1332b;
import p020b7.C1345h0;
import p020b7.C1352l;
import p249x4.C4112e;

public final class C1407d {

    public static final C1345h0 f4294c = new C1345h0(new C4112e(5));

    public static final C1401a f4295d = new C1401a();

    public long f4296a;

    public long f4297b;

    public final String toString() {
        C0026b c0026bM3232w = AbstractC1332b.m3232w(this);
        long j10 = this.f4296a;
        if (j10 != -1) {
            String strValueOf = String.valueOf(j10);
            C1352l c1352l = new C1352l(13, false);
            ((C0026b) c0026bM3232w.f56d).f56d = c1352l;
            c0026bM3232w.f56d = c1352l;
            c1352l.f55c = strValueOf;
            c1352l.f54b = "maximumSize";
        }
        if (this.f4297b != -1) {
            c0026bM3232w.m127d(AbstractC0004e.m25s(new StringBuilder(), this.f4297b, "ns"), "expireAfterWrite");
        }
        return c0026bM3232w.toString();
    }
}
