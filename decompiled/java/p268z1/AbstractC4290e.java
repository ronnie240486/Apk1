package p268z1;

import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import p065g0.AbstractC2581a;
import p065g0.InterfaceC2588h;

public abstract class AbstractC4290e extends Drawable implements InterfaceC2588h {

    public Drawable f14529a;

    @Override
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f14529a;
        if (drawable != null) {
            AbstractC2581a.m5579a(drawable, theme);
        }
    }

    @Override
    public final void clearColorFilter() {
        Drawable drawable = this.f14529a;
        if (drawable != null) {
            drawable.clearColorFilter();
        } else {
            super.clearColorFilter();
        }
    }

    @Override
    public final Drawable getCurrent() {
        Drawable drawable = this.f14529a;
        return drawable != null ? drawable.getCurrent() : super.getCurrent();
    }

    @Override
    public final int getMinimumHeight() {
        Drawable drawable = this.f14529a;
        return drawable != null ? drawable.getMinimumHeight() : super.getMinimumHeight();
    }

    @Override
    public final int getMinimumWidth() {
        Drawable drawable = this.f14529a;
        return drawable != null ? drawable.getMinimumWidth() : super.getMinimumWidth();
    }

    @Override
    public final boolean getPadding(Rect rect) {
        Drawable drawable = this.f14529a;
        return drawable != null ? drawable.getPadding(rect) : super.getPadding(rect);
    }

    @Override
    public final int[] getState() {
        Drawable drawable = this.f14529a;
        return drawable != null ? drawable.getState() : super.getState();
    }

    @Override
    public final Region getTransparentRegion() {
        Drawable drawable = this.f14529a;
        return drawable != null ? drawable.getTransparentRegion() : super.getTransparentRegion();
    }

    @Override
    public final void jumpToCurrentState() {
        Drawable drawable = this.f14529a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override
    public boolean onLevelChange(int i6) {
        Drawable drawable = this.f14529a;
        return drawable != null ? drawable.setLevel(i6) : super.onLevelChange(i6);
    }

    @Override
    public final void setChangingConfigurations(int i6) {
        Drawable drawable = this.f14529a;
        if (drawable != null) {
            drawable.setChangingConfigurations(i6);
        } else {
            super.setChangingConfigurations(i6);
        }
    }

    @Override
    public final void setColorFilter(int i6, PorterDuff.Mode mode) {
        Drawable drawable = this.f14529a;
        if (drawable != null) {
            drawable.setColorFilter(i6, mode);
        } else {
            super.setColorFilter(i6, mode);
        }
    }

    @Override
    public final void setFilterBitmap(boolean z7) {
        Drawable drawable = this.f14529a;
        if (drawable != null) {
            drawable.setFilterBitmap(z7);
        }
    }

    @Override
    public final void setHotspot(float f, float f3) {
        Drawable drawable = this.f14529a;
        if (drawable != null) {
            AbstractC2581a.m5583e(drawable, f, f3);
        }
    }

    @Override
    public final void setHotspotBounds(int i6, int i10, int i11, int i12) {
        Drawable drawable = this.f14529a;
        if (drawable != null) {
            AbstractC2581a.m5584f(drawable, i6, i10, i11, i12);
        }
    }

    @Override
    public final boolean setState(int[] iArr) {
        Drawable drawable = this.f14529a;
        return drawable != null ? drawable.setState(iArr) : super.setState(iArr);
    }
}
