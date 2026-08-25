package p178q6;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.appcompat.widget.C0209g3;
import com.google.android.material.progressindicator.LinearProgressIndicatorSpec;
import com.p2serv.android.p032ds.R;
import p156o9.AbstractC3281e;

public final class C3522s extends AbstractC3517n {

    public static final int[] f11872l = {533, 567, 850, 750};

    public static final int[] f11873m = {1267, 1000, 333, 0};

    public static final C0209g3 f11874n = new C0209g3("animationFraction", Float.class, 9);

    public ObjectAnimator f11875d;

    public ObjectAnimator f11876e;

    public final Interpolator[] f11877f;

    public final LinearProgressIndicatorSpec f11878g;

    public int f11879h;

    public boolean f11880i;

    public float f11881j;

    public C3506c f11882k;

    public C3522s(Context context, LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(2);
        this.f11879h = 0;
        this.f11882k = null;
        this.f11878g = linearProgressIndicatorSpec;
        this.f11877f = new Interpolator[]{AnimationUtils.loadInterpolator(context, R.animator.linear_indeterminate_line1_head_interpolator), AnimationUtils.loadInterpolator(context, R.animator.linear_indeterminate_line1_tail_interpolator), AnimationUtils.loadInterpolator(context, R.animator.linear_indeterminate_line2_head_interpolator), AnimationUtils.loadInterpolator(context, R.animator.linear_indeterminate_line2_tail_interpolator)};
    }

    @Override
    public final void mo7155a() {
        ObjectAnimator objectAnimator = this.f11875d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override
    public final void mo7156b() {
        this.f11879h = 0;
        int iM6620j = AbstractC3281e.m6620j(this.f11878g.f11811c[0], this.f11855a.f11852j);
        int[] iArr = this.f11857c;
        iArr[0] = iM6620j;
        iArr[1] = iM6620j;
    }

    @Override
    public final void mo7157c(C3506c c3506c) {
        this.f11882k = c3506c;
    }

    @Override
    public final void mo7158d() {
        ObjectAnimator objectAnimator = this.f11876e;
        if (objectAnimator == null || objectAnimator.isRunning()) {
            return;
        }
        mo7155a();
        if (this.f11855a.isVisible()) {
            this.f11876e.setFloatValues(this.f11881j, 1.0f);
            this.f11876e.setDuration((long) ((1.0f - this.f11881j) * 1800.0f));
            this.f11876e.start();
        }
    }

    @Override
    public final void mo7159e() {
        ObjectAnimator objectAnimator = this.f11875d;
        C0209g3 c0209g3 = f11874n;
        if (objectAnimator == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, c0209g3, 0.0f, 1.0f);
            this.f11875d = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(1800L);
            this.f11875d.setInterpolator(null);
            this.f11875d.setRepeatCount(-1);
            this.f11875d.addListener(new C3521r(this, 0));
        }
        if (this.f11876e == null) {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, c0209g3, 1.0f);
            this.f11876e = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration(1800L);
            this.f11876e.setInterpolator(null);
            this.f11876e.addListener(new C3521r(this, 1));
        }
        this.f11879h = 0;
        int iM6620j = AbstractC3281e.m6620j(this.f11878g.f11811c[0], this.f11855a.f11852j);
        int[] iArr = this.f11857c;
        iArr[0] = iM6620j;
        iArr[1] = iM6620j;
        this.f11875d.start();
    }

    @Override
    public final void mo7160f() {
        this.f11882k = null;
    }
}
