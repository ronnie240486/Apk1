package p016b3;

import com.bumptech.glide.EnumC1469g;
import com.bumptech.glide.load.data.InterfaceC1478d;
import com.bumptech.glide.load.data.InterfaceC1479e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p186r3.AbstractC3602f;
import p187r4.C3621k;
import p247x2.C4098t;

public final class C1293z implements InterfaceC1479e, InterfaceC1478d {

    public final ArrayList f4059a;

    public final C3621k f4060b;

    public int f4061c;

    public EnumC1469g f4062d;

    public InterfaceC1478d f4063e;

    public List f4064f;

    public boolean f4065g;

    public C1293z(ArrayList arrayList, C3621k c3621k) {
        this.f4060b = c3621k;
        if (arrayList.isEmpty()) {
            throw new IllegalArgumentException("Must not be empty.");
        }
        this.f4059a = arrayList;
        this.f4061c = 0;
    }

    @Override
    public final Class mo3151a() {
        return ((InterfaceC1479e) this.f4059a.get(0)).mo3151a();
    }

    @Override
    public final void mo3152b() {
        List list = this.f4064f;
        if (list != null) {
            this.f4060b.m7334k(list);
        }
        this.f4064f = null;
        Iterator it = this.f4059a.iterator();
        while (it.hasNext()) {
            ((InterfaceC1479e) it.next()).mo3152b();
        }
    }

    @Override
    public final void mo3172c(Exception exc) {
        List list = this.f4064f;
        AbstractC3602f.m7225c(list, "Argument must not be null");
        list.add(exc);
        m3174g();
    }

    @Override
    public final void cancel() {
        this.f4065g = true;
        Iterator it = this.f4059a.iterator();
        while (it.hasNext()) {
            ((InterfaceC1479e) it.next()).cancel();
        }
    }

    @Override
    public final int mo3153d() {
        return ((InterfaceC1479e) this.f4059a.get(0)).mo3153d();
    }

    @Override
    public final void mo3173e(Object obj) {
        if (obj != null) {
            this.f4063e.mo3173e(obj);
        } else {
            m3174g();
        }
    }

    @Override
    public final void mo3154f(EnumC1469g enumC1469g, InterfaceC1478d interfaceC1478d) {
        this.f4062d = enumC1469g;
        this.f4063e = interfaceC1478d;
        this.f4064f = (List) this.f4060b.m7329f();
        ((InterfaceC1479e) this.f4059a.get(this.f4061c)).mo3154f(enumC1469g, this);
        if (this.f4065g) {
            cancel();
        }
    }

    public final void m3174g() {
        if (this.f4065g) {
            return;
        }
        if (this.f4061c < this.f4059a.size() - 1) {
            this.f4061c++;
            mo3154f(this.f4062d, this.f4063e);
        } else {
            AbstractC3602f.m7224b(this.f4064f);
            this.f4063e.mo3172c(new C4098t("Fetch failed", new ArrayList(this.f4064f)));
        }
    }
}
