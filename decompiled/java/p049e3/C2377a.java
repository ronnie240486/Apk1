package p049e3;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import java.io.InputStream;
import java.util.ArrayDeque;
import p002a1.C0026b;
import p007a7.C0069f;
import p068g3.C2609c;
import p068g3.C2610d;
import p186r3.C3600d;
import p186r3.C3607k;
import p228v2.C3981h;
import p228v2.InterfaceC3983j;
import p247x2.InterfaceC4102x;
import p259y2.C4243f;
import p259y2.InterfaceC4238a;

public final class C2377a implements InterfaceC3983j {

    public final int f8325a;

    public final Object f8326b;

    public final Object f8327c;

    public C2377a(Object obj, int i6, Object obj2) {
        this.f8325a = i6;
        this.f8326b = obj;
        this.f8327c = obj2;
    }

    @Override
    public final InterfaceC4102x mo5398a(Object obj, int i6, int i10, C3981h c3981h) {
        C2405w c2405w;
        boolean z7;
        C3600d c3600d;
        switch (this.f8325a) {
            case 0:
                InterfaceC4102x interfaceC4102xMo5398a = ((InterfaceC3983j) this.f8326b).mo5398a(obj, i6, i10, c3981h);
                if (interfaceC4102xMo5398a == null) {
                    return null;
                }
                return new C2383d((Resources) this.f8327c, interfaceC4102xMo5398a);
            case 1:
                InterfaceC4102x interfaceC4102xM5624c = ((C2610d) this.f8326b).m5624c((Uri) obj, c3981h);
                if (interfaceC4102xM5624c == null) {
                    return null;
                }
                return AbstractC2400r.m5435a((InterfaceC4238a) this.f8327c, (Drawable) ((C2609c) interfaceC4102xM5624c).get(), i6, i10);
            default:
                InputStream inputStream = (InputStream) obj;
                if (inputStream instanceof C2405w) {
                    c2405w = (C2405w) inputStream;
                    z7 = false;
                } else {
                    c2405w = new C2405w(inputStream, (C4243f) this.f8327c);
                    z7 = true;
                }
                ArrayDeque arrayDeque = C3600d.f12094c;
                synchronized (arrayDeque) {
                    c3600d = (C3600d) arrayDeque.poll();
                    break;
                }
                if (c3600d == null) {
                    c3600d = new C3600d();
                }
                c3600d.f12095a = c2405w;
                C3607k c3607k = new C3607k(c3600d);
                C0069f c0069f = new C0069f(18, c2405w, c3600d, false);
                try {
                    C2398p c2398p = (C2398p) this.f8326b;
                    return c2398p.m5432a(new C0026b(c3607k, c2398p.f8375d, c2398p.f8374c), i6, i10, c3981h, c0069f);
                } finally {
                    c3600d.m7222a();
                    if (z7) {
                        c2405w.m5441b();
                    }
                }
        }
    }

    @Override
    public final boolean mo5399b(Object obj, C3981h c3981h) {
        switch (this.f8325a) {
            case 0:
                return ((InterfaceC3983j) this.f8326b).mo5399b(obj, c3981h);
            case 1:
                return "android.resource".equals(((Uri) obj).getScheme());
            default:
                ((C2398p) this.f8326b).getClass();
                return true;
        }
    }

    public C2377a(Resources resources, InterfaceC3983j interfaceC3983j) {
        this.f8325a = 0;
        this.f8327c = resources;
        this.f8326b = interfaceC3983j;
    }
}
