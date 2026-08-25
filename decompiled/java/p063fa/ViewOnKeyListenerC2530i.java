package p063fa;

import android.view.KeyEvent;
import android.view.View;

public final class ViewOnKeyListenerC2530i implements View.OnKeyListener {

    public final int f8814a;

    public final boolean f8815b;

    public final C2536k f8816c;

    public ViewOnKeyListenerC2530i(C2536k c2536k, int i6, boolean z7) {
        this.f8816c = c2536k;
        this.f8814a = i6;
        this.f8815b = z7;
    }

    @Override
    public final boolean onKey(View view, int i6, KeyEvent keyEvent) {
        C2536k c2536k = this.f8816c;
        if (this.f8814a == c2536k.getGroupCount() - 1 && this.f8815b && i6 == 20) {
            return true;
        }
        return c2536k.f8844k.onKey(view, i6, keyEvent);
    }
}
