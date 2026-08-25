package com.google.android.material.datepicker;

import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.C0275u;
import androidx.recyclerview.widget.AbstractC1158k0;
import androidx.recyclerview.widget.AbstractC1174p1;
import com.p2serv.android.p032ds.R;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;
import p000a.AbstractC0004e;

public final class C1793j0 extends AbstractC1158k0 {

    public final C1801r f6180a;

    public C1793j0(C1801r c1801r) {
        this.f6180a = c1801r;
    }

    @Override
    public final int getItemCount() {
        return this.f6180a.f6201W.f6119e;
    }

    @Override
    public final void onBindViewHolder(AbstractC1174p1 abstractC1174p1, int i6) {
        C1791i0 c1791i0 = (C1791i0) abstractC1174p1;
        C1801r c1801r = this.f6180a;
        int i10 = c1801r.f6201W.f6115a.f6131c + i6;
        String string = c1791i0.f6173a.getContext().getString(R.string.mtrl_picker_navigate_to_year_description);
        String str = String.format(Locale.getDefault(), "%d", Integer.valueOf(i10));
        TextView textView = c1791i0.f6173a;
        textView.setText(str);
        textView.setContentDescription(String.format(string, Integer.valueOf(i10)));
        C1778c c1778c = c1801r.f6204Z;
        Calendar calendarM4198g = AbstractC1787g0.m4198g();
        C0275u c0275u = calendarM4198g.get(1) == i10 ? c1778c.f6155f : c1778c.f6153d;
        Iterator it = c1801r.f6200V.mo4175g().iterator();
        while (it.hasNext()) {
            calendarM4198g.setTimeInMillis(((Long) it.next()).longValue());
            if (calendarM4198g.get(1) == i10) {
                c0275u = c1778c.f6154e;
            }
        }
        c0275u.m782k(textView);
        textView.setOnClickListener(new ViewOnClickListenerC1789h0(this, i10));
    }

    @Override
    public final AbstractC1174p1 onCreateViewHolder(ViewGroup viewGroup, int i6) {
        return new C1791i0((TextView) AbstractC0004e.m15i(viewGroup, R.layout.mtrl_calendar_year, viewGroup, false));
    }
}
