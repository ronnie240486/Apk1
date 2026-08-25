package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.p2serv.android.p032ds.R;
import java.util.WeakHashMap;
import p045e.AbstractC2341a;
import p138n0.AbstractC3155s0;

public class ButtonBarLayout extends LinearLayout {

    public boolean f662a;

    public boolean f663b;

    public int f664c;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f664c = -1;
        int[] iArr = AbstractC2341a.f8164l;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        AbstractC3155s0.m6346p(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, 0, 0);
        this.f662a = typedArrayObtainStyledAttributes.getBoolean(0, true);
        typedArrayObtainStyledAttributes.recycle();
        if (getOrientation() == 1) {
            setStacked(this.f662a);
        }
    }

    private void setStacked(boolean z7) {
        if (this.f663b != z7) {
            if (!z7 || this.f662a) {
                this.f663b = z7;
                setOrientation(z7 ? 1 : 0);
                setGravity(z7 ? 8388613 : 80);
                View viewFindViewById = findViewById(R.id.spacer);
                if (viewFindViewById != null) {
                    viewFindViewById.setVisibility(z7 ? 8 : 4);
                }
                for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
                    bringChildToFront(getChildAt(childCount));
                }
            }
        }
    }

    @Override
    public final void onMeasure(int i6, int i10) {
        int iMakeMeasureSpec;
        boolean z7;
        int i11;
        int size = View.MeasureSpec.getSize(i6);
        int paddingBottom = 0;
        if (this.f662a) {
            if (size > this.f664c && this.f663b) {
                setStacked(false);
            }
            this.f664c = size;
        }
        if (this.f663b || View.MeasureSpec.getMode(i6) != 1073741824) {
            iMakeMeasureSpec = i6;
            z7 = false;
        } else {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            z7 = true;
        }
        super.onMeasure(iMakeMeasureSpec, i10);
        if (this.f662a && !this.f663b && (getMeasuredWidthAndState() & (-16777216)) == 16777216) {
            setStacked(true);
            z7 = true;
        }
        if (z7) {
            super.onMeasure(i6, i10);
        }
        int childCount = getChildCount();
        int i12 = 0;
        while (true) {
            i11 = -1;
            if (i12 >= childCount) {
                i12 = -1;
                break;
            } else if (getChildAt(i12).getVisibility() == 0) {
                break;
            } else {
                i12++;
            }
        }
        if (i12 >= 0) {
            View childAt = getChildAt(i12);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + getPaddingTop() + layoutParams.topMargin + layoutParams.bottomMargin;
            if (this.f663b) {
                int childCount2 = getChildCount();
                for (int i13 = i12 + 1; i13 < childCount2; i13++) {
                    if (getChildAt(i13).getVisibility() == 0) {
                        i11 = i13;
                        break;
                    }
                }
                paddingBottom = i11 >= 0 ? getChildAt(i11).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f)) + measuredHeight : measuredHeight;
            } else {
                paddingBottom = getPaddingBottom() + measuredHeight;
            }
        }
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        if (getMinimumHeight() != paddingBottom) {
            setMinimumHeight(paddingBottom);
            if (i10 == 0) {
                super.onMeasure(i6, i10);
            }
        }
    }

    public void setAllowStacking(boolean z7) {
        if (this.f662a != z7) {
            this.f662a = z7;
            if (!z7 && this.f663b) {
                setStacked(false);
            }
            requestLayout();
        }
    }
}
