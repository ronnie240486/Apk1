package androidx.leanback.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class ScaleFrameLayout extends FrameLayout {

    public float f2220a;

    public float f2221b;

    public float f2222c;

    public ScaleFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override
    public final void addView(View view, int i6, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i6, layoutParams);
        view.setScaleX(this.f2222c);
        view.setScaleY(this.f2222c);
    }

    @Override
    public final boolean addViewInLayout(View view, int i6, ViewGroup.LayoutParams layoutParams, boolean z7) {
        boolean zAddViewInLayout = super.addViewInLayout(view, i6, layoutParams, z7);
        if (zAddViewInLayout) {
            view.setScaleX(this.f2222c);
            view.setScaleY(this.f2222c);
        }
        return zAddViewInLayout;
    }

    @Override
    public final void onLayout(boolean z7, int i6, int i10, int i11, int i12) {
        int paddingLeft;
        int i13;
        int paddingRight;
        int paddingTop;
        int i14;
        int paddingBottom;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        ScaleFrameLayout scaleFrameLayout = this;
        int childCount = getChildCount();
        int layoutDirection = getLayoutDirection();
        float width = layoutDirection == 1 ? getWidth() - getPivotX() : getPivotX();
        if (scaleFrameLayout.f2220a != 1.0f) {
            int paddingLeft2 = getPaddingLeft();
            float f = scaleFrameLayout.f2220a;
            paddingLeft = paddingLeft2 + ((int) ((width - (width / f)) + 0.5f));
            i13 = (int) ((((i11 - i6) - width) / f) + width + 0.5f);
            paddingRight = getPaddingRight();
        } else {
            paddingLeft = getPaddingLeft();
            i13 = i11 - i6;
            paddingRight = getPaddingRight();
        }
        int i21 = i13 - paddingRight;
        float pivotY = getPivotY();
        if (scaleFrameLayout.f2221b != 1.0f) {
            int paddingTop2 = getPaddingTop();
            float f3 = scaleFrameLayout.f2221b;
            paddingTop = paddingTop2 + ((int) ((pivotY - (pivotY / f3)) + 0.5f));
            i14 = (int) ((((i12 - i10) - pivotY) / f3) + pivotY + 0.5f);
            paddingBottom = getPaddingBottom();
        } else {
            paddingTop = getPaddingTop();
            i14 = i12 - i10;
            paddingBottom = getPaddingBottom();
        }
        int i22 = i14 - paddingBottom;
        int i23 = 0;
        while (i23 < childCount) {
            View childAt = scaleFrameLayout.getChildAt(i23);
            if (childAt.getVisibility() != 8) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i24 = layoutParams.gravity;
                if (i24 == -1) {
                    i24 = 8388659;
                }
                int absoluteGravity = Gravity.getAbsoluteGravity(i24, layoutDirection);
                int i25 = i24 & 112;
                int i26 = absoluteGravity & 7;
                if (i26 != 1) {
                    if (i26 != 5) {
                        i17 = layoutParams.leftMargin + paddingLeft;
                    } else {
                        i15 = i21 - measuredWidth;
                        i16 = layoutParams.rightMargin;
                    }
                    if (i25 == 16) {
                        i18 = (((i22 - paddingTop) - measuredHeight) / 2) + paddingTop + layoutParams.topMargin;
                        i19 = layoutParams.bottomMargin;
                    } else if (i25 == 48 && i25 == 80) {
                        i18 = i22 - measuredHeight;
                        i19 = layoutParams.bottomMargin;
                    } else {
                        i20 = i + paddingTop;
                        childAt.layout(i17, i20, measuredWidth + i17, measuredHeight + i20);
                        childAt.setPivotX(width - i17);
                        childAt.setPivotY(pivotY - i20);
                    }
                    i20 = i18 - i19;
                    childAt.layout(i17, i20, measuredWidth + i17, measuredHeight + i20);
                    childAt.setPivotX(width - i17);
                    childAt.setPivotY(pivotY - i20);
                } else {
                    i15 = (((i21 - paddingLeft) - measuredWidth) / 2) + paddingLeft + layoutParams.leftMargin;
                    i16 = layoutParams.rightMargin;
                }
                i17 = i15 - i16;
                if (i25 == 16) {
                    int i27 = i25 == 48 ? layoutParams.topMargin : layoutParams.topMargin;
                    i20 = i27 + paddingTop;
                    childAt.layout(i17, i20, measuredWidth + i17, measuredHeight + i20);
                    childAt.setPivotX(width - i17);
                    childAt.setPivotY(pivotY - i20);
                } else {
                    i18 = (((i22 - paddingTop) - measuredHeight) / 2) + paddingTop + layoutParams.topMargin;
                    i19 = layoutParams.bottomMargin;
                }
                i20 = i18 - i19;
                childAt.layout(i17, i20, measuredWidth + i17, measuredHeight + i20);
                childAt.setPivotX(width - i17);
                childAt.setPivotY(pivotY - i20);
            }
            i23++;
            scaleFrameLayout = this;
        }
    }

    @Override
    public final void onMeasure(int i6, int i10) {
        float f = this.f2220a;
        if (f == 1.0f && this.f2221b == 1.0f) {
            super.onMeasure(i6, i10);
            return;
        }
        if (f != 1.0f) {
            i6 = View.MeasureSpec.makeMeasureSpec((int) ((View.MeasureSpec.getSize(i6) / f) + 0.5f), View.MeasureSpec.getMode(i6));
        }
        float f3 = this.f2221b;
        if (f3 != 1.0f) {
            i10 = View.MeasureSpec.makeMeasureSpec((int) ((View.MeasureSpec.getSize(i10) / f3) + 0.5f), View.MeasureSpec.getMode(i10));
        }
        super.onMeasure(i6, i10);
        setMeasuredDimension((int) ((getMeasuredWidth() * this.f2220a) + 0.5f), (int) ((getMeasuredHeight() * this.f2221b) + 0.5f));
    }

    public void setChildScale(float f) {
        if (this.f2222c != f) {
            this.f2222c = f;
            for (int i6 = 0; i6 < getChildCount(); i6++) {
                getChildAt(i6).setScaleX(f);
                getChildAt(i6).setScaleY(f);
            }
        }
    }

    @Override
    public void setForeground(Drawable drawable) {
        throw new UnsupportedOperationException();
    }

    public void setLayoutScaleX(float f) {
        if (f != this.f2220a) {
            this.f2220a = f;
            requestLayout();
        }
    }

    public void setLayoutScaleY(float f) {
        if (f != this.f2221b) {
            this.f2221b = f;
            requestLayout();
        }
    }

    public ScaleFrameLayout(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f2220a = 1.0f;
        this.f2221b = 1.0f;
        this.f2222c = 1.0f;
    }
}
