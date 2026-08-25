package com.google.android.gms.internal.cast;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import p055ea.AbstractC2460q;
import p165p4.AbstractC3365j;
import p173q1.AbstractC3427m0;
import p173q1.C3424l0;
import p173q1.C3445s0;
import p173q1.C3451u0;
import p230v4.C3988b;

public final class C1685t extends AbstractC3427m0 {

    public static final C3988b f5676f = new C3988b("MRDiscoveryCallback", null);

    public final C1676s f5677a;

    public final Set f5678b;

    public final Map f5679c;

    public final LinkedHashSet f5680d;

    public final C1712w f5681e;

    public C1685t(Context context) {
        C1712w c1712w = new C1712w();
        c1712w.f5714a = context;
        this.f5681e = c1712w;
        this.f5679c = Collections.synchronizedMap(new HashMap());
        this.f5680d = new LinkedHashSet();
        this.f5678b = Collections.synchronizedSet(new LinkedHashSet());
        this.f5677a = new C1676s(this);
    }

    @Override
    public final void mo2753d(C3451u0 c3451u0, C3445s0 c3445s0) {
        f5676f.m7975b("MediaRouterDiscoveryCallback.onRouteAdded.", new Object[0]);
        m4023q(c3445s0, true);
    }

    @Override
    public final void mo2754e(C3451u0 c3451u0, C3445s0 c3445s0) {
        f5676f.m7975b("MediaRouterDiscoveryCallback.onRouteChanged.", new Object[0]);
        m4023q(c3445s0, true);
    }

    @Override
    public final void mo2755h(C3451u0 c3451u0, C3445s0 c3445s0) {
        f5676f.m7975b("MediaRouterDiscoveryCallback.onRouteRemoved.", new Object[0]);
        m4023q(c3445s0, false);
    }

    public final void m4021o() {
        C3988b c3988b = f5676f;
        c3988b.m7975b(AbstractC2460q.m5492f(this.f5680d.size(), "Starting RouteDiscovery with ", " IDs"), new Object[0]);
        c3988b.m7975b("appIdToRouteInfo has these appId route keys: ".concat(String.valueOf(this.f5679c.keySet())), new Object[0]);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            m4022p();
        } else {
            new HandlerC1731y0(Looper.getMainLooper(), 0).post(new RunnableC1658q(this, 1));
        }
    }

    public final void m4022p() {
        C1712w c1712w = this.f5681e;
        if (((C3451u0) c1712w.f5715b) == null) {
            c1712w.f5715b = C3451u0.m7069d((Context) c1712w.f5714a);
        }
        C3451u0 c3451u0 = (C3451u0) c1712w.f5715b;
        if (c3451u0 != null) {
            c3451u0.m7075h(this);
        }
        LinkedHashSet<String> linkedHashSet = this.f5680d;
        synchronized (linkedHashSet) {
            try {
                for (String str : linkedHashSet) {
                    String strM6840a = AbstractC3365j.m6840a(str);
                    if (strM6840a == null) {
                        throw new IllegalArgumentException("category must not be null");
                    }
                    ArrayList<String> arrayList = new ArrayList<>();
                    if (!arrayList.contains(strM6840a)) {
                        arrayList.add(strM6840a);
                    }
                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList("controlCategories", arrayList);
                    C3424l0 c3424l0 = new C3424l0(bundle, arrayList);
                    Map map = this.f5679c;
                    if (((C1667r) map.get(str)) == null) {
                        map.put(str, new C1667r(c3424l0));
                    }
                    f5676f.m7975b("Adding mediaRouter callback for control category " + AbstractC3365j.m6840a(str), new Object[0]);
                    if (((C3451u0) c1712w.f5715b) == null) {
                        c1712w.f5715b = C3451u0.m7069d((Context) c1712w.f5714a);
                    }
                    ((C3451u0) c1712w.f5715b).m7074a(c3424l0, this, 4);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        f5676f.m7975b("appIdToRouteInfo has these appId route keys: ".concat(String.valueOf(this.f5679c.keySet())), new Object[0]);
    }

    public final void m4023q(C3445s0 c3445s0, boolean z7) {
        boolean zAdd;
        Set setM4057h;
        C3988b c3988b = f5676f;
        c3988b.m7975b("MediaRouterDiscoveryCallback.updateRouteToAppIds (add=%b) route %s", Boolean.valueOf(z7), c3445s0);
        Map map = this.f5679c;
        synchronized (map) {
            try {
                c3988b.m7975b("appIdToRouteInfo has these appId route keys: ".concat(String.valueOf(map.keySet())), new Object[0]);
                zAdd = false;
                for (Map.Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    C1667r c1667r = (C1667r) entry.getValue();
                    if (c3445s0.m7025h(c1667r.f5573b)) {
                        if (z7) {
                            c3988b.m7975b("Adding/updating route for appId " + str, new Object[0]);
                            zAdd = c1667r.f5572a.add(c3445s0);
                            if (!zAdd) {
                                Log.w(c3988b.f13521a, c3988b.m7977d("Route " + String.valueOf(c3445s0) + " already exists for appId " + str, new Object[0]));
                            }
                        } else {
                            c3988b.m7975b("Removing route for appId " + str, new Object[0]);
                            zAdd = c1667r.f5572a.remove(c3445s0);
                            if (!zAdd) {
                                Log.w(c3988b.f13521a, c3988b.m7977d("Route " + String.valueOf(c3445s0) + " already removed from appId " + str, new Object[0]));
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zAdd) {
            f5676f.m7975b("Invoking callback.onRouteUpdated.", new Object[0]);
            synchronized (this.f5678b) {
                try {
                    HashMap map2 = new HashMap();
                    Map map3 = this.f5679c;
                    synchronized (map3) {
                        try {
                            for (String str2 : map3.keySet()) {
                                C1667r c1667r2 = (C1667r) map3.get(AbstractC1503a1.m3695f(str2));
                                if (c1667r2 == null) {
                                    int i6 = AbstractC1732y1.f5735c;
                                    setM4057h = C1564g2.f5313j;
                                } else {
                                    LinkedHashSet linkedHashSet = c1667r2.f5572a;
                                    int i10 = AbstractC1732y1.f5735c;
                                    Object[] array = linkedHashSet.toArray();
                                    setM4057h = AbstractC1732y1.m4057h(array, array.length);
                                }
                                if (!setM4057h.isEmpty()) {
                                    map2.put(str2, setM4057h);
                                }
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    C1554f2.m3816a(map2.entrySet());
                    Iterator it = this.f5678b.iterator();
                    if (it.hasNext()) {
                        if (it.next() != null) {
                            throw new ClassCastException();
                        }
                        throw null;
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }
    }
}
