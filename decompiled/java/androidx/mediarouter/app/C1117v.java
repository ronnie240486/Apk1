package androidx.mediarouter.app;

import android.app.Dialog;
import android.content.res.Configuration;
import androidx.appcompat.app.AbstractDialogC0139i0;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0415m;
import p173q1.C3424l0;

public class C1117v extends DialogInterfaceOnCancelListenerC0415m {

    public final boolean f3427k0 = false;

    public AbstractDialogC0139i0 f3428l0;

    public C3424l0 f3429m0;

    public C1117v() {
        this.f1903Z = true;
        Dialog dialog = this.f1908f0;
        if (dialog != null) {
            dialog.setCancelable(true);
        }
    }

    @Override
    public final void mo1271C() {
        super.mo1271C();
        AbstractDialogC0139i0 abstractDialogC0139i0 = this.f3428l0;
        if (abstractDialogC0139i0 == null || this.f3427k0) {
            return;
        }
        ((DialogC1116u) abstractDialogC0139i0).m2793l(false);
    }

    @Override
    public final Dialog mo1275R() {
        if (this.f3427k0) {
            DialogC1109q0 dialogC1109q0 = new DialogC1109q0(m1321j());
            this.f3428l0 = dialogC1109q0;
            dialogC1109q0.m2775l(this.f3429m0);
        } else {
            this.f3428l0 = new DialogC1116u(m1321j());
        }
        return this.f3428l0;
    }

    @Override
    public final void onConfigurationChanged(Configuration configuration) {
        this.f1949D = true;
        AbstractDialogC0139i0 abstractDialogC0139i0 = this.f3428l0;
        if (abstractDialogC0139i0 != null) {
            if (this.f3427k0) {
                ((DialogC1109q0) abstractDialogC0139i0).m2776m();
            } else {
                ((DialogC1116u) abstractDialogC0139i0).m2801u();
            }
        }
    }
}
