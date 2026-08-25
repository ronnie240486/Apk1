package com.google.android.material.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

@SuppressLint({"AppCompatCustomView"})
public class VisibilityAwareImageButton extends ImageButton {

    public int f6349a;

    public VisibilityAwareImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void m4235a(int i6, boolean z7) {
        super.setVisibility(i6);
        if (z7) {
            this.f6349a = i6;
        }
    }

    public final int getUserSetVisibility() {
        return this.f6349a;
    }

    @Override
    public void setVisibility(int i6) {
        m4235a(i6, true);
    }

    public VisibilityAwareImageButton(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f6349a = getVisibility();
    }
}
