package p150o2;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.lifecycle.InterfaceC0519e;
import androidx.lifecycle.InterfaceC0555w;
import p103j9.AbstractC2796i;

public final class C3246a implements InterfaceC0519e {

    public boolean f10869a;

    public final ImageView f10870b;

    public C3246a(ImageView imageView) {
        this.f10870b = imageView;
    }

    @Override
    public final void mo1491b(InterfaceC0555w interfaceC0555w) {
        AbstractC2796i.m5785f(interfaceC0555w, "owner");
    }

    @Override
    public final void mo1492c(InterfaceC0555w interfaceC0555w) {
        AbstractC2796i.m5785f(interfaceC0555w, "owner");
    }

    public final void m6554d() {
        Object drawable = this.f10870b.getDrawable();
        Animatable animatable = drawable instanceof Animatable ? (Animatable) drawable : null;
        if (animatable == null) {
            return;
        }
        if (this.f10869a) {
            animatable.start();
        } else {
            animatable.stop();
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C3246a) {
            if (AbstractC2796i.m5780a(this.f10870b, ((C3246a) obj).f10870b)) {
                return true;
            }
        }
        return false;
    }

    public final void m6555g(Drawable drawable) {
        ImageView imageView = this.f10870b;
        Object drawable2 = imageView.getDrawable();
        Animatable animatable = drawable2 instanceof Animatable ? (Animatable) drawable2 : null;
        if (animatable != null) {
            animatable.stop();
        }
        imageView.setImageDrawable(drawable);
        m6554d();
    }

    public final int hashCode() {
        return this.f10870b.hashCode();
    }

    @Override
    public final void onStart(InterfaceC0555w interfaceC0555w) {
        this.f10869a = true;
        m6554d();
    }

    @Override
    public final void onStop(InterfaceC0555w interfaceC0555w) {
        this.f10869a = false;
        m6554d();
    }

    @Override
    public final void mo1493e(InterfaceC0555w interfaceC0555w) {
    }

    @Override
    public final void onDestroy(InterfaceC0555w interfaceC0555w) {
    }
}
