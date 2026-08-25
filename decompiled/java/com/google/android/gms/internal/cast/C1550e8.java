package com.google.android.gms.internal.cast;

public final class C1550e8 {

    public static final C1550e8 f5286e = new C1550e8(new int[0], new Object[0], false);

    public final int[] f5287a;

    public final Object[] f5288b;

    public int f5289c = -1;

    public boolean f5290d;

    public C1550e8(int[] iArr, Object[] objArr, boolean z7) {
        this.f5287a = iArr;
        this.f5288b = objArr;
        this.f5290d = z7;
    }

    public final int m3813a() {
        int i6 = this.f5289c;
        if (i6 != -1) {
            return i6;
        }
        this.f5289c = 0;
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof C1550e8)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return 506991;
    }
}
