package p268z1;

import android.animation.TypeEvaluator;
import p055ea.AbstractC2460q;

public final class C4289d implements TypeEvaluator {

    public static final C4289d f14528a = new C4289d();

    @Override
    public final Object evaluate(float f, Object obj, Object obj2) {
        int iIntValue = ((Integer) obj).intValue();
        float f3 = ((iIntValue >> 24) & 255) / 255.0f;
        int iIntValue2 = ((Integer) obj2).intValue();
        float f4 = ((iIntValue2 >> 24) & 255) / 255.0f;
        float fPow = (float) Math.pow(((iIntValue >> 16) & 255) / 255.0f, 2.2d);
        float fPow2 = (float) Math.pow(((iIntValue >> 8) & 255) / 255.0f, 2.2d);
        float fPow3 = (float) Math.pow((iIntValue & 255) / 255.0f, 2.2d);
        float fPow4 = (float) Math.pow(((iIntValue2 >> 16) & 255) / 255.0f, 2.2d);
        float fPow5 = (float) Math.pow(((iIntValue2 >> 8) & 255) / 255.0f, 2.2d);
        float fPow6 = (float) Math.pow((iIntValue2 & 255) / 255.0f, 2.2d);
        float fM5490d = AbstractC2460q.m5490d(f4, f3, f, f3);
        float fM5490d2 = AbstractC2460q.m5490d(fPow4, fPow, f, fPow);
        float fM5490d3 = AbstractC2460q.m5490d(fPow5, fPow2, f, fPow2);
        float fM5490d4 = AbstractC2460q.m5490d(fPow6, fPow3, f, fPow3);
        float fPow7 = ((float) Math.pow(fM5490d2, 0.45454545454545453d)) * 255.0f;
        float fPow8 = ((float) Math.pow(fM5490d3, 0.45454545454545453d)) * 255.0f;
        return Integer.valueOf(Math.round(((float) Math.pow(fM5490d4, 0.45454545454545453d)) * 255.0f) | (Math.round(fPow7) << 16) | (Math.round(fM5490d * 255.0f) << 24) | (Math.round(fPow8) << 8));
    }
}
