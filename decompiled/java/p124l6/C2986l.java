package p124l6;

import android.animation.ValueAnimator;
import android.graphics.Matrix;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import p262y5.AbstractC4268a;

public final class C2986l implements ValueAnimator.AnimatorUpdateListener {

    public final float f10237a;

    public final float f10238b;

    public final float f10239c;

    public final float f10240d;

    public final float f10241e;

    public final float f10242f;

    public final float f10243g;

    public final Matrix f10244h;

    public final AbstractC2991q f10245i;

    public C2986l(AbstractC2991q abstractC2991q, float f, float f3, float f4, float f5, float f10, float f11, float f12, Matrix matrix) {
        this.f10245i = abstractC2991q;
        this.f10237a = f;
        this.f10238b = f3;
        this.f10239c = f4;
        this.f10240d = f5;
        this.f10241e = f10;
        this.f10242f = f11;
        this.f10243g = f12;
        this.f10244h = matrix;
    }

    @Override
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        AbstractC2991q abstractC2991q = this.f10245i;
        abstractC2991q.f10284v.setAlpha(AbstractC4268a.m8310b(this.f10237a, this.f10238b, 0.0f, 0.2f, fFloatValue));
        FloatingActionButton floatingActionButton = abstractC2991q.f10284v;
        float f = this.f10239c;
        float f3 = this.f10240d;
        floatingActionButton.setScaleX(AbstractC4268a.m8309a(f, f3, fFloatValue));
        abstractC2991q.f10284v.setScaleY(AbstractC4268a.m8309a(this.f10241e, f3, fFloatValue));
        float f4 = this.f10242f;
        float f5 = this.f10243g;
        abstractC2991q.f10278p = AbstractC4268a.m8309a(f4, f5, fFloatValue);
        float fM8309a = AbstractC4268a.m8309a(f4, f5, fFloatValue);
        Matrix matrix = this.f10244h;
        abstractC2991q.m6056a(fM8309a, matrix);
        abstractC2991q.f10284v.setImageMatrix(matrix);
    }
}
