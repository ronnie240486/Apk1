package com.google.android.material.imageview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.bumptech.glide.AbstractC1466d;
import com.p2serv.android.p032ds.R;
import p133m6.C3082a;
import p221u6.AbstractC3914n;
import p221u6.C3908h;
import p221u6.C3913m;
import p221u6.C3915o;
import p221u6.InterfaceC3924x;
import p222u7.AbstractC3928d;
import p250x5.AbstractC4121a;
import p263y6.AbstractC4275a;

public class ShapeableImageView extends AppCompatImageView implements InterfaceC3924x {

    public final C3915o f6299d;

    public final RectF f6300e;

    public final RectF f6301f;

    public final Paint f6302g;

    public final Paint f6303h;

    public final Path f6304i;

    public ColorStateList f6305j;

    public C3908h f6306k;

    public C3913m f6307l;

    public float f6308m;

    public final Path f6309n;

    public final int f6310o;

    public final int f6311p;

    public final int f6312q;

    public final int f6313r;

    public final int f6314s;

    public final int f6315t;

    public boolean f6316u;

    public ShapeableImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final boolean m4232c() {
        return getLayoutDirection() == 1;
    }

    public final void m4233d(int i6, int i10) {
        RectF rectF = this.f6300e;
        rectF.set(getPaddingLeft(), getPaddingTop(), i6 - getPaddingRight(), i10 - getPaddingBottom());
        C3913m c3913m = this.f6307l;
        Path path = this.f6304i;
        this.f6299d.m7827a(c3913m, 1.0f, rectF, null, path);
        Path path2 = this.f6309n;
        path2.rewind();
        path2.addPath(path);
        RectF rectF2 = this.f6301f;
        rectF2.set(0.0f, 0.0f, i6, i10);
        path2.addRect(rectF2, Path.Direction.CCW);
    }

    public int getContentPaddingBottom() {
        return this.f6313r;
    }

    public final int getContentPaddingEnd() {
        int i6 = this.f6315t;
        if (i6 != Integer.MIN_VALUE) {
            return i6;
        }
        return m4232c() ? this.f6310o : this.f6312q;
    }

    public int getContentPaddingLeft() {
        int i6;
        int i10;
        if (this.f6314s != Integer.MIN_VALUE || this.f6315t != Integer.MIN_VALUE) {
            if (m4232c() && (i10 = this.f6315t) != Integer.MIN_VALUE) {
                return i10;
            }
            if (!m4232c() && (i6 = this.f6314s) != Integer.MIN_VALUE) {
                return i6;
            }
        }
        return this.f6310o;
    }

    public int getContentPaddingRight() {
        int i6;
        int i10;
        if (this.f6314s != Integer.MIN_VALUE || this.f6315t != Integer.MIN_VALUE) {
            if (m4232c() && (i10 = this.f6314s) != Integer.MIN_VALUE) {
                return i10;
            }
            if (!m4232c() && (i6 = this.f6315t) != Integer.MIN_VALUE) {
                return i6;
            }
        }
        return this.f6312q;
    }

    public final int getContentPaddingStart() {
        int i6 = this.f6314s;
        if (i6 != Integer.MIN_VALUE) {
            return i6;
        }
        return m4232c() ? this.f6312q : this.f6310o;
    }

    public int getContentPaddingTop() {
        return this.f6311p;
    }

    @Override
    public int getPaddingBottom() {
        return super.getPaddingBottom() - getContentPaddingBottom();
    }

    @Override
    public int getPaddingEnd() {
        return super.getPaddingEnd() - getContentPaddingEnd();
    }

    @Override
    public int getPaddingLeft() {
        return super.getPaddingLeft() - getContentPaddingLeft();
    }

    @Override
    public int getPaddingRight() {
        return super.getPaddingRight() - getContentPaddingRight();
    }

    @Override
    public int getPaddingStart() {
        return super.getPaddingStart() - getContentPaddingStart();
    }

    @Override
    public int getPaddingTop() {
        return super.getPaddingTop() - getContentPaddingTop();
    }

    public C3913m getShapeAppearanceModel() {
        return this.f6307l;
    }

    public ColorStateList getStrokeColor() {
        return this.f6305j;
    }

    public float getStrokeWidth() {
        return this.f6308m;
    }

