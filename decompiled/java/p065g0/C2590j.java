package p065g0;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Method;
import p143n5.AbstractC3198d;

public final class C2590j extends Drawable implements Drawable.Callback, InterfaceC2589i, InterfaceC2588h {

    public static final PorterDuff.Mode f9028g = PorterDuff.Mode.SRC_IN;

    public static Method f9029h;

    public int f9030a;

    public PorterDuff.Mode f9031b;

    public boolean f9032c;

    public C2591k f9033d;

    public boolean f9034e;

    public Drawable f9035f;

    public static void m5605a() {
        if (f9029h == null) {
            try {
                f9029h = Drawable.class.getDeclaredMethod("isProjected", null);
            } catch (Exception e5) {
                Log.w("WrappedDrawableApi21", "Failed to retrieve Drawable#isProjected() method", e5);
            }
        }
    }

    public final boolean m5606b() {
        if (Build.VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.f9035f;
        return (drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable) || (drawable instanceof RippleDrawable);
    }

    public final C2591k m5607c() {
        C2591k c2591k = this.f9033d;
        C2591k c2591k2 = new C2591k();
        c2591k2.f9038c = null;
        c2591k2.f9039d = f9028g;
        if (c2591k != null) {
            c2591k2.f9036a = c2591k.f9036a;
            c2591k2.f9037b = c2591k.f9037b;
            c2591k2.f9038c = c2591k.f9038c;
            c2591k2.f9039d = c2591k.f9039d;
        }
        return c2591k2;
    }

    public final boolean m5608d(int[] iArr) {
        return m5613i(iArr) || this.f9035f.setState(iArr);
    }

    @Override
    public final void draw(Canvas canvas) {
        this.f9035f.draw(canvas);
    }

    public final void m5609e(int i6) {
        setTintList(ColorStateList.valueOf(i6));
    }

    public final void m5610f(ColorStateList colorStateList) {
        this.f9033d.f9038c = colorStateList;
        m5613i(this.f9035f.getState());
    }

    public final void m5611g(PorterDuff.Mode mode) {
        this.f9033d.f9039d = mode;
        m5613i(this.f9035f.getState());
    }

    @Override
    public final int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        C2591k c2591k = this.f9033d;
        return changingConfigurations | (c2591k != null ? c2591k.getChangingConfigurations() : 0) | this.f9035f.getChangingConfigurations();
    }

    @Override
    public final Drawable.ConstantState getConstantState() {
        C2591k c2591k = this.f9033d;
        if (c2591k == null || c2591k.f9037b == null) {
            return null;
        }
        c2591k.f9036a = getChangingConfigurations();
        return this.f9033d;
    }

    @Override
    public final Drawable getCurrent() {
        return this.f9035f.getCurrent();
    }

    @Override
    public final Rect getDirtyBounds() {
        return this.f9035f.getDirtyBounds();
    }

    @Override
    public final int getIntrinsicHeight() {
        return this.f9035f.getIntrinsicHeight();
    }

    @Override
    public final int getIntrinsicWidth() {
        return this.f9035f.getIntrinsicWidth();
    }

    @Override
    public final int getLayoutDirection() {
        return AbstractC3198d.m6474w(this.f9035f);
    }

    @Override
    public final int getMinimumHeight() {
        return this.f9035f.getMinimumHeight();
    }

    @Override
    public final int getMinimumWidth() {
        return this.f9035f.getMinimumWidth();
    }

    @Override
    public final int getOpacity() {
        return this.f9035f.getOpacity();
    }

    @Override
    public final void getOutline(Outline outline) {
        this.f9035f.getOutline(outline);
    }

    @Override
    public final boolean getPadding(Rect rect) {
        return this.f9035f.getPadding(rect);
    }

    @Override
    public final int[] getState() {
        return this.f9035f.getState();
    }

    @Override
    public final Region getTransparentRegion() {
        return this.f9035f.getTransparentRegion();
    }

