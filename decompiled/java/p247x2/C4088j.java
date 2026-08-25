package p247x2;

import android.util.Log;
import com.bumptech.glide.C1471i;
import com.bumptech.glide.C1472j;
import com.bumptech.glide.load.data.InterfaceC1481g;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import p016b3.C1287t;
import p028c6.C1399b;
import p097j3.InterfaceC2770a;
import p187r4.C3621k;
import p215u.AbstractC3885h;
import p228v2.C3981h;
import p228v2.InterfaceC3978e;
import p228v2.InterfaceC3983j;
import p228v2.InterfaceC3984k;
import p228v2.InterfaceC3985l;

public final class C4088j {

    public final Class f13824a;

    public final List f13825b;

    public final InterfaceC2770a f13826c;

    public final C3621k f13827d;

    public final String f13828e;

    public C4088j(Class cls, Class cls2, Class cls3, List list, InterfaceC2770a interfaceC2770a, C3621k c3621k) {
        this.f13824a = cls;
        this.f13825b = list;
        this.f13826c = interfaceC2770a;
        this.f13827d = c3621k;
        this.f13828e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public final InterfaceC4102x m8092a(int i6, int i10, C1399b c1399b, InterfaceC1481g interfaceC1481g, C3981h c3981h) {
        InterfaceC4102x interfaceC4102xMo5086b;
        InterfaceC3985l interfaceC3985l;
        int iMo235l;
        boolean z7;
        boolean z10;
        boolean z11;
        boolean z12;
        Object c4082d;
        String str;
        C3621k c3621k = this.f13827d;
        List list = (List) c3621k.m7329f();
        try {
            InterfaceC4102x interfaceC4102xM8093b = m8093b(interfaceC1481g, i6, i10, c3981h, list);
            c3621k.m7334k(list);
            RunnableC4087i runnableC4087i = (RunnableC4087i) c1399b.f4262b;
            runnableC4087i.getClass();
            Class<?> cls = interfaceC4102xM8093b.get().getClass();
            int i11 = c1399b.f4261a;
            C4085g c4085g = runnableC4087i.f13798a;
            InterfaceC3984k interfaceC3984kM5745d = null;
            if (i11 != 4) {
                InterfaceC3985l interfaceC3985lM8075e = c4085g.m8075e(cls);
                interfaceC4102xMo5086b = interfaceC3985lM8075e.mo5086b(runnableC4087i.f13805h, interfaceC4102xM8093b, runnableC4087i.f13809l, runnableC4087i.f13810m);
                interfaceC3985l = interfaceC3985lM8075e;
            } else {
                interfaceC4102xMo5086b = interfaceC4102xM8093b;
                interfaceC3985l = null;
            }
            if (!interfaceC4102xM8093b.equals(interfaceC4102xMo5086b)) {
                interfaceC4102xM8093b.mo5405d();
            }
            if (c4085g.f13774c.m3518b().f4449d.m5745d(interfaceC4102xMo5086b.mo5404c()) != null) {
                C1472j c1472jM3518b = c4085g.f13774c.m3518b();
                c1472jM3518b.getClass();
                interfaceC3984kM5745d = c1472jM3518b.f4449d.m5745d(interfaceC4102xMo5086b.mo5404c());
                if (interfaceC3984kM5745d == null) {
                    throw new C1471i(interfaceC4102xMo5086b.mo5404c());
                }
                iMo235l = interfaceC3984kM5745d.mo235l(runnableC4087i.f13812o);
            } else {
                iMo235l = 3;
            }
            InterfaceC3978e interfaceC3978e = runnableC4087i.f13818u;
            ArrayList arrayListM8072b = c4085g.m8072b();
            int size = arrayListM8072b.size();
            int i12 = 0;
            while (true) {
                if (i12 >= size) {
                    z7 = false;
                    break;
                }
                if (((C1287t) arrayListM8072b.get(i12)).f4052a.equals(interfaceC3978e)) {
                    z7 = true;
                    break;
                }
                i12++;
            }
            switch (runnableC4087i.f13811n.f13832a) {
                default:
                    z10 = true;
                    if (((z7 || i11 != 3) && i11 != 1) || iMo235l != 2) {
                    }
                case 0:
                case 1:
                    z10 = false;
                    break;
            }
            if (z10) {
                if (interfaceC3984kM5745d == null) {
                    throw new C1471i(interfaceC4102xMo5086b.get().getClass());
                }
                int iM7785a = AbstractC3885h.m7785a(iMo235l);
                if (iM7785a == 0) {
                    z11 = true;
                    z12 = false;
                    c4082d = new C4082d(runnableC4087i.f13818u, runnableC4087i.f13806i);
                } else {
                    if (iM7785a != 1) {
                        if (iMo235l == 1) {
                            str = "SOURCE";
                        } else if (iMo235l != 2) {
                            str = iMo235l != 3 ? "null" : "NONE";
                        } else {
                            str = "TRANSFORMED";
                        }
                        throw new IllegalArgumentException("Unknown strategy: ".concat(str));
                    }
                    z11 = true;
                    c4082d = new C4104z(c4085g.f13774c.f4431a, runnableC4087i.f13818u, runnableC4087i.f13806i, runnableC4087i.f13809l, runnableC4087i.f13810m, interfaceC3985l, cls, runnableC4087i.f13812o);
                    z12 = false;
                }
                C4101w c4101w = (C4101w) C4101w.f13897e.m7329f();
                c4101w.f13901d = z12;
                c4101w.f13900c = z11;
                c4101w.f13899b = interfaceC4102xMo5086b;
                C3621k c3621k2 = runnableC4087i.f13803f;
                c3621k2.f12170b = c4082d;
                c3621k2.f12171c = interfaceC3984kM5745d;
                c3621k2.f12172d = c4101w;
                interfaceC4102xMo5086b = c4101w;
            }
            return this.f13826c.mo89e(interfaceC4102xMo5086b, c3981h);
        } catch (Throwable th) {
            c3621k.m7334k(list);
            throw th;
        }
    }

    public final InterfaceC4102x m8093b(InterfaceC1481g interfaceC1481g, int i6, int i10, C3981h c3981h, List list) throws C4098t {
        List list2 = this.f13825b;
        int size = list2.size();
        InterfaceC4102x interfaceC4102xMo5398a = null;
        for (int i11 = 0; i11 < size; i11++) {
            InterfaceC3983j interfaceC3983j = (InterfaceC3983j) list2.get(i11);
            try {
                if (interfaceC3983j.mo5399b(interfaceC1481g.mo3551e(), c3981h)) {
                    interfaceC4102xMo5398a = interfaceC3983j.mo5398a(interfaceC1481g.mo3551e(), i6, i10, c3981h);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e5) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Log.v("DecodePath", "Failed to decode data for " + interfaceC3983j, e5);
                }
                list.add(e5);
            }
            if (interfaceC4102xMo5398a != null) {
                break;
            }
        }
        if (interfaceC4102xMo5398a != null) {
            return interfaceC4102xMo5398a;
        }
        throw new C4098t(this.f13828e, new ArrayList(list));
    }

    public final String toString() {
        return "DecodePath{ dataClass=" + this.f13824a + ", decoders=" + this.f13825b + ", transcoder=" + this.f13826c + '}';
    }
}
