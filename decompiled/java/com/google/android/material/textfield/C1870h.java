package com.google.android.material.textfield;

import android.widget.AutoCompleteTextView;

public final class C1870h implements AutoCompleteTextView.OnDismissListener {

    public final C1875m f6843a;

    public C1870h(C1875m c1875m) {
        this.f6843a = c1875m;
    }

    @Override
    public final void onDismiss() {
        C1875m c1875m = this.f6843a;
        c1875m.f6859l = true;
        c1875m.f6861n = System.currentTimeMillis();
        c1875m.m4392i(false);
    }
}
