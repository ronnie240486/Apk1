package com.google.android.gms.internal.cast;

import p000a.AbstractC0004e;

public final class C1519b7 extends C1529c7 {

    public final int f5223d;

    public C1519b7(byte[] bArr) {
        super(bArr);
        C1529c7.m3757f(bArr.length);
        this.f5223d = 47;
    }

    @Override
    public final byte mo3732c(int i6) {
        int i10 = this.f5223d;
        if (((i10 - (i6 + 1)) | i6) >= 0) {
            return this.f5235b[i6];
        }
        if (i6 < 0) {
            throw new ArrayIndexOutOfBoundsException(AbstractC0004e.m20n(i6, "Index < 0: "));
        }
        throw new ArrayIndexOutOfBoundsException(AbstractC0004e.m19m(i6, i10, "Index > length: ", ", "));
    }

    @Override
    public final byte mo3733d(int i6) {
        return this.f5235b[i6];
    }

    @Override
    public final int mo3734e() {
        return this.f5223d;
    }
}
