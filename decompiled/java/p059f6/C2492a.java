package p059f6;

import android.animation.TypeEvaluator;

public final class C2492a implements TypeEvaluator {

    public static final C2492a f8720b = new C2492a();

    public final C2495d f8721a = new C2495d();

    @Override
    public final Object evaluate(float f, Object obj, Object obj2) {
        C2495d c2495d = (C2495d) obj;
        C2495d c2495d2 = (C2495d) obj2;
        float f3 = c2495d.f8724a;
        float f4 = 1.0f - f;
        float f5 = (c2495d2.f8724a * f) + (f3 * f4);
        float f10 = c2495d.f8725b;
        float f11 = (c2495d2.f8725b * f) + (f10 * f4);
        float f12 = c2495d.f8726c;
        float f13 = (f * c2495d2.f8726c) + (f4 * f12);
        C2495d c2495d3 = this.f8721a;
        c2495d3.f8724a = f5;
        c2495d3.f8725b = f11;
        c2495d3.f8726c = f13;
        return c2495d3;
    }
}
