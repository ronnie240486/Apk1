package p063fa;

import android.view.View;
import org.bitspark.android.beans.ChannelBean;
import p055ea.C2448k;

public final class ViewOnFocusChangeListenerC2571y0 implements View.OnFocusChangeListener {

    public final C2508a1 f8943a;

    public final ChannelBean.SourcesBean f8944b;

    public final int f8945c;

    public final C2511b1 f8946d;

    public ViewOnFocusChangeListenerC2571y0(C2511b1 c2511b1, C2508a1 c2508a1, ChannelBean.SourcesBean sourcesBean, int i6) {
        this.f8946d = c2511b1;
        this.f8943a = c2508a1;
        this.f8944b = sourcesBean;
        this.f8945c = i6;
    }

    @Override
    public final void onFocusChange(View view, boolean z7) {
        if (z7) {
            C2448k c2448k = this.f8946d.f8750c;
            View view2 = this.f8943a.itemView;
            c2448k.m5486d(this.f8945c, this.f8944b);
        }
    }
}
