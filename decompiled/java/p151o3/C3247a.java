package p151o3;

import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;
import p141n3.C3192f;
import p141n3.InterfaceC3189c;
import p164p3.InterfaceC3354c;
import p186r3.AbstractC3602f;

public final class C3247a implements InterfaceC3254h {

    public final ImageView f10871a;

    public final C3255i f10872b;

    public Animatable f10873c;

    public final int f10874d;

    public C3247a(ImageView imageView, int i6) {
        this.f10874d = i6;
        AbstractC3602f.m7225c(imageView, "Argument must not be null");
        this.f10871a = imageView;
        this.f10872b = new C3255i(imageView);
    }

    @Override
    public final void mo3557a(InterfaceC3189c interfaceC3189c) {
        this.f10871a.setTag(R.id.glide_custom_view_target_tag, interfaceC3189c);
    }

    @Override
    public final void mo3558b(Drawable drawable) {
        m6556k(null);
        this.f10873c = null;
        this.f10871a.setImageDrawable(drawable);
    }

    @Override
    public final void mo3559c() {
        Animatable animatable = this.f10873c;
        if (animatable != null) {
            animatable.stop();
        }
    }

    @Override
    public final void mo3560d(Object obj, InterfaceC3354c interfaceC3354c) {
        if (interfaceC3354c != null && interfaceC3354c.mo6824a(obj, this)) {
            if (!(obj instanceof Animatable)) {
                this.f10873c = null;
                return;
            }
            Animatable animatable = (Animatable) obj;
            this.f10873c = animatable;
            animatable.start();
            return;
        }
        m6556k(obj);
        if (!(obj instanceof Animatable)) {
            this.f10873c = null;
            return;
        }
        Animatable animatable2 = (Animatable) obj;
        this.f10873c = animatable2;
        animatable2.start();
    }

    @Override
    public final void mo3561e(C3192f c3192f) {
        this.f10872b.f10889b.remove(c3192f);
    }

    @Override
    public final void mo3562f(C3192f c3192f) {
        C3255i c3255i = this.f10872b;
        ImageView imageView = c3255i.f10888a;
        int paddingRight = imageView.getPaddingRight() + imageView.getPaddingLeft();
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int iM6558a = c3255i.m6558a(imageView.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingRight);
        ImageView imageView2 = c3255i.f10888a;
        int paddingBottom = imageView2.getPaddingBottom() + imageView2.getPaddingTop();
        ViewGroup.LayoutParams layoutParams2 = imageView2.getLayoutParams();
        int iM6558a2 = c3255i.m6558a(imageView2.getHeight(), layoutParams2 != null ? layoutParams2.height : 0, paddingBottom);
        if ((iM6558a > 0 || iM6558a == Integer.MIN_VALUE) && (iM6558a2 > 0 || iM6558a2 == Integer.MIN_VALUE)) {
            c3192f.m6418m(iM6558a, iM6558a2);
            return;
        }
        ArrayList arrayList = c3255i.f10889b;
        if (!arrayList.contains(c3192f)) {
            arrayList.add(c3192f);
        }
        if (c3255i.f10890c == null) {
            ViewTreeObserver viewTreeObserver = imageView2.getViewTreeObserver();
            ViewTreeObserverOnPreDrawListenerC3249c viewTreeObserverOnPreDrawListenerC3249c = new ViewTreeObserverOnPreDrawListenerC3249c(c3255i);
            c3255i.f10890c = viewTreeObserverOnPreDrawListenerC3249c;
            viewTreeObserver.addOnPreDrawListener(viewTreeObserverOnPreDrawListenerC3249c);
        }
    }

    @Override
    public final void mo3563g(Drawable drawable) {
        m6556k(null);
        this.f10873c = null;
        this.f10871a.setImageDrawable(drawable);
    }

    @Override
    public final InterfaceC3189c getRequest() {
        Object tag = this.f10871a.getTag(R.id.glide_custom_view_target_tag);
        if (tag == null) {
            return null;
        }
        if (tag instanceof InterfaceC3189c) {
            return (InterfaceC3189c) tag;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    @Override
    public final void mo3564h(Drawable drawable) {
        C3255i c3255i = this.f10872b;
        ViewTreeObserver viewTreeObserver = c3255i.f10888a.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(c3255i.f10890c);
        }
        c3255i.f10890c = null;
        c3255i.f10889b.clear();
        Animatable animatable = this.f10873c;
        if (animatable != null) {
            animatable.stop();
        }
        m6556k(null);
        this.f10873c = null;
        this.f10871a.setImageDrawable(drawable);
    }

    @Override
    public final void mo3565i() {
        Animatable animatable = this.f10873c;
        if (animatable != null) {
            animatable.start();
        }
    }

    public final void m6556k(Object obj) {
        switch (this.f10874d) {
            case 0:
                this.f10871a.setImageBitmap((Bitmap) obj);
                break;
            default:
                this.f10871a.setImageDrawable((Drawable) obj);
                break;
        }
    }

    public final String toString() {
        return "Target for: " + this.f10871a;
    }

    @Override
    public final void mo3566j() {
    }
}
