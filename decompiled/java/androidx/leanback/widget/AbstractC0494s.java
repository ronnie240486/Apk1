package androidx.leanback.widget;

import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.C1123a0;
import androidx.recyclerview.widget.C1153i1;
import androidx.recyclerview.widget.C1162l1;

public abstract class AbstractC0494s extends C1123a0 {

    public boolean f2434a;

    public final GridLayoutManager f2435b;

    public AbstractC0494s(GridLayoutManager gridLayoutManager) {
        super(gridLayoutManager.f2108c.getContext());
        this.f2435b = gridLayoutManager;
    }

    public void mo1473a() {
        View viewFindViewByPosition = findViewByPosition(getTargetPosition());
        GridLayoutManager gridLayoutManager = this.f2435b;
        if (viewFindViewByPosition == null) {
            if (getTargetPosition() >= 0) {
                gridLayoutManager.m1354F(getTargetPosition(), false);
                return;
            }
            return;
        }
        if (gridLayoutManager.f2121p != getTargetPosition()) {
            gridLayoutManager.f2121p = getTargetPosition();
        }
        if (gridLayoutManager.hasFocus()) {
            gridLayoutManager.f2119n |= 32;
            viewFindViewByPosition.requestFocus();
            gridLayoutManager.f2119n &= -33;
        }
        gridLayoutManager.m1366e();
        gridLayoutManager.m1367f();
    }

    @Override
    public final float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
        return super.calculateSpeedPerPixel(displayMetrics) * this.f2435b.f2106a;
    }

    @Override
    public final int calculateTimeForScrolling(int i6) {
        int iCalculateTimeForScrolling = super.calculateTimeForScrolling(i6);
        int i10 = ((C0479k1) this.f2435b.f2097I.f46d).f2362i;
        if (i10 <= 0) {
            return iCalculateTimeForScrolling;
        }
        float f = (30.0f / i10) * i6;
        return ((float) iCalculateTimeForScrolling) < f ? (int) f : iCalculateTimeForScrolling;
    }

    @Override
    public final void onStop() {
        super.onStop();
        if (!this.f2434a) {
            mo1473a();
        }
        GridLayoutManager gridLayoutManager = this.f2435b;
        if (gridLayoutManager.f2122q == this) {
            gridLayoutManager.f2122q = null;
        }
        if (gridLayoutManager.f2123r == this) {
            gridLayoutManager.f2123r = null;
        }
    }

    @Override
    public final void onTargetFound(View view, C1162l1 c1162l1, C1153i1 c1153i1) {
        int i6;
        int i10;
        int[] iArr = GridLayoutManager.f2088S;
        GridLayoutManager gridLayoutManager = this.f2435b;
        if (gridLayoutManager.m1374n(view, null, iArr)) {
            if (gridLayoutManager.f2109d == 0) {
                i6 = iArr[0];
                i10 = iArr[1];
            } else {
                i6 = iArr[1];
                i10 = iArr[0];
            }
            c1153i1.m2951b(i6, i10, this.mDecelerateInterpolator, calculateTimeForDeceleration((int) Math.sqrt((i10 * i10) + (i6 * i6))));
        }
    }
}
