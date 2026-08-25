package com.google.android.material.datepicker;

import androidx.recyclerview.widget.AbstractC1128b1;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;

public final class C1799p extends AbstractC1128b1 {

    public final C1775a0 f6193a;

    public final MaterialButton f6194b;

    public final C1801r f6195c;

    public C1799p(C1801r c1801r, C1775a0 c1775a0, MaterialButton materialButton) {
        this.f6195c = c1801r;
        this.f6193a = c1775a0;
        this.f6194b = materialButton;
    }

    @Override
    public final void onScrollStateChanged(RecyclerView recyclerView, int i6) {
        if (i6 == 0) {
            recyclerView.announceForAccessibility(this.f6194b.getText());
        }
    }

    @Override
    public final void onScrolled(RecyclerView recyclerView, int i6, int i10) {
        C1801r c1801r = this.f6195c;
        int iFindFirstVisibleItemPosition = i6 < 0 ? ((LinearLayoutManager) c1801r.f6206c0.getLayoutManager()).findFirstVisibleItemPosition() : ((LinearLayoutManager) c1801r.f6206c0.getLayoutManager()).findLastVisibleItemPosition();
        CalendarConstraints calendarConstraints = this.f6193a.f6142a;
        Calendar calendarM4194c = AbstractC1787g0.m4194c(calendarConstraints.f6115a.f6129a);
        calendarM4194c.add(2, iFindFirstVisibleItemPosition);
        c1801r.f6202X = new Month(calendarM4194c);
        Calendar calendarM4194c2 = AbstractC1787g0.m4194c(calendarConstraints.f6115a.f6129a);
        calendarM4194c2.add(2, iFindFirstVisibleItemPosition);
        this.f6194b.setText(new Month(calendarM4194c2).m4185o());
    }
}
