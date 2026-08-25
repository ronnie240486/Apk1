package p055ea;

import android.content.DialogInterface;
import android.content.Intent;
import com.tencent.mars.xlog.Log;
import org.bitspark.android.Spark;
import org.bitspark.android.utils.AbstractC3331m;
import p003a2.AbstractC0032a;

public final class DialogInterfaceOnClickListenerC2450l implements DialogInterface.OnClickListener {

    public final int f8632a;

    public final Spark f8633b;

    public DialogInterfaceOnClickListenerC2450l(Spark spark, int i6) {
        this.f8632a = i6;
        this.f8633b = spark;
    }

    @Override
    public final void onClick(DialogInterface dialogInterface, int i6) {
        Spark spark = this.f8633b;
        switch (this.f8632a) {
            case 0:
                try {
                    spark.startActivity(new Intent(AbstractC0032a.m165s("ix3LawGB6UiZFtttB4bqFcQk5ksrpMg1uSz8XDq8xCitIA==\n", "6nOvGW7ojWY=\n")));
                } catch (Exception e5) {
                    String strM165s = AbstractC0032a.m165s("CZLb6lDt\n", "S8GWizmDjxI=\n");
                    String string = e5.toString();
                    boolean z7 = AbstractC3331m.f11244b;
                    Log.m5049i(strM165s, string);
                }
                dialogInterface.dismiss();
                String str = AbstractC2442h.f8595a;
                spark.finish();
                break;
            default:
                Spark.m6677t(spark);
                spark.m6697M0(true);
                dialogInterface.dismiss();
                break;
        }
    }
}
