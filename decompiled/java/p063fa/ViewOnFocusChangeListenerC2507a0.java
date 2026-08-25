package p063fa;

import android.view.View;
import org.bitspark.android.beans.ChannelBean;

public final class ViewOnFocusChangeListenerC2507a0 implements View.OnFocusChangeListener {

    public final int f8742a;

    public final C2516d0 f8743b;

    public ViewOnFocusChangeListenerC2507a0(C2516d0 c2516d0, int i6, ChannelBean channelBean) {
        this.f8743b = c2516d0;
        this.f8742a = i6;
    }

    @Override
    public final void onFocusChange(View view, boolean z7) {
        view.getLocationInWindow(new int[2]);
        C2516d0 c2516d0 = this.f8743b;
        if (c2516d0.f8770g) {
            view.setSelected(z7);
            if (z7) {
                c2516d0.m5551b(view);
            }
            if (this.f8742a < c2516d0.f8767d.size()) {
                c2516d0.f8769f.m5943b(view, z7);
            }
        }
    }
}
