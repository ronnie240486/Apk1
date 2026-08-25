package androidx.fragment.app;

import java.lang.reflect.InvocationTargetException;
import p000a.AbstractC0004e;
import p160p.C3347k;

public final class C0398d0 {

    public static final C3347k f1834b = new C3347k(0);

    public final AbstractC0410j0 f1835a;

    public C0398d0(AbstractC0410j0 abstractC0410j0) {
        this.f1835a = abstractC0410j0;
    }

    public static Class m1201b(String str, ClassLoader classLoader) throws ClassNotFoundException {
        C3347k c3347k = f1834b;
        C3347k c3347k2 = (C3347k) c3347k.get(classLoader);
        if (c3347k2 == null) {
            c3347k2 = new C3347k(0);
            c3347k.put(classLoader, c3347k2);
        }
        Class cls = (Class) c3347k2.get(str);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str, false, classLoader);
        c3347k2.put(str, cls2);
        return cls2;
    }

    public static Class m1202c(String str, ClassLoader classLoader) {
        try {
            return m1201b(str, classLoader);
        } catch (ClassCastException e5) {
            throw new C0423q(AbstractC0004e.m24r("Unable to instantiate fragment ", str, ": make sure class is a valid subclass of Fragment"), e5, 0);
        } catch (ClassNotFoundException e10) {
            throw new C0423q(AbstractC0004e.m24r("Unable to instantiate fragment ", str, ": make sure class name exists"), e10, 0);
        }
    }

    public final AbstractComponentCallbacksC0427s m1203a(String str) {
        try {
            return (AbstractComponentCallbacksC0427s) m1202c(str, this.f1835a.f1874n.f2003g.getClassLoader()).getConstructor(null).newInstance(null);
        } catch (IllegalAccessException e5) {
            throw new C0423q(AbstractC0004e.m24r("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e5, 0);
        } catch (InstantiationException e10) {
            throw new C0423q(AbstractC0004e.m24r("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e10, 0);
        } catch (NoSuchMethodException e11) {
            throw new C0423q(AbstractC0004e.m24r("Unable to instantiate fragment ", str, ": could not find Fragment constructor"), e11, 0);
        } catch (InvocationTargetException e12) {
            throw new C0423q(AbstractC0004e.m24r("Unable to instantiate fragment ", str, ": calling Fragment constructor caused an exception"), e12, 0);
        }
    }
}
