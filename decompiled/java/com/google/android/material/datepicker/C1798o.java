package com.google.android.material.datepicker;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.AbstractC1185t0;
import androidx.recyclerview.widget.C1162l1;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Calendar;
import p128m0.C3026b;

public final class C1798o extends AbstractC1185t0 {

    public final Calendar f6190a = AbstractC1787g0.m4199h(null);

    public final Calendar f6191b = AbstractC1787g0.m4199h(null);

    public final C1801r f6192c;

    public C1798o(C1801r c1801r) {
        this.f6192c = c1801r;
    }

    @Override
    public final void onDraw(Canvas canvas, RecyclerView recyclerView, C1162l1 c1162l1) {
        Object obj;
        if ((recyclerView.getAdapter() instanceof C1793j0) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
            C1793j0 c1793j0 = (C1793j0) recyclerView.getAdapter();
            GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
            C1801r c1801r = this.f6192c;
            for (C3026b c3026b : c1801r.f6200V.mo4172c()) {
                Object obj2 = c3026b.f10354a;
                if (obj2 != null && (obj = c3026b.f10355b) != null) {
                    long jLongValue = ((Long) obj2).longValue();
                    Calendar calendar = this.f6190a;
                    calendar.setTimeInMillis(jLongValue);
                    long jLongValue2 = ((Long) obj).longValue();
                    Calendar calendar2 = this.f6191b;
                    calendar2.setTimeInMillis(jLongValue2);
                    int i6 = calendar.get(1) - c1793j0.f6180a.f6201W.f6115a.f6131c;
                    int i10 = calendar2.get(1) - c1793j0.f6180a.f6201W.f6115a.f6131c;
                    View viewFindViewByPosition = gridLayoutManager.findViewByPosition(i6);
                    View viewFindViewByPosition2 = gridLayoutManager.findViewByPosition(i10);
                    int i11 = gridLayoutManager.f3446b;
                    int i12 = i6 / i11;
                    int i13 = i10 / i11;
                    int i14 = i12;
                    while (i14 <= i13) {
                        View viewFindViewByPosition3 = gridLayoutManager.findViewByPosition(gridLayoutManager.f3446b * i14);
                        if (viewFindViewByPosition3 != null) {
                            canvas.drawRect(i14 == i12 ? (viewFindViewByPosition.getWidth() / 2) + viewFindViewByPosition.getLeft() : 0, viewFindViewByPosition3.getTop() + ((Rect) c1801r.f6204Z.f6153d.f1070b).top, i14 == i13 ? (viewFindViewByPosition2.getWidth() / 2) + viewFindViewByPosition2.getLeft() : recyclerView.getWidth(), viewFindViewByPosition3.getBottom() - ((Rect) c1801r.f6204Z.f6153d.f1070b).bottom, c1801r.f6204Z.f6157h);
                        }
                        i14++;
                    }
                }
            }
        }
    }
}
