package p064g;

import android.animation.TimeInterpolator;

public final class C2577d implements TimeInterpolator {

    public int[] f8991a;

    public int f8992b;

    public int f8993c;

    @Override
    public final float getInterpolation(float f) {
        int i6 = (int) ((f * this.f8993c) + 0.5f);
        int i10 = this.f8992b;
        int[] iArr = this.f8991a;
        int i11 = 0;
        while (i11 < i10) {
            int i12 = iArr[i11];
            if (i6 < i12) {
                break;
            }
            i6 -= i12;
            i11++;
        }
        return (i11 / i10) + (i11 < i10 ? i6 / this.f8993c : 0.0f);
    }
}
