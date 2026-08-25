package p055ea;

import android.view.View;
import org.bitspark.android.Spark;
import org.bitspark.android.beans.ChannelBean;
import org.bitspark.android.utils.C3333o;
import p000a.RunnableC0005f;
import p063fa.C2516d0;
import p116ka.ViewOnKeyListenerC2932m0;
import p193ra.C3663f;

public final class ViewOnClickListenerC2474x implements View.OnClickListener {

    public final int f8673a;

    public final Spark f8674b;

    public ViewOnClickListenerC2474x(Spark spark, int i6) {
        this.f8673a = i6;
        this.f8674b = spark;
    }

    @Override
    public final void onClick(View view) {
        Spark spark = this.f8674b;
        switch (this.f8673a) {
            case 0:
                HandlerC2468u handlerC2468u = Spark.f11002X1;
                spark.m6698N0();
                break;
            case 1:
                spark.m6697M0(!Spark.f11011g2);
                ViewOnKeyListenerC2932m0.f9950E0.postDelayed(new RunnableC0005f(14, this), 500L);
                break;
            case 2:
                spark.m6697M0(!Spark.f11011g2);
                C3333o c3333o = C3333o.f11249f;
                if (c3333o.f11254e) {
                    c3333o.m6774g();
                }
                break;
            case 3:
                spark.m6725p0();
                ChannelBean channelBean = C3663f.m7415b().f12272e;
                C2516d0 c2516d0 = spark.f11054I.f10002Y;
                int iM5550a = c2516d0 != null ? c2516d0.m5550a() : -1;
                if (iM5550a >= 0) {
                    spark.f11054I.m5963j0(channelBean, iM5550a);
                }
                break;
            case 4:
                spark.m6686B0();
                break;
            case 5:
                spark.m6690F0();
                break;
            case 6:
                spark.m6689E0();
                break;
            default:
                if (spark.f11135p1.isShown()) {
                    spark.m6709Z();
                }
                break;
        }
    }
}
