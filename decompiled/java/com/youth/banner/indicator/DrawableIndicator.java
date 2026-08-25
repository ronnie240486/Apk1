package com.youth.banner.indicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import com.youth.banner.C2110R;

public class DrawableIndicator extends BaseIndicator {
    private Bitmap normalBitmap;
    private Bitmap selectedBitmap;

    public DrawableIndicator(Context context, int i6, int i10) {
        super(context);
        this.normalBitmap = BitmapFactory.decodeResource(getResources(), i6);
        this.selectedBitmap = BitmapFactory.decodeResource(getResources(), i10);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int indicatorSize = this.config.getIndicatorSize();
        if (indicatorSize <= 1 || this.normalBitmap == null || this.selectedBitmap == null) {
            return;
        }
        int i6 = 0;
        float indicatorSpace = 0.0f;
        while (i6 < indicatorSize) {
            canvas.drawBitmap(this.config.getCurrentPosition() == i6 ? this.selectedBitmap : this.normalBitmap, indicatorSpace, 0.0f, this.mPaint);
            indicatorSpace += this.config.getIndicatorSpace() + this.normalBitmap.getWidth();
            i6++;
        }
    }

    @Override
    public void onMeasure(int i6, int i10) {
        super.onMeasure(i6, i10);
        int indicatorSize = this.config.getIndicatorSize();
        if (indicatorSize <= 1) {
            return;
        }
        int i11 = indicatorSize - 1;
        setMeasuredDimension((this.config.getIndicatorSpace() * i11) + this.selectedBitmap.getWidth() + (this.selectedBitmap.getWidth() * i11), Math.max(this.normalBitmap.getHeight(), this.selectedBitmap.getHeight()));
    }

    public DrawableIndicator(Context context) {
        this(context, null);
    }

    public DrawableIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DrawableIndicator(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2110R.styleable.DrawableIndicator);
        if (typedArrayObtainStyledAttributes != null) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) typedArrayObtainStyledAttributes.getDrawable(C2110R.styleable.DrawableIndicator_normal_drawable);
            BitmapDrawable bitmapDrawable2 = (BitmapDrawable) typedArrayObtainStyledAttributes.getDrawable(C2110R.styleable.DrawableIndicator_selected_drawable);
            this.normalBitmap = bitmapDrawable.getBitmap();
            this.selectedBitmap = bitmapDrawable2.getBitmap();
        }
    }
}
