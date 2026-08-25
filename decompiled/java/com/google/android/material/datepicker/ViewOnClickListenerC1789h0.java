package com.google.android.material.datepicker;

import android.view.View;

public final class ViewOnClickListenerC1789h0 implements View.OnClickListener {

    public final int f6168a;

    public final C1793j0 f6169b;

    public ViewOnClickListenerC1789h0(C1793j0 c1793j0, int i6) {
        this.f6169b = c1793j0;
        this.f6168a = i6;
    }

    @Override
    public final void onClick(View view) {
        C1793j0 c1793j0 = this.f6169b;
        Month monthM4180j = Month.m4180j(this.f6168a, c1793j0.f6180a.f6202X.f6130b);
        C1801r c1801r = c1793j0.f6180a;
        CalendarConstraints calendarConstraints = c1801r.f6201W;
        Month month = calendarConstraints.f6115a;
        if (monthM4180j.compareTo(month) < 0) {
            monthM4180j = month;
        } else {
            Month month2 = calendarConstraints.f6116b;
            if (monthM4180j.compareTo(month2) > 0) {
                monthM4180j = month2;
            }
        }
        c1801r.m4200R(monthM4180j);
        c1801r.m4201S(1);
    }
}
