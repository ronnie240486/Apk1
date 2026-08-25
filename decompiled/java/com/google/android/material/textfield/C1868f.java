package com.google.android.material.textfield;

import android.graphics.drawable.Drawable;

public final class C1868f extends AbstractC1876n {

    public final int f6841e;

    public C1868f(TextInputLayout textInputLayout, int i6, int i10) {
        super(textInputLayout, i6);
        this.f6841e = i10;
    }

    @Override
    public final void mo4379a() {
        switch (this.f6841e) {
            case 0:
                int i6 = this.f6870d;
                TextInputLayout textInputLayout = this.f6867a;
                textInputLayout.setEndIconDrawable(i6);
                textInputLayout.setEndIconOnClickListener(null);
                textInputLayout.setEndIconOnLongClickListener(null);
                break;
            default:
                TextInputLayout textInputLayout2 = this.f6867a;
                textInputLayout2.setEndIconOnClickListener(null);
                textInputLayout2.setEndIconDrawable((Drawable) null);
                textInputLayout2.setEndIconContentDescription((CharSequence) null);
                break;
        }
    }
}
