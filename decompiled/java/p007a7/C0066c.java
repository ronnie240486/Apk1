package p007a7;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.C1875m;
import com.google.android.material.textfield.TextInputLayout;
import org.bitspark.android.view.CircularProgressBar;
import p221u6.C3908h;

public final class C0066c implements ValueAnimator.AnimatorUpdateListener {

    public final int f188a;

    public final Object f189b;

    public C0066c(int i6, Object obj) {
        this.f188a = i6;
        this.f189b = obj;
    }

    @Override
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f188a) {
            case 0:
                ((View) this.f189b).invalidate();
                break;
            case 1:
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                C3908h c3908h = ((BottomSheetBehavior) this.f189b).f5992h;
                if (c3908h != null) {
                    c3908h.m7810o(fFloatValue);
                }
                break;
            case 2:
                ((CollapsingToolbarLayout) this.f189b).setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
                break;
            case 3:
                float fFloatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                TextView textView = (TextView) this.f189b;
                textView.setScaleX(fFloatValue2);
                textView.setScaleY(fFloatValue2);
                break;
            case 4:
                ((C1875m) this.f189b).f6869c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
            case 5:
                ((TextInputLayout) this.f189b).f6746D0.m4272q(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
            case 6:
                int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                CircularProgressBar circularProgressBar = (CircularProgressBar) this.f189b;
                circularProgressBar.f11266b = iIntValue;
                int i6 = circularProgressBar.f11266b;
                circularProgressBar.f11272h = (i6 * 360.0f) / circularProgressBar.f11267c;
                circularProgressBar.setProgress(i6);
                break;
            default:
                ((TabLayout) this.f189b).scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
                break;
        }
    }
}
