package androidx.appcompat.app;

import android.view.View;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import java.util.WeakHashMap;
import p007a7.C0069f;
import p138n0.AbstractC3113e0;
import p138n0.AbstractC3155s0;
import p156o9.AbstractC3280d;

public final class C0165v0 extends AbstractC3280d {

    public final int f448j;

    public final C0169x0 f449k;

    public C0165v0(C0169x0 c0169x0, int i6) {
        this.f448j = i6;
        this.f449k = c0169x0;
    }

    @Override
    public final void mo463a() {
        View view;
        C0169x0 c0169x0 = this.f449k;
        switch (this.f448j) {
            case 0:
                if (c0169x0.f462F && (view = c0169x0.f478x) != null) {
                    view.setTranslationY(0.0f);
                    c0169x0.f475u.setTranslationY(0.0f);
                }
                c0169x0.f475u.setVisibility(8);
                c0169x0.f475u.setTransitioning(false);
                c0169x0.f466J = null;
                C0069f c0069f = c0169x0.f458B;
                if (c0069f != null) {
                    c0069f.m222E(c0169x0.f457A);
                    c0169x0.f457A = null;
                    c0169x0.f458B = null;
                }
                ActionBarOverlayLayout actionBarOverlayLayout = c0169x0.f474t;
                if (actionBarOverlayLayout != null) {
                    WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                    AbstractC3113e0.m6130c(actionBarOverlayLayout);
                }
                break;
            default:
                c0169x0.f466J = null;
                c0169x0.f475u.requestLayout();
                break;
        }
    }
}
