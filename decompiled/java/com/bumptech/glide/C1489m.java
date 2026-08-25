package com.bumptech.glide;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;
import p141n3.C3192f;
import p141n3.InterfaceC3189c;
import p151o3.C3250d;
import p151o3.InterfaceC3254h;
import p151o3.ViewTreeObserverOnPreDrawListenerC3249c;
import p164p3.InterfaceC3354c;
import p186r3.AbstractC3602f;

public final class C1489m implements InterfaceC3254h {

    public final C3250d f4497a;

    public final ImageView f4498b;

    public C1489m(ImageView imageView) {
        AbstractC3602f.m7225c(imageView, "Argument must not be null");
        this.f4498b = imageView;
        this.f4497a = new C3250d(imageView);
    }

    @Override
    public final void mo3557a(InterfaceC3189c interfaceC3189c) {
        this.f4498b.setTag(R.id.glide_custom_view_target_tag, interfaceC3189c);
    }

    @Override
    public final void mo3561e(C3192f c3192f) {
        this.f4497a.f10882b.remove(c3192f);
    }

    @Override
    public final void mo3562f(C3192f c3192f) {
        C3250d c3250d = this.f4497a;
        ImageView imageView = c3250d.f10881a;
        int paddingRight = imageView.getPaddingRight() + imageView.getPaddingLeft();
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int iM6557a = c3250d.m6557a(imageView.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingRight);
        ImageView imageView2 = c3250d.f10881a;
        int paddingBottom = imageView2.getPaddingBottom() + imageView2.getPaddingTop();
        ViewGroup.LayoutParams layoutParams2 = imageView2.getLayoutParams();
        int iM6557a2 = c3250d.m6557a(imageView2.getHeight(), layoutParams2 != null ? layoutParams2.height : 0, paddingBottom);
        if ((iM6557a > 0 || iM6557a == Integer.MIN_VALUE) && (iM6557a2 > 0 || iM6557a2 == Integer.MIN_VALUE)) {
            c3192f.m6418m(iM6557a, iM6557a2);
            return;
        }
        ArrayList arrayList = c3250d.f10882b;
        if (!arrayList.contains(c3192f)) {
            arrayList.add(c3192f);
        }
        if (c3250d.f10883c == null) {
            ViewTreeObserver viewTreeObserver = imageView2.getViewTreeObserver();
            ViewTreeObserverOnPreDrawListenerC3249c viewTreeObserverOnPreDrawListenerC3249c = new ViewTreeObserverOnPreDrawListenerC3249c(c3250d);
            c3250d.f10883c = viewTreeObserverOnPreDrawListenerC3249c;
            viewTreeObserver.addOnPreDrawListener(viewTreeObserverOnPreDrawListenerC3249c);
        }
    }

    @Override
    public final InterfaceC3189c getRequest() {
        Object tag = this.f4498b.getTag(R.id.glide_custom_view_target_tag);
        if (tag == null) {
            return null;
        }
        if (tag instanceof InterfaceC3189c) {
            return (InterfaceC3189c) tag;
        }
        throw new IllegalArgumentException("You must not pass non-R.id ids to setTag(id)");
    }

    @Override
    public final void mo3564h(Drawable drawable) {
        C3250d c3250d = this.f4497a;
        ViewTreeObserver viewTreeObserver = c3250d.f10881a.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(c3250d.f10883c);
        }
        c3250d.f10883c = null;
        c3250d.f10882b.clear();
    }

    public final String toString() {
        return "Target for: " + this.f4498b;
    }

    @Override
    public final void mo3559c() {
    }

    @Override
    public final void mo3565i() {
    }

    @Override
    public final void mo3566j() {
    }

    @Override
    public final void mo3558b(Drawable drawable) {
    }

    @Override
    public final void mo3563g(Drawable drawable) {
    }

    @Override
    public final void mo3560d(Object obj, InterfaceC3354c interfaceC3354c) {
    }
}
