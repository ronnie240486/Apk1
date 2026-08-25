package com.google.android.material.circularreveal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import p025c2.C1381b;
import p059f6.C2495d;
import p059f6.InterfaceC2496e;

public class CircularRevealRelativeLayout extends RelativeLayout implements InterfaceC2496e {

    public final C1381b f6112a;

    public CircularRevealRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6112a = new C1381b(this);
    }

    @Override
    public final void mo4165c() {
        this.f6112a.getClass();
    }

    @Override
    public final void mo4166d(Canvas canvas) {
        super.draw(canvas);
    }

    @Override
    public final void draw(Canvas canvas) {
        C1381b c1381b = this.f6112a;
        if (c1381b != null) {
            c1381b.m3253c(canvas);
        } else {
            super.draw(canvas);
        }
    }

    @Override
    public final void mo4167e() {
        this.f6112a.getClass();
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return (Drawable) this.f6112a.f4202f;
    }

    @Override
    public int getCircularRevealScrimColor() {
        return ((Paint) this.f6112a.f4200d).getColor();
    }

    @Override
    public C2495d getRevealInfo() {
        return this.f6112a.m3254d();
    }

    @Override
    public final boolean mo4168h() {
        return super.isOpaque();
    }

    @Override
    public final boolean isOpaque() {
        C1381b c1381b = this.f6112a;
        return c1381b != null ? c1381b.m3255e() : super.isOpaque();
    }

    @Override
    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.f6112a.m3256f(drawable);
    }

    @Override
    public void setCircularRevealScrimColor(int i6) {
        this.f6112a.m3257g(i6);
    }

    @Override
    public void setRevealInfo(C2495d c2495d) {
        this.f6112a.m3258h(c2495d);
    }
}
