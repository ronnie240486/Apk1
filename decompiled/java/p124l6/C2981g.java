package p124l6;

import android.animation.Animator;
import androidx.appcompat.widget.C0209g3;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.p2serv.android.p032ds.R;
import p101j7.C2782c;

public final class C2981g extends AbstractC2976b {

    public final ExtendedFloatingActionButton f10223g;

    public C2981g(ExtendedFloatingActionButton extendedFloatingActionButton, C2782c c2782c) {
        super(extendedFloatingActionButton, c2782c);
        this.f10223g = extendedFloatingActionButton;
    }

    @Override
    public final int mo6028c() {
        return R.animator.mtrl_extended_fab_show_motion_spec;
    }

    @Override
    public final void mo6030e() {
        this.f10197d.f9501b = null;
        this.f10223g.f6271s = 0;
    }

    @Override
    public final void mo6031f(Animator animator) {
        C2782c c2782c = this.f10197d;
        Animator animator2 = (Animator) c2782c.f9501b;
        if (animator2 != null) {
            animator2.cancel();
        }
        c2782c.f9501b = animator;
        ExtendedFloatingActionButton extendedFloatingActionButton = this.f10223g;
        extendedFloatingActionButton.setVisibility(0);
        extendedFloatingActionButton.f6271s = 2;
    }

    @Override
    public final void mo6032g() {
        ExtendedFloatingActionButton extendedFloatingActionButton = this.f10223g;
        extendedFloatingActionButton.setVisibility(0);
        extendedFloatingActionButton.setAlpha(1.0f);
        extendedFloatingActionButton.setScaleY(1.0f);
        extendedFloatingActionButton.setScaleX(1.0f);
    }

    @Override
    public final boolean mo6033h() {
        C0209g3 c0209g3 = ExtendedFloatingActionButton.f6262F;
        ExtendedFloatingActionButton extendedFloatingActionButton = this.f10223g;
        if (extendedFloatingActionButton.getVisibility() != 0) {
            if (extendedFloatingActionButton.f6271s != 2) {
                return false;
            }
        } else if (extendedFloatingActionButton.f6271s == 1) {
            return false;
        }
        return true;
    }
}
