package p016b3;

import com.bumptech.glide.C1471i;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import p187r4.C3621k;
import p218u2.C3891b;

public final class C1262b0 {

    public static final C1263c f3993e = new C1263c(6);

    public static final C1270f0 f3994f = new C1270f0(2);

    public final ArrayList f3995a;

    public final C1263c f3996b;

    public final HashSet f3997c;

    public final C3621k f3998d;

    public C1262b0(C3621k c3621k) {
        C1263c c1263c = f3993e;
        this.f3995a = new ArrayList();
        this.f3997c = new HashSet();
        this.f3998d = c3621k;
        this.f3996b = c1263c;
    }

    public final synchronized void m3139a(Class cls, Class cls2, InterfaceC1289v interfaceC1289v) {
        C1260a0 c1260a0 = new C1260a0(cls, cls2, interfaceC1289v);
        ArrayList arrayList = this.f3995a;
        arrayList.add(arrayList.size(), c1260a0);
    }

    public final synchronized InterfaceC1288u m3140b(Class cls, Class cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            Iterator it = this.f3995a.iterator();
            boolean z7 = false;
            while (true) {
                boolean z10 = true;
                if (!it.hasNext()) {
                    break;
                }
                C1260a0 c1260a0 = (C1260a0) it.next();
                if (this.f3997c.contains(c1260a0)) {
                    z7 = true;
                } else {
                    if (!c1260a0.f3987a.isAssignableFrom(cls) || !c1260a0.f3988b.isAssignableFrom(cls2)) {
                        z10 = false;
                    }
                    if (z10) {
                        this.f3997c.add(c1260a0);
                        arrayList.add(c1260a0.f3989c.mo3136a(this));
                        this.f3997c.remove(c1260a0);
                    }
                }
            }
            if (arrayList.size() > 1) {
                C1263c c1263c = this.f3996b;
                C3621k c3621k = this.f3998d;
                c1263c.getClass();
                return new C1261b(arrayList, 2, c3621k);
            }
            if (arrayList.size() == 1) {
                return (InterfaceC1288u) arrayList.get(0);
            }
            if (z7) {
                return f3994f;
            }
            throw new C1471i("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        } catch (Throwable th) {
            this.f3997c.clear();
            throw th;
        }
    }

    public final synchronized ArrayList m3141c(Class cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (C1260a0 c1260a0 : this.f3995a) {
                if (!this.f3997c.contains(c1260a0) && c1260a0.f3987a.isAssignableFrom(cls)) {
                    this.f3997c.add(c1260a0);
                    arrayList.add(c1260a0.f3989c.mo3136a(this));
                    this.f3997c.remove(c1260a0);
                }
            }
        } catch (Throwable th) {
            this.f3997c.clear();
            throw th;
        }
        return arrayList;
    }

    public final synchronized ArrayList m3142d(Class cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (C1260a0 c1260a0 : this.f3995a) {
            if (!arrayList.contains(c1260a0.f3988b) && c1260a0.f3987a.isAssignableFrom(cls)) {
                arrayList.add(c1260a0.f3988b);
            }
        }
        return arrayList;
    }

    public final synchronized ArrayList m3143e() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator it = this.f3995a.iterator();
        while (it.hasNext()) {
            C1260a0 c1260a0 = (C1260a0) it.next();
            if (c1260a0.f3987a.isAssignableFrom(C1278k.class) && c1260a0.f3988b.isAssignableFrom(InputStream.class)) {
                it.remove();
                arrayList.add(c1260a0.f3989c);
            }
        }
        return arrayList;
    }

    public final synchronized ArrayList m3144f(C3891b c3891b) {
        ArrayList arrayListM3143e;
        arrayListM3143e = m3143e();
        m3139a(C1278k.class, InputStream.class, c3891b);
        return arrayListM3143e;
    }
}
