package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
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
import java.util.Locale;
import p000a.RunnableC0005f;
import p187r4.AbstractC3612b;

public class SingleDateSelector implements DateSelector<Long> {
    public static final Parcelable.Creator<SingleDateSelector> CREATOR = new C1806w(4);

    public Long f6141a;

    @Override
    public final String mo4170a(Context context) {
        Resources resources = context.getResources();
        Long l9 = this.f6141a;
        return l9 == null ? resources.getString(R.string.mtrl_picker_date_header_unselected) : resources.getString(R.string.mtrl_picker_date_header_selected, AbstractC3612b.m7274z(l9.longValue(), Locale.getDefault()));
    }

    @Override
    public final int mo4171b(Context context) {
        return AbstractC1465c.m3478m(context, R.attr.materialCalendarTheme, C1804u.class.getCanonicalName());
    }

    @Override
    public final ArrayList mo4172c() {
        return new ArrayList();
    }

    @Override
    public final int describeContents() {
        return 0;
    }

    @Override
    public final View mo4173e(LayoutInflater layoutInflater, ViewGroup viewGroup, CalendarConstraints calendarConstraints, C1803t c1803t) {
        View viewInflate = layoutInflater.inflate(R.layout.mtrl_picker_text_input_date, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) viewInflate.findViewById(R.id.mtrl_picker_text_input_date);
        EditText editText = textInputLayout.getEditText();
        if (AbstractC1811a0.m4248h()) {
            editText.setInputType(17);
        }
        SimpleDateFormat simpleDateFormatM4196e = AbstractC1787g0.m4196e();
        String strM4197f = AbstractC1787g0.m4197f(viewInflate.getResources(), simpleDateFormatM4196e);
        textInputLayout.setPlaceholderText(strM4197f);
        Long l9 = this.f6141a;
        if (l9 != null) {
            editText.setText(simpleDateFormatM4196e.format(l9));
        }
        editText.addTextChangedListener(new C1781d0(this, strM4197f, simpleDateFormatM4196e, textInputLayout, calendarConstraints, c1803t));
        editText.requestFocus();
        editText.post(new RunnableC0005f(10, editText));
        return viewInflate;
    }

    @Override
    public final boolean mo4174f() {
        return this.f6141a != null;
    }

    @Override
    public final ArrayList mo4175g() {
        ArrayList arrayList = new ArrayList();
        Long l9 = this.f6141a;
        if (l9 != null) {
            arrayList.add(l9);
        }
        return arrayList;
    }

    @Override
    public final Object mo4176i() {
        return this.f6141a;
    }

    @Override
    public final void mo4177k(long j10) {
        this.f6141a = Long.valueOf(j10);
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        parcel.writeValue(this.f6141a);
    }
}
