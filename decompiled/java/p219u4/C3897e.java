package p219u4;

import com.google.android.gms.cast.framework.media.widget.ExpandedControllerActivity;
import com.p2serv.android.p032ds.R;
import p187r4.C3616f;
import p187r4.InterfaceC3614d;

public final class C3897e implements InterfaceC3614d {

    public final ExpandedControllerActivity f13097a;

    public C3897e(ExpandedControllerActivity expandedControllerActivity) {
        this.f13097a = expandedControllerActivity;
    }

    @Override
    public final void mo7283b() {
        int i6 = ExpandedControllerActivity.f4902n0;
        this.f13097a.m3632t();
    }

    @Override
    public final void mo7285e() {
        int i6 = ExpandedControllerActivity.f4902n0;
        ExpandedControllerActivity expandedControllerActivity = this.f13097a;
        C3616f c3616fM3628p = expandedControllerActivity.m3628p();
        if (c3616fM3628p == null || !c3616fM3628p.m7305i()) {
            if (expandedControllerActivity.f4937j0) {
                return;
            }
            expandedControllerActivity.finish();
        } else {
            expandedControllerActivity.f4937j0 = false;
            expandedControllerActivity.m3631s();
            expandedControllerActivity.m3633u();
        }
    }

    @Override
    public final void mo7286f() {
        ExpandedControllerActivity expandedControllerActivity = this.f13097a;
        expandedControllerActivity.f4920R.setText(expandedControllerActivity.getResources().getString(R.string.cast_expanded_controller_loading));
    }

    @Override
    public final void mo7287j() {
        int i6 = ExpandedControllerActivity.f4902n0;
        this.f13097a.m3633u();
    }

    @Override
    public final void mo7284c() {
    }

    @Override
    public final void mo7288o() {
    }
}
