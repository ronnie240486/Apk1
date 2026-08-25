package p055ea;

import android.content.DialogInterface;
import org.bitspark.android.Spark;

public final class DialogInterfaceOnClickListenerC2462r implements DialogInterface.OnClickListener {

    public final int f8653a;

    public DialogInterfaceOnClickListenerC2462r(int i6) {
        this.f8653a = i6;
    }

    @Override
    public final void onClick(DialogInterface dialogInterface, int i6) {
        switch (this.f8653a) {
            case 0:
                Spark.f11002X1.sendEmptyMessage(9999);
                dialogInterface.dismiss();
                break;
            case 1:
                dialogInterface.dismiss();
                break;
            case 2:
                dialogInterface.dismiss();
                break;
            case 3:
                dialogInterface.dismiss();
                break;
            case 4:
                dialogInterface.dismiss();
                break;
            case 5:
                dialogInterface.dismiss();
                break;
            case 6:
                dialogInterface.dismiss();
                break;
            default:
                Spark.f11002X1.sendEmptyMessage(9999);
                dialogInterface.dismiss();
                break;
        }
    }
}
