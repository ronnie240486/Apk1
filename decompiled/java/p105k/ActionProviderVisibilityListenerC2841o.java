package p105k;

import android.view.ActionProvider;
import android.view.View;
import p101j7.C2782c;
import p138n0.AbstractC3106c;

public final class ActionProviderVisibilityListenerC2841o extends AbstractC3106c implements ActionProvider.VisibilityListener {

    public final ActionProvider f9743b;

    public final MenuItemC2845s f9744c;

    public C2782c f9745d;

    public ActionProviderVisibilityListenerC2841o(MenuItemC2845s menuItemC2845s, ActionProvider actionProvider) {
        this.f9744c = menuItemC2845s;
        this.f9743b = actionProvider;
    }

    @Override
    public final boolean mo5847a() {
        return this.f9743b.isVisible();
    }

    @Override
    public final View mo5848b(C2840n c2840n) {
        return this.f9743b.onCreateActionView(c2840n);
    }

    @Override
    public final boolean mo5849c() {
        return this.f9743b.overridesItemVisibility();
    }

    @Override
    public final void mo5850d(C2782c c2782c) {
        this.f9745d = c2782c;
        this.f9743b.setVisibilityListener(this);
    }

    @Override
    public final void onActionProviderVisibilityChanged(boolean z7) {
        C2782c c2782c = this.f9745d;
        if (c2782c != null) {
            MenuC2838l menuC2838l = ((C2840n) c2782c.f9501b).f9730n;
            menuC2838l.f9694h = true;
            menuC2838l.mo4279p(true);
        }
    }
}
