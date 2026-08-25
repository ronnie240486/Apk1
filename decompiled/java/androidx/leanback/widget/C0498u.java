package androidx.leanback.widget;

import android.graphics.PointF;
import android.view.View;

public final class C0498u extends AbstractC0494s {

    public final boolean f2444c;

    public int f2445d;

    public final GridLayoutManager f2446e;

    public C0498u(GridLayoutManager gridLayoutManager, int i6, boolean z7) {
        super(gridLayoutManager);
        this.f2446e = gridLayoutManager;
        this.f2445d = i6;
        this.f2444c = z7;
        setTargetPosition(-2);
    }

    @Override
    public final void mo1473a() {
        super.mo1473a();
        this.f2445d = 0;
        View viewFindViewByPosition = findViewByPosition(getTargetPosition());
        if (viewFindViewByPosition != null) {
            this.f2446e.m1356H(viewFindViewByPosition, true);
        }
    }

    @Override
    public final PointF computeScrollVectorForPosition(int i6) {
        int i10 = this.f2445d;
        if (i10 == 0) {
            return null;
        }
        GridLayoutManager gridLayoutManager = this.f2446e;
        int i11 = ((gridLayoutManager.f2119n & 262144) == 0 ? i10 >= 0 : i10 <= 0) ? 1 : -1;
        return gridLayoutManager.f2109d == 0 ? new PointF(i11, 0.0f) : new PointF(0.0f, i11);
    }
}
