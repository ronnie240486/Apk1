package p055ea;

import android.widget.ImageView;
import com.tencent.mars.xlog.Log;
import org.bitspark.android.Spark;
import org.bitspark.android.utils.AbstractC3331m;
import p003a2.AbstractC0032a;

public final class RunnableC2472w implements Runnable {

    public final float f8669a;

    public final Spark f8670b;

    public RunnableC2472w(Spark spark, float f) {
        this.f8670b = spark;
        this.f8669a = f;
    }

    @Override
    public final void run() {
        Spark spark = this.f8670b;
        ImageView imageView = spark.f11106b0;
        float f = this.f8669a;
        imageView.setAlpha(f);
        spark.f11106b0.setVisibility(0);
        String strM165s = AbstractC0032a.m165s("VReVq9Ig\n", "F0TYyrtOKDk=\n");
        String str = AbstractC0032a.m165s("rK6Xamm+0AOTr4tpZ7CcRg==\n", "38b4HSXXpmY=\n") + f + AbstractC0032a.m165s("AKDtYJYI5cw=\n", "PZ3QXas12PE=\n") + spark.f11106b0.isShown();
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(strM165s, str);
    }
}
