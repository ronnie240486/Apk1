package androidx.media3.p011ui;

import android.animation.ValueAnimator;

public final class C1062g implements ValueAnimator.AnimatorUpdateListener {

    public final int f3129a;

    public final Object f3130b;

    public C1062g(int i6, Object obj) {
        this.f3129a = i6;
        this.f3130b = obj;
    }

    @Override
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f3129a) {
            case 0:
                ((PlayerControlViewLayoutManager) this.f3130b).lambda$new$0(valueAnimator);
                break;
            case 1:
                ((PlayerControlViewLayoutManager) this.f3130b).lambda$new$1(valueAnimator);
                break;
            case 2:
                ((PlayerControlViewLayoutManager) this.f3130b).lambda$new$2(valueAnimator);
                break;
            case 3:
                ((PlayerControlViewLayoutManager) this.f3130b).lambda$new$3(valueAnimator);
                break;
            default:
                ((DefaultTimeBar) this.f3130b).lambda$new$1(valueAnimator);
                break;
        }
    }
}
