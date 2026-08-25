package p130m2;

import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.AbstractC0541p;
import androidx.lifecycle.InterfaceC0553v;
import p150o2.C3246a;
import p213t9.AbstractC3865u;
import p213t9.C3871x;

public final class ViewOnAttachStateChangeListenerC3073u implements View.OnAttachStateChangeListener {

    public final ImageView f10529a;

    public C3063k f10530b;

    public C3871x f10531c;

    public C3071s f10532d;

    public boolean f10533e;

    public ViewOnAttachStateChangeListenerC3073u(ImageView imageView) {
        this.f10529a = imageView;
    }

    @Override
    public final void onViewAttachedToWindow(View view) {
        C3071s c3071s = this.f10532d;
        if (c3071s == null) {
            return;
        }
        this.f10533e = true;
        c3071s.f10523a.m3266b(c3071s.f10524b);
    }

    @Override
    public final void onViewDetachedFromWindow(View view) {
        C3071s c3071s = this.f10532d;
        if (c3071s != null) {
            AbstractC3865u.m7688c(c3071s.f10527e);
            C3246a c3246a = c3071s.f10525c;
            boolean z7 = c3246a instanceof InterfaceC0553v;
            AbstractC0541p abstractC0541p = c3071s.f10526d;
            if (z7) {
                abstractC0541p.mo1510c(c3246a);
            }
            abstractC0541p.mo1510c(c3071s);
        }
    }
}
