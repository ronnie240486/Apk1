package p026c3;

import com.bumptech.glide.load.data.C1486l;
import java.util.ArrayDeque;
import p001a0.C0019b;
import p016b3.C1278k;
import p016b3.C1285r;
import p016b3.C1286s;
import p016b3.C1287t;
import p016b3.InterfaceC1288u;
import p228v2.C3980g;
import p228v2.C3981h;

public final class C1392a implements InterfaceC1288u {

    public static final C3980g f4241b = C3980g.m7966a(2500, "com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout");

    public final C0019b f4242a;

    public C1392a(C0019b c0019b) {
        this.f4242a = c0019b;
    }

    @Override
    public final C1287t mo3137a(Object obj, int i6, int i10, C3981h c3981h) {
        C1278k c1278k = (C1278k) obj;
        C0019b c0019b = this.f4242a;
        if (c0019b != null) {
            C1286s c1286sM3170a = C1286s.m3170a(c1278k);
            C1285r c1285r = (C1285r) c0019b.f38b;
            Object objM7227a = c1285r.m7227a(c1286sM3170a);
            ArrayDeque arrayDeque = C1286s.f4050b;
            synchronized (arrayDeque) {
                arrayDeque.offer(c1286sM3170a);
            }
            C1278k c1278k2 = (C1278k) objM7227a;
            if (c1278k2 == null) {
                c1285r.m7229d(C1286s.m3170a(c1278k), c1278k);
            } else {
                c1278k = c1278k2;
            }
        }
        return new C1287t(c1278k, new C1486l(c1278k, ((Integer) c3981h.m7967c(f4241b)).intValue()));
    }

    @Override
    public final boolean mo3138b(Object obj) {
        return true;
    }
}
