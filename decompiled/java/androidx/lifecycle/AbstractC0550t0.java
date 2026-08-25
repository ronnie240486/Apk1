package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import p000a.AbstractC0004e;
import p003a2.AbstractC0032a;
import p103j9.AbstractC2796i;
import p253x8.AbstractC4146i;

public abstract class AbstractC0550t0 {

    public static final List f2534a;

    public static final List f2535b;

    static {
        List listAsList = Arrays.asList(Application.class, C0536m0.class);
        AbstractC2796i.m5784e(listAsList, "asList(...)");
        f2534a = listAsList;
        f2535b = AbstractC0032a.m154F(C0536m0.class);
    }

    public static final Constructor m1514a(Class cls, List list) {
        AbstractC2796i.m5785f(list, "signature");
        Constructor<?>[] constructors = cls.getConstructors();
        AbstractC2796i.m5784e(constructors, "modelClass.constructors");
        for (Constructor<?> constructor : constructors) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            AbstractC2796i.m5784e(parameterTypes, "constructor.parameterTypes");
            List listM8179L = AbstractC4146i.m8179L(parameterTypes);
            if (list.equals(listM8179L)) {
                return constructor;
            }
            if (list.size() == listM8179L.size() && listM8179L.containsAll(list)) {
                throw new UnsupportedOperationException("Class " + cls.getSimpleName() + " must have parameters in the proper order: " + list);
            }
        }
        return null;
    }

    public static final AbstractC0554v0 m1515b(Class cls, Constructor constructor, Object... objArr) {
        try {
            return (AbstractC0554v0) constructor.newInstance(Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException e5) {
            throw new RuntimeException(AbstractC0004e.m23q(cls, "Failed to access "), e5);
        } catch (InstantiationException e10) {
            throw new RuntimeException("A " + cls + " cannot be instantiated.", e10);
        } catch (InvocationTargetException e11) {
            throw new RuntimeException(AbstractC0004e.m23q(cls, "An exception happened in constructor of "), e11.getCause());
        }
    }
}
