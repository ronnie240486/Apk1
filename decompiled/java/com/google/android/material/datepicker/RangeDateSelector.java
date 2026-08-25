package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.bumptech.glide.AbstractC1465c;
import com.google.android.material.internal.AbstractC1811a0;
import com.google.android.material.textfield.TextInputLayout;
import com.p2serv.android.p032ds.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import p000a.RunnableC0005f;
import p128m0.C3026b;
import p187r4.AbstractC3612b;

public class RangeDateSelector implements DateSelector<C3026b> {
    public static final Parcelable.Creator<RangeDateSelector> CREATOR = new C1806w(3);

    public String f6136a;

    public Long f6137b;

    public Long f6138c;

    public Long f6139d;

    public Long f6140e;

    public static void m4187h(RangeDateSelector rangeDateSelector, TextInputLayout textInputLayout, TextInputLayout textInputLayout2, C1803t c1803t) {
        Long l9 = rangeDateSelector.f6139d;
        if (l9 == null || rangeDateSelector.f6140e == null) {
            if (textInputLayout.getError() != null && rangeDateSelector.f6136a.contentEquals(textInputLayout.getError())) {
                textInputLayout.setError(null);
            }
            if (textInputLayout2.getError() != null && " ".contentEquals(textInputLayout2.getError())) {
                textInputLayout2.setError(null);
            }
            c1803t.m4202a();
            return;
        }
        if (l9.longValue() > rangeDateSelector.f6140e.longValue()) {
            textInputLayout.setError(rangeDateSelector.f6136a);
            textInputLayout2.setError(" ");
            c1803t.m4202a();
        } else {
            Long l10 = rangeDateSelector.f6139d;
            rangeDateSelector.f6137b = l10;
            Long l11 = rangeDateSelector.f6140e;
            rangeDateSelector.f6138c = l11;
            c1803t.m4203b(new C3026b(l10, l11));
        }
    }

    @Override
    public final String mo4170a(Context context) {
        C3026b c3026b;
        Resources resources = context.getResources();
        Long l9 = this.f6137b;
        if (l9 == null && this.f6138c == null) {
            return resources.getString(R.string.mtrl_picker_range_header_unselected);
        }
        Long l10 = this.f6138c;
        if (l10 == null) {
            return resources.getString(R.string.mtrl_picker_range_header_only_start_selected, AbstractC3612b.m7271m(l9.longValue()));
        }
        if (l9 == null) {
            return resources.getString(R.string.mtrl_picker_range_header_only_end_selected, AbstractC3612b.m7271m(l10.longValue()));
        }
        Calendar calendarM4198g = AbstractC1787g0.m4198g();
        Calendar calendarM4199h = AbstractC1787g0.m4199h(null);
        calendarM4199h.setTimeInMillis(l9.longValue());
        Calendar calendarM4199h2 = AbstractC1787g0.m4199h(null);
        calendarM4199h2.setTimeInMillis(l10.longValue());
        if (calendarM4199h.get(1) == calendarM4199h2.get(1)) {
            c3026b = calendarM4199h.get(1) == calendarM4198g.get(1) ? new C3026b(AbstractC3612b.m7272p(l9.longValue(), Locale.getDefault()), AbstractC3612b.m7272p(l10.longValue(), Locale.getDefault())) : new C3026b(AbstractC3612b.m7272p(l9.longValue(), Locale.getDefault()), AbstractC3612b.m7274z(l10.longValue(), Locale.getDefault()));
        } else {
            c3026b = new C3026b(AbstractC3612b.m7274z(l9.longValue(), Locale.getDefault()), AbstractC3612b.m7274z(l10.longValue(), Locale.getDefault()));
        }
        return resources.getString(R.string.mtrl_picker_range_header_selected, c3026b.f10354a, c3026b.f10355b);
    }

    @Override
    public final int mo4171b(Context context) {
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return AbstractC1465c.m3478m(context, Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) > resources.getDimensionPixelSize(R.dimen.mtrl_calendar_maximum_default_fullscreen_minor_axis) ? R.attr.materialCalendarTheme : R.attr.materialCalendarFullscreenTheme, C1804u.class.getCanonicalName());
    }

    @Override
    public final ArrayList mo4172c() {
        if (this.f6137b == null || this.f6138c == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C3026b(this.f6137b, this.f6138c));
        return arrayList;
    }

    @Override
    public final int describeContents() {
        return 0;
    }

    @Override
    public final View mo4173e(LayoutInflater layoutInflater, ViewGroup viewGroup, CalendarConstraints calendarConstraints, C1803t c1803t) {
        View viewInflate = layoutInflater.inflate(R.layout.mtrl_picker_text_input_date_range, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) viewInflate.findViewById(R.id.mtrl_picker_text_input_range_start);
        TextInputLayout textInputLayout2 = (TextInputLayout) viewInflate.findViewById(R.id.mtrl_picker_text_input_range_end);
        EditText editText = textInputLayout.getEditText();
        EditText editText2 = textInputLayout2.getEditText();
        if (AbstractC1811a0.m4248h()) {
            editText.setInputType(17);
            editText2.setInputType(17);
        }
        this.f6136a = viewInflate.getResources().getString(R.string.mtrl_picker_invalid_range);
        SimpleDateFormat simpleDateFormatM4196e = AbstractC1787g0.m4196e();
        Long l9 = this.f6137b;
        if (l9 != null) {
            editText.setText(simpleDateFormatM4196e.format(l9));
            this.f6139d = this.f6137b;
        }
        Long l10 = this.f6138c;
        if (l10 != null) {
            editText2.setText(simpleDateFormatM4196e.format(l10));
            this.f6140e = this.f6138c;
        }
        String strM4197f = AbstractC1787g0.m4197f(viewInflate.getResources(), simpleDateFormatM4196e);
        textInputLayout.setPlaceholderText(strM4197f);
        textInputLayout2.setPlaceholderText(strM4197f);
        editText.addTextChangedListener(new C1779c0(this, strM4197f, simpleDateFormatM4196e, textInputLayout, calendarConstraints, textInputLayout, textInputLayout2, c1803t, 0));
        editText2.addTextChangedListener(new C1779c0(this, strM4197f, simpleDateFormatM4196e, textInputLayout2, calendarConstraints, textInputLayout, textInputLayout2, c1803t, 1));
        editText.requestFocus();
        editText.post(new RunnableC0005f(10, editText));
        return viewInflate;
    }

    @Override
    public final boolean mo4174f() {
        Long l9 = this.f6137b;
        return (l9 == null || this.f6138c == null || l9.longValue() > this.f6138c.longValue()) ? false : true;
    }

    @Override
    public final ArrayList mo4175g() {
        ArrayList arrayList = new ArrayList();
        Long l9 = this.f6137b;
        if (l9 != null) {
            arrayList.add(l9);
        }
        Long l10 = this.f6138c;
        if (l10 != null) {
            arrayList.add(l10);
        }
        return arrayList;
    }

    @Override
    public final Object mo4176i() {
        return new C3026b(this.f6137b, this.f6138c);
    }

    @Override
    public final void mo4177k(long j10) {
        Long l9 = this.f6137b;
        if (l9 == null) {
            this.f6137b = Long.valueOf(j10);
        } else if (this.f6138c == null && l9.longValue() <= j10) {
            this.f6138c = Long.valueOf(j10);
        } else {
            this.f6138c = null;
            this.f6137b = Long.valueOf(j10);
        }
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        parcel.writeValue(this.f6137b);
        parcel.writeValue(this.f6138c);
    }
}
