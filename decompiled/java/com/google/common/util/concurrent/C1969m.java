package com.google.common.util.concurrent;

import java.lang.reflect.Constructor;
import java.util.List;
import p020b7.InterfaceC1346i;

public final class C1969m implements InterfaceC1346i {

    public final int f6989a;

    public C1969m(int i6) {
        this.f6989a = i6;
    }

    @Override
    public final Object apply(Object obj) {
        switch (this.f6989a) {
            case 0:
                return FuturesGetChecked.lambda$static$0((List) obj);
            case 1:
                return FuturesGetChecked.lambda$static$1((List) obj);
            case 2:
                return FuturesGetChecked.lambda$static$2((Constructor) obj);
            default:
                return ClosingFuture.access$000((ClosingFuture) obj);
        }
    }
}
