package com.google.android.gms.internal.cast;

import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.cast.framework.media.widget.CastSeekBar;
import com.p2serv.android.p032ds.R;
import p176q4.AbstractC3480f;
import p176q4.C3475c;
import p187r4.C3616f;
import p187r4.C3626p;
import p210t4.AbstractC3808a;

public final class C1650p0 extends AbstractC3808a {

    public boolean f5532b = true;

    public final RelativeLayout f5533c;

    public final TextView f5534d;

    public final CastSeekBar f5535e;

    public final C3626p f5536f;

    public C1650p0(RelativeLayout relativeLayout, CastSeekBar castSeekBar, C3626p c3626p) {
        this.f5533c = relativeLayout;
        TextView textView = (TextView) relativeLayout.findViewById(R.id.tooltip);
        this.f5534d = textView;
        this.f5535e = castSeekBar;
        this.f5536f = c3626p;
        TypedArray typedArrayObtainStyledAttributes = textView.getContext().obtainStyledAttributes(null, AbstractC3480f.f11774a, R.attr.castExpandedControllerStyle, R.style.CastExpandedController);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(22, 0);
        typedArrayObtainStyledAttributes.recycle();
        textView.getBackground().setColorFilter(textView.getContext().getResources().getColor(resourceId), PorterDuff.Mode.SRC_IN);
    }

    @Override
    public final void mo3832b() {
        m3968f();
    }

    @Override
    public final void mo3834d(C3475c c3475c) {
        super.mo3834d(c3475c);
        m3968f();
    }

    @Override
    public final void mo3835e() {
        this.f12849a = null;
        m3968f();
    }

    public final void m3968f() {
        C3616f c3616f = this.f12849a;
        RelativeLayout relativeLayout = this.f5533c;
        if (c3616f == null || !c3616f.m7305i() || this.f5532b) {
            relativeLayout.setVisibility(8);
            return;
        }
        relativeLayout.setVisibility(0);
        CastSeekBar castSeekBar = this.f5535e;
        long progress = castSeekBar.getProgress();
        C3626p c3626p = this.f5536f;
        String strM7357k = c3626p.m7357k(c3626p.m7351e() + progress);
        TextView textView = this.f5534d;
        textView.setText(strM7357k);
        int measuredWidth = (castSeekBar.getMeasuredWidth() - castSeekBar.getPaddingLeft()) - castSeekBar.getPaddingRight();
        textView.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth2 = textView.getMeasuredWidth();
        int iMin = Math.min(Math.max(0, ((int) ((((double) castSeekBar.getProgress()) / ((double) castSeekBar.getMaxProgress())) * ((double) measuredWidth))) - (measuredWidth2 / 2)), measuredWidth - measuredWidth2);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
        layoutParams.leftMargin = iMin;
        textView.setLayoutParams(layoutParams);
    }
}
