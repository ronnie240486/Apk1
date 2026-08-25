package com.google.android.gms.internal.cast;

import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.p2serv.android.p032ds.R;
import p176q4.AbstractC3480f;
import p176q4.C3475c;
import p187r4.C3616f;
import p187r4.C3626p;
import p187r4.InterfaceC3615e;
import p210t4.AbstractC3808a;

public final class C1641o0 extends AbstractC3808a implements InterfaceC3615e {

    public final TextView f5480b;

    public final ImageView f5481c;

    public final C3626p f5482d;

    public C1641o0(View view, C3626p c3626p) {
        TextView textView = (TextView) view.findViewById(R.id.live_indicator_text);
        this.f5480b = textView;
        ImageView imageView = (ImageView) view.findViewById(R.id.live_indicator_dot);
        this.f5481c = imageView;
        this.f5482d = c3626p;
        TypedArray typedArrayObtainStyledAttributes = imageView.getContext().obtainStyledAttributes(null, AbstractC3480f.f11774a, R.attr.castExpandedControllerStyle, R.style.CastExpandedController);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(13, 0);
        typedArrayObtainStyledAttributes.recycle();
        imageView.getDrawable().setColorFilter(imageView.getContext().getResources().getColor(resourceId), PorterDuff.Mode.SRC_IN);
        textView.setVisibility(8);
        imageView.setVisibility(8);
    }

    @Override
    public final void mo3844a() {
        m3955f();
    }

    @Override
    public final void mo3832b() {
        m3955f();
    }

    @Override
    public final void mo3834d(C3475c c3475c) {
        super.mo3834d(c3475c);
        C3616f c3616f = this.f12849a;
        if (c3616f != null) {
            c3616f.m7297a(this);
        }
        m3955f();
    }

    @Override
    public final void mo3835e() {
        C3616f c3616f = this.f12849a;
        if (c3616f != null) {
            c3616f.m7315s(this);
        }
        this.f12849a = null;
        m3955f();
    }

    public final void m3955f() {
        boolean zM7358l;
        C3616f c3616f = this.f12849a;
        ImageView imageView = this.f5481c;
        TextView textView = this.f5480b;
        if (c3616f == null || !c3616f.m7305i() || !c3616f.m7307k()) {
            textView.setVisibility(8);
            imageView.setVisibility(8);
            return;
        }
        if (c3616f.m7294D()) {
            C3626p c3626p = this.f5482d;
            zM7358l = c3626p.m7358l(c3626p.m7351e() + ((long) c3626p.m7347a()));
        } else {
            zM7358l = c3616f.m7310n();
        }
        textView.setVisibility(0);
        imageView.setVisibility(true == zM7358l ? 0 : 8);
        C1670r2.m3989a(EnumC1679s2.CAF_EXPANDED_CONTROLLER_WITH_LIVE_CONTENT);
    }
}
