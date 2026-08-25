package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.p2serv.android.p032ds.R;
import java.util.WeakHashMap;
import p138n0.AbstractC3155s0;
import p250x5.AbstractC4121a;

public class FlowLayout extends ViewGroup {

    public int f6323a;

    public int f6324b;

    public boolean f6325c;

    public int f6326d;

    public FlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public boolean mo4164a() {
        return this.f6325c;
    }

    public int getItemSpacing() {
        return this.f6324b;
    }

    public int getLineSpacing() {
        return this.f6323a;
    }

    public int getRowCount() {
        return this.f6326d;
    }

    @Override
    public final void onLayout(boolean z7, int i6, int i10, int i11, int i12) {
        int marginEnd;
        int marginStart;
        if (getChildCount() == 0) {
            this.f6326d = 0;
            return;
        }
        this.f6326d = 1;
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        boolean z10 = getLayoutDirection() == 1;
        int paddingRight = z10 ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = z10 ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int i13 = (i11 - i6) - paddingLeft;
        int measuredWidth = paddingRight;
        int i14 = paddingTop;
        for (int i15 = 0; i15 < getChildCount(); i15++) {
            View childAt = getChildAt(i15);
            if (childAt.getVisibility() == 8) {
                childAt.setTag(R.id.row_index_key, -1);
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    marginStart = marginLayoutParams.getMarginStart();
                    marginEnd = marginLayoutParams.getMarginEnd();
                } else {
                    marginEnd = 0;
                    marginStart = 0;
                }
                int measuredWidth2 = childAt.getMeasuredWidth() + measuredWidth + marginStart;
                if (!this.f6325c && measuredWidth2 > i13) {
                    i14 = this.f6323a + paddingTop;
                    this.f6326d++;
                    measuredWidth = paddingRight;
                }
                childAt.setTag(R.id.row_index_key, Integer.valueOf(this.f6326d - 1));
                int i16 = measuredWidth + marginStart;
                int measuredWidth3 = childAt.getMeasuredWidth() + i16;
                int measuredHeight = childAt.getMeasuredHeight() + i14;
                if (z10) {
                    childAt.layout(i13 - measuredWidth3, i14, (i13 - measuredWidth) - marginStart, measuredHeight);
                } else {
                    childAt.layout(i16, i14, measuredWidth3, measuredHeight);
                }
                measuredWidth += childAt.getMeasuredWidth() + marginStart + marginEnd + this.f6324b;
                paddingTop = measuredHeight;
            }
        }
    }

    @Override
    public final void onMeasure(int i6, int i10) {
        int i11;
        int i12;
        int i13;
        int paddingLeft;
        int size = View.MeasureSpec.getSize(i6);
        int mode = View.MeasureSpec.getMode(i6);
        int size2 = View.MeasureSpec.getSize(i10);
        int mode2 = View.MeasureSpec.getMode(i10);
        int i14 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : Integer.MAX_VALUE;
        int paddingLeft2 = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = i14 - getPaddingRight();
        int i15 = paddingTop;
        int i16 = 0;
        for (int i17 = 0; i17 < getChildCount(); i17++) {
            View childAt = getChildAt(i17);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i6, i10);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i13 = marginLayoutParams.leftMargin;
                    i12 = marginLayoutParams.rightMargin;
                } else {
                    i12 = 0;
                    i13 = 0;
                }
                int i18 = paddingLeft2;
                if (childAt.getMeasuredWidth() + paddingLeft2 + i13 <= paddingRight || mo4164a()) {
                    paddingLeft = i18;
                } else {
                    paddingLeft = getPaddingLeft();
                    i15 = this.f6323a + paddingTop;
                }
                int measuredWidth = childAt.getMeasuredWidth() + paddingLeft + i13;
                int measuredHeight = childAt.getMeasuredHeight() + i15;
                if (measuredWidth > i16) {
                    i16 = measuredWidth;
                }
                int measuredWidth2 = childAt.getMeasuredWidth() + i13 + i12 + this.f6324b + paddingLeft;
                if (i17 == getChildCount() - 1) {
                    i16 += i12;
                }
                paddingLeft2 = measuredWidth2;
                paddingTop = measuredHeight;
            }
        }
        int paddingRight2 = getPaddingRight() + i16;
        int paddingBottom = getPaddingBottom() + paddingTop;
        if (mode != Integer.MIN_VALUE) {
            i11 = 1073741824;
            if (mode != 1073741824) {
                size = paddingRight2;
            }
        } else {
            i11 = 1073741824;
            size = Math.min(paddingRight2, size);
        }
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(paddingBottom, size2);
        } else if (mode2 != i11) {
            size2 = paddingBottom;
        }
        setMeasuredDimension(size, size2);
    }

    public void setItemSpacing(int i6) {
        this.f6324b = i6;
    }

    public void setLineSpacing(int i6) {
        this.f6323a = i6;
    }

    public void setSingleLine(boolean z7) {
        this.f6325c = z7;
    }

    public FlowLayout(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f6325c = false;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, AbstractC4121a.f14006t, 0, 0);
        this.f6323a = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.f6324b = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        typedArrayObtainStyledAttributes.recycle();
    }
}