    public final void m5612h(Drawable drawable) {
        Drawable drawable2 = this.f9035f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f9035f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            C2591k c2591k = this.f9033d;
            if (c2591k != null) {
                c2591k.f9037b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    public final boolean m5613i(int[] iArr) {
        if (!m5606b()) {
            return false;
        }
        C2591k c2591k = this.f9033d;
        ColorStateList colorStateList = c2591k.f9038c;
        PorterDuff.Mode mode = c2591k.f9039d;
        if (colorStateList == null || mode == null) {
            this.f9032c = false;
            clearColorFilter();
        } else {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!this.f9032c || colorForState != this.f9030a || mode != this.f9031b) {
                setColorFilter(colorForState, mode);
                this.f9030a = colorForState;
                this.f9031b = mode;
                this.f9032c = true;
                return true;
            }
        }
        return false;
    }

    @Override
    public final void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override
    public final boolean isAutoMirrored() {
        return this.f9035f.isAutoMirrored();
    }

    @Override
    public final boolean isProjected() {
        Method method;
        Drawable drawable = this.f9035f;
        if (drawable == null || (method = f9029h) == null) {
            return false;
        }
        try {
            return ((Boolean) method.invoke(drawable, null)).booleanValue();
        } catch (Exception e5) {
            Log.w("WrappedDrawableApi21", "Error calling Drawable#isProjected() method", e5);
            return false;
        }
    }

    @Override
    public final boolean isStateful() {
        C2591k c2591k;
        ColorStateList colorStateList = (!m5606b() || (c2591k = this.f9033d) == null) ? null : c2591k.f9038c;
        return (colorStateList != null && colorStateList.isStateful()) || this.f9035f.isStateful();
    }

    @Override
    public final void jumpToCurrentState() {
        this.f9035f.jumpToCurrentState();
    }

    @Override
    public final Drawable mutate() {
        if (!this.f9034e && super.mutate() == this) {
            this.f9033d = m5607c();
            Drawable drawable = this.f9035f;
            if (drawable != null) {
                drawable.mutate();
            }
            C2591k c2591k = this.f9033d;
            if (c2591k != null) {
                Drawable drawable2 = this.f9035f;
                c2591k.f9037b = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.f9034e = true;
        }
        return this;
    }

    @Override
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f9035f;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override
    public final boolean onLayoutDirectionChanged(int i6) {
        return AbstractC3198d.m6442Q(this.f9035f, i6);
    }

    @Override
    public final boolean onLevelChange(int i6) {
        return this.f9035f.setLevel(i6);
    }

    @Override
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        scheduleSelf(runnable, j10);
    }

    @Override
    public final void setAlpha(int i6) {
        this.f9035f.setAlpha(i6);
    }

    @Override
    public final void setAutoMirrored(boolean z7) {
        this.f9035f.setAutoMirrored(z7);
    }

    @Override
    public final void setChangingConfigurations(int i6) {
        this.f9035f.setChangingConfigurations(i6);
    }

    @Override
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f9035f.setColorFilter(colorFilter);
    }

    @Override
    public final void setDither(boolean z7) {
        this.f9035f.setDither(z7);
    }

    @Override
    public final void setFilterBitmap(boolean z7) {
        this.f9035f.setFilterBitmap(z7);
    }

    @Override
    public final void setHotspot(float f, float f3) {
        this.f9035f.setHotspot(f, f3);
    }

    @Override
    public final void setHotspotBounds(int i6, int i10, int i11, int i12) {
        this.f9035f.setHotspotBounds(i6, i10, i11, i12);
    }

    @Override
    public final boolean setState(int[] iArr) {
        if (!m5608d(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    @Override
    public final void setTint(int i6) {
        if (m5606b()) {
            m5609e(i6);
        } else {
            this.f9035f.setTint(i6);
        }
    }

    @Override
    public final void setTintList(ColorStateList colorStateList) {
        if (m5606b()) {
            m5610f(colorStateList);
        } else {
            this.f9035f.setTintList(colorStateList);
        }
    }

    @Override
    public final void setTintMode(PorterDuff.Mode mode) {
        if (m5606b()) {
            m5611g(mode);
        } else {
            this.f9035f.setTintMode(mode);
        }
    }

    @Override
    public final boolean setVisible(boolean z7, boolean z10) {
        return super.setVisible(z7, z10) || this.f9035f.setVisible(z7, z10);
    }

    @Override
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
