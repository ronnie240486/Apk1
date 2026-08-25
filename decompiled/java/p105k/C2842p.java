package p105k;

import android.view.CollapsibleActionView;
import android.view.View;
import android.widget.FrameLayout;
import p093j.InterfaceC2741b;

public final class C2842p extends FrameLayout implements InterfaceC2741b {

    public final CollapsibleActionView f9746a;

    public C2842p(View view) {
        super(view.getContext());
        this.f9746a = (CollapsibleActionView) view;
        addView(view);
    }

    @Override
    public final void mo588b() {
        this.f9746a.onActionViewExpanded();
    }

    @Override
    public final void mo589e() {
        this.f9746a.onActionViewCollapsed();
    }
}
