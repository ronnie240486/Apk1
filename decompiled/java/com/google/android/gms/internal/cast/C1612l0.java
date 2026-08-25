package com.google.android.gms.internal.cast;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.google.android.gms.cast.framework.media.widget.ExpandedControllerActivity;
import com.p2serv.android.p032ds.R;
import p176q4.C3475c;
import p187r4.C3616f;
import p210t4.AbstractC3808a;

public final class C1612l0 extends AbstractC3808a {

    public final ImageView f5395b;

    public final Drawable f5396c;

    public final String f5397d;

    public final Drawable f5398e;

    public final String f5399f;

    public final Drawable f5400g;

    public final String f5401h;

    public boolean f5402i = false;

    public C1612l0(ImageView imageView, ExpandedControllerActivity expandedControllerActivity, Drawable drawable, Drawable drawable2, Drawable drawable3) {
        this.f5395b = imageView;
        this.f5396c = drawable;
        this.f5398e = drawable2;
        this.f5400g = drawable3 != null ? drawable3 : drawable2;
        this.f5397d = expandedControllerActivity.getString(R.string.cast_play);
        this.f5399f = expandedControllerActivity.getString(R.string.cast_pause);
        this.f5401h = expandedControllerActivity.getString(R.string.cast_stop);
        imageView.setEnabled(false);
    }

    @Override
    public final void mo3832b() {
        m3926h();
    }

    @Override
    public final void mo3833c() {
        m3925g(true);
    }

    @Override
    public final void mo3834d(C3475c c3475c) {
        super.mo3834d(c3475c);
        m3926h();
    }

    @Override
    public final void mo3835e() {
        this.f5395b.setEnabled(false);
        this.f12849a = null;
    }

    public final void m3924f(Drawable drawable, String str) {
        ImageView imageView = this.f5395b;
        boolean zEquals = drawable.equals(imageView.getDrawable());
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(str);
        imageView.setVisibility(0);
        imageView.setEnabled(true);
        if (zEquals || !this.f5402i) {
            return;
        }
        imageView.sendAccessibilityEvent(8);
    }

    public final void m3925g(boolean z7) {
        ImageView imageView = this.f5395b;
        this.f5402i = imageView.isAccessibilityFocused();
        imageView.setVisibility(0);
        imageView.setEnabled(!z7);
    }

    public final void m3926h() {
        C3616f c3616f = this.f12849a;
        if (c3616f == null || !c3616f.m7305i()) {
            this.f5395b.setEnabled(false);
            return;
        }
        if (c3616f.m7310n()) {
            if (c3616f.m7307k()) {
                m3924f(this.f5400g, this.f5401h);
                return;
            } else {
                m3924f(this.f5398e, this.f5399f);
                return;
            }
        }
        if (c3616f.m7306j()) {
            m3925g(false);
        } else if (c3616f.m7309m()) {
            m3924f(this.f5396c, this.f5397d);
        } else if (c3616f.m7308l()) {
            m3925g(true);
        }
    }
}
