package p262y5;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import p055ea.AbstractC2460q;
import p066g1.C2592a;

public abstract class AbstractC4268a {

    public static final LinearInterpolator f14469a = new LinearInterpolator();

    public static final C2592a f14470b = new C2592a();

    public static final C2592a f14471c = new C2592a(C2592a.f9040c);

    public static final C2592a f14472d = new C2592a(C2592a.f9042e);

    public static final DecelerateInterpolator f14473e = new DecelerateInterpolator();

    public static float m8309a(float f, float f3, float f4) {
        return AbstractC2460q.m5490d(f3, f, f4, f);
    }

    public static float m8310b(float f, float f3, float f4, float f5, float f10) {
        if (f10 < f4) {
            return f;
        }
        return f10 > f5 ? f3 : m8309a(f, f3, (f10 - f4) / (f5 - f4));
    }

    public static int m8311c(float f, int i6, int i10) {
        return Math.round(f * (i10 - i6)) + i6;
    }
}
