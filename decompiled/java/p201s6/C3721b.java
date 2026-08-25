package p201s6;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import p065g0.InterfaceC2588h;
import p221u6.C3913m;
import p221u6.InterfaceC3924x;

public final class C3721b extends Drawable implements InterfaceC3924x, InterfaceC2588h {

    public C3720a f12474a;

    public C3721b(C3720a c3720a) {
        this.f12474a = c3720a;
    }

    @Override
    public final void draw(Canvas canvas) {
        C3720a c3720a = this.f12474a;
        if (c3720a.f12473b) {
            c3720a.f12472a.draw(canvas);
        }
    }

    @Override
    public final Drawable.ConstantState getConstantState() {
        return this.f12474a;
    }

    @Override
    public final int getOpacity() {
        this.f12474a.f12472a.getClass();
        return -3;
    }

    @Override
    public final boolean isStateful() {
        return true;
    }

    @Override
    public final Drawable mutate() {
        this.f12474a = new C3720a(this.f12474a);
        return this;
    }

    @Override
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f12474a.f12472a.setBounds(rect);
    }

    @Override
    public final boolean onStateChange(int[] iArr) {
        boolean zOnStateChange = super.onStateChange(iArr);
        if (this.f12474a.f12472a.setState(iArr)) {
            zOnStateChange = true;
        }
        boolean zM7486c = AbstractC3722c.m7486c(iArr);
        C3720a c3720a = this.f12474a;
        if (c3720a.f12473b == zM7486c) {
            return zOnStateChange;
        }
        c3720a.f12473b = zM7486c;
        return true;
    }

    @Override
    public final void setAlpha(int i6) {
        this.f12474a.f12472a.setAlpha(i6);
    }

    @Override
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f12474a.f12472a.setColorFilter(colorFilter);
    }

    @Override
    public final void setShapeAppearanceModel(C3913m c3913m) {
        this.f12474a.f12472a.setShapeAppearanceModel(c3913m);
    }

    @Override
    public final void setTint(int i6) {
        this.f12474a.f12472a.setTint(i6);
    }

    @Override
    public final void setTintList(ColorStateList colorStateList) {
        this.f12474a.f12472a.setTintList(colorStateList);
    }

    @Override
    public final void setTintMode(PorterDuff.Mode mode) {
        this.f12474a.f12472a.setTintMode(mode);
    }
}
