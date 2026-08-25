package p167p6;

import android.view.View;
import com.google.android.material.navigation.AbstractC1844d;
import com.p2serv.android.p032ds.R;

public final class C3373a extends AbstractC1844d {
    @Override
    public final int getItemDefaultMarginResId() {
        return R.dimen.mtrl_navigation_rail_icon_margin;
    }

    @Override
    public final int getItemLayoutResId() {
        return R.layout.mtrl_navigation_rail_item;
    }

    @Override
    public final void onMeasure(int i6, int i10) {
        super.onMeasure(i6, i10);
        if (View.MeasureSpec.getMode(i10) == 0) {
            setMeasuredDimension(getMeasuredWidthAndState(), View.resolveSizeAndState(Math.max(getMeasuredHeight(), View.MeasureSpec.getSize(i10)), i10, 0));
        }
    }
}
