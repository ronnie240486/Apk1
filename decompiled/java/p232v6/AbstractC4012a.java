package p232v6;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bumptech.glide.AbstractC1466d;
import com.google.android.material.internal.AbstractC1811a0;
import com.p2serv.android.p032ds.R;
import java.util.WeakHashMap;
import p065g0.AbstractC2581a;
import p138n0.AbstractC3113e0;
import p138n0.AbstractC3119g0;
import p138n0.AbstractC3155s0;
import p143n5.AbstractC3198d;
import p156o9.AbstractC3281e;
import p205t.ViewOnTouchListenerC3773n0;
import p250x5.AbstractC4121a;
import p263y6.AbstractC4275a;

public abstract class AbstractC4012a extends FrameLayout {

    public static final ViewOnTouchListenerC3773n0 f13604h = new ViewOnTouchListenerC3773n0(1);

    public int f13605a;

    public final float f13606b;

    public final float f13607c;

    public final int f13608d;

    public final int f13609e;

    public ColorStateList f13610f;

    public PorterDuff.Mode f13611g;

    public AbstractC4012a(Context context, AttributeSet attributeSet) {
        Drawable drawableM6448W;
        super(AbstractC4275a.m8323a(context, attributeSet, 0, 0), attributeSet);
        Context context2 = getContext();
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, AbstractC4121a.f13978V);
        if (typedArrayObtainStyledAttributes.hasValue(6)) {
            float dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(6, 0);
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            AbstractC3119g0.m6180s(this, dimensionPixelSize);
        }
        this.f13605a = typedArrayObtainStyledAttributes.getInt(2, 0);
        this.f13606b = typedArrayObtainStyledAttributes.getFloat(3, 1.0f);
        setBackgroundTintList(AbstractC1466d.m3493k(context2, typedArrayObtainStyledAttributes, 4));
        setBackgroundTintMode(AbstractC1811a0.m4252l(typedArrayObtainStyledAttributes.getInt(5, -1), PorterDuff.Mode.SRC_IN));
        this.f13607c = typedArrayObtainStyledAttributes.getFloat(1, 1.0f);
        this.f13608d = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1);
        this.f13609e = typedArrayObtainStyledAttributes.getDimensionPixelSize(7, -1);
        typedArrayObtainStyledAttributes.recycle();
        setOnTouchListener(f13604h);
        setFocusable(true);
        if (getBackground() == null) {
            float dimension = getResources().getDimension(R.dimen.mtrl_snackbar_background_corner_radius);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(dimension);
            gradientDrawable.setColor(AbstractC3281e.m6634x(getBackgroundOverlayColorAlpha(), AbstractC3281e.m6626p(R.attr.colorSurface, this), AbstractC3281e.m6626p(R.attr.colorOnSurface, this)));
            if (this.f13610f != null) {
                drawableM6448W = AbstractC3198d.m6448W(gradientDrawable);
                AbstractC2581a.m5586h(drawableM6448W, this.f13610f);
            } else {
                drawableM6448W = AbstractC3198d.m6448W(gradientDrawable);
            }
            WeakHashMap weakHashMap2 = AbstractC3155s0.f10642a;
            setBackground(drawableM6448W);
        }
    }

    public float getActionTextColorAlpha() {
        return this.f13607c;
    }

    public int getAnimationMode() {
        return this.f13605a;
    }

    public float getBackgroundOverlayColorAlpha() {
        return this.f13606b;
    }

    public int getMaxInlineActionWidth() {
        return this.f13609e;
    }

    public int getMaxWidth() {
        return this.f13608d;
    }

    @Override
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        AbstractC3113e0.m6130c(this);
    }

    @Override
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override
    public final void onLayout(boolean z7, int i6, int i10, int i11, int i12) {
        super.onLayout(z7, i6, i10, i11, i12);
    }

    @Override
    public void onMeasure(int i6, int i10) {
        super.onMeasure(i6, i10);
        int i11 = this.f13608d;
        if (i11 <= 0 || getMeasuredWidth() <= i11) {
            return;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(i11, 1073741824), i10);
    }

    public void setAnimationMode(int i6) {
        this.f13605a = i6;
    }

    @Override
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable != null && this.f13610f != null) {
            drawable = AbstractC3198d.m6448W(drawable.mutate());
            AbstractC2581a.m5586h(drawable, this.f13610f);
            AbstractC2581a.m5587i(drawable, this.f13611g);
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override
    public void setBackgroundTintList(ColorStateList colorStateList) {
        this.f13610f = colorStateList;
        if (getBackground() != null) {
            Drawable drawableM6448W = AbstractC3198d.m6448W(getBackground().mutate());
            AbstractC2581a.m5586h(drawableM6448W, colorStateList);
            AbstractC2581a.m5587i(drawableM6448W, this.f13611g);
            if (drawableM6448W != getBackground()) {
                super.setBackgroundDrawable(drawableM6448W);
            }
        }
    }

    @Override
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        this.f13611g = mode;
        if (getBackground() != null) {
            Drawable drawableM6448W = AbstractC3198d.m6448W(getBackground().mutate());
            AbstractC2581a.m5587i(drawableM6448W, mode);
            if (drawableM6448W != getBackground()) {
                super.setBackgroundDrawable(drawableM6448W);
            }
        }
    }

    @Override
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }
    }

    @Override
    public void setOnClickListener(View.OnClickListener onClickListener) {
        setOnTouchListener(onClickListener != null ? null : f13604h);
        super.setOnClickListener(onClickListener);
    }

    private void setBaseTransientBottomBar(AbstractC4013b abstractC4013b) {
    }
}
