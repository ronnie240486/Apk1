package p055ea;

import android.view.View;
import org.bitspark.android.Spark;
import org.bitspark.android.beans.ChannelBean;
import p063fa.C2511b1;
import p063fa.InterfaceC2549o0;
import p214ta.C3877a;

public final class C2435d0 implements InterfaceC2549o0 {

    public final Spark f8537a;

    public C2435d0(Spark spark) {
        this.f8537a = spark;
    }

    @Override
    public final void mo5482a(int i6, View view) {
        Spark spark = this.f8537a;
        C2511b1 c2511b1 = spark.f11146v0;
        c2511b1.f8752e = i6;
        c2511b1.notifyDataSetChanged();
        spark.f11120i0.f13005r = (ChannelBean.SourcesBean) spark.f11146v0.f8755h.get(i6);
        C3877a c3877a = spark.f11120i0;
        c3877a.m7739i(i6, c3877a.f13004q, c3877a.f12984A);
    }
}
