package p144n7;

import java.lang.reflect.Method;

public final class C3217o extends AbstractC3206d {

    public final Method f10817b;

    public final int f10818c;

    public C3217o(Method method, int i6) {
        this.f10817b = method;
        this.f10818c = i6;
    }

    @Override
    public final Object mo6496i(Class cls) {
        AbstractC3206d.m6485a(cls);
        return this.f10817b.invoke(null, cls, Integer.valueOf(this.f10818c));
    }
}
