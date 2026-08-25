package p109k3;

import android.view.View;
import android.view.ViewTreeObserver;
import p004a3.RunnableC0038c;
import p186r3.AbstractC3610n;

public final class ViewTreeObserverOnDrawListenerC2872d implements ViewTreeObserver.OnDrawListener {

    public final View f9804a;

    public final C2873e f9805b;

    public ViewTreeObserverOnDrawListenerC2872d(C2873e c2873e, View view) {
        this.f9805b = c2873e;
        this.f9804a = view;
    }

    @Override
    public final void onDraw() {
        AbstractC3610n.m7238f().post(new RunnableC0038c(this, 19, this));
    }
}
