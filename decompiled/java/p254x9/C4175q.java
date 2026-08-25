package p254x9;

import java.util.concurrent.atomic.AtomicReferenceArray;
import p275z9.C4359a;

public final class C4175q {
    private volatile AtomicReferenceArray<Object> array;

    public C4175q(int i6) {
        this.array = new AtomicReferenceArray<>(i6);
    }

    public final int m8227a() {
        return this.array.length();
    }

    public final Object m8228b(int i6) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.array;
        if (i6 < atomicReferenceArray.length()) {
            return atomicReferenceArray.get(i6);
        }
        return null;
    }

    public final void m8229c(int i6, C4359a c4359a) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.array;
        int length = atomicReferenceArray.length();
        if (i6 < length) {
            atomicReferenceArray.set(i6, c4359a);
            return;
        }
        int i10 = i6 + 1;
        int i11 = length * 2;
        if (i10 < i11) {
            i10 = i11;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(i10);
        for (int i12 = 0; i12 < length; i12++) {
            atomicReferenceArray2.set(i12, atomicReferenceArray.get(i12));
        }
        atomicReferenceArray2.set(i6, c4359a);
        this.array = atomicReferenceArray2;
    }
}
