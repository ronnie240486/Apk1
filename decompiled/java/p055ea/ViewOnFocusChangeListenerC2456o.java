package p055ea;

import android.view.View;
import android.widget.LinearLayout;
import org.bitspark.android.Spark;

public final class ViewOnFocusChangeListenerC2456o implements View.OnFocusChangeListener {

    public final int f8641a;

    public final LinearLayout f8642b;

    public final LinearLayout f8643c;

    public final Spark f8644d;

    public ViewOnFocusChangeListenerC2456o(Spark spark, LinearLayout linearLayout, LinearLayout linearLayout2, int i6) {
        this.f8641a = i6;
        this.f8644d = spark;
        this.f8642b = linearLayout;
        this.f8643c = linearLayout2;
    }

    @Override
    public final void onFocusChange(View view, boolean z7) {
        switch (this.f8641a) {
            case 0:
                if (z7) {
                    Spark spark = this.f8644d;
                    spark.f11132o0 = false;
                    this.f8642b.setSelected(true);
                    this.f8643c.setSelected(spark.f11132o0);
                }
                break;
            default:
                if (z7) {
                    Spark spark2 = this.f8644d;
                    spark2.f11132o0 = true;
                    this.f8642b.setSelected(!true);
                    this.f8643c.setSelected(spark2.f11132o0);
                }
                break;
        }
    }
}
