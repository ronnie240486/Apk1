package p144n7;

import java.lang.reflect.Method;

public final class C3216n extends AbstractC3206d {

    public final Method f10815b;

    public final Object f10816c;

    public C3216n(Method method, Object obj) {
        this.f10815b = method;
        this.f10816c = obj;
    }

    @Override
    public final Object mo6496i(Class cls) {
        AbstractC3206d.m6485a(cls);
        return this.f10815b.invoke(this.f10816c, cls);
    }
}
