package com.bumptech.glide;

import com.bumptech.glide.load.data.C1483i;
import com.bumptech.glide.load.data.InterfaceC1480f;
import com.bumptech.glide.load.data.InterfaceC1481g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import p016b3.C1290w;
import p016b3.C1292y;
import p016b3.InterfaceC1288u;
import p016b3.InterfaceC1289v;
import p097j3.C2771b;
import p097j3.C2772c;
import p097j3.InterfaceC2770a;
import p124l6.C2982h;
import p128m0.C3028d;
import p131m3.C3074a;
import p131m3.C3075b;
import p131m3.C3076c;
import p131m3.C3077d;
import p171q.C3388b;
import p173q1.C3406f0;
import p186r3.AbstractC3602f;
import p187r4.C3621k;
import p218u2.C3891b;
import p228v2.InterfaceC3975b;
import p228v2.InterfaceC3977d;
import p228v2.InterfaceC3983j;
import p228v2.InterfaceC3984k;
import p247x2.C4088j;

public final class C1472j {

    public final C1292y f4446a;

    public final C2772c f4447b;

    public final C2982h f4448c;

    public final C2772c f4449d;

    public final C1483i f4450e;

    public final C2772c f4451f;

    public final C2772c f4452g;

    public final C2982h f4453h = new C2982h(1);

    public final C3075b f4454i = new C3075b();

    public final C3621k f4455j;

