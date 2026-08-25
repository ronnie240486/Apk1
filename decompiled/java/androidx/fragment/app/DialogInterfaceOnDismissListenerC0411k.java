package androidx.fragment.app;

import android.app.Dialog;
import android.content.DialogInterface;

public final class DialogInterfaceOnDismissListenerC0411k implements DialogInterface.OnDismissListener {

    public final DialogInterfaceOnCancelListenerC0415m f1887a;

    public DialogInterfaceOnDismissListenerC0411k(DialogInterfaceOnCancelListenerC0415m dialogInterfaceOnCancelListenerC0415m) {
        this.f1887a = dialogInterfaceOnCancelListenerC0415m;
    }

    @Override
    public final void onDismiss(DialogInterface dialogInterface) {
        DialogInterfaceOnCancelListenerC0415m dialogInterfaceOnCancelListenerC0415m = this.f1887a;
        Dialog dialog = dialogInterfaceOnCancelListenerC0415m.f1908f0;
        if (dialog != null) {
            dialogInterfaceOnCancelListenerC0415m.onDismiss(dialog);
        }
    }
}
