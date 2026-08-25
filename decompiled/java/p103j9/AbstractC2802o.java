package p103j9;

public abstract class AbstractC2802o {

    public static final C2803p f9541a;

    static {
        C2803p c2803p = null;
        try {
            c2803p = (C2803p) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (c2803p == null) {
            c2803p = new C2803p();
        }
        f9541a = c2803p;
    }

    public static C2792e m5794a(Class cls) {
        f9541a.getClass();
        return new C2792e(cls);
    }
}
