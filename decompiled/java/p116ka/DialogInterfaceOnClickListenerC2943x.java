package p116ka;

import android.app.AlertDialog;
import android.content.DialogInterface;
import androidx.fragment.app.AbstractComponentCallbacksC0427s;
import org.bitspark.android.Spark;
import p187r4.C3617g;

public final class DialogInterfaceOnClickListenerC2943x implements DialogInterface.OnClickListener {

    public final int f10029a;

    public final AbstractComponentCallbacksC0427s f10030b;

    public DialogInterfaceOnClickListenerC2943x(int i6, AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s) {
        this.f10029a = i6;
        this.f10030b = abstractComponentCallbacksC0427s;
    }

    @Override
    public final void onClick(DialogInterface dialogInterface, int i6) {
        switch (this.f10029a) {
            case 0:
                dialogInterface.dismiss();
                ViewOnKeyListenerC2944y viewOnKeyListenerC2944y = (ViewOnKeyListenerC2944y) this.f10030b;
                if (viewOnKeyListenerC2944y.m1319h() != null) {
                    ((Spark) viewOnKeyListenerC2944y.m1319h()).m6701Q0();
                }
                break;
            default:
                C3617g c3617g = (C3617g) this.f10030b;
                AlertDialog alertDialog = c3617g.f12162o0;
                if (alertDialog != null) {
                    alertDialog.cancel();
                    c3617g.f12162o0 = null;
                }
                break;
        }
    }
}
