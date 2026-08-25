package com.google.android.material.datepicker;

import android.content.Context;
import com.google.android.material.textfield.TextInputLayout;
import com.p2serv.android.p032ds.R;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class RunnableC1788h implements Runnable {

    public final String f6166a;

    public final AbstractC1792j f6167b;

    public RunnableC1788h(AbstractC1792j abstractC1792j, String str) {
        this.f6167b = abstractC1792j;
        this.f6166a = str;
    }

    @Override
    public final void run() {
        AbstractC1792j abstractC1792j = this.f6167b;
        TextInputLayout textInputLayout = abstractC1792j.f6174a;
        SimpleDateFormat simpleDateFormat = abstractC1792j.f6175b;
        Context context = textInputLayout.getContext();
        textInputLayout.setError(context.getString(R.string.mtrl_picker_invalid_format) + "\n" + String.format(context.getString(R.string.mtrl_picker_invalid_format_use), this.f6166a) + "\n" + String.format(context.getString(R.string.mtrl_picker_invalid_format_example), simpleDateFormat.format(new Date(AbstractC1787g0.m4198g().getTimeInMillis()))));
        abstractC1792j.mo4189a();
    }
}
