package p247x2;

import com.bumptech.glide.C1468f;
import com.bumptech.glide.C1471i;
import com.bumptech.glide.C1472j;
import com.bumptech.glide.EnumC1469g;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p000a.AbstractC0004e;
import p012b.C1224a;
import p016b3.C1287t;
import p016b3.InterfaceC1288u;
import p037d3.C2150c;
import p041d7.C2203g0;
import p097j3.C2772c;
import p131m3.C3074a;
import p131m3.C3075b;
import p186r3.C3598b;
import p186r3.C3608l;
import p228v2.C3981h;
import p228v2.InterfaceC3975b;
import p228v2.InterfaceC3978e;
import p228v2.InterfaceC3985l;

public final class C4085g {

    public final ArrayList f13772a = new ArrayList();

    public final ArrayList f13773b = new ArrayList();

    public C1468f f13774c;

    public Object f13775d;

    public int f13776e;

    public int f13777f;

    public Class f13778g;

    public C1224a f13779h;

    public C3981h f13780i;

    public C3598b f13781j;

    public Class f13782k;

    public boolean f13783l;

    public boolean f13784m;

    public InterfaceC3978e f13785n;

    public EnumC1469g f13786o;

    public C4089k f13787p;

    public boolean f13788q;

    public boolean f13789r;

    public final ArrayList m8071a() {
        boolean z7 = this.f13784m;
        ArrayList arrayList = this.f13773b;
        if (!z7) {
            this.f13784m = true;
            arrayList.clear();
            ArrayList arrayListM8072b = m8072b();
            int size = arrayListM8072b.size();
            for (int i6 = 0; i6 < size; i6++) {
                C1287t c1287t = (C1287t) arrayListM8072b.get(i6);
                if (!arrayList.contains(c1287t.f4052a)) {
                    arrayList.add(c1287t.f4052a);
                }
                int i10 = 0;
                while (true) {
                    List list = c1287t.f4053b;
                    if (i10 < list.size()) {
                        if (!arrayList.contains(list.get(i10))) {
                            arrayList.add(list.get(i10));
                        }
                        i10++;
                    }
                }
            }
        }
        return arrayList;
    }

    public final ArrayList m8072b() {
        boolean z7 = this.f13783l;
        ArrayList arrayList = this.f13772a;
        if (!z7) {
            this.f13783l = true;
            arrayList.clear();
            List listM3527g = this.f13774c.m3518b().m3527g(this.f13775d);
            int size = listM3527g.size();
            for (int i6 = 0; i6 < size; i6++) {
                C1287t c1287tMo3137a = ((InterfaceC1288u) listM3527g.get(i6)).mo3137a(this.f13775d, this.f13776e, this.f13777f, this.f13780i);
                if (c1287tMo3137a != null) {
                    arrayList.add(c1287tMo3137a);
                }
            }
        }
        return arrayList;
    }

    public final C4100v m8073c(Class cls) {
        C4100v c4100v;
        C1472j c1472jM3518b = this.f13774c.m3518b();
        Class cls2 = this.f13778g;
        Class cls3 = this.f13782k;
        C3075b c3075b = c1472jM3518b.f4454i;
        C3608l c3608l = (C3608l) c3075b.f10538b.getAndSet(null);
        if (c3608l == null) {
            c3608l = new C3608l();
        }
        c3608l.f12108a = cls;
        c3608l.f12109b = cls2;
        c3608l.f12110c = cls3;
        synchronized (c3075b.f10537a) {
            c4100v = (C4100v) c3075b.f10537a.get(c3608l);
        }
        c3075b.f10538b.set(c3608l);
        c1472jM3518b.f4454i.getClass();
        if (C3075b.f10536c.equals(c4100v)) {
            return null;
        }
        if (c4100v != null) {
            return c4100v;
        }
        ArrayList arrayListM3525e = c1472jM3518b.m3525e(cls, cls2, cls3);
        C4100v c4100v2 = arrayListM3525e.isEmpty() ? null : new C4100v(cls, cls2, cls3, arrayListM3525e, c1472jM3518b.f4455j);
        c1472jM3518b.f4454i.m6110a(cls, cls2, cls3, c4100v2);
        return c4100v2;
    }

    public final InterfaceC3975b m8074d(Object obj) {
        InterfaceC3975b interfaceC3975b;
        C2772c c2772c = this.f13774c.m3518b().f4447b;
        Class<?> cls = obj.getClass();
        synchronized (c2772c) {
            for (C3074a c3074a : c2772c.f9487a) {
                if (c3074a.f10534a.isAssignableFrom(cls)) {
                    interfaceC3975b = c3074a.f10535b;
                }
            }
            interfaceC3975b = null;
        }
        if (interfaceC3975b != null) {
            return interfaceC3975b;
        }
        throw new C1471i(AbstractC0004e.m23q(obj.getClass(), "Failed to find source encoder for data class: "));
    }

    public final InterfaceC3985l m8075e(Class cls) {
        InterfaceC3985l interfaceC3985l = (InterfaceC3985l) this.f13781j.get(cls);
        if (interfaceC3985l == null) {
            for (Map.Entry entry : (C2203g0) this.f13781j.entrySet()) {
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    interfaceC3985l = (InterfaceC3985l) entry.getValue();
                    break;
                }
            }
        }
        if (interfaceC3985l != null) {
            return interfaceC3985l;
        }
        if (!this.f13781j.isEmpty() || !this.f13788q) {
            return C2150c.f7794b;
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }
}
