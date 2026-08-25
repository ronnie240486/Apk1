package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.bumptech.glide.AbstractC1466d;
import com.google.android.material.internal.AbstractC1811a0;
import com.p2serv.android.p032ds.R;
import p178q6.AbstractC3508e;
import p250x5.AbstractC4121a;

public final class CircularProgressIndicatorSpec extends AbstractC3508e {

    public int f6596g;

    public int f6597h;

    public int f6598i;

    public CircularProgressIndicatorSpec(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.circularProgressIndicatorStyle);
    }

    public CircularProgressIndicatorSpec(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6, R.style.Widget_MaterialComponents_CircularProgressIndicator);
        int i10 = CircularProgressIndicator.f6595l;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.mtrl_progress_circular_size_medium);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.mtrl_progress_circular_inset_medium);
        int[] iArr = AbstractC4121a.f13997k;
        AbstractC1811a0.m4241a(context, attributeSet, i6, R.style.Widget_MaterialComponents_CircularProgressIndicator);
        AbstractC1811a0.m4242b(context, attributeSet, iArr, i6, R.style.Widget_MaterialComponents_CircularProgressIndicator, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i6, R.style.Widget_MaterialComponents_CircularProgressIndicator);
        this.f6596g = Math.max(AbstractC1466d.m3494l(context, typedArrayObtainStyledAttributes, 2, dimensionPixelSize), this.f11809a * 2);
        this.f6597h = AbstractC1466d.m3494l(context, typedArrayObtainStyledAttributes, 1, dimensionPixelSize2);
        this.f6598i = typedArrayObtainStyledAttributes.getInt(0, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override
    public final void mo4303a() {
    }
}