    public C1472j() {
        C3621k c3621k = new C3621k(new C3028d(20), new C3406f0(1), new C3388b(2));
        this.f4455j = c3621k;
        this.f4446a = new C1292y(c3621k);
        this.f4447b = new C2772c(1);
        this.f4448c = new C2982h(2);
        this.f4449d = new C2772c(3);
        this.f4450e = new C1483i();
        this.f4451f = new C2772c(0);
        this.f4452g = new C2772c(2);
        List listAsList = Arrays.asList("Animation", "Bitmap", "BitmapDrawable");
        ArrayList arrayList = new ArrayList(listAsList.size());
        arrayList.add("legacy_prepend_all");
        Iterator it = listAsList.iterator();
        while (it.hasNext()) {
            arrayList.add((String) it.next());
        }
        arrayList.add("legacy_append");
        C2982h c2982h = this.f4448c;
        synchronized (c2982h) {
            try {
                ArrayList<String> arrayList2 = new ArrayList((ArrayList) c2982h.f10225b);
                ((ArrayList) c2982h.f10225b).clear();
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ((ArrayList) c2982h.f10225b).add((String) it2.next());
                }
                for (String str : arrayList2) {
                    if (!arrayList.contains(str)) {
                        ((ArrayList) c2982h.f10225b).add(str);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void m3521a(Class cls, Class cls2, InterfaceC1289v interfaceC1289v) {
        C1292y c1292y = this.f4446a;
        synchronized (c1292y) {
            c1292y.f4057a.m3139a(cls, cls2, interfaceC1289v);
            c1292y.f4058b.f4056a.clear();
        }
    }

    public final void m3522b(Class cls, InterfaceC3975b interfaceC3975b) {
        C2772c c2772c = this.f4447b;
        synchronized (c2772c) {
            c2772c.f9487a.add(new C3074a(cls, interfaceC3975b));
        }
    }

    public final void m3523c(Class cls, InterfaceC3984k interfaceC3984k) {
        C2772c c2772c = this.f4449d;
        synchronized (c2772c) {
            c2772c.f9487a.add(new C3077d(cls, interfaceC3984k));
        }
    }

    public final void m3524d(String str, Class cls, Class cls2, InterfaceC3983j interfaceC3983j) {
        C2982h c2982h = this.f4448c;
        synchronized (c2982h) {
            c2982h.m6046s(str).add(new C3076c(cls, cls2, interfaceC3983j));
        }
    }

    public final ArrayList m3525e(Class cls, Class cls2, Class cls3) {
        ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList();
        for (Class cls4 : this.f4448c.m6047t(cls, cls2)) {
            for (Class cls5 : this.f4451f.m5746e(cls4, cls3)) {
                C2982h c2982h = this.f4448c;
                synchronized (c2982h) {
                    arrayList = new ArrayList();
                    Iterator it = ((ArrayList) c2982h.f10225b).iterator();
                    while (it.hasNext()) {
                        List<C3076c> list = (List) ((HashMap) c2982h.f10226c).get((String) it.next());
                        if (list != null) {
                            for (C3076c c3076c : list) {
                                if (c3076c.f10539a.isAssignableFrom(cls) && cls4.isAssignableFrom(c3076c.f10540b)) {
                                    arrayList.add(c3076c.f10541c);
                                }
                            }
                        }
                    }
                }
                arrayList2.add(new C4088j(cls, cls4, cls5, arrayList, this.f4451f.m5744c(cls4, cls5), this.f4455j));
            }
        }
        return arrayList2;
    }

    public final ArrayList m3526f() {
        ArrayList arrayList;
        C2772c c2772c = this.f4452g;
        synchronized (c2772c) {
            arrayList = c2772c.f9487a;
        }
        if (arrayList.isEmpty()) {
            throw new C1471i("Failed to find image header parser.");
        }
        return arrayList;
    }

    public final List m3527g(Object obj) {
        List listUnmodifiableList;
        C1292y c1292y = this.f4446a;
        c1292y.getClass();
        Class<?> cls = obj.getClass();
        synchronized (c1292y) {
            C1290w c1290w = (C1290w) c1292y.f4058b.f4056a.get(cls);
            listUnmodifiableList = c1290w == null ? null : c1290w.f4055a;
            if (listUnmodifiableList == null) {
                listUnmodifiableList = Collections.unmodifiableList(c1292y.f4057a.m3141c(cls));
                if (((C1290w) c1292y.f4058b.f4056a.put(cls, new C1290w(listUnmodifiableList))) != null) {
                    throw new IllegalStateException("Already cached loaders for model: " + cls);
                }
            }
        }
        if (listUnmodifiableList.isEmpty()) {
            throw new C1471i("Failed to find any ModelLoaders registered for model class: " + obj.getClass());
        }
        int size = listUnmodifiableList.size();
        List listEmptyList = Collections.emptyList();
        boolean z7 = true;
        for (int i6 = 0; i6 < size; i6++) {
            InterfaceC1288u interfaceC1288u = (InterfaceC1288u) listUnmodifiableList.get(i6);
            if (interfaceC1288u.mo3138b(obj)) {
                if (z7) {
                    listEmptyList = new ArrayList(size - i6);
                    z7 = false;
                }
                listEmptyList.add(interfaceC1288u);
            }
        }
        if (!listEmptyList.isEmpty()) {
            return listEmptyList;
        }
        throw new C1471i("Found ModelLoaders for model class: " + listUnmodifiableList + ", but none that handle this specific model instance: " + obj);
    }

    public final InterfaceC1481g m3528h(Object obj) {
        InterfaceC1481g interfaceC1481gMo3549b;
        C1483i c1483i = this.f4450e;
        synchronized (c1483i) {
            try {
                AbstractC3602f.m7224b(obj);
                InterfaceC1480f interfaceC1480f = (InterfaceC1480f) ((HashMap) c1483i.f4484b).get(obj.getClass());
                if (interfaceC1480f == null) {
                    for (InterfaceC1480f interfaceC1480f2 : ((HashMap) c1483i.f4484b).values()) {
                        if (interfaceC1480f2.mo3548a().isAssignableFrom(obj.getClass())) {
                            interfaceC1480f = interfaceC1480f2;
                            break;
                        }
                    }
                }
                if (interfaceC1480f == null) {
                    interfaceC1480f = C1483i.f4482c;
                }
                interfaceC1481gMo3549b = interfaceC1480f.mo3549b(obj);
            } catch (Throwable th) {
                throw th;
            }
        }
        return interfaceC1481gMo3549b;
    }

    public final void m3529i(InterfaceC1480f interfaceC1480f) {
        C1483i c1483i = this.f4450e;
        synchronized (c1483i) {
            ((HashMap) c1483i.f4484b).put(interfaceC1480f.mo3548a(), interfaceC1480f);
        }
    }

    public final void m3530j(Class cls, Class cls2, InterfaceC2770a interfaceC2770a) {
        C2772c c2772c = this.f4451f;
        synchronized (c2772c) {
            c2772c.f9487a.add(new C2771b(cls, cls2, interfaceC2770a));
        }
    }

    public final void m3531k(InterfaceC3977d interfaceC3977d) {
        C2772c c2772c = this.f4452g;
        synchronized (c2772c) {
            c2772c.f9487a.add(interfaceC3977d);
        }
    }

    public final void m3532l(C3891b c3891b) {
        C1292y c1292y = this.f4446a;
        synchronized (c1292y) {
            Iterator it = c1292y.f4057a.m3144f(c3891b).iterator();
            while (it.hasNext()) {
                ((InterfaceC1289v) it.next()).getClass();
            }
            c1292y.f4058b.f4056a.clear();
        }
    }
}