    @Override
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        setLayerType(2, null);
    }

    @Override
    public final void onDetachedFromWindow() {
        setLayerType(0, null);
        super.onDetachedFromWindow();
    }

    @Override
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.f6309n, this.f6303h);
        if (this.f6305j == null) {
            return;
        }
        Paint paint = this.f6302g;
        paint.setStrokeWidth(this.f6308m);
        int colorForState = this.f6305j.getColorForState(getDrawableState(), this.f6305j.getDefaultColor());
        if (this.f6308m <= 0.0f || colorForState == 0) {
            return;
        }
        paint.setColor(colorForState);
        canvas.drawPath(this.f6304i, paint);
    }

    @Override
    public final void onMeasure(int i6, int i10) {
        super.onMeasure(i6, i10);
        if (!this.f6316u && isLayoutDirectionResolved()) {
            this.f6316u = true;
            if (!isPaddingRelative() && this.f6314s == Integer.MIN_VALUE && this.f6315t == Integer.MIN_VALUE) {
                setPadding(super.getPaddingLeft(), super.getPaddingTop(), super.getPaddingRight(), super.getPaddingBottom());
            } else {
                setPaddingRelative(super.getPaddingStart(), super.getPaddingTop(), super.getPaddingEnd(), super.getPaddingBottom());
            }
        }
    }

    @Override
    public final void onSizeChanged(int i6, int i10, int i11, int i12) {
        super.onSizeChanged(i6, i10, i11, i12);
        m4233d(i6, i10);
    }

    @Override
    public final void setPadding(int i6, int i10, int i11, int i12) {
        super.setPadding(getContentPaddingLeft() + i6, getContentPaddingTop() + i10, getContentPaddingRight() + i11, getContentPaddingBottom() + i12);
    }

    @Override
    public final void setPaddingRelative(int i6, int i10, int i11, int i12) {
        super.setPaddingRelative(getContentPaddingStart() + i6, getContentPaddingTop() + i10, getContentPaddingEnd() + i11, getContentPaddingBottom() + i12);
    }

    @Override
    public void setShapeAppearanceModel(C3913m c3913m) {
        this.f6307l = c3913m;
        C3908h c3908h = this.f6306k;
        if (c3908h != null) {
            c3908h.setShapeAppearanceModel(c3913m);
        }
        m4233d(getWidth(), getHeight());
        invalidate();
        invalidateOutline();
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.f6305j = colorStateList;
        invalidate();
    }

    public void setStrokeColorResource(int i6) {
        setStrokeColor(AbstractC3928d.m7848k(getContext(), i6));
    }

    public void setStrokeWidth(float f) {
        if (this.f6308m != f) {
            this.f6308m = f;
            invalidate();
        }
    }

    public void setStrokeWidthResource(int i6) {
        setStrokeWidth(getResources().getDimensionPixelSize(i6));
    }

    public ShapeableImageView(Context context, AttributeSet attributeSet, int i6) {
        super(AbstractC4275a.m8323a(context, attributeSet, i6, R.style.Widget_MaterialComponents_ShapeableImageView), attributeSet, i6);
        this.f6299d = AbstractC3914n.f13176a;
        this.f6304i = new Path();
        this.f6316u = false;
        Context context2 = getContext();
        Paint paint = new Paint();
        this.f6303h = paint;
        paint.setAntiAlias(true);
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.f6300e = new RectF();
        this.f6301f = new RectF();
        this.f6309n = new Path();
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, AbstractC4121a.f13976T, i6, R.style.Widget_MaterialComponents_ShapeableImageView);
        this.f6305j = AbstractC1466d.m3493k(context2, typedArrayObtainStyledAttributes, 9);
        this.f6308m = typedArrayObtainStyledAttributes.getDimensionPixelSize(10, 0);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f6310o = dimensionPixelSize;
        this.f6311p = dimensionPixelSize;
        this.f6312q = dimensionPixelSize;
        this.f6313r = dimensionPixelSize;
        this.f6310o = typedArrayObtainStyledAttributes.getDimensionPixelSize(3, dimensionPixelSize);
        this.f6311p = typedArrayObtainStyledAttributes.getDimensionPixelSize(6, dimensionPixelSize);
        this.f6312q = typedArrayObtainStyledAttributes.getDimensionPixelSize(4, dimensionPixelSize);
        this.f6313r = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, dimensionPixelSize);
        this.f6314s = typedArrayObtainStyledAttributes.getDimensionPixelSize(5, Integer.MIN_VALUE);
        this.f6315t = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, Integer.MIN_VALUE);
        typedArrayObtainStyledAttributes.recycle();
        Paint paint2 = new Paint();
        this.f6302g = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        this.f6307l = C3913m.m7822b(context2, attributeSet, i6, R.style.Widget_MaterialComponents_ShapeableImageView).m7819a();
        setOutlineProvider(new C3082a(this));
    }
}
