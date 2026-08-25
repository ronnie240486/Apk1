package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import p065g0.AbstractC2581a;

public final class C0257q1 extends Drawable implements Drawable.Callback {

    public Drawable f1036a;

    public boolean f1037b;

    public final void m759a(Canvas canvas) {
        this.f1036a.draw(canvas);
    }

    public final void m760b(float f, float f3) {
        AbstractC2581a.m5583e(this.f1036a, f, f3);
    }

    public final void m761c(int i6, int i10, int i11, int i12) {
        AbstractC2581a.m5584f(this.f1036a, i6, i10, i11, i12);
    }

    public final boolean m762d(boolean z7, boolean z10) {
        return super.setVisible(z7, z10) || this.f1036a.setVisible(z7, z10);
    }

    @Override
    public final void draw(Canvas canvas) {
        if (this.f1037b) {
            m759a(canvas);
        }
    }

    @Override
    public final int getChangingConfigurations() {
        return this.f1036a.getChangingConfigurations();
    }

    @Override
    public final Drawable getCurrent() {
        return this.f1036a.getCurrent();
    }

    @Override
    public final int getIntrinsicHeight() {
        return this.f1036a.getIntrinsicHeight();
    }

    @Override
    public final int getIntrinsicWidth() {
        return this.f1036a.getIntrinsicWidth();
    }

    @Override
    public final int getMinimumHeight() {
        return this.f1036a.getMinimumHeight();
    }

    @Override
    public final int getMinimumWidth() {
        return this.f1036a.getMinimumWidth();
    }

    @Override
    public final int getOpacity() {
        return this.f1036a.getOpacity();
    }

    @Override
    public final boolean getPadding(Rect rect) {
        return this.f1036a.getPadding(rect);
    }

    @Override
    public final int[] getState() {
        return this.f1036a.getState();
    }

    @Override
    public final Region getTransparentRegion() {
        return this.f1036a.getTransparentRegion();
    }

    @Override
    public final void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override
    public final boolean isAutoMirrored() {
        return this.f1036a.isAutoMirrored();
    }

    @Override
    public final boolean isStateful() {
        return this.f1036a.isStateful();
    }

    @Override
    public final void jumpToCurrentState() {
        this.f1036a.jumpToCurrentState();
    }

    @Override
    public final void onBoundsChange(Rect rect) {
        this.f1036a.setBounds(rect);
    }

    @Override
    public final boolean onLevelChange(int i6) {
        return this.f1036a.setLevel(i6);
    }

    @Override
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        scheduleSelf(runnable, j10);
    }

    @Override
    public final void setAlpha(int i6) {
        this.f1036a.setAlpha(i6);
    }

    @Override
    public final void setAutoMirrored(boolean z7) {
        this.f1036a.setAutoMirrored(z7);
    }

    @Override
    public final void setChangingConfigurations(int i6) {
        this.f1036a.setChangingConfigurations(i6);
    }

    @Override
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f1036a.setColorFilter(colorFilter);
    }

    @Override
    public final void setDither(boolean z7) {
        this.f1036a.setDither(z7);
    }

    @Override
    public final void setFilterBitmap(boolean z7) {
        this.f1036a.setFilterBitmap(z7);
    }

    @Override
    public final void setHotspot(float f, float f3) {
        if (this.f1037b) {
            m760b(f, f3);
        }
    }

    @Override
    public final void setHotspotBounds(int i6, int i10, int i11, int i12) {
        if (this.f1037b) {
            m761c(i6, i10, i11, i12);
        }
    }

    @Override
    public final boolean setState(int[] iArr) {
        if (this.f1037b) {
            return this.f1036a.setState(iArr);
        }
        return false;
    }

    @Override
    public final void setTint(int i6) {
        AbstractC2581a.m5585g(this.f1036a, i6);
    }

    @Override
    public final void setTintList(ColorStateList colorStateList) {
        AbstractC2581a.m5586h(this.f1036a, colorStateList);
    }

    @Override
    public final void setTintMode(PorterDuff.Mode mode) {
        AbstractC2581a.m5587i(this.f1036a, mode);
    }

    @Override
    public final boolean setVisible(boolean z7, boolean z10) {
        if (this.f1037b) {
            return m762d(z7, z10);
        }
        return false;
    }

    @Override
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
