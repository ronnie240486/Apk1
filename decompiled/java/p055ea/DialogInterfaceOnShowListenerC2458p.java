package p055ea;

import android.content.DialogInterface;
import android.widget.LinearLayout;
import org.bitspark.android.Spark;

public final class DialogInterfaceOnShowListenerC2458p implements DialogInterface.OnShowListener {

    public final LinearLayout f8646a;

    public final LinearLayout f8647b;

    public final Spark f8648c;

    public DialogInterfaceOnShowListenerC2458p(Spark spark, LinearLayout linearLayout, LinearLayout linearLayout2) {
        this.f8648c = spark;
        this.f8646a = linearLayout;
        this.f8647b = linearLayout2;
    }

    @Override
    public final void onShow(DialogInterface dialogInterface) {
        Spark spark = this.f8648c;
        boolean z7 = !spark.f11132o0;
        LinearLayout linearLayout = this.f8646a;
        linearLayout.setSelected(z7);
        boolean z10 = spark.f11132o0;
        LinearLayout linearLayout2 = this.f8647b;
        linearLayout2.setSelected(z10);
        if (spark.f11132o0) {
            linearLayout2.requestFocus();
        } else {
            linearLayout.requestFocus();
        }
    }
}
