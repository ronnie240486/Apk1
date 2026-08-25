package com.google.android.material.datepicker;

import com.google.android.material.textfield.TextInputLayout;
import java.text.SimpleDateFormat;

public final class C1779c0 extends AbstractC1792j {

    public final int f6158g;

    public final TextInputLayout f6159h;

    public final TextInputLayout f6160i;

    public final C1803t f6161j;

    public final RangeDateSelector f6162k;

    public C1779c0(RangeDateSelector rangeDateSelector, String str, SimpleDateFormat simpleDateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, C1803t c1803t, int i6) {
        super(str, simpleDateFormat, textInputLayout, calendarConstraints);
        this.f6158g = i6;
        this.f6162k = rangeDateSelector;
        this.f6159h = textInputLayout2;
        this.f6160i = textInputLayout3;
        this.f6161j = c1803t;
    }

    @Override
    public final void mo4189a() {
        switch (this.f6158g) {
            case 0:
                RangeDateSelector rangeDateSelector = this.f6162k;
                rangeDateSelector.f6139d = null;
                RangeDateSelector.m4187h(rangeDateSelector, this.f6159h, this.f6160i, this.f6161j);
                break;
            default:
                RangeDateSelector rangeDateSelector2 = this.f6162k;
                rangeDateSelector2.f6140e = null;
                RangeDateSelector.m4187h(rangeDateSelector2, this.f6159h, this.f6160i, this.f6161j);
                break;
        }
    }

    @Override
    public final void mo4190b(Long l9) {
        switch (this.f6158g) {
            case 0:
                RangeDateSelector rangeDateSelector = this.f6162k;
                rangeDateSelector.f6139d = l9;
                RangeDateSelector.m4187h(rangeDateSelector, this.f6159h, this.f6160i, this.f6161j);
                break;
            default:
                RangeDateSelector rangeDateSelector2 = this.f6162k;
                rangeDateSelector2.f6140e = l9;
                RangeDateSelector.m4187h(rangeDateSelector2, this.f6159h, this.f6160i, this.f6161j);
                break;
        }
    }
}
