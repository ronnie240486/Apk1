package androidx.leanback.widget;

import android.view.View;
import android.view.animation.Animation;

public final class AnimationAnimationListenerC0450b implements Animation.AnimationListener {

    public final int f2311a;

    public final BaseCardView f2312b;

    public AnimationAnimationListenerC0450b(BaseCardView baseCardView, int i6) {
        this.f2311a = i6;
        this.f2312b = baseCardView;
    }

    @Override
    public final void onAnimationEnd(Animation animation) {
        switch (this.f2311a) {
            case 0:
                BaseCardView baseCardView = this.f2312b;
                if (baseCardView.f2076m == 0.0f) {
                    for (int i6 = 0; i6 < baseCardView.f2069f.size(); i6++) {
                        ((View) baseCardView.f2069f.get(i6)).setVisibility(8);
                    }
                }
                break;
            case 1:
                BaseCardView baseCardView2 = this.f2312b;
                if (baseCardView2.f2077n == 0.0f) {
                    for (int i10 = 0; i10 < baseCardView2.f2068e.size(); i10++) {
                        ((View) baseCardView2.f2068e.get(i10)).setVisibility(8);
                    }
                }
                break;
            default:
                BaseCardView baseCardView3 = this.f2312b;
                if (baseCardView3.f2078o == 0.0d) {
                    for (int i11 = 0; i11 < baseCardView3.f2068e.size(); i11++) {
                        ((View) baseCardView3.f2068e.get(i11)).setVisibility(8);
                    }
                }
                break;
        }
    }

    @Override
    public final void onAnimationRepeat(Animation animation) {
        int i6 = this.f2311a;
    }

    @Override
    public final void onAnimationStart(Animation animation) {
        int i6 = this.f2311a;
    }

    private final void m1406a(Animation animation) {
    }

    private final void m1407b(Animation animation) {
    }

    private final void m1408c(Animation animation) {
    }

    private final void m1409d(Animation animation) {
    }

    private final void m1410e(Animation animation) {
    }

    private final void m1411f(Animation animation) {
    }
}
