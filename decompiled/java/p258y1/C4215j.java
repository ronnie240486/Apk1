package p258y1;

import android.view.View;
import java.util.WeakHashMap;
import p138n0.AbstractC3119g0;
import p138n0.AbstractC3155s0;

public final class C4215j {

    public final float f14329a;

    public final float f14330b;

    public final float f14331c;

    public final float f14332d;

    public final float f14333e;

    public final float f14334f;

    public final float f14335g;

    public final float f14336h;

    public C4215j(View view) {
        this.f14329a = view.getTranslationX();
        this.f14330b = view.getTranslationY();
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        this.f14331c = AbstractC3119g0.m6173l(view);
        this.f14332d = view.getScaleX();
        this.f14333e = view.getScaleY();
        this.f14334f = view.getRotationX();
        this.f14335g = view.getRotationY();
        this.f14336h = view.getRotation();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C4215j)) {
            return false;
        }
        C4215j c4215j = (C4215j) obj;
        return c4215j.f14329a == this.f14329a && c4215j.f14330b == this.f14330b && c4215j.f14331c == this.f14331c && c4215j.f14332d == this.f14332d && c4215j.f14333e == this.f14333e && c4215j.f14334f == this.f14334f && c4215j.f14335g == this.f14335g && c4215j.f14336h == this.f14336h;
    }

    public final int hashCode() {
        float f = this.f14329a;
        int iFloatToIntBits = (f != 0.0f ? Float.floatToIntBits(f) : 0) * 31;
        float f3 = this.f14330b;
        int iFloatToIntBits2 = (iFloatToIntBits + (f3 != 0.0f ? Float.floatToIntBits(f3) : 0)) * 31;
        float f4 = this.f14331c;
        int iFloatToIntBits3 = (iFloatToIntBits2 + (f4 != 0.0f ? Float.floatToIntBits(f4) : 0)) * 31;
        float f5 = this.f14332d;
        int iFloatToIntBits4 = (iFloatToIntBits3 + (f5 != 0.0f ? Float.floatToIntBits(f5) : 0)) * 31;
        float f10 = this.f14333e;
        int iFloatToIntBits5 = (iFloatToIntBits4 + (f10 != 0.0f ? Float.floatToIntBits(f10) : 0)) * 31;
        float f11 = this.f14334f;
        int iFloatToIntBits6 = (iFloatToIntBits5 + (f11 != 0.0f ? Float.floatToIntBits(f11) : 0)) * 31;
        float f12 = this.f14335g;
        int iFloatToIntBits7 = (iFloatToIntBits6 + (f12 != 0.0f ? Float.floatToIntBits(f12) : 0)) * 31;
        float f13 = this.f14336h;
        return iFloatToIntBits7 + (f13 != 0.0f ? Float.floatToIntBits(f13) : 0);
    }
}
