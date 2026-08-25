package com.google.android.material.circularreveal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.GridLayout;
import p025c2.C1381b;
import p059f6.C2495d;
import p059f6.InterfaceC2496e;

public class CircularRevealGridLayout extends GridLayout implements InterfaceC2496e {

    public final C1381b f6110a;

    public CircularRevealGridLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6110a = new C1381b(this);
    }

    @Override
    public final void mo4165c() {
        this.f6110a.getClass();
    }

    @Override
    public final void mo4166d(Canvas canvas) {
        super.draw(canvas);
    }

    @Override
    public final void draw(Canvas canvas) {
        C1381b c1381b = this.f6110a;
        if (c1381b != null) {
            c1381b.m3253c(canvas);
        } else {
            super.draw(canvas);
        }
    }

    @Override
    public final void mo4167e() {
        this.f6110a.getClass();
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return (Drawable) this.f6110a.f4202f;
    }

    @Override
    public int getCircularRevealScrimColor() {
        return ((Paint) this.f6110a.f4200d).getColor();
    }

    @Override
    public C2495d getRevealInfo() {
        return this.f6110a.m3254d();
    }

    @Override
    public final boolean mo4168h() {
        return super.isOpaque();
    }

    @Override
    public final boolean isOpaque() {
        C1381b c1381b = this.f6110a;
        return c1381b != null ? c1381b.m3255e() : super.isOpaque();
    }

    @Override
    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.f6110a.m3256f(drawable);
    }

    @Override
    public void setCircularRevealScrimColor(int i6) {
        this.f6110a.m3257g(i6);
    }

    @Override
    public void setRevealInfo(C2495d c2495d) {
        this.f6110a.m3258h(c2495d);
    }
}
