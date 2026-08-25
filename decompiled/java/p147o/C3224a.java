package p147o;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public final class C3224a extends Drawable {

    public float f10825a;

    public final Paint f10826b;

    public final RectF f10827c;

    public final Rect f10828d;

    public float f10829e;

    public ColorStateList f10832h;

    public PorterDuffColorFilter f10833i;

    public ColorStateList f10834j;

    public boolean f10830f = false;

    public boolean f10831g = true;

    public PorterDuff.Mode f10835k = PorterDuff.Mode.SRC_IN;

    public C3224a(ColorStateList colorStateList, float f) {
        this.f10825a = f;
        Paint paint = new Paint(5);
        this.f10826b = paint;
        colorStateList = colorStateList == null ? ColorStateList.valueOf(0) : colorStateList;
        this.f10832h = colorStateList;
        paint.setColor(colorStateList.getColorForState(getState(), this.f10832h.getDefaultColor()));
        this.f10827c = new RectF();
        this.f10828d = new Rect();
    }

    public final PorterDuffColorFilter m6508a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public final void m6509b(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        RectF rectF = this.f10827c;
        rectF.set(rect.left, rect.top, rect.right, rect.bottom);
        Rect rect2 = this.f10828d;
        rect2.set(rect);
        if (this.f10830f) {
            rect2.inset((int) Math.ceil(AbstractC3225b.m6510a(this.f10829e, this.f10825a, this.f10831g)), (int) Math.ceil(AbstractC3225b.m6511b(this.f10829e, this.f10825a, this.f10831g)));
            rectF.set(rect2);
        }
    }

    @Override
    public final void draw(Canvas canvas) {
        boolean z7;
        Paint paint = this.f10826b;
        if (this.f10833i == null || paint.getColorFilter() != null) {
            z7 = false;
        } else {
            paint.setColorFilter(this.f10833i);
            z7 = true;
        }
        RectF rectF = this.f10827c;
        float f = this.f10825a;
        canvas.drawRoundRect(rectF, f, f, paint);
        if (z7) {
            paint.setColorFilter(null);
        }
    }

    @Override
    public final int getOpacity() {
        return -3;
    }

    @Override
    public final void getOutline(Outline outline) {
        outline.setRoundRect(this.f10828d, this.f10825a);
    }

    @Override
    public final boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f10834j;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f10832h) != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        m6509b(rect);
    }

    @Override
    public final boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f10832h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        Paint paint = this.f10826b;
        boolean z7 = colorForState != paint.getColor();
        if (z7) {
            paint.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f10834j;
        if (colorStateList2 == null || (mode = this.f10835k) == null) {
            return z7;
        }
        this.f10833i = m6508a(colorStateList2, mode);
        return true;
    }

    @Override
    public final void setAlpha(int i6) {
        this.f10826b.setAlpha(i6);
    }

    @Override
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f10826b.setColorFilter(colorFilter);
    }

    @Override
    public final void setTintList(ColorStateList colorStateList) {
        this.f10834j = colorStateList;
        this.f10833i = m6508a(colorStateList, this.f10835k);
        invalidateSelf();
    }

    @Override
    public final void setTintMode(PorterDuff.Mode mode) {
        this.f10835k = mode;
        this.f10833i = m6508a(this.f10834j, mode);
        invalidateSelf();
    }
}
