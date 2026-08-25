package com.google.android.material.datepicker;

import android.view.ContextThemeWrapper;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import androidx.recyclerview.widget.AbstractC1158k0;
import androidx.recyclerview.widget.AbstractC1174p1;
import androidx.recyclerview.widget.RecyclerView;
import com.p2serv.android.p032ds.R;
import java.util.Calendar;
import java.util.Iterator;
import p000a.AbstractC0004e;

public final class C1775a0 extends AbstractC1158k0 {

    public final CalendarConstraints f6142a;

    public final DateSelector f6143b;

    public final C1797n f6144c;

    public final int f6145d;

    public C1775a0(ContextThemeWrapper contextThemeWrapper, DateSelector dateSelector, CalendarConstraints calendarConstraints, C1797n c1797n) {
        Month month = calendarConstraints.f6115a;
        Month month2 = calendarConstraints.f6118d;
        if (month.compareTo(month2) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (month2.compareTo(calendarConstraints.f6116b) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        this.f6145d = (contextThemeWrapper.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height) * C1807x.f6239f) + (C1804u.m4205V(contextThemeWrapper, android.R.attr.windowFullscreen) ? contextThemeWrapper.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height) : 0);
        this.f6142a = calendarConstraints;
        this.f6143b = dateSelector;
        this.f6144c = c1797n;
        setHasStableIds(true);
    }

    @Override
    public final int getItemCount() {
        return this.f6142a.f6120f;
    }

    @Override
    public final long getItemId(int i6) {
        Calendar calendarM4194c = AbstractC1787g0.m4194c(this.f6142a.f6115a.f6129a);
        calendarM4194c.add(2, i6);
        return new Month(calendarM4194c).f6129a.getTimeInMillis();
    }

    @Override
    public final void onBindViewHolder(AbstractC1174p1 abstractC1174p1, int i6) {
        C1809z c1809z = (C1809z) abstractC1174p1;
        CalendarConstraints calendarConstraints = this.f6142a;
        Calendar calendarM4194c = AbstractC1787g0.m4194c(calendarConstraints.f6115a.f6129a);
        calendarM4194c.add(2, i6);
        Month month = new Month(calendarM4194c);
        c1809z.f6247a.setText(month.m4185o());
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) c1809z.f6248b.findViewById(R.id.month_grid);
        if (materialCalendarGridView.m4178a() == null || !month.equals(materialCalendarGridView.m4178a().f6240a)) {
            C1807x c1807x = new C1807x(month, this.f6143b, calendarConstraints);
            materialCalendarGridView.setNumColumns(month.f6132d);
            materialCalendarGridView.setAdapter((ListAdapter) c1807x);
        } else {
            materialCalendarGridView.invalidate();
            C1807x c1807xM4178a = materialCalendarGridView.m4178a();
            Iterator it = c1807xM4178a.f6242c.iterator();
            while (it.hasNext()) {
                c1807xM4178a.m4213d(materialCalendarGridView, ((Long) it.next()).longValue());
            }
            DateSelector dateSelector = c1807xM4178a.f6241b;
            if (dateSelector != null) {
                Iterator it2 = dateSelector.mo4175g().iterator();
                while (it2.hasNext()) {
                    c1807xM4178a.m4213d(materialCalendarGridView, ((Long) it2.next()).longValue());
                }
                c1807xM4178a.f6242c = dateSelector.mo4175g();
            }
        }
        materialCalendarGridView.setOnItemClickListener(new C1808y(this, materialCalendarGridView));
    }

    @Override
    public final AbstractC1174p1 onCreateViewHolder(ViewGroup viewGroup, int i6) {
        LinearLayout linearLayout = (LinearLayout) AbstractC0004e.m15i(viewGroup, R.layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (!C1804u.m4205V(viewGroup.getContext(), android.R.attr.windowFullscreen)) {
            return new C1809z(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, this.f6145d));
        return new C1809z(linearLayout, true);
    }
}
