package com.youth.banner.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;

public class RoundLinesIndicator extends BaseIndicator {
    public RoundLinesIndicator(Context context) {
        this(context, null);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.config.getIndicatorSize() <= 1) {
            return;
        }
        this.mPaint.setColor(this.config.getNormalColor());
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, canvas.getWidth(), this.config.getHeight()), this.config.getRadius(), this.config.getRadius(), this.mPaint);
        this.mPaint.setColor(this.config.getSelectedColor());
        int selectedWidth = this.config.getSelectedWidth() * this.config.getCurrentPosition();
        canvas.drawRoundRect(new RectF(selectedWidth, 0.0f, this.config.getSelectedWidth() + selectedWidth, this.config.getHeight()), this.config.getRadius(), this.config.getRadius(), this.mPaint);
    }

    @Override
    public void onMeasure(int i6, int i10) {
        super.onMeasure(i6, i10);
        int indicatorSize = this.config.getIndicatorSize();
        if (indicatorSize <= 1) {
            return;
        }
        setMeasuredDimension(this.config.getSelectedWidth() * indicatorSize, this.config.getHeight());
    }

    public RoundLinesIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundLinesIndicator(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.mPaint.setStyle(Paint.Style.FILL);
    }
}
