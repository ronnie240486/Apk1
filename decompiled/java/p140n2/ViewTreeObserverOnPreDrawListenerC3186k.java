package p140n2;

import android.view.ViewTreeObserver;
import p055ea.AbstractC2460q;
import p213t9.C3827e;

public final class ViewTreeObserverOnPreDrawListenerC3186k implements ViewTreeObserver.OnPreDrawListener {

    public boolean f10683a;

    public final C3181f f10684b;

    public final ViewTreeObserver f10685c;

    public final C3827e f10686d;

    public ViewTreeObserverOnPreDrawListenerC3186k(C3181f c3181f, ViewTreeObserver viewTreeObserver, C3827e c3827e) {
        this.f10684b = c3181f;
        this.f10685c = viewTreeObserver;
        this.f10686d = c3827e;
    }

    @Override
    public final boolean onPreDraw() {
        C3181f c3181f = this.f10684b;
        C3183h c3183hM5488b = AbstractC2460q.m5488b(c3181f);
        if (c3183hM5488b != null) {
            ViewTreeObserver viewTreeObserver = this.f10685c;
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this);
            } else {
                c3181f.f10672a.getViewTreeObserver().removeOnPreDrawListener(this);
            }
            if (!this.f10683a) {
                this.f10683a = true;
                this.f10686d.resumeWith(c3183hM5488b);
            }
        }
        return true;
    }
}
