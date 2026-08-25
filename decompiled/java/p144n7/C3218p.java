package p144n7;

import java.lang.reflect.Method;

public final class C3218p extends AbstractC3206d {

    public final Method f10819b;

    public C3218p(Method method) {
        this.f10819b = method;
    }

    @Override
    public final Object mo6496i(Class cls) {
        AbstractC3206d.m6485a(cls);
        return this.f10819b.invoke(null, cls, Object.class);
    }
}
