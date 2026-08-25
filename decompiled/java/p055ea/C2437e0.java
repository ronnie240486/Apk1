package p055ea;

import android.widget.PopupWindow;
import org.bitspark.android.Spark;
import p193ra.CountDownTimerC3662e;
import sa.C3736g;

public final class C2437e0 implements PopupWindow.OnDismissListener {

    public final C3736g f8545a;

    public final Spark f8546b;

    public C2437e0(Spark spark, C3736g c3736g) {
        this.f8546b = spark;
        this.f8545a = c3736g;
    }

    @Override
    public final void onDismiss() {
        CountDownTimerC3662e countDownTimerC3662e = this.f8545a.f12513a;
        if (countDownTimerC3662e != null) {
            countDownTimerC3662e.cancel();
        }
        this.f8546b.m6691G0(5000);
    }
}
