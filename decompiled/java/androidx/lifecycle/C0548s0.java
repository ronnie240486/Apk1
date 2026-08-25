package androidx.lifecycle;

import android.app.Application;
import android.os.Bundle;
import androidx.appcompat.widget.C0280v;
import java.lang.reflect.Constructor;
import java.util.LinkedHashMap;
import p095j1.C2768b;
import p103j9.AbstractC2796i;
import p227v1.InterfaceC3973e;

public final class C0548s0 implements InterfaceC0560y0 {

    public final Application f2528a;

    public final C0558x0 f2529b;

    public final Bundle f2530c;

    public final AbstractC0541p f2531d;

    public final C0280v f2532e;

    public C0548s0(Application application, InterfaceC3973e interfaceC3973e, Bundle bundle) {
        C0558x0 c0558x0;
        this.f2532e = interfaceC3973e.mo356a();
        this.f2531d = interfaceC3973e.mo360f();
        this.f2530c = bundle;
        this.f2528a = application;
        if (application != null) {
            if (C0558x0.f2549f == null) {
                C0558x0.f2549f = new C0558x0(application);
            }
            c0558x0 = C0558x0.f2549f;
            AbstractC2796i.m5782c(c0558x0);
        } else {
            c0558x0 = new C0558x0(null);
        }
        this.f2529b = c0558x0;
    }

    @Override
    public final AbstractC0554v0 mo1197a(Class cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return m1513c(cls, canonicalName);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override
    public final AbstractC0554v0 mo1198b(Class cls, C2768b c2768b) {
        C0556w0 c0556w0 = C0556w0.f2544c;
        LinkedHashMap linkedHashMap = (LinkedHashMap) c2768b.f7850a;
        String str = (String) linkedHashMap.get(c0556w0);
        if (str == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        }
        if (linkedHashMap.get(AbstractC0540o0.f2513a) == null || linkedHashMap.get(AbstractC0540o0.f2514b) == null) {
            if (this.f2531d != null) {
                return m1513c(cls, str);
            }
            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
        Application application = (Application) linkedHashMap.get(C0556w0.f2543b);
        boolean zIsAssignableFrom = AbstractC0510a.class.isAssignableFrom(cls);
        Constructor constructorM1514a = (!zIsAssignableFrom || application == null) ? AbstractC0550t0.m1514a(cls, AbstractC0550t0.f2535b) : AbstractC0550t0.m1514a(cls, AbstractC0550t0.f2534a);
        if (constructorM1514a == null) {
            return this.f2529b.mo1198b(cls, c2768b);
        }
        return (!zIsAssignableFrom || application == null) ? AbstractC0550t0.m1515b(cls, constructorM1514a, AbstractC0540o0.m1505c(c2768b)) : AbstractC0550t0.m1515b(cls, constructorM1514a, application, AbstractC0540o0.m1505c(c2768b));
    }

    public final AbstractC0554v0 m1513c(Class cls, String str) {
        Object obj;
        Application application;
        AbstractC0541p abstractC0541p = this.f2531d;
        if (abstractC0541p == null) {
            throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        }
        boolean zIsAssignableFrom = AbstractC0510a.class.isAssignableFrom(cls);
        Constructor constructorM1514a = (!zIsAssignableFrom || this.f2528a == null) ? AbstractC0550t0.m1514a(cls, AbstractC0550t0.f2535b) : AbstractC0550t0.m1514a(cls, AbstractC0550t0.f2534a);
        if (constructorM1514a == null) {
            if (this.f2528a != null) {
                return this.f2529b.mo1197a(cls);
            }
            if (C0556w0.f2545d == null) {
                C0556w0.f2545d = new C0556w0(6);
            }
            C0556w0 c0556w0 = C0556w0.f2545d;
            AbstractC2796i.m5782c(c0556w0);
            return c0556w0.mo1197a(cls);
        }
        C0280v c0280v = this.f2532e;
        AbstractC2796i.m5782c(c0280v);
        Bundle bundle = this.f2530c;
        Bundle bundleM787c = c0280v.m787c(str);
        Class[] clsArr = C0536m0.f2498f;
        C0536m0 c0536m0M1504b = AbstractC0540o0.m1504b(bundleM787c, bundle);
        C0538n0 c0538n0 = new C0538n0(str, c0536m0M1504b);
        c0538n0.m1502d(c0280v, abstractC0541p);
        EnumC0539o enumC0539oMo1509b = abstractC0541p.mo1509b();
        if (enumC0539oMo1509b == EnumC0539o.f2508b || enumC0539oMo1509b.compareTo(EnumC0539o.f2510d) >= 0) {
            c0280v.m791g();
        } else {
            abstractC0541p.mo1508a(new C0523g(c0280v, abstractC0541p));
        }
        AbstractC0554v0 abstractC0554v0M1515b = (!zIsAssignableFrom || (application = this.f2528a) == null) ? AbstractC0550t0.m1515b(cls, constructorM1514a, c0536m0M1504b) : AbstractC0550t0.m1515b(cls, constructorM1514a, application, c0536m0M1504b);
        synchronized (abstractC0554v0M1515b.f2540a) {
            try {
                obj = abstractC0554v0M1515b.f2540a.get("androidx.lifecycle.savedstate.vm.tag");
                if (obj == null) {
                    abstractC0554v0M1515b.f2540a.put("androidx.lifecycle.savedstate.vm.tag", c0538n0);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (obj != null) {
            c0538n0 = obj;
        }
        if (abstractC0554v0M1515b.f2542c) {
            AbstractC0554v0.m1516a(c0538n0);
        }
        return abstractC0554v0M1515b;
    }
}
