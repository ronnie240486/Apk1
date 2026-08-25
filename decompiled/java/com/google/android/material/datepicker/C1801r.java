package com.google.android.material.datepicker;

import android.R;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.appcompat.app.ViewOnClickListenerC0122a;
import androidx.core.widget.C0376i;
import androidx.recyclerview.widget.C1143f0;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import p015b2.C1256h;
import p138n0.AbstractC3155s0;

public final class C1801r<S> extends AbstractC1777b0 {

    public int f6199U;

    public DateSelector f6200V;

    public CalendarConstraints f6201W;

    public Month f6202X;

    public int f6203Y;

    public C1778c f6204Z;

    public RecyclerView f6205b0;

    public RecyclerView f6206c0;

    public View f6207d0;

    public View f6208e0;

    @Override
    public final void mo1269A(Bundle bundle) {
        bundle.putInt("THEME_RES_ID_KEY", this.f6199U);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.f6200V);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f6201W);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.f6202X);
    }

    @Override
    public final void mo4188Q(C1803t c1803t) {
        this.f6149T.add(c1803t);
    }

    public final void m4200R(Month month) {
        C1775a0 c1775a0 = (C1775a0) this.f6206c0.getAdapter();
        int iM4186p = c1775a0.f6142a.f6115a.m4186p(month);
        int iM4186p2 = iM4186p - c1775a0.f6142a.f6115a.m4186p(this.f6202X);
        boolean z7 = Math.abs(iM4186p2) > 3;
        boolean z10 = iM4186p2 > 0;
        this.f6202X = month;
        if (z7 && z10) {
            this.f6206c0.scrollToPosition(iM4186p - 3);
            this.f6206c0.post(new RunnableC1795l(this, iM4186p));
        } else if (!z7) {
            this.f6206c0.post(new RunnableC1795l(this, iM4186p));
        } else {
            this.f6206c0.scrollToPosition(iM4186p + 3);
            this.f6206c0.post(new RunnableC1795l(this, iM4186p));
        }
    }

    public final void m4201S(int i6) {
        this.f6203Y = i6;
        if (i6 == 2) {
            this.f6205b0.getLayoutManager().scrollToPosition(this.f6202X.f6131c - ((C1793j0) this.f6205b0.getAdapter()).f6180a.f6201W.f6115a.f6131c);
            this.f6207d0.setVisibility(0);
            this.f6208e0.setVisibility(8);
            return;
        }
        if (i6 == 1) {
            this.f6207d0.setVisibility(8);
            this.f6208e0.setVisibility(0);
            m4200R(this.f6202X);
        }
    }

    @Override
    public final void mo1279s(Bundle bundle) {
        super.mo1279s(bundle);
        if (bundle == null) {
            bundle = this.f1970g;
        }
        this.f6199U = bundle.getInt("THEME_RES_ID_KEY");
        this.f6200V = (DateSelector) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.f6201W = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f6202X = (Month) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override
    public final View mo1329t(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i6;
        int i10;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(m1321j(), this.f6199U);
        this.f6204Z = new C1778c(contextThemeWrapper);
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        Month month = this.f6201W.f6115a;
        if (C1804u.m4205V(contextThemeWrapper, R.attr.windowFullscreen)) {
            i6 = com.p2serv.android.p032ds.R.layout.mtrl_calendar_vertical;
            i10 = 1;
        } else {
            i6 = com.p2serv.android.p032ds.R.layout.mtrl_calendar_horizontal;
            i10 = 0;
        }
        View viewInflate = layoutInflaterCloneInContext.inflate(i6, viewGroup, false);
        Resources resources = m1312K().getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(com.p2serv.android.p032ds.R.dimen.mtrl_calendar_navigation_bottom_padding) + resources.getDimensionPixelOffset(com.p2serv.android.p032ds.R.dimen.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelSize(com.p2serv.android.p032ds.R.dimen.mtrl_calendar_navigation_height);
        int dimensionPixelSize = resources.getDimensionPixelSize(com.p2serv.android.p032ds.R.dimen.mtrl_calendar_days_of_week_height);
        int i11 = C1807x.f6239f;
        int i12 = dimensionPixelOffset + dimensionPixelSize;
        viewInflate.setMinimumHeight(i12 + (resources.getDimensionPixelOffset(com.p2serv.android.p032ds.R.dimen.mtrl_calendar_month_vertical_padding) * (i11 - 1)) + (resources.getDimensionPixelSize(com.p2serv.android.p032ds.R.dimen.mtrl_calendar_day_height) * i11) + resources.getDimensionPixelOffset(com.p2serv.android.p032ds.R.dimen.mtrl_calendar_bottom_padding));
        GridView gridView = (GridView) viewInflate.findViewById(com.p2serv.android.p032ds.R.id.mtrl_calendar_days_of_week);
        AbstractC3155s0.m6347q(gridView, new C0376i(1));
        gridView.setAdapter((ListAdapter) new C1794k());
        gridView.setNumColumns(month.f6132d);
        gridView.setEnabled(false);
        this.f6206c0 = (RecyclerView) viewInflate.findViewById(com.p2serv.android.p032ds.R.id.mtrl_calendar_months);
        this.f6206c0.setLayoutManager(new C1796m(this, i10, i10));
        this.f6206c0.setTag("MONTHS_VIEW_GROUP_TAG");
        C1775a0 c1775a0 = new C1775a0(contextThemeWrapper, this.f6200V, this.f6201W, new C1797n(this));
        this.f6206c0.setAdapter(c1775a0);
        int integer = contextThemeWrapper.getResources().getInteger(com.p2serv.android.p032ds.R.integer.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(com.p2serv.android.p032ds.R.id.mtrl_calendar_year_selector_frame);
        this.f6205b0 = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.f6205b0.setLayoutManager(new GridLayoutManager(integer));
            this.f6205b0.setAdapter(new C1793j0(this));
            this.f6205b0.addItemDecoration(new C1798o(this));
        }
        if (viewInflate.findViewById(com.p2serv.android.p032ds.R.id.month_navigation_fragment_toggle) != null) {
            MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(com.p2serv.android.p032ds.R.id.month_navigation_fragment_toggle);
            materialButton.setTag("SELECTOR_TOGGLE_TAG");
            AbstractC3155s0.m6347q(materialButton, new C1256h(2, this));
            MaterialButton materialButton2 = (MaterialButton) viewInflate.findViewById(com.p2serv.android.p032ds.R.id.month_navigation_previous);
            materialButton2.setTag("NAVIGATION_PREV_TAG");
            MaterialButton materialButton3 = (MaterialButton) viewInflate.findViewById(com.p2serv.android.p032ds.R.id.month_navigation_next);
            materialButton3.setTag("NAVIGATION_NEXT_TAG");
            this.f6207d0 = viewInflate.findViewById(com.p2serv.android.p032ds.R.id.mtrl_calendar_year_selector_frame);
            this.f6208e0 = viewInflate.findViewById(com.p2serv.android.p032ds.R.id.mtrl_calendar_day_selector_frame);
            m4201S(1);
            materialButton.setText(this.f6202X.m4185o());
            this.f6206c0.addOnScrollListener(new C1799p(this, c1775a0, materialButton));
            materialButton.setOnClickListener(new ViewOnClickListenerC0122a(3, this));
            materialButton3.setOnClickListener(new ViewOnClickListenerC1800q(this, c1775a0, 0));
            materialButton2.setOnClickListener(new ViewOnClickListenerC1800q(this, c1775a0, 1));
        }
        if (!C1804u.m4205V(contextThemeWrapper, R.attr.windowFullscreen)) {
            new C1143f0().attachToRecyclerView(this.f6206c0);
        }
        this.f6206c0.scrollToPosition(c1775a0.f6142a.f6115a.m4186p(this.f6202X));
        return viewInflate;
    }
}
