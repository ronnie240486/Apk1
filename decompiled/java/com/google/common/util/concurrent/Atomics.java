package com.google.common.util.concurrent;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

@ElementTypesAreNonnullByDefault
public final class Atomics {
    private Atomics() {
    }

    public static <V> AtomicReference<V> newReference() {
        return new AtomicReference<>();
    }

    public static <E> AtomicReferenceArray<E> newReferenceArray(int i6) {
        return new AtomicReferenceArray<>(i6);
    }

    public static <V> AtomicReference<V> newReference(@ParametricNullness V v10) {
        return new AtomicReference<>(v10);
    }

    public static <E> AtomicReferenceArray<E> newReferenceArray(E[] eArr) {
        return new AtomicReferenceArray<>(eArr);
    }
}
