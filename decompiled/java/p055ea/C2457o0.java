package p055ea;

import androidx.lifecycle.InterfaceC0520e0;
import org.bitspark.android.Spark;
import org.bitspark.android.beans.EpgBeans;
import org.bitspark.android.utils.AbstractC3331m;
import p003a2.AbstractC0032a;

public final class C2457o0 implements InterfaceC0520e0 {

    public final Spark f8645a;

    public C2457o0(Spark spark) {
        this.f8645a = spark;
    }

    @Override
    public final void mo1200c(Object obj) {
        Spark spark = this.f8645a;
        EpgBeans.EpgBean epgBean = (EpgBeans.EpgBean) spark.f11120i0.f13000m.m1484d();
        if (epgBean == null) {
            spark.m6733z0();
            return;
        }
        String name = epgBean.getName();
        String strM5494h = AbstractC2460q.m5494h(AbstractC3331m.m6751a(epgBean.getTime()), AbstractC0032a.m165s("PA==\n", "ESA/V/VXjtg=\n") + AbstractC3331m.m6751a(epgBean.getEndTime()));
        spark.f11147v1.setText(name);
        spark.f11145u1.setText(strM5494h);
    }
}
