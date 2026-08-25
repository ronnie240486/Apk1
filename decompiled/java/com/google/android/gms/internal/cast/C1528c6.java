package com.google.android.gms.internal.cast;

public final class C1528c6 extends Throwable {

    public final int f5232a;

    public C1528c6(String str, int i6) {
        super(str);
        this.f5232a = i6;
    }

    @Override
    public final Throwable fillInStackTrace() {
        int i6 = this.f5232a;
        return this;
    }
}
