package p064g;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import com.alibaba.fastjson.asm.Opcodes;
import p000a.RunnableC0005f;
import p065g0.AbstractC2581a;
import p143n5.AbstractC3198d;

public abstract class AbstractC2580g extends Drawable implements Drawable.Callback {

    public static final int f9003m = 0;

    public C2575b f9004a;

    public Rect f9005b;

    public Drawable f9006c;

    public Drawable f9007d;

    public int f9008e;

    public boolean f9009f;

    public int f9010g;

    public boolean f9011h;

    public RunnableC0005f f9012i;

    public long f9013j;

    public long f9014k;

    public C2579f f9015l;

    public final void m5576a(boolean z7) {
        boolean z10;
        Drawable drawable;
        long j10;
        boolean z11 = true;
        this.f9009f = true;
        long jUptimeMillis = SystemClock.uptimeMillis();
        Drawable drawable2 = this.f9006c;
        if (drawable2 != null) {
            long j11 = this.f9013j;
            if (j11 != 0) {
                if (j11 <= jUptimeMillis) {
                    drawable2.setAlpha(this.f9008e);
                    this.f9013j = 0L;
                } else {
                    drawable2.setAlpha(((255 - (((int) ((j11 - jUptimeMillis) * 255)) / this.f9004a.f8987y)) * this.f9008e) / 255);
                    z10 = true;
                }
            }
            drawable = this.f9007d;
            if (drawable != null) {
                j10 = this.f9014k;
                if (j10 == 0) {
                    if (j10 <= jUptimeMillis) {
                        drawable.setVisible(false, false);
                        this.f9007d = null;
                        this.f9014k = 0L;
                    } else {
                        drawable.setAlpha(((((int) ((j10 - jUptimeMillis) * 255)) / this.f9004a.f8988z) * this.f9008e) / 255);
                    }
                }
                if (z7 || !z11) {
                }
                scheduleSelf(this.f9012i, jUptimeMillis + 16);
                return;
            }
            this.f9014k = 0L;
            z11 = z10;
            if (z7) {
            }
        }
        this.f9013j = 0L;
        z10 = false;
        drawable = this.f9007d;
        if (drawable != null) {
            j10 = this.f9014k;
            if (j10 == 0) {
                if (j10 <= jUptimeMillis) {
                    drawable.setVisible(false, false);
                    this.f9007d = null;
                    this.f9014k = 0L;
                } else {
                    drawable.setAlpha(((((int) ((j10 - jUptimeMillis) * 255)) / this.f9004a.f8988z) * this.f9008e) / 255);
                }
            }
            if (z7) {
            }
        }
        this.f9014k = 0L;
        z11 = z10;
        if (z7) {
        }
    }

    @Override
    public void applyTheme(Resources.Theme theme) {
        C2575b c2575b = this.f9004a;
        if (theme == null) {
            c2575b.getClass();
            return;
        }
        c2575b.m5566c();
        int i6 = c2575b.f8970h;
        Drawable[] drawableArr = c2575b.f8969g;
        for (int i10 = 0; i10 < i6; i10++) {
            Drawable drawable = drawableArr[i10];
            if (drawable != null && AbstractC2581a.m5580b(drawable)) {
                AbstractC2581a.m5579a(drawableArr[i10], theme);
                c2575b.f8967e |= drawableArr[i10].getChangingConfigurations();
            }
        }
        Resources resources = theme.getResources();
        if (resources != null) {
            c2575b.f8964b = resources;
            int i11 = resources.getDisplayMetrics().densityDpi;
            if (i11 == 0) {
                i11 = Opcodes.IF_ICMPNE;
            }
            int i12 = c2575b.f8965c;
            c2575b.f8965c = i11;
            if (i12 != i11) {
                c2575b.f8975m = false;
                c2575b.f8972j = false;
            }
        }
    }

