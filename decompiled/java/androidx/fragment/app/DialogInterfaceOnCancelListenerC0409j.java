package androidx.fragment.app;

import android.app.Dialog;
import android.content.DialogInterface;

public final class DialogInterfaceOnCancelListenerC0409j implements DialogInterface.OnCancelListener {

    public final DialogInterfaceOnCancelListenerC0415m f1853a;

    public DialogInterfaceOnCancelListenerC0409j(DialogInterfaceOnCancelListenerC0415m dialogInterfaceOnCancelListenerC0415m) {
        this.f1853a = dialogInterfaceOnCancelListenerC0415m;
    }

    @Override
    public final void onCancel(DialogInterface dialogInterface) {
        DialogInterfaceOnCancelListenerC0415m dialogInterfaceOnCancelListenerC0415m = this.f1853a;
        Dialog dialog = dialogInterfaceOnCancelListenerC0415m.f1908f0;
        if (dialog != null) {
            dialogInterfaceOnCancelListenerC0415m.onCancel(dialog);
        }
    }
}
