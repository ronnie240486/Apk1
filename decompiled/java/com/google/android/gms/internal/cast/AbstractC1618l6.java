package com.google.android.gms.internal.cast;

import sun.misc.Unsafe;

public abstract class AbstractC1618l6 {
    public static boolean m3927a(Unsafe unsafe, AbstractC1608k6 abstractC1608k6, long j10, Object obj, Object obj2) {
        while (!unsafe.compareAndSwapObject(abstractC1608k6, j10, obj, obj2)) {
            if (unsafe.getObject(abstractC1608k6, j10) != obj) {
                return false;
            }
        }
        return true;
    }
}
