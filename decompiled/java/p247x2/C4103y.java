package p247x2;

import com.bumptech.glide.C1472j;
import com.bumptech.glide.load.data.InterfaceC1478d;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import p016b3.C1287t;
import p016b3.InterfaceC1288u;
import p124l6.C2982h;
import p160p.C3341e;
import p186r3.C3608l;
import p228v2.InterfaceC3978e;
import p228v2.InterfaceC3985l;

public final class C4103y implements InterfaceC4084f, InterfaceC1478d {

    public final RunnableC4087i f13902a;

    public final C4085g f13903b;

    public int f13904c;

    public int f13905d = -1;

    public InterfaceC3978e f13906e;

    public List f13907f;

    public int f13908g;

    public volatile C1287t f13909h;

    public File f13910i;

    public C4104z f13911j;

    public C4103y(C4085g c4085g, RunnableC4087i runnableC4087i) {
        this.f13903b = c4085g;
        this.f13902a = runnableC4087i;
    }

    @Override
    public final boolean mo8068b() {
        List list;
        ArrayList arrayListM8071a = this.f13903b.m8071a();
        boolean z7 = false;
        if (arrayListM8071a.isEmpty()) {
            return false;
        }
        C4085g c4085g = this.f13903b;
        C1472j c1472jM3518b = c4085g.f13774c.m3518b();
        Class<?> cls = c4085g.f13775d.getClass();
        Class cls2 = c4085g.f13778g;
        Class cls3 = c4085g.f13782k;
        C2982h c2982h = c1472jM3518b.f4453h;
        C3608l c3608l = (C3608l) ((AtomicReference) c2982h.f10225b).getAndSet(null);
        if (c3608l == null) {
            c3608l = new C3608l(cls, cls2, cls3);
        } else {
            c3608l.f12108a = cls;
            c3608l.f12109b = cls2;
            c3608l.f12110c = cls3;
        }
        synchronized (((C3341e) c2982h.f10226c)) {
            list = (List) ((C3341e) c2982h.f10226c).get(c3608l);
        }
        ((AtomicReference) c2982h.f10225b).set(c3608l);
        List list2 = list;
        if (list == null) {
            ArrayList arrayList = new ArrayList();
            Iterator it = c1472jM3518b.f4446a.m3171a(cls).iterator();
            while (it.hasNext()) {
                for (Class cls4 : c1472jM3518b.f4448c.m6047t((Class) it.next(), cls2)) {
                    if (!c1472jM3518b.f4451f.m5746e(cls4, cls3).isEmpty() && !arrayList.contains(cls4)) {
                        arrayList.add(cls4);
                    }
                }
            }
            c1472jM3518b.f4453h.m6051x(cls, cls2, cls3, Collections.unmodifiableList(arrayList));
            list2 = arrayList;
        }
        if (list2.isEmpty()) {
            if (File.class.equals(this.f13903b.f13782k)) {
                return false;
            }
            throw new IllegalStateException("Failed to find any load path from " + this.f13903b.f13775d.getClass() + " to " + this.f13903b.f13782k);
        }
        while (true) {
            List list3 = this.f13907f;
            if (list3 != null && this.f13908g < list3.size()) {
                this.f13909h = null;
                while (!z7 && this.f13908g < this.f13907f.size()) {
                    List list4 = this.f13907f;
                    int i6 = this.f13908g;
                    this.f13908g = i6 + 1;
                    InterfaceC1288u interfaceC1288u = (InterfaceC1288u) list4.get(i6);
                    File file = this.f13910i;
                    C4085g c4085g2 = this.f13903b;
                    this.f13909h = interfaceC1288u.mo3137a(file, c4085g2.f13776e, c4085g2.f13777f, c4085g2.f13780i);
                    if (this.f13909h != null && this.f13903b.m8073c(this.f13909h.f4054c.mo3151a()) != null) {
                        this.f13909h.f4054c.mo3154f(this.f13903b.f13786o, this);
                        z7 = true;
                    }
                }
                return z7;
            }
            int i10 = this.f13905d + 1;
            this.f13905d = i10;
            if (i10 >= list2.size()) {
                int i11 = this.f13904c + 1;
                this.f13904c = i11;
                if (i11 >= arrayListM8071a.size()) {
                    return false;
                }
                this.f13905d = 0;
            }
            InterfaceC3978e interfaceC3978e = (InterfaceC3978e) arrayListM8071a.get(this.f13904c);
            Class cls5 = (Class) list2.get(this.f13905d);
            InterfaceC3985l interfaceC3985lM8075e = this.f13903b.m8075e(cls5);
            C4085g c4085g3 = this.f13903b;
            this.f13911j = new C4104z(c4085g3.f13774c.f4431a, interfaceC3978e, c4085g3.f13785n, c4085g3.f13776e, c4085g3.f13777f, interfaceC3985lM8075e, cls5, c4085g3.f13780i);
            File fileMo6926h = c4085g3.f13779h.m3103a().mo6926h(this.f13911j);
            this.f13910i = fileMo6926h;
            if (fileMo6926h != null) {
                this.f13906e = interfaceC3978e;
                this.f13907f = this.f13903b.f13774c.m3518b().m3527g(fileMo6926h);
                this.f13908g = 0;
            }
        }
    }

    @Override
    public final void mo3172c(Exception exc) {
        this.f13902a.mo8067a(this.f13911j, exc, this.f13909h.f4054c, 4);
    }

    @Override
    public final void cancel() {
        C1287t c1287t = this.f13909h;
        if (c1287t != null) {
            c1287t.f4054c.cancel();
        }
    }

    @Override
    public final void mo3173e(Object obj) {
        this.f13902a.mo8069c(this.f13906e, obj, this.f13909h.f4054c, 4, this.f13911j);
    }
}
