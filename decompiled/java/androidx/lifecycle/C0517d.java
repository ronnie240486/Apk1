package androidx.lifecycle;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public final class C0517d {

    public static final C0517d f2468c = new C0517d();

    public final HashMap f2469a = new HashMap();

    public final HashMap f2470b = new HashMap();

    public static void m1479b(HashMap map, C0515c c0515c, EnumC0537n enumC0537n, Class cls) {
        EnumC0537n enumC0537n2 = (EnumC0537n) map.get(c0515c);
        if (enumC0537n2 == null || enumC0537n == enumC0537n2) {
            if (enumC0537n2 == null) {
                map.put(c0515c, enumC0537n);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + c0515c.f2463b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + enumC0537n2 + ", new value " + enumC0537n);
    }

    public final C0513b m1480a(Class cls, Method[] methodArr) {
        int i6;
        Class superclass = cls.getSuperclass();
        HashMap map = new HashMap();
        HashMap map2 = this.f2469a;
        if (superclass != null) {
            C0513b c0513bM1480a = (C0513b) map2.get(superclass);
            if (c0513bM1480a == null) {
                c0513bM1480a = m1480a(superclass, null);
            }
            map.putAll(c0513bM1480a.f2459b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            C0513b c0513bM1480a2 = (C0513b) map2.get(cls2);
            if (c0513bM1480a2 == null) {
                c0513bM1480a2 = m1480a(cls2, null);
            }
            for (Map.Entry entry : c0513bM1480a2.f2459b.entrySet()) {
                m1479b(map, (C0515c) entry.getKey(), (EnumC0537n) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            try {
                methodArr = cls.getDeclaredMethods();
            } catch (NoClassDefFoundError e5) {
                throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e5);
            }
        }
        boolean z7 = false;
        for (Method method : methodArr) {
            InterfaceC0522f0 interfaceC0522f0 = (InterfaceC0522f0) method.getAnnotation(InterfaceC0522f0.class);
            if (interfaceC0522f0 != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i6 = 0;
                } else {
                    if (!InterfaceC0555w.class.isAssignableFrom(parameterTypes[0])) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i6 = 1;
                }
                EnumC0537n enumC0537nValue = interfaceC0522f0.value();
                if (parameterTypes.length > 1) {
                    if (!EnumC0537n.class.isAssignableFrom(parameterTypes[1])) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (enumC0537nValue != EnumC0537n.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i6 = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                m1479b(map, new C0515c(method, i6), enumC0537nValue, cls);
                z7 = true;
            }
        }
        C0513b c0513b = new C0513b(map);
        map2.put(cls, c0513b);
        this.f2470b.put(cls, Boolean.valueOf(z7));
        return c0513b;
    }
}
