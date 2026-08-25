package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import com.p2serv.android.p032ds.R;
import java.util.WeakHashMap;
import p138n0.AbstractC3155s0;
import p178q6.AbstractC3507d;
import p178q6.AbstractC3508e;
import p178q6.C3513j;
import p178q6.C3518o;
import p178q6.C3519p;
import p178q6.C3520q;
import p178q6.C3522s;

public final class LinearProgressIndicator extends AbstractC3507d {

    public static final int f6599l = 0;

    public LinearProgressIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.linearProgressIndicatorStyle);
    }

    @Override
    public final AbstractC3508e mo4302a(Context context, AttributeSet attributeSet) {
        return new LinearProgressIndicatorSpec(context, attributeSet);
    }

    @Override
    public final void mo4304b(int i6) {
        AbstractC3508e abstractC3508e = this.f11798a;
        if (abstractC3508e != null && ((LinearProgressIndicatorSpec) abstractC3508e).f6600g == 0 && isIndeterminate()) {
            return;
        }
        super.mo4304b(i6);
    }

    public int getIndeterminateAnimationType() {
        return ((LinearProgressIndicatorSpec) this.f11798a).f6600g;
    }

    public int getIndicatorDirection() {
        return ((LinearProgressIndicatorSpec) this.f11798a).f6601h;
    }

    @Override
    public final void onLayout(boolean z7, int i6, int i10, int i11, int i12) {
        super.onLayout(z7, i6, i10, i11, i12);
        AbstractC3508e abstractC3508e = this.f11798a;
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = (LinearProgressIndicatorSpec) abstractC3508e;
        boolean z10 = true;
        if (((LinearProgressIndicatorSpec) abstractC3508e).f6601h != 1) {
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            if ((getLayoutDirection() != 1 || ((LinearProgressIndicatorSpec) abstractC3508e).f6601h != 2) && (getLayoutDirection() != 0 || ((LinearProgressIndicatorSpec) abstractC3508e).f6601h != 3)) {
                z10 = false;
            }
        }
        linearProgressIndicatorSpec.f6602i = z10;
    }

    @Override
    public final void onSizeChanged(int i6, int i10, int i11, int i12) {
        int paddingRight = i6 - (getPaddingRight() + getPaddingLeft());
        int paddingBottom = i10 - (getPaddingBottom() + getPaddingTop());
        C3518o indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable != null) {
            indeterminateDrawable.setBounds(0, 0, paddingRight, paddingBottom);
        }
        C3513j progressDrawable = getProgressDrawable();
        if (progressDrawable != null) {
            progressDrawable.setBounds(0, 0, paddingRight, paddingBottom);
        }
    }

    public void setIndeterminateAnimationType(int i6) {
        AbstractC3508e abstractC3508e = this.f11798a;
        if (((LinearProgressIndicatorSpec) abstractC3508e).f6600g == i6) {
            return;
        }
        if (m7148c() && isIndeterminate()) {
            throw new IllegalStateException("Cannot change indeterminate animation type while the progress indicator is show in indeterminate mode.");
        }
        ((LinearProgressIndicatorSpec) abstractC3508e).f6600g = i6;
        ((LinearProgressIndicatorSpec) abstractC3508e).mo4303a();
        if (i6 == 0) {
            C3518o indeterminateDrawable = getIndeterminateDrawable();
            C3520q c3520q = new C3520q((LinearProgressIndicatorSpec) abstractC3508e);
            indeterminateDrawable.f11859m = c3520q;
            c3520q.f11855a = indeterminateDrawable;
        } else {
            C3518o indeterminateDrawable2 = getIndeterminateDrawable();
            C3522s c3522s = new C3522s(getContext(), (LinearProgressIndicatorSpec) abstractC3508e);
            indeterminateDrawable2.f11859m = c3522s;
            c3522s.f11855a = indeterminateDrawable2;
        }
        invalidate();
    }

    @Override
    public void setIndicatorColor(int... iArr) {
        super.setIndicatorColor(iArr);
        ((LinearProgressIndicatorSpec) this.f11798a).mo4303a();
    }

    public void setIndicatorDirection(int i6) {
        AbstractC3508e abstractC3508e = this.f11798a;
        ((LinearProgressIndicatorSpec) abstractC3508e).f6601h = i6;
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = (LinearProgressIndicatorSpec) abstractC3508e;
        boolean z7 = true;
        if (i6 != 1) {
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            if ((getLayoutDirection() != 1 || ((LinearProgressIndicatorSpec) abstractC3508e).f6601h != 2) && (getLayoutDirection() != 0 || i6 != 3)) {
                z7 = false;
            }
        }
        linearProgressIndicatorSpec.f6602i = z7;
        invalidate();
    }

    @Override
    public void setTrackCornerRadius(int i6) {
        super.setTrackCornerRadius(i6);
        ((LinearProgressIndicatorSpec) this.f11798a).mo4303a();
        invalidate();
    }

    public LinearProgressIndicator(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6, R.style.Widget_MaterialComponents_LinearProgressIndicator);
        Context context2 = getContext();
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = (LinearProgressIndicatorSpec) this.f11798a;
        setIndeterminateDrawable(new C3518o(context2, linearProgressIndicatorSpec, new C3519p(linearProgressIndicatorSpec), linearProgressIndicatorSpec.f6600g == 0 ? new C3520q(linearProgressIndicatorSpec) : new C3522s(context2, linearProgressIndicatorSpec)));
        setProgressDrawable(new C3513j(getContext(), linearProgressIndicatorSpec, new C3519p(linearProgressIndicatorSpec)));
    }
}
