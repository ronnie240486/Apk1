package com.google.android.gms.common.internal;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import p000a.AbstractC0004e;

public final class zaaa extends Button {
    public zaaa(Context context, AttributeSet attributeSet) {
        super(context, null, R.attr.buttonStyle);
    }

    public static final int m3671a(int i6, int i10, int i11, int i12) {
        if (i6 == 0) {
            return i10;
        }
        if (i6 == 1) {
            return i11;
        }
        if (i6 == 2) {
            return i12;
        }
        throw new IllegalStateException(AbstractC0004e.m20n(i6, "Unknown color scheme: "));
    }
}
