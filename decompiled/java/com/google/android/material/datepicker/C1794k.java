package com.google.android.material.datepicker;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.p2serv.android.p032ds.R;
import java.util.Calendar;
import java.util.Locale;
import p000a.AbstractC0004e;

public final class C1794k extends BaseAdapter {

    public static final int f6181d;

    public final Calendar f6182a;

    public final int f6183b;

    public final int f6184c;

    static {
        f6181d = Build.VERSION.SDK_INT >= 26 ? 4 : 1;
    }

    public C1794k() {
        Calendar calendarM4199h = AbstractC1787g0.m4199h(null);
        this.f6182a = calendarM4199h;
        this.f6183b = calendarM4199h.getMaximum(7);
        this.f6184c = calendarM4199h.getFirstDayOfWeek();
    }

    @Override
    public final int getCount() {
        return this.f6183b;
    }

    @Override
    public final Object getItem(int i6) {
        int i10 = this.f6183b;
        if (i6 >= i10) {
            return null;
        }
        int i11 = i6 + this.f6184c;
        if (i11 > i10) {
            i11 -= i10;
        }
        return Integer.valueOf(i11);
    }

    @Override
    public final long getItemId(int i6) {
        return 0L;
    }

    @Override
    public final View getView(int i6, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) AbstractC0004e.m15i(viewGroup, R.layout.mtrl_calendar_day_of_week, viewGroup, false);
        }
        int i10 = i6 + this.f6184c;
        int i11 = this.f6183b;
        if (i10 > i11) {
            i10 -= i11;
        }
        Calendar calendar = this.f6182a;
        calendar.set(7, i10);
        textView.setText(calendar.getDisplayName(7, f6181d, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(R.string.mtrl_picker_day_of_week_column_header), calendar.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }
}
