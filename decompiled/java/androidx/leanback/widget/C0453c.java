package androidx.leanback.widget;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public final class C0453c extends Animation {

    public final int f2315a;

    public final float f2316b;

    public final float f2317c;

    public final BaseCardView f2318d;

    public C0453c(BaseCardView baseCardView, float f, float f3, int i6) {
        this.f2315a = i6;
        switch (i6) {
            case 1:
                this.f2318d = baseCardView;
                this.f2316b = f;
                this.f2317c = f3 - f;
                break;
            case 2:
                this.f2318d = baseCardView;
                this.f2316b = f;
                this.f2317c = f3 - f;
                break;
            default:
                this.f2318d = baseCardView;
                this.f2316b = f;
                this.f2317c = f3 - f;
                break;
        }
    }

    @Override
    public final void applyTransformation(float f, Transformation transformation) {
        switch (this.f2315a) {
            case 0:
                float f3 = (f * this.f2317c) + this.f2316b;
                BaseCardView baseCardView = this.f2318d;
                baseCardView.f2078o = f3;
                for (int i6 = 0; i6 < baseCardView.f2068e.size(); i6++) {
                    ((View) baseCardView.f2068e.get(i6)).setAlpha(baseCardView.f2078o);
                }
                break;
            case 1:
                float f4 = (f * this.f2317c) + this.f2316b;
                BaseCardView baseCardView2 = this.f2318d;
                baseCardView2.f2077n = f4;
                baseCardView2.requestLayout();
                break;
            default:
                float f5 = (f * this.f2317c) + this.f2316b;
                BaseCardView baseCardView3 = this.f2318d;
                baseCardView3.f2076m = f5;
                baseCardView3.requestLayout();
                break;
        }
    }
}
