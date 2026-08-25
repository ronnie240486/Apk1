package p058f2;

import android.content.res.ColorStateList;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.ArrayList;
import p000a.AbstractC0004e;
import p123l5.AbstractC2973a;
import p140n2.EnumC3182g;
import p178q6.C3506c;
import p187r4.AbstractC3612b;

public final class C2491a extends Drawable implements Drawable.Callback, Animatable {

    public final EnumC3182g f8708a;

    public final int f8709b;

    public final boolean f8710c;

    public final boolean f8711d;

    public final ArrayList f8712e = new ArrayList();

    public final int f8713f;

    public final int f8714g;

    public long f8715h;

    public int f8716i;

    public int f8717j;

    public Drawable f8718k;

    public final Drawable f8719l;

    public C2491a(Drawable drawable, Drawable drawable2, EnumC3182g enumC3182g, int i6, boolean z7, boolean z10) {
        this.f8708a = enumC3182g;
        this.f8709b = i6;
        this.f8710c = z7;
        this.f8711d = z10;
        this.f8713f = m5542a(drawable != null ? Integer.valueOf(drawable.getIntrinsicWidth()) : null, drawable2 != null ? Integer.valueOf(drawable2.getIntrinsicWidth()) : null);
        this.f8714g = m5542a(drawable != null ? Integer.valueOf(drawable.getIntrinsicHeight()) : null, drawable2 != null ? Integer.valueOf(drawable2.getIntrinsicHeight()) : null);
        this.f8716i = 255;
        this.f8718k = drawable != null ? drawable.mutate() : null;
        Drawable drawableMutate = drawable2 != null ? drawable2.mutate() : null;
        this.f8719l = drawableMutate;
        if (i6 <= 0) {
            throw new IllegalArgumentException("durationMillis must be > 0.");
        }
        Drawable drawable3 = this.f8718k;
        if (drawable3 != null) {
            drawable3.setCallback(this);
        }
        if (drawableMutate == null) {
            return;
        }
        drawableMutate.setCallback(this);
    }

    public final int m5542a(Integer num, Integer num2) {
        if (this.f8711d || ((num == null || num.intValue() != -1) && (num2 == null || num2.intValue() != -1))) {
            return Math.max(num != null ? num.intValue() : -1, num2 != null ? num2.intValue() : -1);
        }
        return -1;
    }

