package p140n2;

import android.view.ViewTreeObserver;
import p091i9.InterfaceC2724l;
import p103j9.AbstractC2797j;
import p243w8.C4070l;

public final class C3185j extends AbstractC2797j implements InterfaceC2724l {

    public final C3181f f10680a;

    public final ViewTreeObserver f10681b;

    public final ViewTreeObserverOnPreDrawListenerC3186k f10682c;

    public C3185j(C3181f c3181f, ViewTreeObserver viewTreeObserver, ViewTreeObserverOnPreDrawListenerC3186k viewTreeObserverOnPreDrawListenerC3186k) {
        super(1);
        this.f10680a = c3181f;
        this.f10681b = viewTreeObserver;
        this.f10682c = viewTreeObserverOnPreDrawListenerC3186k;
    }

    @Override
    public final Object invoke(Object obj) {
        ViewTreeObserverOnPreDrawListenerC3186k viewTreeObserverOnPreDrawListenerC3186k = this.f10682c;
        ViewTreeObserver viewTreeObserver = this.f10681b;
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(viewTreeObserverOnPreDrawListenerC3186k);
        } else {
            this.f10680a.f10672a.getViewTreeObserver().removeOnPreDrawListener(viewTreeObserverOnPreDrawListenerC3186k);
        }
        return C4070l.f13734a;
    }
}
