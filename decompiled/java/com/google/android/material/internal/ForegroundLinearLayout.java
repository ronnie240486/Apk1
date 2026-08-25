package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.appcompat.widget.LinearLayoutCompat;
import p250x5.AbstractC4121a;

public class ForegroundLinearLayout extends LinearLayoutCompat {

    public Drawable f6327p;

    public final Rect f6328q;

    public final Rect f6329r;

    public int f6330s;

    public final boolean f6331t;

    public boolean f6332u;

    public ForegroundLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.f6327p;
        if (drawable != null) {
            if (this.f6332u) {
                this.f6332u = false;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                boolean z7 = this.f6331t;
                Rect rect = this.f6328q;
                if (z7) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                int i6 = this.f6330s;
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                Rect rect2 = this.f6329r;
                Gravity.apply(i6, intrinsicWidth, intrinsicHeight, rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @Override
    public final void drawableHotspotChanged(float f, float f3) {
        super.drawableHotspotChanged(f, f3);
        Drawable drawable = this.f6327p;
        if (drawable != null) {
            drawable.setHotspot(f, f3);
        }
    }

    @Override
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f6327p;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        this.f6327p.setState(getDrawableState());
    }

    @Override
    public Drawable getForeground() {
        return this.f6327p;
    }

    @Override
    public int getForegroundGravity() {
        return this.f6330s;
    }

    @Override
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f6327p;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override
    public final void onLayout(boolean z7, int i6, int i10, int i11, int i12) {
        super.onLayout(z7, i6, i10, i11, i12);
        this.f6332u = z7 | this.f6332u;
    }

    @Override
    public final void onSizeChanged(int i6, int i10, int i11, int i12) {
        super.onSizeChanged(i6, i10, i11, i12);
        this.f6332u = true;
    }

    @Override
    public void setForeground(Drawable drawable) {
        Drawable drawable2 = this.f6327p;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.f6327p);
            }
            this.f6327p = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.f6330s == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    @Override
    public void setForegroundGravity(int i6) {
        if (this.f6330s != i6) {
            if ((8388615 & i6) == 0) {
                i6 |= 8388611;
            }
            if ((i6 & 112) == 0) {
                i6 |= 48;
            }
            this.f6330s = i6;
            if (i6 == 119 && this.f6327p != null) {
                this.f6327p.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    @Override
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f6327p;
    }

    public ForegroundLinearLayout(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f6328q = new Rect();
        this.f6329r = new Rect();
        this.f6330s = 119;
        this.f6331t = true;
        this.f6332u = false;
        TypedArray typedArrayM4250j = AbstractC1811a0.m4250j(context, attributeSet, AbstractC4121a.f14007u, i6, 0, new int[0]);
        this.f6330s = typedArrayM4250j.getInt(1, this.f6330s);
        Drawable drawable = typedArrayM4250j.getDrawable(0);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.f6331t = typedArrayM4250j.getBoolean(2, true);
        typedArrayM4250j.recycle();
    }
}
