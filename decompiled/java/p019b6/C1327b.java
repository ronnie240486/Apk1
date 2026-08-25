package p019b6;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.navigation.AbstractC1844d;
import com.google.android.material.navigation.AbstractC1846f;
import com.p2serv.android.p032ds.R;
import java.util.WeakHashMap;
import p105k.MenuC2838l;
import p138n0.AbstractC3155s0;

public final class C1327b extends AbstractC1846f {

    public final int f4132E;

    public final int f4133F;

    public final int f4134G;

    public final int f4135H;

    public boolean f4136I;

    public final int[] f4137J;

    public C1327b(Context context) {
        super(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
        Resources resources = getResources();
        this.f4132E = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_max_width);
        this.f4133F = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_min_width);
        this.f4134G = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_max_width);
        this.f4135H = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_min_width);
        this.f4137J = new int[5];
    }

    @Override
    public final AbstractC1844d mo3208e(Context context) {
        return new C1326a(context);
    }

    @Override
    public final void onLayout(boolean z7, int i6, int i10, int i11, int i12) {
        int childCount = getChildCount();
        int i13 = i11 - i6;
        int i14 = i12 - i10;
        int measuredWidth = 0;
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            if (childAt.getVisibility() != 8) {
                WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                if (getLayoutDirection() == 1) {
                    int i16 = i13 - measuredWidth;
                    childAt.layout(i16 - childAt.getMeasuredWidth(), 0, i16, i14);
                } else {
                    childAt.layout(measuredWidth, 0, childAt.getMeasuredWidth() + measuredWidth, i14);
                }
                measuredWidth += childAt.getMeasuredWidth();
            }
        }
    }

    @Override
    public final void onMeasure(int i6, int i10) {
        MenuC2838l menu = getMenu();
        int size = View.MeasureSpec.getSize(i6);
        int size2 = menu.m5831l().size();
        int childCount = getChildCount();
        int size3 = View.MeasureSpec.getSize(i10);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size3, 1073741824);
        boolean zM4298f = AbstractC1846f.m4298f(getLabelVisibilityMode(), size2);
        int[] iArr = this.f4137J;
        int i11 = this.f4134G;
        if (zM4298f && this.f4136I) {
            View childAt = getChildAt(getSelectedItemPosition());
            int visibility = childAt.getVisibility();
            int iMax = this.f4135H;
            if (visibility != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i11, Integer.MIN_VALUE), iMakeMeasureSpec);
                iMax = Math.max(iMax, childAt.getMeasuredWidth());
            }
            int i12 = size2 - (childAt.getVisibility() != 8 ? 1 : 0);
            int iMin = Math.min(size - (this.f4133F * i12), Math.min(iMax, i11));
            int i13 = size - iMin;
            int iMin2 = Math.min(i13 / (i12 != 0 ? i12 : 1), this.f4132E);
            int i14 = i13 - (i12 * iMin2);
            int i15 = 0;
            while (i15 < childCount) {
                if (getChildAt(i15).getVisibility() != 8) {
                    int i16 = i15 == getSelectedItemPosition() ? iMin : iMin2;
                    iArr[i15] = i16;
                    if (i14 > 0) {
                        iArr[i15] = i16 + 1;
                        i14--;
                    }
                } else {
                    iArr[i15] = 0;
                }
                i15++;
            }
        } else {
            int iMin3 = Math.min(size / (size2 != 0 ? size2 : 1), i11);
            int i17 = size - (size2 * iMin3);
            for (int i18 = 0; i18 < childCount; i18++) {
                if (getChildAt(i18).getVisibility() != 8) {
                    iArr[i18] = iMin3;
                    if (i17 > 0) {
                        iArr[i18] = iMin3 + 1;
                        i17--;
                    }
                } else {
                    iArr[i18] = 0;
                }
            }
        }
        int measuredWidth = 0;
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt2 = getChildAt(i19);
            if (childAt2.getVisibility() != 8) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec(iArr[i19], 1073741824), iMakeMeasureSpec);
                childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                measuredWidth += childAt2.getMeasuredWidth();
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(measuredWidth, View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), 0), View.resolveSizeAndState(size3, i10, 0));
    }

    public void setItemHorizontalTranslationEnabled(boolean z7) {
        this.f4136I = z7;
    }
}
