package p227v1;

import android.os.Bundle;
import androidx.appcompat.widget.C0280v;
import androidx.lifecycle.AbstractC0540o0;
import androidx.lifecycle.AbstractC0554v0;
import androidx.lifecycle.C0544q0;
import androidx.lifecycle.C0562z0;
import androidx.lifecycle.EnumC0537n;
import androidx.lifecycle.InterfaceC0512a1;
import androidx.lifecycle.InterfaceC0527i;
import androidx.lifecycle.InterfaceC0551u;
import androidx.lifecycle.InterfaceC0555w;
import com.lzy.okgo.cache.CacheEntity;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import p000a.AbstractC0004e;
import p055ea.AbstractC2460q;
import p103j9.AbstractC2796i;

public final class C3969a implements InterfaceC0551u {

    public final int f13501a;

    public final Object f13502b;

    public C3969a(int i6, Object obj) {
        this.f13501a = i6;
        this.f13502b = obj;
    }

    @Override
    public final void onStateChanged(InterfaceC0555w interfaceC0555w, EnumC0537n enumC0537n) {
        switch (this.f13501a) {
            case 0:
                if (enumC0537n != EnumC0537n.ON_CREATE) {
                    throw new AssertionError("Next event must be ON_CREATE");
                }
                interfaceC0555w.mo360f().mo1510c(this);
                ?? r10 = this.f13502b;
                Bundle bundleM787c = r10.mo356a().m787c("androidx.savedstate.Restarter");
                if (bundleM787c == null) {
                    return;
                }
                ArrayList<String> stringArrayList = bundleM787c.getStringArrayList("classes_to_restore");
                if (stringArrayList == null) {
                    throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
                }
                for (String str : stringArrayList) {
                    try {
                        Class<? extends U> clsAsSubclass = Class.forName(str, false, C3969a.class.getClassLoader()).asSubclass(InterfaceC3971c.class);
                        AbstractC2796i.m5784e(clsAsSubclass, "{\n                Class.…class.java)\n            }");
                        try {
                            Constructor declaredConstructor = clsAsSubclass.getDeclaredConstructor(null);
                            declaredConstructor.setAccessible(true);
                            try {
                                Object objNewInstance = declaredConstructor.newInstance(null);
                                AbstractC2796i.m5784e(objNewInstance, "{\n                constr…wInstance()\n            }");
                                C0562z0 c0562z0Mo359e = ((InterfaceC0512a1) r10).mo359e();
                                C0280v c0280vMo356a = r10.mo356a();
                                c0562z0Mo359e.getClass();
                                LinkedHashMap linkedHashMap = c0562z0Mo359e.f2562a;
                                for (String str2 : new HashSet(linkedHashMap.keySet())) {
                                    AbstractC2796i.m5785f(str2, CacheEntity.KEY);
                                    AbstractC0554v0 abstractC0554v0 = (AbstractC0554v0) linkedHashMap.get(str2);
                                    AbstractC2796i.m5782c(abstractC0554v0);
                                    AbstractC0540o0.m1503a(abstractC0554v0, c0280vMo356a, r10.mo360f());
                                }
                                if (!new HashSet(linkedHashMap.keySet()).isEmpty()) {
                                    c0280vMo356a.m791g();
                                }
                            } catch (Exception e5) {
                                throw new RuntimeException(AbstractC2460q.m5501o("Failed to instantiate ", str), e5);
                            }
                        } catch (NoSuchMethodException e10) {
                            throw new IllegalStateException("Class " + clsAsSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e10);
                        }
                    } catch (ClassNotFoundException e11) {
                        throw new RuntimeException(AbstractC0004e.m24r("Class ", str, " wasn't found"), e11);
                    }
                }
                return;
            case 1:
                new HashMap();
                InterfaceC0527i[] interfaceC0527iArr = (InterfaceC0527i[]) this.f13502b;
                if (interfaceC0527iArr.length > 0) {
                    InterfaceC0527i interfaceC0527i = interfaceC0527iArr[0];
                    throw null;
                }
                if (interfaceC0527iArr.length <= 0) {
                    return;
                }
                InterfaceC0527i interfaceC0527i2 = interfaceC0527iArr[0];
                throw null;
            default:
                if (enumC0537n != EnumC0537n.ON_CREATE) {
                    throw new IllegalStateException(("Next event must be ON_CREATE, it was " + enumC0537n).toString());
                }
                interfaceC0555w.mo360f().mo1510c(this);
                ((C0544q0) this.f13502b).m1511a();
                return;
        }
    }
}
