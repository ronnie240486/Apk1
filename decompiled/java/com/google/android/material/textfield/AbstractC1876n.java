package com.google.android.material.textfield;

import android.content.Context;
import com.google.android.material.internal.CheckableImageButton;

public abstract class AbstractC1876n {

    public final TextInputLayout f6867a;

    public final Context f6868b;

    public final CheckableImageButton f6869c;

    public final int f6870d;

    public AbstractC1876n(TextInputLayout textInputLayout, int i6) {
        this.f6867a = textInputLayout;
        this.f6868b = textInputLayout.getContext();
        this.f6869c = textInputLayout.getEndIconView();
        this.f6870d = i6;
    }

    public abstract void mo4379a();

    public boolean mo4388b(int i6) {
        return true;
    }

    public void mo4380c(boolean z7) {
    }
}
