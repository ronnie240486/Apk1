package androidx.lifecycle;

import java.lang.reflect.Method;

public final class C0515c {

    public final int f2462a;

    public final Method f2463b;

    public C0515c(Method method, int i6) {
        this.f2462a = i6;
        this.f2463b = method;
        method.setAccessible(true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0515c)) {
            return false;
        }
        C0515c c0515c = (C0515c) obj;
        return this.f2462a == c0515c.f2462a && this.f2463b.getName().equals(c0515c.f2463b.getName());
    }

    public final int hashCode() {
        return this.f2463b.getName().hashCode() + (this.f2462a * 31);
    }
}
