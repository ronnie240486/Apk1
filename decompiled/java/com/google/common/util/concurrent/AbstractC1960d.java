package com.google.common.util.concurrent;

import sun.misc.Unsafe;

public abstract class AbstractC1960d {
    public static boolean m4450a(Unsafe unsafe, AbstractFuture abstractFuture, long j10, Object obj, Object obj2) {
        while (!unsafe.compareAndSwapObject(abstractFuture, j10, obj, obj2)) {
            if (unsafe.getObject(abstractFuture, j10) != obj) {
                return false;
            }
        }
        return true;
    }
}
