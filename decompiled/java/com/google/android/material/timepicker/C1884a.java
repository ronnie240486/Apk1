package com.google.android.material.timepicker;

import android.text.Editable;
import android.text.TextUtils;
import com.google.android.material.internal.AbstractC1840z;

public final class C1884a extends AbstractC1840z {

    public final ChipTextInputComboView f6943a;

    public C1884a(ChipTextInputComboView chipTextInputComboView) {
        this.f6943a = chipTextInputComboView;
    }

    @Override
    public final void afterTextChanged(Editable editable) {
        boolean zIsEmpty = TextUtils.isEmpty(editable);
        ChipTextInputComboView chipTextInputComboView = this.f6943a;
        if (zIsEmpty) {
            chipTextInputComboView.f6908a.setText(String.format(chipTextInputComboView.getResources().getConfiguration().locale, "%02d", Integer.valueOf(Integer.parseInt("00"))));
        } else {
            chipTextInputComboView.f6908a.setText(String.format(chipTextInputComboView.getResources().getConfiguration().locale, "%02d", Integer.valueOf(Integer.parseInt(String.valueOf(editable)))));
        }
    }
}
