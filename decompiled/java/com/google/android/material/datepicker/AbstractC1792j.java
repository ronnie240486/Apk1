package com.google.android.material.datepicker;

import android.text.TextUtils;
import com.google.android.material.internal.AbstractC1840z;
import com.google.android.material.textfield.TextInputLayout;
import com.p2serv.android.p032ds.R;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class AbstractC1792j extends AbstractC1840z {

    public final TextInputLayout f6174a;

    public final SimpleDateFormat f6175b;

    public final CalendarConstraints f6176c;

    public final String f6177d;

    public final RunnableC1788h f6178e;

    public RunnableC1790i f6179f;

    public AbstractC1792j(String str, SimpleDateFormat simpleDateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints) {
        this.f6175b = simpleDateFormat;
        this.f6174a = textInputLayout;
        this.f6176c = calendarConstraints;
        this.f6177d = textInputLayout.getContext().getString(R.string.mtrl_picker_out_of_range);
        this.f6178e = new RunnableC1788h(this, str);
    }

    public abstract void mo4189a();

    public abstract void mo4190b(Long l9);

    @Override
    public final void onTextChanged(CharSequence charSequence, int i6, int i10, int i11) {
        CalendarConstraints calendarConstraints = this.f6176c;
        TextInputLayout textInputLayout = this.f6174a;
        RunnableC1788h runnableC1788h = this.f6178e;
        textInputLayout.removeCallbacks(runnableC1788h);
        textInputLayout.removeCallbacks(this.f6179f);
        textInputLayout.setError(null);
        mo4190b(null);
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        try {
            Date date = this.f6175b.parse(charSequence.toString());
            textInputLayout.setError(null);
            long time = date.getTime();
            if (calendarConstraints.f6117c.mo4169d(time) && calendarConstraints.f6115a.m4184n(1) <= time) {
                Month month = calendarConstraints.f6116b;
                if (time <= month.m4184n(month.f6133e)) {
                    mo4190b(Long.valueOf(date.getTime()));
                    return;
                }
            }
            RunnableC1790i runnableC1790i = new RunnableC1790i(this, time, 0);
            this.f6179f = runnableC1790i;
            textInputLayout.postDelayed(runnableC1790i, 1000L);
        } catch (ParseException unused) {
            textInputLayout.postDelayed(runnableC1788h, 1000L);
        }
    }
}
