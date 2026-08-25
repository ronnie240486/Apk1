package p228v2;

import android.text.TextUtils;
import p000a.AbstractC0004e;
import p171q.C3388b;

public final class C3980g {

    public static final C3388b f13510e = new C3388b(7);

    public final Object f13511a;

    public final InterfaceC3979f f13512b;

    public final String f13513c;

    public volatile byte[] f13514d;

    public C3980g(String str, Object obj, InterfaceC3979f interfaceC3979f) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Must not be null or empty");
        }
        this.f13513c = str;
        this.f13511a = obj;
        this.f13512b = interfaceC3979f;
    }

    public static C3980g m7966a(Object obj, String str) {
        return new C3980g(str, obj, f13510e);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C3980g) {
            return this.f13513c.equals(((C3980g) obj).f13513c);
        }
        return false;
    }

    public final int hashCode() {
        return this.f13513c.hashCode();
    }

    public final String toString() {
        return AbstractC0004e.m26t(new StringBuilder("Option{key='"), this.f13513c, "'}");
    }
}
