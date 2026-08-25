package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import com.p2serv.android.p032ds.R;
import p178q6.AbstractC3507d;
import p178q6.AbstractC3508e;
import p178q6.C3509f;
import p178q6.C3511h;
import p178q6.C3513j;
import p178q6.C3518o;

public final class CircularProgressIndicator extends AbstractC3507d {

    public static final int f6595l = 0;

    public CircularProgressIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.circularProgressIndicatorStyle);
    }

    @Override
    public final AbstractC3508e mo4302a(Context context, AttributeSet attributeSet) {
        return new CircularProgressIndicatorSpec(context, attributeSet);
    }

    public int getIndicatorDirection() {
        return ((CircularProgressIndicatorSpec) this.f11798a).f6598i;
    }

    public int getIndicatorInset() {
        return ((CircularProgressIndicatorSpec) this.f11798a).f6597h;
    }

    public int getIndicatorSize() {
        return ((CircularProgressIndicatorSpec) this.f11798a).f6596g;
    }

    public void setIndicatorDirection(int i6) {
        ((CircularProgressIndicatorSpec) this.f11798a).f6598i = i6;
        invalidate();
    }

    public void setIndicatorInset(int i6) {
        AbstractC3508e abstractC3508e = this.f11798a;
        if (((CircularProgressIndicatorSpec) abstractC3508e).f6597h != i6) {
            ((CircularProgressIndicatorSpec) abstractC3508e).f6597h = i6;
            invalidate();
        }
    }

    public void setIndicatorSize(int i6) {
        int iMax = Math.max(i6, getTrackThickness() * 2);
        AbstractC3508e abstractC3508e = this.f11798a;
        if (((CircularProgressIndicatorSpec) abstractC3508e).f6596g != iMax) {
            ((CircularProgressIndicatorSpec) abstractC3508e).f6596g = iMax;
            ((CircularProgressIndicatorSpec) abstractC3508e).getClass();
            invalidate();
        }
    }

    @Override
    public void setTrackThickness(int i6) {
        super.setTrackThickness(i6);
        ((CircularProgressIndicatorSpec) this.f11798a).getClass();
    }

    public CircularProgressIndicator(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6, R.style.Widget_MaterialComponents_CircularProgressIndicator);
        Context context2 = getContext();
        CircularProgressIndicatorSpec circularProgressIndicatorSpec = (CircularProgressIndicatorSpec) this.f11798a;
        setIndeterminateDrawable(new C3518o(context2, circularProgressIndicatorSpec, new C3509f(circularProgressIndicatorSpec), new C3511h(circularProgressIndicatorSpec)));
        setProgressDrawable(new C3513j(getContext(), circularProgressIndicatorSpec, new C3509f(circularProgressIndicatorSpec)));
    }
}
