package androidx.lifecycle;

import java.lang.reflect.InvocationTargetException;
import p000a.AbstractC0004e;
import p095j1.C2768b;
import p103j9.AbstractC2796i;

public class C0556w0 implements InterfaceC0560y0 {

    public static final C0556w0 f2543b = new C0556w0(0);

    public static final C0556w0 f2544c = new C0556w0(1);

    public static C0556w0 f2545d;

    public final int f2546a;

    public C0556w0(int i6) {
        this.f2546a = i6;
    }

    @Override
    public AbstractC0554v0 mo1197a(Class cls) throws InvocationTargetException {
        switch (this.f2546a) {
            case 5:
                throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
            default:
                try {
                    Object objNewInstance = cls.getDeclaredConstructor(null).newInstance(null);
                    AbstractC2796i.m5784e(objNewInstance, "{\n                modelC…wInstance()\n            }");
                    return (AbstractC0554v0) objNewInstance;
                } catch (IllegalAccessException e5) {
                    throw new RuntimeException(AbstractC0004e.m23q(cls, "Cannot create an instance of "), e5);
                } catch (InstantiationException e10) {
                    throw new RuntimeException(AbstractC0004e.m23q(cls, "Cannot create an instance of "), e10);
                } catch (NoSuchMethodException e11) {
                    throw new RuntimeException(AbstractC0004e.m23q(cls, "Cannot create an instance of "), e11);
                }
        }
    }

    @Override
    public AbstractC0554v0 mo1198b(Class cls, C2768b c2768b) {
        switch (this.f2546a) {
            case 5:
                return new C0546r0();
            default:
                return mo1197a(cls);
        }
    }
}
