package androidx.fragment.app;

import android.app.Dialog;
import android.view.View;
import p156o9.AbstractC3281e;

public final class C0413l extends AbstractC3281e {

    public final C0417n f1888f;

    public final DialogInterfaceOnCancelListenerC0415m f1889g;

    public C0413l(DialogInterfaceOnCancelListenerC0415m dialogInterfaceOnCancelListenerC0415m, C0417n c0417n) {
        this.f1889g = dialogInterfaceOnCancelListenerC0415m;
        this.f1888f = c0417n;
    }

    @Override
    public final View mo1265B(int i6) {
        C0417n c0417n = this.f1888f;
        if (c0417n.mo1266C()) {
            return c0417n.mo1265B(i6);
        }
        Dialog dialog = this.f1889g.f1908f0;
        if (dialog != null) {
            return dialog.findViewById(i6);
        }
        return null;
    }

    @Override
    public final boolean mo1266C() {
        return this.f1888f.mo1266C() || this.f1889g.f1912j0;
    }
}
