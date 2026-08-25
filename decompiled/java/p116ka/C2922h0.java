package p116ka;

import android.view.View;
import ba.C1371d;
import com.p2serv.android.p032ds.R;
import org.bitspark.android.beans.ChannelBean;
import p063fa.C2543m0;
import p063fa.InterfaceC2549o0;
import p214ta.C3877a;

public final class C2922h0 implements InterfaceC2549o0 {

    public final C2543m0 f9907a;

    public final ChannelBean f9908b;

    public final C2924i0 f9909c;

    public C2922h0(C2924i0 c2924i0, C2543m0 c2543m0, ChannelBean channelBean) {
        this.f9909c = c2924i0;
        this.f9907a = c2543m0;
        this.f9908b = channelBean;
    }

    @Override
    public final void mo5482a(int i6, View view) {
        C2924i0 c2924i0 = this.f9909c;
        C3877a c3877a = c2924i0.f9912U;
        if (!c3877a.f13009v) {
            C1371d.m3242a(c2924i0.m1321j(), 0, c2924i0.m1324m().getString(R.string.advise_delete_outdated_programs)).show();
            return;
        }
        C2543m0 c2543m0 = this.f9907a;
        c3877a.f13005r = (ChannelBean.SourcesBean) c2543m0.f8866d.get(i6);
        c2924i0.f9912U.m7739i(i6, this.f9908b, c2543m0.f8866d);
    }
}
