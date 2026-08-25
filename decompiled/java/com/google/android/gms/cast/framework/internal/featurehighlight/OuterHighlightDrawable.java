package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.R;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.annotation.Keep;
import com.google.android.gms.internal.cast.AbstractC1503a1;
import p056f0.AbstractC2478a;

class OuterHighlightDrawable extends Drawable {

    public final int f4794a;

    public final int f4795b;

    public final int f4796c;

    public final Rect f4797d = new Rect();

    public final Rect f4798e = new Rect();

    public final Paint f4799f;

    public float f4800g;

    public float f4801h;

    public float f4802i;

    public float f4803j;

    public float f4804k;

    public float f4805l;

    public final int f4806m;

    public OuterHighlightDrawable(Activity activity) {
        Paint paint = new Paint();
        this.f4799f = paint;
        this.f4801h = 1.0f;
        this.f4804k = 0.0f;
        this.f4805l = 0.0f;
        this.f4806m = 244;
        TypedValue typedValue = new TypedValue();
        activity.getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true);
        paint.setColor(AbstractC2478a.m5513h(typedValue.data, 244));
        this.f4806m = paint.getAlpha();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        Resources resources = activity.getResources();
        this.f4794a = resources.getDimensionPixelSize(com.p2serv.android.p032ds.R.dimen.cast_libraries_material_featurehighlight_center_threshold);
        this.f4795b = resources.getDimensionPixelSize(com.p2serv.android.p032ds.R.dimen.cast_libraries_material_featurehighlight_center_horizontal_offset);
        this.f4796c = resources.getDimensionPixelSize(com.p2serv.android.p032ds.R.dimen.cast_libraries_material_featurehighlight_outer_padding);
    }

    public static final float m3610a(float f, float f3, Rect rect) {
        float f4 = rect.left;
        float f5 = rect.top;
        float f10 = rect.right;
        float f11 = rect.bottom;
        float fM3691a = AbstractC1503a1.m3691a(f, f3, f4, f5);
        float fM3691a2 = AbstractC1503a1.m3691a(f, f3, f10, f5);
        float fM3691a3 = AbstractC1503a1.m3691a(f, f3, f10, f11);
        float fM3691a4 = AbstractC1503a1.m3691a(f, f3, f4, f11);
        if (fM3691a <= fM3691a2 || fM3691a <= fM3691a3 || fM3691a <= fM3691a4) {
            if (fM3691a2 <= fM3691a3 || fM3691a2 <= fM3691a4) {
                fM3691a = fM3691a3 <= fM3691a4 ? fM3691a4 : fM3691a3;
            } else {
                fM3691a = fM3691a2;
            }
        }
        return (float) Math.ceil(fM3691a);
    }

    @Override
    public final void draw(Canvas canvas) {
        canvas.drawCircle(this.f4802i + this.f4804k, this.f4803j + this.f4805l, this.f4800g * this.f4801h, this.f4799f);
    }

    @Override
    public final int getAlpha() {
        return this.f4799f.getAlpha();
    }

    @Override
    public final int getOpacity() {
        return -3;
    }

    @Override
    public final void setAlpha(int i6) {
        this.f4799f.setAlpha(i6);
        invalidateSelf();
    }

    @Override
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f4799f.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Keep
    public void setScale(float f) {
        this.f4801h = f;
        invalidateSelf();
    }

    @Keep
    public void setTranslationX(float f) {
        this.f4804k = f;
        invalidateSelf();
    }

    @Keep
    public void setTranslationY(float f) {
        this.f4805l = f;
        invalidateSelf();
    }
}
