package com.google.android.gms.internal.cast;

public final class C1518b6 {

    public static final C1518b6 f5219c;

    public static final C1518b6 f5220d;

    public final boolean f5221a;

    public final RuntimeException f5222b;

    static {
        if (AbstractC1608k6.f5389i) {
            f5220d = null;
            f5219c = null;
        } else {
            f5220d = new C1518b6(false, null);
            f5219c = new C1518b6(true, null);
        }
    }

    public C1518b6(boolean z7, RuntimeException runtimeException) {
        this.f5221a = z7;
        this.f5222b = runtimeException;
    }
}
