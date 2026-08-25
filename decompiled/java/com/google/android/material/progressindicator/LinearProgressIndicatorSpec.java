package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.internal.AbstractC1811a0;
import com.p2serv.android.p032ds.R;
import p178q6.AbstractC3508e;
import p250x5.AbstractC4121a;

public final class LinearProgressIndicatorSpec extends AbstractC3508e {

    public int f6600g;

    public int f6601h;

    public boolean f6602i;

    public LinearProgressIndicatorSpec(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.linearProgressIndicatorStyle);
    }

    @Override
    public final void mo4303a() {
        if (this.f6600g == 0) {
            if (this.f11810b > 0) {
                throw new IllegalArgumentException("Rounded corners are not supported in contiguous indeterminate animation.");
            }
            if (this.f11811c.length < 3) {
                throw new IllegalArgumentException("Contiguous indeterminate animation must be used with 3 or more indicator colors.");
            }
        }
    }

    public LinearProgressIndicatorSpec(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6, R.style.Widget_MaterialComponents_LinearProgressIndicator);
        int i10 = LinearProgressIndicator.f6599l;
        int[] iArr = AbstractC4121a.f14009w;
        AbstractC1811a0.m4241a(context, attributeSet, R.attr.linearProgressIndicatorStyle, R.style.Widget_MaterialComponents_LinearProgressIndicator);
        AbstractC1811a0.m4242b(context, attributeSet, iArr, R.attr.linearProgressIndicatorStyle, R.style.Widget_MaterialComponents_LinearProgressIndicator, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, R.attr.linearProgressIndicatorStyle, R.style.Widget_MaterialComponents_LinearProgressIndicator);
        this.f6600g = typedArrayObtainStyledAttributes.getInt(0, 1);
        this.f6601h = typedArrayObtainStyledAttributes.getInt(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        mo4303a();
        this.f6602i = this.f6601h == 1;
    }
}
