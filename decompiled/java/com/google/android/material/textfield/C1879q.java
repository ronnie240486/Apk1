package com.google.android.material.textfield;

import android.text.method.PasswordTransformationMethod;
import android.widget.EditText;
import androidx.appcompat.app.ViewOnClickListenerC0122a;
import com.p2serv.android.p032ds.R;
import java.util.LinkedHashSet;

public final class C1879q extends AbstractC1876n {

    public final C1871i f6894e;

    public final C1863a f6895f;

    public final C1864b f6896g;

    public C1879q(TextInputLayout textInputLayout, int i6) {
        super(textInputLayout, i6);
        this.f6894e = new C1871i(this, 1);
        this.f6895f = new C1863a(this, 2);
        this.f6896g = new C1864b(this, 2);
    }

    public static boolean m4403d(C1879q c1879q) {
        EditText editText = c1879q.f6867a.getEditText();
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    @Override
    public final void mo4379a() {
        int i6 = this.f6870d;
        if (i6 == 0) {
            i6 = R.drawable.design_password_eye;
        }
        TextInputLayout textInputLayout = this.f6867a;
        textInputLayout.setEndIconDrawable(i6);
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R.string.password_toggle_content_description));
        textInputLayout.setEndIconVisible(true);
        textInputLayout.setEndIconCheckable(true);
        textInputLayout.setEndIconOnClickListener(new ViewOnClickListenerC0122a(8, this));
        LinkedHashSet linkedHashSet = textInputLayout.f6775c0;
        C1863a c1863a = this.f6895f;
        linkedHashSet.add(c1863a);
        if (textInputLayout.f6778e != null) {
            c1863a.m4377a(textInputLayout);
        }
        textInputLayout.f6783g0.add(this.f6896g);
        EditText editText = textInputLayout.getEditText();
        if (editText != null) {
            if (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224) {
                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }
}
