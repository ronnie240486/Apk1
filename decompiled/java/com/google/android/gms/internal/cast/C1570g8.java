package com.google.android.gms.internal.cast;

import sun.misc.Unsafe;

public final class C1570g8 extends AbstractC1590i8 {
    public C1570g8(Unsafe unsafe) {
        super(unsafe);
    }

    @Override
    public final double mo3825a(long j10, Object obj) {
        return Double.longBitsToDouble(this.f5350a.getLong(obj, j10));
    }

    @Override
    public final float mo3826b(long j10, Object obj) {
        return Float.intBitsToFloat(this.f5350a.getInt(obj, j10));
    }

    @Override
    public final void mo3827c(Object obj, long j10, boolean z7) {
        if (AbstractC1600j8.f5378g) {
            AbstractC1600j8.m3882b(obj, j10, z7 ? (byte) 1 : (byte) 0);
        } else {
            AbstractC1600j8.m3883c(obj, j10, z7 ? (byte) 1 : (byte) 0);
        }
    }

    @Override
    public final void mo3828d(Object obj, long j10, byte b8) {
        if (AbstractC1600j8.f5378g) {
            AbstractC1600j8.m3882b(obj, j10, b8);
        } else {
            AbstractC1600j8.m3883c(obj, j10, b8);
        }
    }

    @Override
    public final void mo3829e(Object obj, long j10, double d) {
        this.f5350a.putLong(obj, j10, Double.doubleToLongBits(d));
    }

    @Override
    public final void mo3830f(Object obj, long j10, float f) {
        this.f5350a.putInt(obj, j10, Float.floatToIntBits(f));
    }

    @Override
    public final boolean mo3831g(long j10, Object obj) {
        return AbstractC1600j8.f5378g ? AbstractC1600j8.m3894n(j10, obj) : AbstractC1600j8.m3895o(j10, obj);
    }
}
