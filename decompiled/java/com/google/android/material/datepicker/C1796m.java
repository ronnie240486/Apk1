package com.google.android.material.datepicker;

import androidx.recyclerview.widget.C1162l1;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public final class C1796m extends LinearLayoutManager {

    public final int f6187a;

    public final C1801r f6188b;

    public C1796m(C1801r c1801r, int i6, int i10) {
        super(i6);
        this.f6188b = c1801r;
        this.f6187a = i10;
    }

    @Override
    public final void calculateExtraLayoutSpace(C1162l1 c1162l1, int[] iArr) {
        int i6 = this.f6187a;
        C1801r c1801r = this.f6188b;
        if (i6 == 0) {
            iArr[0] = c1801r.f6206c0.getWidth();
            iArr[1] = c1801r.f6206c0.getWidth();
        } else {
            iArr[0] = c1801r.f6206c0.getHeight();
            iArr[1] = c1801r.f6206c0.getHeight();
        }
    }

    @Override
    public final void smoothScrollToPosition(RecyclerView recyclerView, C1162l1 c1162l1, int i6) {
        C1783e0 c1783e0 = new C1783e0(recyclerView.getContext());
        c1783e0.setTargetPosition(i6);
        startSmoothScroll(c1783e0);
    }
}
