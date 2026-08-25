package com.google.android.material.datepicker;

import com.google.android.material.textfield.TextInputLayout;
import java.text.SimpleDateFormat;

public final class C1781d0 extends AbstractC1792j {

    public final C1803t f6163g;

    public final SingleDateSelector f6164h;

    public C1781d0(SingleDateSelector singleDateSelector, String str, SimpleDateFormat simpleDateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, C1803t c1803t) {
        super(str, simpleDateFormat, textInputLayout, calendarConstraints);
        this.f6164h = singleDateSelector;
        this.f6163g = c1803t;
    }

    @Override
    public final void mo4189a() {
        this.f6163g.m4202a();
    }

    @Override
    public final void mo4190b(Long l9) {
        SingleDateSelector singleDateSelector = this.f6164h;
        if (l9 == null) {
            singleDateSelector.f6141a = null;
        } else {
            singleDateSelector.f6141a = l9;
        }
        this.f6163g.m4203b(singleDateSelector.f6141a);
    }
}
