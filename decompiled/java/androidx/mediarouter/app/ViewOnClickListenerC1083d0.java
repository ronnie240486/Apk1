package androidx.mediarouter.app;

import android.view.View;
import p173q1.C3451u0;

public final class ViewOnClickListenerC1083d0 implements View.OnClickListener {

    public final int f3211a;

    public final DialogC1109q0 f3212b;

    public ViewOnClickListenerC1083d0(DialogC1109q0 dialogC1109q0, int i6) {
        this.f3211a = i6;
        this.f3212b = dialogC1109q0;
    }

    @Override
    public final void onClick(View view) {
        switch (this.f3211a) {
            case 0:
                this.f3212b.dismiss();
                break;
            default:
                DialogC1109q0 dialogC1109q0 = this.f3212b;
                if (dialogC1109q0.f3329h.m7024g()) {
                    dialogC1109q0.f3326e.getClass();
                    C3451u0.m7073i(2);
                }
                dialogC1109q0.dismiss();
                break;
        }
    }
}
