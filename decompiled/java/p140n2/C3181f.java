package p140n2;

import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.bumptech.glide.AbstractC1466d;
import p025c2.C1388i;
import p055ea.AbstractC2460q;
import p103j9.AbstractC2796i;
import p213t9.C3827e;

public final class C3181f implements InterfaceC3184i {

    public final ImageView f10672a;

    public final boolean f10673b;

    public C3181f(ImageView imageView, boolean z7) {
        this.f10672a = imageView;
        this.f10673b = z7;
    }

    @Override
    public final Object mo6380a(C1388i c1388i) {
        C3183h c3183hM5488b = AbstractC2460q.m5488b(this);
        if (c3183hM5488b != null) {
            return c3183hM5488b;
        }
        C3827e c3827e = new C3827e(AbstractC1466d.m3499r(c1388i), 1);
        c3827e.m7658n();
        ViewTreeObserver viewTreeObserver = this.f10672a.getViewTreeObserver();
        ViewTreeObserverOnPreDrawListenerC3186k viewTreeObserverOnPreDrawListenerC3186k = new ViewTreeObserverOnPreDrawListenerC3186k(this, viewTreeObserver, c3827e);
        viewTreeObserver.addOnPreDrawListener(viewTreeObserverOnPreDrawListenerC3186k);
        c3827e.m7660p(new C3185j(this, viewTreeObserver, viewTreeObserverOnPreDrawListenerC3186k));
        return c3827e.m7657m();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C3181f) {
            C3181f c3181f = (C3181f) obj;
            if (AbstractC2796i.m5780a(this.f10672a, c3181f.f10672a) && this.f10673b == c3181f.f10673b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.f10672a.hashCode() * 31) + (this.f10673b ? 1231 : 1237);
    }
}
