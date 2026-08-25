package androidx.mediarouter.app;

import p173q1.C3445s0;

public final class C1120y {

    public final Object f3432a;

    public final int f3433b;

    public C1120y(Object obj) {
        this.f3432a = obj;
        if (obj instanceof String) {
            this.f3433b = 1;
        } else {
            if (!(obj instanceof C3445s0)) {
                throw new IllegalArgumentException();
            }
            this.f3433b = 2;
        }
    }
}
