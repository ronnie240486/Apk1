package androidx.lifecycle;

import android.os.Bundle;
import androidx.appcompat.widget.C0280v;
import com.bumptech.glide.AbstractC1466d;
import com.lzy.okgo.cache.CacheEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicReference;
import p002a1.C0026b;
import p095j1.C2767a;
import p095j1.C2768b;
import p103j9.AbstractC2796i;
import p213t9.AbstractC3819b0;
import p213t9.AbstractC3865u;
import p213t9.C3826d1;
import p227v1.InterfaceC3972d;
import p227v1.InterfaceC3973e;
import p254x9.AbstractC4172n;
import p275z9.C4362d;

public abstract class AbstractC0540o0 {

    public static final C0556w0 f2513a = new C0556w0(3);

    public static final C0556w0 f2514b = new C0556w0(4);

    public static final C0556w0 f2515c = new C0556w0(2);

    public static final void m1503a(AbstractC0554v0 abstractC0554v0, C0280v c0280v, AbstractC0541p abstractC0541p) {
        Object obj;
        AbstractC2796i.m5785f(c0280v, "registry");
        AbstractC2796i.m5785f(abstractC0541p, "lifecycle");
        HashMap map = abstractC0554v0.f2540a;
        if (map == null) {
            obj = null;
        } else {
            synchronized (map) {
                obj = abstractC0554v0.f2540a.get("androidx.lifecycle.savedstate.vm.tag");
            }
        }
        C0538n0 c0538n0 = (C0538n0) obj;
        if (c0538n0 == null || c0538n0.f2506c) {
            return;
        }
        c0538n0.m1502d(c0280v, abstractC0541p);
        EnumC0539o enumC0539oMo1509b = abstractC0541p.mo1509b();
        if (enumC0539oMo1509b == EnumC0539o.f2508b || enumC0539oMo1509b.compareTo(EnumC0539o.f2510d) >= 0) {
            c0280v.m791g();
        } else {
            abstractC0541p.mo1508a(new C0523g(c0280v, abstractC0541p));
        }
    }

    public static C0536m0 m1504b(Bundle bundle, Bundle bundle2) {
        if (bundle == null) {
            if (bundle2 == null) {
                return new C0536m0();
            }
            HashMap map = new HashMap();
            for (String str : bundle2.keySet()) {
                AbstractC2796i.m5784e(str, CacheEntity.KEY);
                map.put(str, bundle2.get(str));
            }
            return new C0536m0(map);
        }
        ClassLoader classLoader = C0536m0.class.getClassLoader();
        AbstractC2796i.m5782c(classLoader);
        bundle.setClassLoader(classLoader);
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("keys");
        ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("values");
        if (parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) {
            throw new IllegalStateException("Invalid bundle passed as restored state");
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int size = parcelableArrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            Object obj = parcelableArrayList.get(i6);
            AbstractC2796i.m5783d(obj, "null cannot be cast to non-null type kotlin.String");
            linkedHashMap.put((String) obj, parcelableArrayList2.get(i6));
        }
        return new C0536m0(linkedHashMap);
    }

    public static final C0536m0 m1505c(C2768b c2768b) {
        C0556w0 c0556w0 = f2513a;
        LinkedHashMap linkedHashMap = (LinkedHashMap) c2768b.f7850a;
        InterfaceC3973e interfaceC3973e = (InterfaceC3973e) linkedHashMap.get(c0556w0);
        if (interfaceC3973e == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
        }
        InterfaceC0512a1 interfaceC0512a1 = (InterfaceC0512a1) linkedHashMap.get(f2514b);
        if (interfaceC0512a1 == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        Bundle bundle = (Bundle) linkedHashMap.get(f2515c);
        String str = (String) linkedHashMap.get(C0556w0.f2544c);
        if (str == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
        }
        InterfaceC3972d interfaceC3972dM788d = interfaceC3973e.mo356a().m788d();
        C0544q0 c0544q0 = interfaceC3972dM788d instanceof C0544q0 ? (C0544q0) interfaceC3972dM788d : null;
        if (c0544q0 == null) {
            throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
        }
        LinkedHashMap linkedHashMap2 = m1507e(interfaceC0512a1).f2527d;
        C0536m0 c0536m0 = (C0536m0) linkedHashMap2.get(str);
        if (c0536m0 != null) {
            return c0536m0;
        }
        Class[] clsArr = C0536m0.f2498f;
        c0544q0.m1511a();
        Bundle bundle2 = c0544q0.f2523c;
        Bundle bundle3 = bundle2 != null ? bundle2.getBundle(str) : null;
        Bundle bundle4 = c0544q0.f2523c;
        if (bundle4 != null) {
            bundle4.remove(str);
        }
        Bundle bundle5 = c0544q0.f2523c;
        if (bundle5 != null && bundle5.isEmpty()) {
            c0544q0.f2523c = null;
        }
        C0536m0 c0536m0M1504b = m1504b(bundle3, bundle);
        linkedHashMap2.put(str, c0536m0M1504b);
        return c0536m0M1504b;
    }

    public static final C0545r m1506d(InterfaceC0555w interfaceC0555w) {
        C0545r c0545r;
        AbstractC2796i.m5785f(interfaceC0555w, "<this>");
        AbstractC0541p abstractC0541pMo360f = interfaceC0555w.mo360f();
        AbstractC2796i.m5785f(abstractC0541pMo360f, "<this>");
        loop0: while (true) {
            AtomicReference atomicReference = abstractC0541pMo360f.f2516a;
            c0545r = (C0545r) atomicReference.get();
            if (c0545r != null) {
                break;
            }
            C3826d1 c3826d1 = new C3826d1(null);
            C4362d c4362d = AbstractC3819b0.f12901a;
            c0545r = new C0545r(abstractC0541pMo360f, AbstractC1466d.m3482A(c3826d1, AbstractC4172n.f14112a.f13237f));
            do {
                if (atomicReference.compareAndSet(null, c0545r)) {
                    C4362d c4362d2 = AbstractC3819b0.f12901a;
                    AbstractC3865u.m7696k(c0545r, AbstractC4172n.f14112a.f13237f, new C0543q(c0545r, null), 2);
                    break loop0;
                }
            } while (atomicReference.get() == null);
        }
        return c0545r;
    }

    public static final C0546r0 m1507e(InterfaceC0512a1 interfaceC0512a1) {
        return (C0546r0) new C0026b(interfaceC0512a1.mo359e(), new C0556w0(5), interfaceC0512a1 instanceof InterfaceC0529j ? ((InterfaceC0529j) interfaceC0512a1).mo358d() : C2767a.f9482b).m137q(C0546r0.class, "androidx.lifecycle.internal.SavedStateHandlesVM");
    }
}