    public final void m5543b() {
        this.f8717j = 2;
        this.f8718k = null;
        ArrayList arrayList = this.f8712e;
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            ((C3506c) arrayList.get(i6)).m7147a();
        }
    }

    public final void m5544c(Drawable drawable, Rect rect) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            drawable.setBounds(rect);
            return;
        }
        int iWidth = rect.width();
        int iHeight = rect.height();
        double dM6017j = AbstractC2973a.m6017j(intrinsicWidth, intrinsicHeight, iWidth, iHeight, this.f8708a);
        double d = 2;
        int iM7254J = AbstractC3612b.m7254J((((double) iWidth) - (((double) intrinsicWidth) * dM6017j)) / d);
        int iM7254J2 = AbstractC3612b.m7254J((((double) iHeight) - (dM6017j * ((double) intrinsicHeight))) / d);
        drawable.setBounds(rect.left + iM7254J, rect.top + iM7254J2, rect.right - iM7254J, rect.bottom - iM7254J2);
    }

    @Override
    public final void draw(Canvas canvas) {
        Drawable drawable;
        int i6 = this.f8717j;
        if (i6 == 0) {
            Drawable drawable2 = this.f8718k;
            if (drawable2 != null) {
                drawable2.setAlpha(this.f8716i);
                int iSave = canvas.save();
                try {
                    drawable2.draw(canvas);
                    return;
                } finally {
                    canvas.restoreToCount(iSave);
                }
            }
            return;
        }
        Drawable drawable3 = this.f8719l;
        if (i6 == 2) {
            if (drawable3 != null) {
                drawable3.setAlpha(this.f8716i);
                int iSave2 = canvas.save();
                try {
                    drawable3.draw(canvas);
                    return;
                } finally {
                    canvas.restoreToCount(iSave2);
                }
            }
            return;
        }
        double dUptimeMillis = (SystemClock.uptimeMillis() - this.f8715h) / ((double) this.f8709b);
        double d = 0.0d;
        if (dUptimeMillis >= 0.0d) {
            d = dUptimeMillis > 1.0d ? 1.0d : dUptimeMillis;
        }
        int i10 = this.f8716i;
        int i11 = (int) (d * ((double) i10));
        if (this.f8710c) {
            i10 -= i11;
        }
        boolean z7 = dUptimeMillis >= 1.0d;
        if (!z7 && (drawable = this.f8718k) != null) {
            drawable.setAlpha(i10);
            int iSave3 = canvas.save();
            try {
                drawable.draw(canvas);
                canvas.restoreToCount(iSave3);
            } catch (Throwable th) {
                canvas.restoreToCount(iSave3);
                throw th;
            }
        }
        if (drawable3 != null) {
            drawable3.setAlpha(i11);
            int iSave4 = canvas.save();
            try {
                drawable3.draw(canvas);
                canvas.restoreToCount(iSave4);
            } catch (Throwable th2) {
                canvas.restoreToCount(iSave4);
                throw th2;
            }
        }
        if (z7) {
            m5543b();
        } else {
            invalidateSelf();
        }
    }

    @Override
    public final int getAlpha() {
        return this.f8716i;
    }

    @Override
    public final ColorFilter getColorFilter() {
        ColorFilter colorFilter;
        int i6 = this.f8717j;
        if (i6 == 0) {
            Drawable drawable = this.f8718k;
            if (drawable != null) {
                return drawable.getColorFilter();
            }
            return null;
        }
        Drawable drawable2 = this.f8719l;
        if (i6 != 1) {
            if (i6 == 2 && drawable2 != null) {
                return drawable2.getColorFilter();
            }
            return null;
        }
        if (drawable2 != null && (colorFilter = drawable2.getColorFilter()) != null) {
            return colorFilter;
        }
        Drawable drawable3 = this.f8718k;
        if (drawable3 != null) {
            return drawable3.getColorFilter();
        }
        return null;
    }

    @Override
    public final int getIntrinsicHeight() {
        return this.f8714g;
    }

    @Override
    public final int getIntrinsicWidth() {
        return this.f8713f;
    }

    @Override
    public final int getOpacity() {
        Drawable drawable = this.f8718k;
        int i6 = this.f8717j;
        if (i6 == 0) {
            if (drawable != null) {
                return drawable.getOpacity();
            }
            return -2;
        }
        Drawable drawable2 = this.f8719l;
        if (i6 == 2) {
            if (drawable2 != null) {
                return drawable2.getOpacity();
            }
            return -2;
        }
        if (drawable != null && drawable2 != null) {
            return Drawable.resolveOpacity(drawable.getOpacity(), drawable2.getOpacity());
        }
        if (drawable != null) {
            return drawable.getOpacity();
        }
        if (drawable2 != null) {
            return drawable2.getOpacity();
        }
        return -2;
    }

    @Override
    public final void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override
    public final boolean isRunning() {
        return this.f8717j == 1;
    }

    @Override
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f8718k;
        if (drawable != null) {
            m5544c(drawable, rect);
        }
        Drawable drawable2 = this.f8719l;
        if (drawable2 != null) {
            m5544c(drawable2, rect);
        }
    }

    @Override
    public final boolean onLevelChange(int i6) {
        Drawable drawable = this.f8718k;
        boolean level = drawable != null ? drawable.setLevel(i6) : false;
        Drawable drawable2 = this.f8719l;
        return level || (drawable2 != null ? drawable2.setLevel(i6) : false);
    }

    @Override
    public final boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f8718k;
        boolean state = drawable != null ? drawable.setState(iArr) : false;
        Drawable drawable2 = this.f8719l;
        return state || (drawable2 != null ? drawable2.setState(iArr) : false);
    }

    @Override
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        scheduleSelf(runnable, j10);
    }

    @Override
    public final void setAlpha(int i6) {
        if (i6 < 0 || i6 >= 256) {
            throw new IllegalArgumentException(AbstractC0004e.m20n(i6, "Invalid alpha: ").toString());
        }
        this.f8716i = i6;
    }

    @Override
    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f8718k;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
        Drawable drawable2 = this.f8719l;
        if (drawable2 == null) {
            return;
        }
        drawable2.setColorFilter(colorFilter);
    }

    @Override
    public final void setTint(int i6) {
        Drawable drawable = this.f8718k;
        if (drawable != null) {
            drawable.setTint(i6);
        }
        Drawable drawable2 = this.f8719l;
        if (drawable2 != null) {
            drawable2.setTint(i6);
        }
    }

    @Override
    public final void setTintBlendMode(BlendMode blendMode) {
        Drawable drawable = this.f8718k;
        if (drawable != null) {
            drawable.setTintBlendMode(blendMode);
        }
        Drawable drawable2 = this.f8719l;
        if (drawable2 != null) {
            drawable2.setTintBlendMode(blendMode);
        }
    }

    @Override
    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f8718k;
        if (drawable != null) {
            drawable.setTintList(colorStateList);
        }
        Drawable drawable2 = this.f8719l;
        if (drawable2 != null) {
            drawable2.setTintList(colorStateList);
        }
    }

    @Override
    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f8718k;
        if (drawable != null) {
            drawable.setTintMode(mode);
        }
        Drawable drawable2 = this.f8719l;
        if (drawable2 != null) {
            drawable2.setTintMode(mode);
        }
    }

    @Override
    public final void start() {
        Object obj = this.f8718k;
        Animatable animatable = obj instanceof Animatable ? (Animatable) obj : null;
        if (animatable != null) {
            animatable.start();
        }
        Object obj2 = this.f8719l;
        Animatable animatable2 = obj2 instanceof Animatable ? (Animatable) obj2 : null;
        if (animatable2 != null) {
            animatable2.start();
        }
        if (this.f8717j != 0) {
            return;
        }
        this.f8717j = 1;
        this.f8715h = SystemClock.uptimeMillis();
        ArrayList arrayList = this.f8712e;
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            ((C3506c) arrayList.get(i6)).getClass();
        }
        invalidateSelf();
    }

    @Override
    public final void stop() {
        Object obj = this.f8718k;
        Animatable animatable = obj instanceof Animatable ? (Animatable) obj : null;
        if (animatable != null) {
            animatable.stop();
        }
        Object obj2 = this.f8719l;
        Animatable animatable2 = obj2 instanceof Animatable ? (Animatable) obj2 : null;
        if (animatable2 != null) {
            animatable2.stop();
        }
        if (this.f8717j != 2) {
            m5543b();
        }
    }

    @Override
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
