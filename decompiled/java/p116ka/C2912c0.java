package p116ka;

import android.view.View;
import ba.C1371d;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;
import org.bitspark.android.beans.ChannelBean;
import p063fa.C2543m0;
import p063fa.InterfaceC2549o0;
import p214ta.C3877a;

public final class C2912c0 implements InterfaceC2549o0 {

    public final C2543m0 f9869a;

    public final C2914d0 f9870b;

    public C2912c0(C2914d0 c2914d0, C2543m0 c2543m0) {
        this.f9870b = c2914d0;
        this.f9869a = c2543m0;
    }

    @Override
    public final void mo5482a(int i6, View view) {
        C2914d0 c2914d0 = this.f9870b;
        C2924i0 c2924i0 = c2914d0.f9876d;
        C3877a c3877a = c2924i0.f9912U;
        boolean z7 = c3877a.f13009v;
        C2924i0 c2924i1 = c2914d0.f9876d;
        if (!z7) {
            C1371d.m3242a(c2924i0.m1321j(), 0, c2924i1.m1324m().getString(R.string.advise_delete_outdated_programs)).show();
            return;
        }
        c3877a.f13006s = c2914d0.f9874b.getCurrentItem();
        c2924i1.f9912U.f12984A.clear();
        ArrayList arrayList = c2924i1.f9912U.f12984A;
        C2543m0 c2543m0 = this.f9869a;
        arrayList.addAll(c2543m0.f8866d);
        c2924i1.f9912U.f13005r = (ChannelBean.SourcesBean) c2543m0.f8866d.get(i6);
        c2924i1.f9912U.m7739i(i6, c2914d0.f9873a, c2543m0.f8866d);
    }
}
