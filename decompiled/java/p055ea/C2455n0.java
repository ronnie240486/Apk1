package p055ea;

import androidx.lifecycle.InterfaceC0520e0;
import org.bitspark.android.Spark;
import org.bitspark.android.beans.EpgBeans;
import org.bitspark.android.utils.AbstractC3331m;
import p003a2.AbstractC0032a;
import p004a3.RunnableC0038c;
import p116ka.ViewOnKeyListenerC2932m0;

public final class C2455n0 implements InterfaceC0520e0 {

    public final Spark f8640a;

    public C2455n0(Spark spark) {
        this.f8640a = spark;
    }

    @Override
    public final void mo1200c(Object obj) {
        Spark spark = this.f8640a;
        EpgBeans.EpgBean epgBean = (EpgBeans.EpgBean) spark.f11120i0.f12999l.m1484d();
        EpgBeans.EpgBean epgBean2 = (EpgBeans.EpgBean) spark.f11120i0.f13000m.m1484d();
        if (epgBean == null) {
            spark.m6732y0();
            return;
        }
        String name = epgBean.getName();
        String strM5494h = AbstractC2460q.m5494h(AbstractC3331m.m6751a(epgBean.getTime()), AbstractC0032a.m165s("gQ==\n", "rG8GHNq9XGI=\n") + AbstractC3331m.m6751a(epgBean.getEndTime()));
        spark.f11143t1.setText(name);
        spark.f11141s1.setText(strM5494h);
        long jLongValue = epgBean.getEndTime().longValue() - epgBean.getTime().longValue();
        spark.f11139r1.setProgress((int) AbstractC3331m.m6760j(epgBean.getTime()));
        spark.f11139r1.setMax((int) jLongValue);
        Long time = epgBean.getTime();
        RunnableC0038c runnableC0038c = spark.f11136q0;
        if (runnableC0038c != null) {
            ViewOnKeyListenerC2932m0.f9950E0.removeCallbacks(runnableC0038c);
        }
        RunnableC0038c runnableC0038c2 = new RunnableC0038c(spark, 14, time);
        spark.f11136q0 = runnableC0038c2;
        ViewOnKeyListenerC2932m0.f9950E0.post(runnableC0038c2);
        if (epgBean2 == null) {
            spark.m6733z0();
            return;
        }
        String name2 = epgBean2.getName();
        String strM5494h2 = AbstractC2460q.m5494h(AbstractC3331m.m6751a(epgBean2.getTime()), AbstractC0032a.m165s("xw==\n", "6kfS/d0npTY=\n") + AbstractC3331m.m6751a(epgBean2.getEndTime()));
        spark.f11147v1.setText(name2);
        spark.f11145u1.setText(strM5494h2);
    }
}
