package androidx.leanback.widget;

import android.graphics.PointF;

public final class C0492r extends AbstractC0494s {

    public final GridLayoutManager f2432c;

    public C0492r(GridLayoutManager gridLayoutManager) {
        super(gridLayoutManager);
        this.f2432c = gridLayoutManager;
    }

    @Override
    public final PointF computeScrollVectorForPosition(int i6) {
        if (getChildCount() == 0) {
            return null;
        }
        GridLayoutManager gridLayoutManager = this.f2432c;
        int position = gridLayoutManager.getPosition(gridLayoutManager.getChildAt(0));
        int i10 = ((gridLayoutManager.f2119n & 262144) == 0 ? i6 >= position : i6 <= position) ? 1 : -1;
        return gridLayoutManager.f2109d == 0 ? new PointF(i10, 0.0f) : new PointF(0.0f, i10);
    }
}
