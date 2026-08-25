package p236w;

import java.util.ArrayList;

public final class C4037l {

    public AbstractC4039n f13677a;

    public ArrayList f13678b;

    public static long m8035a(C4032g c4032g, long j10) {
        AbstractC4039n abstractC4039n = c4032g.f13666d;
        if (abstractC4039n instanceof C4035j) {
            return j10;
        }
        ArrayList arrayList = c4032g.f13673k;
        int size = arrayList.size();
        long jMin = j10;
        for (int i6 = 0; i6 < size; i6++) {
            InterfaceC4030e interfaceC4030e = (InterfaceC4030e) arrayList.get(i6);
            if (interfaceC4030e instanceof C4032g) {
                C4032g c4032g2 = (C4032g) interfaceC4030e;
                if (c4032g2.f13666d != abstractC4039n) {
                    jMin = Math.min(jMin, m8035a(c4032g2, ((long) c4032g2.f13668f) + j10));
                }
            }
        }
        if (c4032g != abstractC4039n.f13689i) {
            return jMin;
        }
        long jMo8017j = abstractC4039n.mo8017j();
        C4032g c4032g3 = abstractC4039n.f13688h;
        long j11 = j10 - jMo8017j;
        return Math.min(Math.min(jMin, m8035a(c4032g3, j11)), j11 - ((long) c4032g3.f13668f));
    }

    public static long m8036b(C4032g c4032g, long j10) {
        AbstractC4039n abstractC4039n = c4032g.f13666d;
        if (abstractC4039n instanceof C4035j) {
            return j10;
        }
        ArrayList arrayList = c4032g.f13673k;
        int size = arrayList.size();
        long jMax = j10;
        for (int i6 = 0; i6 < size; i6++) {
            InterfaceC4030e interfaceC4030e = (InterfaceC4030e) arrayList.get(i6);
            if (interfaceC4030e instanceof C4032g) {
                C4032g c4032g2 = (C4032g) interfaceC4030e;
                if (c4032g2.f13666d != abstractC4039n) {
                    jMax = Math.max(jMax, m8036b(c4032g2, ((long) c4032g2.f13668f) + j10));
                }
            }
        }
        if (c4032g != abstractC4039n.f13688h) {
            return jMax;
        }
        long jMo8017j = abstractC4039n.mo8017j();
        C4032g c4032g3 = abstractC4039n.f13689i;
        long j11 = j10 + jMo8017j;
        return Math.max(Math.max(jMax, m8036b(c4032g3, j11)), j11 - ((long) c4032g3.f13668f));
    }
}
