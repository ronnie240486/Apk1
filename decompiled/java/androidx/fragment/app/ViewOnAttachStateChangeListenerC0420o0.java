package androidx.fragment.app;

import android.view.View;
import java.util.WeakHashMap;
import p138n0.AbstractC3113e0;
import p138n0.AbstractC3155s0;

public final class ViewOnAttachStateChangeListenerC0420o0 implements View.OnAttachStateChangeListener {

    public final View f1919a;

    public ViewOnAttachStateChangeListenerC0420o0(View view) {
        this.f1919a = view;
    }

    @Override
    public final void onViewAttachedToWindow(View view) {
        View view2 = this.f1919a;
        view2.removeOnAttachStateChangeListener(this);
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        AbstractC3113e0.m6130c(view2);
    }

    @Override
    public final void onViewDetachedFromWindow(View view) {
    }
}
