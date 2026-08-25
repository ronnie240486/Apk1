package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.Keep;
import com.google.android.gms.internal.cast.AbstractC1642o1;
import com.p2serv.android.p032ds.R;

class InnerZoneDrawable extends Drawable {

    public final Paint f4783a;

    public final Paint f4784b;

    public final Rect f4785c;

    public final int f4786d;

    public final int f4787e;

    public float f4788f;

    public float f4789g;

    public float f4790h;

    public float f4791i;

    public float f4792j;

    public float f4793k;

    public InnerZoneDrawable(Activity activity) {
        Paint paint = new Paint();
        this.f4783a = paint;
        Paint paint2 = new Paint();
        this.f4784b = paint2;
        this.f4785c = new Rect();
        this.f4789g = 1.0f;
        Resources resources = activity.getResources();
        this.f4786d = resources.getDimensionPixelSize(R.dimen.cast_libraries_material_featurehighlight_inner_radius);
        this.f4787e = resources.getInteger(R.integer.cast_libraries_material_featurehighlight_pulse_base_alpha);
        paint.setAntiAlias(true);
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        paint.setColor(-1);
        paint2.setAntiAlias(true);
        paint2.setStyle(style);
        paint2.setColor(-1);
    }

    public final Animator m3609a() {
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofFloat("scale", 0.0f), PropertyValuesHolder.ofInt("alpha", 0), PropertyValuesHolder.ofFloat("pulseScale", 0.0f), PropertyValuesHolder.ofFloat("pulseAlpha", 0.0f));
        objectAnimatorOfPropertyValuesHolder.setInterpolator(AbstractC1642o1.f5484b);
        return objectAnimatorOfPropertyValuesHolder.setDuration(200L);
    }

    @Override
    public final void draw(Canvas canvas) {
        float f = this.f4793k;
        if (f > 0.0f) {
            float f3 = this.f4788f * this.f4792j;
            Paint paint = this.f4784b;
            paint.setAlpha((int) (this.f4787e * f));
            canvas.drawCircle(this.f4790h, this.f4791i, f3, paint);
        }
        canvas.drawCircle(this.f4790h, this.f4791i, this.f4788f * this.f4789g, this.f4783a);
    }

    @Override
    public final int getOpacity() {
        return -3;
    }

    @Override
    public final void setAlpha(int i6) {
        this.f4783a.setAlpha(i6);
        invalidateSelf();
    }

    @Override
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f4783a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Keep
    public void setPulseAlpha(float f) {
        this.f4793k = f;
        invalidateSelf();
    }

    @Keep
    public void setPulseScale(float f) {
        this.f4792j = f;
        invalidateSelf();
    }

    @Keep
    public void setScale(float f) {
        this.f4789g = f;
        invalidateSelf();
    }
}
