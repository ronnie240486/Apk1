package com.youth.banner.transformer;

import android.view.View;

public class RotateDownPageTransformer extends BasePageTransformer {
    private static final float DEFAULT_MAX_ROTATE = 15.0f;
    private float mMaxRotate;

    public RotateDownPageTransformer() {
        this.mMaxRotate = DEFAULT_MAX_ROTATE;
    }

    @Override
    public void transformPage(View view, float f) {
        if (f < -1.0f) {
            view.setRotation(this.mMaxRotate * (-1.0f));
            view.setPivotX(view.getWidth());
            view.setPivotY(view.getHeight());
            return;
        }
        if (f > 1.0f) {
            view.setRotation(this.mMaxRotate);
            view.getWidth();
            view.setPivotX(0);
            view.setPivotY(view.getHeight());
            return;
        }
        if (f < 0.0f) {
            view.setPivotX((((-f) * 0.5f) + 0.5f) * view.getWidth());
            view.setPivotY(view.getHeight());
            view.setRotation(this.mMaxRotate * f);
            return;
        }
        view.setPivotX((1.0f - f) * view.getWidth() * 0.5f);
        view.setPivotY(view.getHeight());
        view.setRotation(this.mMaxRotate * f);
    }

    public RotateDownPageTransformer(float f) {
        this.mMaxRotate = f;
    }
}
