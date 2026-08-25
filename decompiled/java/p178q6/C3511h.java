package p178q6;

import android.animation.ObjectAnimator;
import androidx.appcompat.widget.C0209g3;
import com.google.android.material.progressindicator.CircularProgressIndicatorSpec;
import p066g1.C2592a;
import p156o9.AbstractC3281e;

public final class C3511h extends AbstractC3517n {

    public static final int[] f11821l = {0, 1350, 2700, 4050};

    public static final int[] f11822m = {667, 2017, 3367, 4717};

    public static final int[] f11823n = {1000, 2350, 3700, 5050};

    public static final C0209g3 f11824o = new C0209g3("animationFraction", Float.class, 5);

    public static final C0209g3 f11825p = new C0209g3("completeEndFraction", Float.class, 6);

    public ObjectAnimator f11826d;

    public ObjectAnimator f11827e;

    public final C2592a f11828f;

    public final CircularProgressIndicatorSpec f11829g;

    public int f11830h;

    public float f11831i;

    public float f11832j;

    public C3506c f11833k;

    public C3511h(CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(1);
        this.f11830h = 0;
        this.f11833k = null;
        this.f11829g = circularProgressIndicatorSpec;
        this.f11828f = new C2592a();
    }

    @Override
    public final void mo7155a() {
        ObjectAnimator objectAnimator = this.f11826d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override
    public final void mo7156b() {
        this.f11830h = 0;
        this.f11857c[0] = AbstractC3281e.m6620j(this.f11829g.f11811c[0], this.f11855a.f11852j);
        this.f11832j = 0.0f;
    }

    @Override
    public final void mo7157c(C3506c c3506c) {
        this.f11833k = c3506c;
    }

    @Override
    public final void mo7158d() {
        ObjectAnimator objectAnimator = this.f11827e;
        if (objectAnimator == null || objectAnimator.isRunning()) {
            return;
        }
        if (this.f11855a.isVisible()) {
            this.f11827e.start();
        } else {
            mo7155a();
        }
    }

    @Override
    public final void mo7159e() {
        if (this.f11826d == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, f11824o, 0.0f, 1.0f);
            this.f11826d = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(5400L);
            this.f11826d.setInterpolator(null);
            this.f11826d.setRepeatCount(-1);
            this.f11826d.addListener(new C3510g(this, 0));
        }
        if (this.f11827e == null) {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, f11825p, 0.0f, 1.0f);
            this.f11827e = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration(333L);
            this.f11827e.setInterpolator(this.f11828f);
            this.f11827e.addListener(new C3510g(this, 1));
        }
        this.f11830h = 0;
        this.f11857c[0] = AbstractC3281e.m6620j(this.f11829g.f11811c[0], this.f11855a.f11852j);
        this.f11832j = 0.0f;
        this.f11826d.start();
    }

    @Override
    public final void mo7160f() {
        this.f11833k = null;
    }
}
