package p167p6;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.navigation.AbstractC1844d;
import com.google.android.material.navigation.AbstractC1846f;

public final class C3374b extends AbstractC1846f {

    public int f11401E;

    public final FrameLayout.LayoutParams f11402F;

    public C3374b(Context context) {
        super(context);
        this.f11401E = -1;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        this.f11402F = layoutParams;
        layoutParams.gravity = 49;
        setLayoutParams(layoutParams);
        setItemActiveIndicatorResizeable(true);
    }

    @Override
    public final AbstractC1844d mo3208e(Context context) {
        return new C3373a(context);
    }

    public final int m6867g(int i6, int i10, int i11) {
        int iMax = i10 / Math.max(1, i11);
        int size = this.f11401E;
        if (size == -1) {
            size = View.MeasureSpec.getSize(i6);
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(size, iMax), 0);
    }

    public int getItemMinimumHeight() {
        return this.f11401E;
    }

    public int getMenuGravity() {
        return this.f11402F.gravity;
    }

    public final int m6868h(int i6, int i10, int i11, View view) {
        int measuredHeight;
        m6867g(i6, i10, i11);
        int iM6867g = view == null ? m6867g(i6, i10, i11) : View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 0);
        int childCount = getChildCount();
        int i12 = 0;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt != view) {
                if (childAt.getVisibility() != 8) {
                    childAt.measure(i6, iM6867g);
                    measuredHeight = childAt.getMeasuredHeight();
                } else {
                    measuredHeight = 0;
                }
                i12 += measuredHeight;
            }
        }
        return i12;
    }

    @Override
    public final void onLayout(boolean z7, int i6, int i10, int i11, int i12) {
        int childCount = getChildCount();
        int i13 = i11 - i6;
        int i14 = 0;
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            if (childAt.getVisibility() != 8) {
                int measuredHeight = childAt.getMeasuredHeight() + i14;
                childAt.layout(0, i14, i13, measuredHeight);
                i14 = measuredHeight;
            }
        }
    }

    @Override
    public final void onMeasure(int i6, int i10) {
        int iM6868h;
        int measuredHeight;
        int size = View.MeasureSpec.getSize(i10);
        int size2 = getMenu().m5831l().size();
        if (size2 <= 1 || !AbstractC1846f.m4298f(getLabelVisibilityMode(), size2)) {
            iM6868h = m6868h(i6, size, size2, null);
        } else {
            View childAt = getChildAt(getSelectedItemPosition());
            if (childAt != null) {
                int iM6867g = m6867g(i6, size, size2);
                if (childAt.getVisibility() != 8) {
                    childAt.measure(i6, iM6867g);
                    measuredHeight = childAt.getMeasuredHeight();
                } else {
                    measuredHeight = 0;
                }
                size -= measuredHeight;
                size2--;
            } else {
                measuredHeight = 0;
            }
            iM6868h = m6868h(i6, size, size2, childAt) + measuredHeight;
        }
        setMeasuredDimension(View.resolveSizeAndState(View.MeasureSpec.getSize(i6), i6, 0), View.resolveSizeAndState(iM6868h, i10, 0));
    }

    public void setItemMinimumHeight(int i6) {
        if (this.f11401E != i6) {
            this.f11401E = i6;
            requestLayout();
        }
    }

    public void setMenuGravity(int i6) {
        FrameLayout.LayoutParams layoutParams = this.f11402F;
        if (layoutParams.gravity != i6) {
            layoutParams.gravity = i6;
            setLayoutParams(layoutParams);
        }
    }
}
