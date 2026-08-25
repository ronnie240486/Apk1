package androidx.constraintlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class Guideline extends View {
    public Guideline(Context context) {
        super(context);
        super.setVisibility(8);
    }

    @Override
    public final void onMeasure(int i6, int i10) {
        setMeasuredDimension(0, 0);
    }

    public void setGuidelineBegin(int i6) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.f1341a = i6;
        setLayoutParams(layoutParams);
    }

    public void setGuidelineEnd(int i6) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.f1343b = i6;
        setLayoutParams(layoutParams);
    }

    public void setGuidelinePercent(float f) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.f1345c = f;
        setLayoutParams(layoutParams);
    }

    public Guideline(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }

    public Guideline(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        super.setVisibility(8);
    }

    @Override
    public final void draw(Canvas canvas) {
    }

    @Override
    public void setVisibility(int i6) {
    }
}