    public final void m5577b(Drawable drawable) {
        if (this.f9015l == null) {
            this.f9015l = new C2579f();
        }
        C2579f c2579f = this.f9015l;
        c2579f.f9002b = drawable.getCallback();
        drawable.setCallback(c2579f);
        try {
            if (this.f9004a.f8987y <= 0 && this.f9009f) {
                drawable.setAlpha(this.f9008e);
            }
            C2575b c2575b = this.f9004a;
            if (c2575b.f8955C) {
                drawable.setColorFilter(c2575b.f8954B);
            } else {
                if (c2575b.f8958F) {
                    AbstractC2581a.m5586h(drawable, c2575b.f8956D);
                }
                C2575b c2575b2 = this.f9004a;
                if (c2575b2.f8959G) {
                    AbstractC2581a.m5587i(drawable, c2575b2.f8957E);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f9004a.f8985w);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (Build.VERSION.SDK_INT >= 23) {
                AbstractC3198d.m6442Q(drawable, AbstractC3198d.m6474w(this));
            }
            drawable.setAutoMirrored(this.f9004a.f8953A);
            Rect rect = this.f9005b;
            if (rect != null) {
                AbstractC2581a.m5584f(drawable, rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            C2579f c2579f2 = this.f9015l;
            Drawable.Callback callback = (Drawable.Callback) c2579f2.f9002b;
            c2579f2.f9002b = null;
            drawable.setCallback(callback);
        }
    }

    public final boolean m5578c(int i6) {
        if (i6 == this.f9010g) {
            return false;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (this.f9004a.f8988z > 0) {
            Drawable drawable = this.f9007d;
            if (drawable != null) {
                drawable.setVisible(false, false);
            }
            Drawable drawable2 = this.f9006c;
            if (drawable2 != null) {
                this.f9007d = drawable2;
                this.f9014k = ((long) this.f9004a.f8988z) + jUptimeMillis;
            } else {
                this.f9007d = null;
                this.f9014k = 0L;
            }
        } else {
            Drawable drawable3 = this.f9006c;
            if (drawable3 != null) {
                drawable3.setVisible(false, false);
            }
        }
        if (i6 >= 0) {
            C2575b c2575b = this.f9004a;
            if (i6 < c2575b.f8970h) {
                Drawable drawableM5567d = c2575b.m5567d(i6);
                this.f9006c = drawableM5567d;
                this.f9010g = i6;
                if (drawableM5567d != null) {
                    int i10 = this.f9004a.f8987y;
                    if (i10 > 0) {
                        this.f9013j = jUptimeMillis + ((long) i10);
                    }
                    m5577b(drawableM5567d);
                }
            } else {
                this.f9006c = null;
                this.f9010g = -1;
            }
        } else {
            this.f9006c = null;
            this.f9010g = -1;
        }
        if (this.f9013j != 0 || this.f9014k != 0) {
            RunnableC0005f runnableC0005f = this.f9012i;
            if (runnableC0005f == null) {
                this.f9012i = new RunnableC0005f(17, (C2578e) this);
            } else {
                unscheduleSelf(runnableC0005f);
            }
            m5576a(true);
        }
        invalidateSelf();
        return true;
    }

    @Override
    public final boolean canApplyTheme() {
        return this.f9004a.canApplyTheme();
    }

    public abstract void mo5573d(C2575b c2575b);

    @Override
    public final void draw(Canvas canvas) {
        Drawable drawable = this.f9006c;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f9007d;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    @Override
    public final int getAlpha() {
        return this.f9008e;
    }

    @Override
    public final int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f9004a.getChangingConfigurations();
    }

    @Override
    public final Drawable.ConstantState getConstantState() {
        boolean z7;
        C2575b c2575b = this.f9004a;
        if (!c2575b.f8983u) {
            c2575b.m5566c();
            c2575b.f8983u = true;
            int i6 = c2575b.f8970h;
            Drawable[] drawableArr = c2575b.f8969g;
            int i10 = 0;
            while (true) {
                if (i10 >= i6) {
                    c2575b.f8984v = true;
                    z7 = true;
                    break;
                }
                if (drawableArr[i10].getConstantState() == null) {
                    c2575b.f8984v = false;
                    z7 = false;
                    break;
                }
                i10++;
            }
        } else {
            z7 = c2575b.f8984v;
        }
        if (!z7) {
            return null;
        }
        this.f9004a.f8966d = getChangingConfigurations();
        return this.f9004a;
    }

    @Override
    public final Drawable getCurrent() {
        return this.f9006c;
    }

    @Override
    public final void getHotspotBounds(Rect rect) {
        Rect rect2 = this.f9005b;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override
    public final int getIntrinsicHeight() {
        C2575b c2575b = this.f9004a;
        if (c2575b.f8974l) {
            if (!c2575b.f8975m) {
                c2575b.m5565b();
            }
            return c2575b.f8977o;
        }
        Drawable drawable = this.f9006c;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override
    public final int getIntrinsicWidth() {
        C2575b c2575b = this.f9004a;
        if (c2575b.f8974l) {
            if (!c2575b.f8975m) {
                c2575b.m5565b();
            }
            return c2575b.f8976n;
        }
        Drawable drawable = this.f9006c;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override
    public final int getMinimumHeight() {
        C2575b c2575b = this.f9004a;
        if (c2575b.f8974l) {
            if (!c2575b.f8975m) {
                c2575b.m5565b();
            }
            return c2575b.f8979q;
        }
        Drawable drawable = this.f9006c;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    @Override
    public final int getMinimumWidth() {
        C2575b c2575b = this.f9004a;
        if (c2575b.f8974l) {
            if (!c2575b.f8975m) {
                c2575b.m5565b();
            }
            return c2575b.f8978p;
        }
        Drawable drawable = this.f9006c;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    @Override
    public final int getOpacity() {
        Drawable drawable = this.f9006c;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        C2575b c2575b = this.f9004a;
        if (c2575b.f8980r) {
            return c2575b.f8981s;
        }
        c2575b.m5566c();
        int i6 = c2575b.f8970h;
        Drawable[] drawableArr = c2575b.f8969g;
        int opacity = i6 > 0 ? drawableArr[0].getOpacity() : -2;
        for (int i10 = 1; i10 < i6; i10++) {
            opacity = Drawable.resolveOpacity(opacity, drawableArr[i10].getOpacity());
        }
        c2575b.f8981s = opacity;
        c2575b.f8980r = true;
        return opacity;
    }

    @Override
    public final void getOutline(Outline outline) {
        Drawable drawable = this.f9006c;
        if (drawable != null) {
            drawable.getOutline(outline);
        }
    }

    @Override
    public final boolean getPadding(Rect rect) {
        C2575b c2575b = this.f9004a;
        boolean padding = false;
        Rect rect2 = null;
        if (!c2575b.f8971i) {
            Rect rect3 = c2575b.f8973k;
            if (rect3 != null || c2575b.f8972j) {
                rect2 = rect3;
            } else {
                c2575b.m5566c();
                Rect rect4 = new Rect();
                int i6 = c2575b.f8970h;
                Drawable[] drawableArr = c2575b.f8969g;
                for (int i10 = 0; i10 < i6; i10++) {
                    if (drawableArr[i10].getPadding(rect4)) {
                        if (rect2 == null) {
                            rect2 = new Rect(0, 0, 0, 0);
                        }
                        int i11 = rect4.left;
                        if (i11 > rect2.left) {
                            rect2.left = i11;
                        }
                        int i12 = rect4.top;
                        if (i12 > rect2.top) {
                            rect2.top = i12;
                        }
                        int i13 = rect4.right;
                        if (i13 > rect2.right) {
                            rect2.right = i13;
                        }
                        int i14 = rect4.bottom;
                        if (i14 > rect2.bottom) {
                            rect2.bottom = i14;
                        }
                    }
                }
                c2575b.f8972j = true;
                c2575b.f8973k = rect2;
            }
        }
        if (rect2 != null) {
            rect.set(rect2);
            if ((rect2.left | rect2.top | rect2.bottom | rect2.right) != 0) {
                padding = true;
            }
        } else {
            Drawable drawable = this.f9006c;
            padding = drawable != null ? drawable.getPadding(rect) : super.getPadding(rect);
        }
        if (this.f9004a.f8953A && AbstractC3198d.m6474w(this) == 1) {
            int i15 = rect.left;
            rect.left = rect.right;
            rect.right = i15;
        }
        return padding;
    }

    @Override
    public final void invalidateDrawable(Drawable drawable) {
        C2575b c2575b = this.f9004a;
        if (c2575b != null) {
            c2575b.f8980r = false;
            c2575b.f8982t = false;
        }
        if (drawable != this.f9006c || getCallback() == null) {
            return;
        }
        getCallback().invalidateDrawable(this);
    }

    @Override
    public final boolean isAutoMirrored() {
        return this.f9004a.f8953A;
    }

    @Override
    public void jumpToCurrentState() {
        boolean z7;
        Drawable drawable = this.f9007d;
        boolean z10 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f9007d = null;
            z7 = true;
        } else {
            z7 = false;
        }
        Drawable drawable2 = this.f9006c;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f9009f) {
                this.f9006c.setAlpha(this.f9008e);
            }
        }
        if (this.f9014k != 0) {
            this.f9014k = 0L;
            z7 = true;
        }
        if (this.f9013j != 0) {
            this.f9013j = 0L;
        } else {
            z10 = z7;
        }
        if (z10) {
            invalidateSelf();
        }
    }

    @Override
    public Drawable mutate() {
        if (!this.f9011h && super.mutate() == this) {
            C2578e c2578e = (C2578e) this;
            C2575b c2575b = new C2575b(c2578e.f8996p, c2578e, null);
            c2575b.f8961I = c2575b.f8961I.clone();
            c2575b.f8962J = c2575b.f8962J.clone();
            mo5573d(c2575b);
            this.f9011h = true;
        }
        return this;
    }

    @Override
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f9007d;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.f9006c;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    @Override
    public final boolean onLayoutDirectionChanged(int i6) {
        C2575b c2575b = this.f9004a;
        int i10 = this.f9010g;
        int i11 = c2575b.f8970h;
        Drawable[] drawableArr = c2575b.f8969g;
        boolean z7 = false;
        for (int i12 = 0; i12 < i11; i12++) {
            Drawable drawable = drawableArr[i12];
            if (drawable != null) {
                boolean zM6442Q = Build.VERSION.SDK_INT >= 23 ? AbstractC3198d.m6442Q(drawable, i6) : false;
                if (i12 == i10) {
                    z7 = zM6442Q;
                }
            }
        }
        c2575b.f8986x = i6;
        return z7;
    }

    @Override
    public final boolean onLevelChange(int i6) {
        Drawable drawable = this.f9007d;
        if (drawable != null) {
            return drawable.setLevel(i6);
        }
        Drawable drawable2 = this.f9006c;
        if (drawable2 != null) {
            return drawable2.setLevel(i6);
        }
        return false;
    }

    @Override
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        if (drawable != this.f9006c || getCallback() == null) {
            return;
        }
        getCallback().scheduleDrawable(this, runnable, j10);
    }

    @Override
    public final void setAlpha(int i6) {
        if (this.f9009f && this.f9008e == i6) {
            return;
        }
        this.f9009f = true;
        this.f9008e = i6;
        Drawable drawable = this.f9006c;
        if (drawable != null) {
            if (this.f9013j == 0) {
                drawable.setAlpha(i6);
            } else {
                m5576a(false);
            }
        }
    }

    @Override
    public final void setAutoMirrored(boolean z7) {
        C2575b c2575b = this.f9004a;
        if (c2575b.f8953A != z7) {
            c2575b.f8953A = z7;
            Drawable drawable = this.f9006c;
            if (drawable != null) {
                drawable.setAutoMirrored(z7);
            }
        }
    }

    @Override
    public final void setColorFilter(ColorFilter colorFilter) {
        C2575b c2575b = this.f9004a;
        c2575b.f8955C = true;
        if (c2575b.f8954B != colorFilter) {
            c2575b.f8954B = colorFilter;
            Drawable drawable = this.f9006c;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override
    public final void setDither(boolean z7) {
        C2575b c2575b = this.f9004a;
        if (c2575b.f8985w != z7) {
            c2575b.f8985w = z7;
            Drawable drawable = this.f9006c;
            if (drawable != null) {
                drawable.setDither(z7);
            }
        }
    }

    @Override
    public final void setHotspot(float f, float f3) {
        Drawable drawable = this.f9006c;
        if (drawable != null) {
            AbstractC2581a.m5583e(drawable, f, f3);
        }
    }

    @Override
    public final void setHotspotBounds(int i6, int i10, int i11, int i12) {
        Rect rect = this.f9005b;
        if (rect == null) {
            this.f9005b = new Rect(i6, i10, i11, i12);
        } else {
            rect.set(i6, i10, i11, i12);
        }
        Drawable drawable = this.f9006c;
        if (drawable != null) {
            AbstractC2581a.m5584f(drawable, i6, i10, i11, i12);
        }
    }

    @Override
    public final void setTint(int i6) {
        setTintList(ColorStateList.valueOf(i6));
    }

    @Override
    public final void setTintList(ColorStateList colorStateList) {
        C2575b c2575b = this.f9004a;
        c2575b.f8958F = true;
        if (c2575b.f8956D != colorStateList) {
            c2575b.f8956D = colorStateList;
            AbstractC2581a.m5586h(this.f9006c, colorStateList);
        }
    }

    @Override
    public final void setTintMode(PorterDuff.Mode mode) {
        C2575b c2575b = this.f9004a;
        c2575b.f8959G = true;
        if (c2575b.f8957E != mode) {
            c2575b.f8957E = mode;
            AbstractC2581a.m5587i(this.f9006c, mode);
        }
    }

    @Override
    public boolean setVisible(boolean z7, boolean z10) {
        boolean visible = super.setVisible(z7, z10);
        Drawable drawable = this.f9007d;
        if (drawable != null) {
            drawable.setVisible(z7, z10);
        }
        Drawable drawable2 = this.f9006c;
        if (drawable2 != null) {
            drawable2.setVisible(z7, z10);
        }
        return visible;
    }

    @Override
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable != this.f9006c || getCallback() == null) {
            return;
        }
        getCallback().unscheduleDrawable(this, runnable);
    }
}
