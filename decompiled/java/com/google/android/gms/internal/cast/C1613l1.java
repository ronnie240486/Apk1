package com.google.android.gms.internal.cast;

import java.util.Random;
import ua.C3943d;

public final class C1613l1 extends ThreadLocal {

    public final int f5403a;

    @Override
    public final Object initialValue() {
        switch (this.f5403a) {
            case 0:
                return new C1633n1();
            case 1:
                return new Random();
            case 2:
                return 0L;
            case 3:
                return new C3943d();
            default:
                return Boolean.FALSE;
        }
    }
}
