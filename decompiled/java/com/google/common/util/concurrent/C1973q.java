package com.google.common.util.concurrent;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import p020b7.InterfaceC1339e0;

public final class C1973q implements InterfaceC1339e0 {

    public final int f6993a;

    public C1973q(int i6) {
        this.f6993a = i6;
    }

    @Override
    public final Object get() {
        switch (this.f6993a) {
            case 0:
                return new Striped.WeakSafeReadWriteLock();
            case 1:
                return new Striped.PaddedLock();
            case 2:
                return Striped.lambda$lazyWeakLock$0();
            default:
                return new ReentrantReadWriteLock();
        }
    }
}
