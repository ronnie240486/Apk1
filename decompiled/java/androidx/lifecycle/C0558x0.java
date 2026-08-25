package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import p000a.AbstractC0004e;
import p095j1.C2768b;
import p103j9.AbstractC2796i;

public final class C0558x0 extends C0556w0 {

    public static C0558x0 f2549f;

    public final Application f2550e;

    public C0558x0(Application application) {
        super(6);
        this.f2550e = application;
    }

    @Override
    public final AbstractC0554v0 mo1197a(Class cls) {
        Application application = this.f2550e;
        if (application != null) {
            return m1518c(cls, application);
        }
        throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
    }

    @Override
    public final AbstractC0554v0 mo1198b(Class cls, C2768b c2768b) {
        if (this.f2550e != null) {
            return mo1197a(cls);
        }
        Application application = (Application) ((LinkedHashMap) c2768b.f7850a).get(C0556w0.f2543b);
        if (application != null) {
            return m1518c(cls, application);
        }
        if (AbstractC0510a.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
        }
        return super.mo1197a(cls);
    }

    public final AbstractC0554v0 m1518c(Class cls, Application application) {
        if (!AbstractC0510a.class.isAssignableFrom(cls)) {
            return super.mo1197a(cls);
        }
        try {
            AbstractC0554v0 abstractC0554v0 = (AbstractC0554v0) cls.getConstructor(Application.class).newInstance(application);
            AbstractC2796i.m5784e(abstractC0554v0, "{\n                try {\n…          }\n            }");
            return abstractC0554v0;
        } catch (IllegalAccessException e5) {
            throw new RuntimeException(AbstractC0004e.m23q(cls, "Cannot create an instance of "), e5);
        } catch (InstantiationException e10) {
            throw new RuntimeException(AbstractC0004e.m23q(cls, "Cannot create an instance of "), e10);
        } catch (NoSuchMethodException e11) {
            throw new RuntimeException(AbstractC0004e.m23q(cls, "Cannot create an instance of "), e11);
        } catch (InvocationTargetException e12) {
            throw new RuntimeException(AbstractC0004e.m23q(cls, "Cannot create an instance of "), e12);
        }
    }
}
