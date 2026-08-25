package com.google.android.material.datepicker;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.Calendar;

public final class ViewOnClickListenerC1800q implements View.OnClickListener {

    public final int f6196a;

    public final C1775a0 f6197b;

    public final C1801r f6198c;

    public ViewOnClickListenerC1800q(C1801r c1801r, C1775a0 c1775a0, int i6) {
        this.f6196a = i6;
        this.f6198c = c1801r;
        this.f6197b = c1775a0;
    }

    @Override
    public final void onClick(View view) {
        switch (this.f6196a) {
            case 0:
                C1801r c1801r = this.f6198c;
                int iFindFirstVisibleItemPosition = ((LinearLayoutManager) c1801r.f6206c0.getLayoutManager()).findFirstVisibleItemPosition() + 1;
                if (iFindFirstVisibleItemPosition < c1801r.f6206c0.getAdapter().getItemCount()) {
                    Calendar calendarM4194c = AbstractC1787g0.m4194c(this.f6197b.f6142a.f6115a.f6129a);
                    calendarM4194c.add(2, iFindFirstVisibleItemPosition);
                    c1801r.m4200R(new Month(calendarM4194c));
                }
                break;
            default:
                C1801r c1801r2 = this.f6198c;
                int iFindLastVisibleItemPosition = ((LinearLayoutManager) c1801r2.f6206c0.getLayoutManager()).findLastVisibleItemPosition() - 1;
                if (iFindLastVisibleItemPosition >= 0) {
                    Calendar calendarM4194c2 = AbstractC1787g0.m4194c(this.f6197b.f6142a.f6115a.f6129a);
                    calendarM4194c2.add(2, iFindLastVisibleItemPosition);
                    c1801r2.m4200R(new Month(calendarM4194c2));
                }
                break;
        }
    }
}
