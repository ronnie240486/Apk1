package com.google.android.material.datepicker;

import android.view.View;
import android.widget.AdapterView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Iterator;

public final class C1808y implements AdapterView.OnItemClickListener {

    public final MaterialCalendarGridView f6245a;

    public final C1775a0 f6246b;

    public C1808y(C1775a0 c1775a0, MaterialCalendarGridView materialCalendarGridView) {
        this.f6246b = c1775a0;
        this.f6245a = materialCalendarGridView;
    }

    @Override
    public final void onItemClick(AdapterView adapterView, View view, int i6, long j10) {
        MaterialCalendarGridView materialCalendarGridView = this.f6245a;
        C1807x c1807xM4178a = materialCalendarGridView.m4178a();
        if (i6 < c1807xM4178a.f6240a.m4183m() || i6 > c1807xM4178a.m4211b()) {
            return;
        }
        C1797n c1797n = this.f6246b.f6144c;
        long jLongValue = materialCalendarGridView.m4178a().getItem(i6).longValue();
        C1801r c1801r = c1797n.f6189a;
        if (c1801r.f6201W.f6117c.mo4169d(jLongValue)) {
            c1801r.f6200V.mo4177k(jLongValue);
            Iterator it = c1801r.f6149T.iterator();
            while (it.hasNext()) {
                ((C1803t) it.next()).m4203b(c1801r.f6200V.mo4176i());
            }
            c1801r.f6206c0.getAdapter().notifyDataSetChanged();
            RecyclerView recyclerView = c1801r.f6205b0;
            if (recyclerView != null) {
                recyclerView.getAdapter().notifyDataSetChanged();
            }
        }
    }
}
