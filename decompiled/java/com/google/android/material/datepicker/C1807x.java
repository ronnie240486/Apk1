package com.google.android.material.datepicker;

import android.content.Context;
import android.icu.text.DateFormat;
import android.icu.util.TimeZone;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.C0275u;
import com.p2serv.android.p032ds.R;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import p000a.AbstractC0004e;

public final class C1807x extends BaseAdapter {

    public static final int f6239f = AbstractC1787g0.m4199h(null).getMaximum(4);

    public final Month f6240a;

    public final DateSelector f6241b;

    public Collection f6242c;

    public C1778c f6243d;

    public final CalendarConstraints f6244e;

    public C1807x(Month month, DateSelector dateSelector, CalendarConstraints calendarConstraints) {
        this.f6240a = month;
        this.f6241b = dateSelector;
        this.f6244e = calendarConstraints;
        this.f6242c = dateSelector.mo4175g();
    }

    @Override
    public final Long getItem(int i6) {
        Month month = this.f6240a;
        if (i6 < month.m4183m() || i6 > m4211b()) {
            return null;
        }
        return Long.valueOf(month.m4184n((i6 - month.m4183m()) + 1));
    }

    public final int m4211b() {
        Month month = this.f6240a;
        return (month.m4183m() + month.f6133e) - 1;
    }

    public final void m4212c(TextView textView, long j10) {
        C0275u c0275u;
        if (textView == null) {
            return;
        }
        if (this.f6244e.f6117c.mo4169d(j10)) {
            textView.setEnabled(true);
            Iterator it = this.f6241b.mo4175g().iterator();
            while (it.hasNext()) {
                if (AbstractC1787g0.m4192a(j10) == AbstractC1787g0.m4192a(((Long) it.next()).longValue())) {
                    c0275u = this.f6243d.f6151b;
                }
            }
            c0275u = AbstractC1787g0.m4198g().getTimeInMillis() == j10 ? this.f6243d.f6152c : this.f6243d.f6150a;
        } else {
            textView.setEnabled(false);
            c0275u = this.f6243d.f6156g;
        }
        c0275u.m782k(textView);
    }

    public final void m4213d(MaterialCalendarGridView materialCalendarGridView, long j10) {
        Month monthM4181l = Month.m4181l(j10);
        Month month = this.f6240a;
        if (monthM4181l.equals(month)) {
            Calendar calendarM4194c = AbstractC1787g0.m4194c(month.f6129a);
            calendarM4194c.setTimeInMillis(j10);
            m4212c((TextView) materialCalendarGridView.getChildAt((materialCalendarGridView.m4178a().f6240a.m4183m() + (calendarM4194c.get(5) - 1)) - materialCalendarGridView.getFirstVisiblePosition()), j10);
        }
    }

    @Override
    public final int getCount() {
        Month month = this.f6240a;
        return month.f6133e + month.m4183m();
    }

    @Override
    public final long getItemId(int i6) {
        return i6 / this.f6240a.f6132d;
    }

    @Override
    public final View getView(int i6, View view, ViewGroup viewGroup) {
        CharSequence charSequence;
        CharSequence charSequence2;
        Context context = viewGroup.getContext();
        if (this.f6243d == null) {
            this.f6243d = new C1778c(context);
        }
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) AbstractC0004e.m15i(viewGroup, R.layout.mtrl_calendar_day, viewGroup, false);
        }
        Month month = this.f6240a;
        int iM4183m = i6 - month.m4183m();
        if (iM4183m < 0 || iM4183m >= month.f6133e) {
            textView.setVisibility(8);
            textView.setEnabled(false);
        } else {
            int i10 = iM4183m + 1;
            textView.setTag(month);
            textView.setText(String.format(textView.getResources().getConfiguration().locale, "%d", Integer.valueOf(i10)));
            long jM4184n = month.m4184n(i10);
            if (month.f6131c == new Month(AbstractC1787g0.m4198g()).f6131c) {
                Locale locale = Locale.getDefault();
                if (Build.VERSION.SDK_INT >= 24) {
                    DateFormat instanceForSkeleton = DateFormat.getInstanceForSkeleton("MMMEd", locale);
                    instanceForSkeleton.setTimeZone(TimeZone.getTimeZone("UTC"));
                    charSequence2 = instanceForSkeleton.format(new Date(jM4184n));
                } else {
                    charSequence2 = AbstractC1787g0.m4195d(0, locale).format(new Date(jM4184n));
                }
                textView.setContentDescription(charSequence2);
            } else {
                Locale locale2 = Locale.getDefault();
                if (Build.VERSION.SDK_INT >= 24) {
                    DateFormat instanceForSkeleton2 = DateFormat.getInstanceForSkeleton("yMMMEd", locale2);
                    instanceForSkeleton2.setTimeZone(TimeZone.getTimeZone("UTC"));
                    charSequence = instanceForSkeleton2.format(new Date(jM4184n));
                } else {
                    charSequence = AbstractC1787g0.m4195d(0, locale2).format(new Date(jM4184n));
                }
                textView.setContentDescription(charSequence);
            }
            textView.setVisibility(0);
            textView.setEnabled(true);
        }
        Long item = getItem(i6);
        if (item != null) {
            m4212c(textView, item.longValue());
        }
        return textView;
    }

    @Override
    public final boolean hasStableIds() {
        return true;
    }
}
