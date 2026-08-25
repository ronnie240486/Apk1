package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;

public final class ViewOnAttachStateChangeListenerC0437x implements View.OnAttachStateChangeListener {

    public final C0422p0 f2020a;

    public final LayoutInflaterFactory2C0438y f2021b;

    public ViewOnAttachStateChangeListenerC0437x(LayoutInflaterFactory2C0438y layoutInflaterFactory2C0438y, C0422p0 c0422p0) {
        this.f2021b = layoutInflaterFactory2C0438y;
        this.f2020a = c0422p0;
    }

    @Override
    public final void onViewAttachedToWindow(View view) {
        C0422p0 c0422p0 = this.f2020a;
        c0422p0.m1298k();
        C0407i.m1206f((ViewGroup) c0422p0.f1933c.f1951F.getParent(), this.f2021b.f2022a.m1220D()).m1211e();
    }

    @Override
    public final void onViewDetachedFromWindow(View view) {
    }
}
