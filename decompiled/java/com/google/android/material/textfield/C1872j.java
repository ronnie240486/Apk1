package com.google.android.material.textfield;

import android.os.Build;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import p148o0.C3233h;

public final class C1872j extends C1882t {

    public final C1875m f6846e;

    public C1872j(C1875m c1875m, TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f6846e = c1875m;
    }

    @Override
    public final void mo1136d(View view, C3233h c3233h) {
        super.mo1136d(view, c3233h);
        if (!C1875m.m4387h(this.f6846e.f6867a.getEditText())) {
            c3233h.m6547i(Spinner.class.getName());
        }
        if (Build.VERSION.SDK_INT >= 26 ? c3233h.f10862a.isShowingHintText() : c3233h.m6543e(4)) {
            c3233h.m6551m(null);
        }
    }

    @Override
    public final void mo2982e(View view, AccessibilityEvent accessibilityEvent) {
        super.mo2982e(view, accessibilityEvent);
        C1875m c1875m = this.f6846e;
        EditText editText = c1875m.f6867a.getEditText();
        if (!(editText instanceof AutoCompleteTextView)) {
            throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
        }
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
        if (accessibilityEvent.getEventType() == 1 && c1875m.f6864q.isEnabled() && !C1875m.m4387h(c1875m.f6867a.getEditText())) {
            C1875m.m4386d(c1875m, autoCompleteTextView);
            c1875m.f6859l = true;
            c1875m.f6861n = System.currentTimeMillis();
        }
    }
}
