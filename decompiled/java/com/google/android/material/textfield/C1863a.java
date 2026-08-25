package com.google.android.material.textfield;

import android.graphics.drawable.Drawable;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import androidx.appcompat.widget.C0253p2;
import androidx.appcompat.widget.ViewOnFocusChangeListenerC0263r2;
import com.google.android.material.internal.CheckableImageButton;
import java.util.WeakHashMap;
import p138n0.AbstractC3155s0;

public final class C1863a {

    public final int f6827a;

    public final AbstractC1876n f6828b;

    public C1863a(AbstractC1876n abstractC1876n, int i6) {
        this.f6827a = i6;
        this.f6828b = abstractC1876n;
    }

    public final void m4377a(TextInputLayout textInputLayout) {
        int i6 = 0;
        AbstractC1876n abstractC1876n = this.f6828b;
        switch (this.f6827a) {
            case 0:
                EditText editText = textInputLayout.getEditText();
                C1867e c1867e = (C1867e) abstractC1876n;
                textInputLayout.setEndIconVisible(C1867e.m4378d(c1867e));
                ViewOnFocusChangeListenerC0263r2 viewOnFocusChangeListenerC0263r2 = c1867e.f6836f;
                editText.setOnFocusChangeListener(viewOnFocusChangeListenerC0263r2);
                c1867e.f6869c.setOnFocusChangeListener(viewOnFocusChangeListenerC0263r2);
                C0253p2 c0253p2 = c1867e.f6835e;
                editText.removeTextChangedListener(c0253p2);
                editText.addTextChangedListener(c0253p2);
                return;
            case 1:
                EditText editText2 = textInputLayout.getEditText();
                if (!(editText2 instanceof AutoCompleteTextView)) {
                    throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
                }
                AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText2;
                C1875m c1875m = (C1875m) abstractC1876n;
                int boxBackgroundMode = c1875m.f6867a.getBoxBackgroundMode();
                if (boxBackgroundMode == 2) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(c1875m.f6863p);
                } else if (boxBackgroundMode == 1) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(c1875m.f6862o);
                }
                c1875m.m4389e(autoCompleteTextView);
                autoCompleteTextView.setOnTouchListener(new ViewOnTouchListenerC1874l(c1875m, i6, autoCompleteTextView));
                autoCompleteTextView.setOnFocusChangeListener(c1875m.f6853f);
                autoCompleteTextView.setOnDismissListener(new C1870h(c1875m));
                autoCompleteTextView.setThreshold(0);
                C1871i c1871i = c1875m.f6852e;
                autoCompleteTextView.removeTextChangedListener(c1871i);
                autoCompleteTextView.addTextChangedListener(c1871i);
                textInputLayout.setEndIconCheckable(true);
                textInputLayout.setErrorIconDrawable((Drawable) null);
                if (autoCompleteTextView.getKeyListener() == null && c1875m.f6864q.isTouchExplorationEnabled()) {
                    CheckableImageButton checkableImageButton = c1875m.f6869c;
                    WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                    checkableImageButton.setImportantForAccessibility(2);
                }
                textInputLayout.setTextInputAccessibilityDelegate(c1875m.f6854g);
                textInputLayout.setEndIconVisible(true);
                return;
            default:
                EditText editText3 = textInputLayout.getEditText();
                C1879q c1879q = (C1879q) abstractC1876n;
                c1879q.f6869c.setChecked(true ^ C1879q.m4403d(c1879q));
                C1871i c1871i2 = c1879q.f6894e;
                editText3.removeTextChangedListener(c1871i2);
                editText3.addTextChangedListener(c1871i2);
                return;
        }
    }
}
