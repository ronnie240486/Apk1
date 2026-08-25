package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public final class C1805v<S> extends AbstractC1777b0 {

    public int f6235U;

    public DateSelector f6236V;

    public CalendarConstraints f6237W;

    @Override
    public final void mo1269A(Bundle bundle) {
        bundle.putInt("THEME_RES_ID_KEY", this.f6235U);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f6236V);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f6237W);
    }

    @Override
    public final void mo1279s(Bundle bundle) {
        super.mo1279s(bundle);
        if (bundle == null) {
            bundle = this.f1970g;
        }
        this.f6235U = bundle.getInt("THEME_RES_ID_KEY");
        this.f6236V = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f6237W = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    @Override
    public final View mo1329t(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.f6236V.mo4173e(layoutInflater.cloneInContext(new ContextThemeWrapper(m1321j(), this.f6235U)), viewGroup, this.f6237W, new C1803t(1, this));
    }
}
