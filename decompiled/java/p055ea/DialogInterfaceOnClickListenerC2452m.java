package p055ea;

import android.content.DialogInterface;
import org.bitspark.android.Spark;

public final class DialogInterfaceOnClickListenerC2452m implements DialogInterface.OnClickListener {

    public final boolean f8635a;

    public final Spark f8636b;

    public DialogInterfaceOnClickListenerC2452m(Spark spark, boolean z7) {
        this.f8636b = spark;
        this.f8635a = z7;
    }

    @Override
    public final void onClick(DialogInterface dialogInterface, int i6) {
        dialogInterface.dismiss();
        String str = AbstractC2442h.f8595a;
        if (this.f8635a) {
            this.f8636b.finish();
        } else {
            Spark.f11002X1.sendEmptyMessage(8);
        }
    }
}
