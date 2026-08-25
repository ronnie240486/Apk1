package com.google.android.material.textfield;

import android.text.Editable;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import com.google.android.material.internal.AbstractC1840z;
import p004a3.RunnableC0038c;

public final class C1871i extends AbstractC1840z {

    public final int f6844a;

    public final AbstractC1876n f6845b;

    public C1871i(AbstractC1876n abstractC1876n, int i6) {
        this.f6844a = i6;
        this.f6845b = abstractC1876n;
    }

    @Override
    public void afterTextChanged(Editable editable) {
        switch (this.f6844a) {
            case 0:
                C1875m c1875m = (C1875m) this.f6845b;
                EditText editText = c1875m.f6867a.getEditText();
                if (!(editText instanceof AutoCompleteTextView)) {
                    throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
                }
                AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
                if (c1875m.f6864q.isTouchExplorationEnabled() && C1875m.m4387h(autoCompleteTextView) && !c1875m.f6869c.hasFocus()) {
                    autoCompleteTextView.dismissDropDown();
                }
                autoCompleteTextView.post(new RunnableC0038c(this, 6, autoCompleteTextView));
                return;
            default:
                return;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i6, int i10, int i11) {
        switch (this.f6844a) {
            case 1:
                C1879q c1879q = (C1879q) this.f6845b;
                c1879q.f6869c.setChecked(!C1879q.m4403d(c1879q));
                break;
        }
    }
}
