package p055ea;

import android.content.DialogInterface;
import p116ka.C2933n;
import p116ka.ViewOnKeyListenerC2937r;

public final class DialogInterfaceOnDismissListenerC2466t implements DialogInterface.OnDismissListener {

    public final int f8659a;

    public final Object f8660b;

    public DialogInterfaceOnDismissListenerC2466t(int i6, Object obj) {
        this.f8659a = i6;
        this.f8660b = obj;
    }

    @Override
    public final void onDismiss(DialogInterface dialogInterface) {
        switch (this.f8659a) {
            case 0:
                ((CountDownTimerC2464s) this.f8660b).cancel();
                break;
            case 1:
                ((ViewOnKeyListenerC2937r) this.f8660b).f10016n0 = false;
                break;
            default:
                ((C2933n) this.f8660b).f9989b.f10016n0 = false;
                break;
        }
    }
}
