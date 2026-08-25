package p178q6;

import android.animation.ObjectAnimator;
import androidx.appcompat.widget.C0209g3;
import com.google.android.material.progressindicator.LinearProgressIndicatorSpec;
import java.util.Arrays;
import p006a6.C0062a;
import p066g1.C2592a;
import p156o9.AbstractC3281e;

public final class C3520q extends AbstractC3517n {

    public static final C0209g3 f11863j = new C0209g3("animationFraction", Float.class, 8);

    public ObjectAnimator f11864d;

    public final C2592a f11865e;

    public final LinearProgressIndicatorSpec f11866f;

    public int f11867g;

    public boolean f11868h;

    public float f11869i;

    public C3520q(LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(3);
        this.f11867g = 1;
        this.f11866f = linearProgressIndicatorSpec;
        this.f11865e = new C2592a();
    }

    @Override
    public final void mo7155a() {
        ObjectAnimator objectAnimator = this.f11864d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override
    public final void mo7156b() {
        this.f11868h = true;
        this.f11867g = 1;
        Arrays.fill(this.f11857c, AbstractC3281e.m6620j(this.f11866f.f11811c[0], this.f11855a.f11852j));
    }

    @Override
    public final void mo7159e() {
        if (this.f11864d == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, f11863j, 0.0f, 1.0f);
            this.f11864d = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(333L);
            this.f11864d.setInterpolator(null);
            this.f11864d.setRepeatCount(-1);
            this.f11864d.addListener(new C0062a(6, this));
        }
        this.f11868h = true;
        this.f11867g = 1;
        Arrays.fill(this.f11857c, AbstractC3281e.m6620j(this.f11866f.f11811c[0], this.f11855a.f11852j));
        this.f11864d.start();
    }

    @Override
    public final void mo7158d() {
    }

    @Override
    public final void mo7160f() {
    }

    @Override
    public final void mo7157c(C3506c c3506c) {
    }
}
