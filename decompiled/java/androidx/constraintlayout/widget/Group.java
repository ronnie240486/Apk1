package androidx.constraintlayout.widget;

import android.content.Context;
import android.util.AttributeSet;

public class Group extends ConstraintHelper {
    public Group(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override
    public final void mo845j() {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.f1364l0.m7918z(0);
        layoutParams.f1364l0.m7915w(0);
    }

    @Override
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        m872c();
    }

    @Override
    public void setElevation(float f) {
        super.setElevation(f);
        m872c();
    }

    @Override
    public void setVisibility(int i6) {
        super.setVisibility(i6);
        m872c();
    }

    public Group(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
    }
}
