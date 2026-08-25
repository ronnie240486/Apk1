package p124l6;

import android.animation.Animator;
import androidx.appcompat.widget.C0209g3;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.p2serv.android.p032ds.R;
import p101j7.C2782c;

public final class C2980f extends AbstractC2976b {

    public boolean f10221g;

    public final ExtendedFloatingActionButton f10222h;

    public C2980f(ExtendedFloatingActionButton extendedFloatingActionButton, C2782c c2782c) {
        super(extendedFloatingActionButton, c2782c);
        this.f10222h = extendedFloatingActionButton;
    }

    @Override
    public final int mo6028c() {
        return R.animator.mtrl_extended_fab_hide_motion_spec;
    }

    @Override
    public final void mo6029d() {
        super.mo6029d();
        this.f10221g = true;
    }

    @Override
    public final void mo6030e() {
        this.f10197d.f9501b = null;
        ExtendedFloatingActionButton extendedFloatingActionButton = this.f10222h;
        extendedFloatingActionButton.f6271s = 0;
        if (this.f10221g) {
            return;
        }
        extendedFloatingActionButton.setVisibility(8);
    }

    @Override
    public final void mo6031f(Animator animator) {
        C2782c c2782c = this.f10197d;
        Animator animator2 = (Animator) c2782c.f9501b;
        if (animator2 != null) {
            animator2.cancel();
        }
        c2782c.f9501b = animator;
        this.f10221g = false;
        ExtendedFloatingActionButton extendedFloatingActionButton = this.f10222h;
        extendedFloatingActionButton.setVisibility(0);
        extendedFloatingActionButton.f6271s = 1;
    }

    @Override
    public final void mo6032g() {
        this.f10222h.setVisibility(8);
    }

    @Override
    public final boolean mo6033h() {
        C0209g3 c0209g3 = ExtendedFloatingActionButton.f6262F;
        ExtendedFloatingActionButton extendedFloatingActionButton = this.f10222h;
        if (extendedFloatingActionButton.getVisibility() == 0) {
            if (extendedFloatingActionButton.f6271s != 1) {
                return false;
            }
        } else if (extendedFloatingActionButton.f6271s == 2) {
            return false;
        }
        return true;
    }
}
