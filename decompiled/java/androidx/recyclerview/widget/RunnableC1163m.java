package androidx.recyclerview.widget;

import android.animation.ValueAnimator;

public final class RunnableC1163m implements Runnable {

    public final int f3631a;

    public final Object f3632b;

    public RunnableC1163m(int i6, Object obj) {
        this.f3631a = i6;
        this.f3632b = obj;
    }

    @Override
    public final void run() {
        Object obj = this.f3632b;
        switch (this.f3631a) {
            case 0:
                C1172p c1172p = (C1172p) obj;
                int i6 = c1172p.f3644A;
                ValueAnimator valueAnimator = c1172p.f3671z;
                if (i6 == 1) {
                    valueAnimator.cancel();
                } else if (i6 != 2) {
                }
                c1172p.f3644A = 3;
                valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
                valueAnimator.setDuration(500);
                valueAnimator.start();
                break;
            default:
                ((StaggeredGridLayoutManager) obj).m2844e();
                break;
        }
    }
}
