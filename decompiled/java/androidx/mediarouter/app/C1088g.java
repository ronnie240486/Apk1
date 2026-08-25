package androidx.mediarouter.app;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.appcompat.app.AbstractDialogC0139i0;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0415m;
import com.p2serv.android.p032ds.R;
import p143n5.AbstractC3198d;
import p173q1.C3424l0;

public class C1088g extends DialogInterfaceOnCancelListenerC0415m {

    public final boolean f3240k0 = false;

    public AbstractDialogC0139i0 f3241l0;

    public C3424l0 f3242m0;

    public C1088g() {
        this.f1903Z = true;
        Dialog dialog = this.f1908f0;
        if (dialog != null) {
            dialog.setCancelable(true);
        }
    }

    @Override
    public final Dialog mo1275R() {
        if (this.f3240k0) {
            DialogC1081c0 dialogC1081c0 = new DialogC1081c0(m1321j());
            this.f3241l0 = dialogC1081c0;
            m2747T();
            dialogC1081c0.m2741j(this.f3242m0);
        } else {
            DialogC1086f dialogC1086f = new DialogC1086f(m1321j());
            this.f3241l0 = dialogC1086f;
            m2747T();
            dialogC1086f.m2745k(this.f3242m0);
        }
        return this.f3241l0;
    }

    public final void m2747T() {
        if (this.f3242m0 == null) {
            Bundle bundle = this.f1970g;
            if (bundle != null) {
                this.f3242m0 = C3424l0.m6999b(bundle.getBundle("selector"));
            }
            if (this.f3242m0 == null) {
                this.f3242m0 = C3424l0.f11567c;
            }
        }
    }

    @Override
    public final void onConfigurationChanged(Configuration configuration) {
        this.f1949D = true;
        AbstractDialogC0139i0 abstractDialogC0139i0 = this.f3241l0;
        if (abstractDialogC0139i0 == null) {
            return;
        }
        if (!this.f3240k0) {
            DialogC1086f dialogC1086f = (DialogC1086f) abstractDialogC0139i0;
            dialogC1086f.getWindow().setLayout(AbstractC3198d.m6473v(dialogC1086f.getContext()), -2);
        } else {
            DialogC1081c0 dialogC1081c0 = (DialogC1081c0) abstractDialogC0139i0;
            Context context = dialogC1081c0.f3196g;
            dialogC1081c0.getWindow().setLayout(!context.getResources().getBoolean(R.bool.is_tablet) ? -1 : AbstractC3198d.m6473v(context), context.getResources().getBoolean(R.bool.is_tablet) ? -2 : -1);
        }
    }
}
