package com.google.android.gms.internal.cast;

import android.view.View;
import android.widget.ImageView;
import androidx.media3.exoplayer.Renderer;
import com.google.android.gms.cast.AdBreakClipInfo;
import com.google.android.gms.cast.AdBreakInfo;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.framework.media.widget.CastSeekBar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p138n0.C3151r;
import p176q4.C3475c;
import p187r4.C3616f;
import p187r4.C3624n;
import p187r4.C3626p;
import p187r4.InterfaceC3615e;
import p210t4.AbstractC3808a;
import p219u4.C3893a;
import p219u4.C3894b;

public final class C1582i0 extends AbstractC3808a implements InterfaceC3615e {

    public final int f5340b;

    public final View f5341c;

    public final C3626p f5342d;

    public C1582i0(ImageView imageView, C3626p c3626p, int i6) {
        this.f5340b = i6;
        switch (i6) {
            case 1:
                this.f5341c = imageView;
                this.f5342d = c3626p;
                imageView.setEnabled(false);
                break;
            default:
                this.f5341c = imageView;
                this.f5342d = c3626p;
                imageView.setEnabled(false);
                break;
        }
    }

    @Override
    public final void mo3844a() {
        switch (this.f5340b) {
            case 0:
                m3845f();
                break;
            case 1:
                m3845f();
                break;
            default:
                m3846g();
                m3845f();
                break;
        }
    }

    @Override
    public final void mo3832b() {
        switch (this.f5340b) {
            case 0:
                m3845f();
                break;
            case 1:
                m3845f();
                break;
            default:
                m3847h();
                break;
        }
    }

    @Override
    public void mo3833c() {
        switch (this.f5340b) {
            case 0:
                ((ImageView) this.f5341c).setEnabled(false);
                break;
            case 1:
                ((ImageView) this.f5341c).setEnabled(false);
                break;
        }
    }

    @Override
    public final void mo3834d(C3475c c3475c) {
        switch (this.f5340b) {
            case 0:
                super.mo3834d(c3475c);
                C3616f c3616f = this.f12849a;
                if (c3616f != null) {
                    c3616f.m7297a(this);
                }
                m3845f();
                break;
            case 1:
                super.mo3834d(c3475c);
                C3616f c3616f2 = this.f12849a;
                if (c3616f2 != null) {
                    c3616f2.m7297a(this);
                }
                m3845f();
                break;
            default:
                super.mo3834d(c3475c);
                C3616f c3616f3 = this.f12849a;
                if (c3616f3 != null) {
                    c3616f3.m7297a(this);
                }
                m3847h();
                break;
        }
    }

    @Override
    public final void mo3835e() {
        switch (this.f5340b) {
            case 0:
                C3616f c3616f = this.f12849a;
                if (c3616f != null) {
                    c3616f.m7315s(this);
                }
                ((ImageView) this.f5341c).setEnabled(false);
                this.f12849a = null;
                m3845f();
                break;
            case 1:
                C3616f c3616f2 = this.f12849a;
                if (c3616f2 != null) {
                    c3616f2.m7315s(this);
                }
                ((ImageView) this.f5341c).setEnabled(false);
                this.f12849a = null;
                m3845f();
                break;
            default:
                C3616f c3616f3 = this.f12849a;
                if (c3616f3 != null) {
                    c3616f3.m7315s(this);
                }
                this.f12849a = null;
                m3847h();
                break;
        }
    }

    public final void m3845f() {
        switch (this.f5340b) {
            case 0:
                C3616f c3616f = this.f12849a;
                ImageView imageView = (ImageView) this.f5341c;
                boolean z7 = false;
                if (c3616f == null || !c3616f.m7305i() || c3616f.m7311o()) {
                    imageView.setEnabled(false);
                } else if (!c3616f.m7307k()) {
                    imageView.setEnabled(true);
                } else {
                    if (c3616f.m7294D()) {
                        C3626p c3626p = this.f5342d;
                        if (!c3626p.m7358l(c3626p.m7351e() + ((long) c3626p.m7347a()))) {
                            z7 = true;
                        }
                    }
                    imageView.setEnabled(z7);
                }
                break;
            case 1:
                C3616f c3616f2 = this.f12849a;
                ImageView imageView2 = (ImageView) this.f5341c;
                boolean z10 = false;
                if (c3616f2 == null || !c3616f2.m7305i() || c3616f2.m7311o()) {
                    imageView2.setEnabled(false);
                } else if (!c3616f2.m7307k()) {
                    imageView2.setEnabled(true);
                } else {
                    if (c3616f2.m7294D()) {
                        C3626p c3626p2 = this.f5342d;
                        if ((c3626p2.m7351e() + ((long) c3626p2.m7347a())) - (c3626p2.m7351e() + ((long) c3626p2.m7350d())) >= Renderer.DEFAULT_DURATION_TO_PROGRESS_US) {
                            z10 = true;
                        }
                    }
                    imageView2.setEnabled(z10);
                }
                break;
            default:
                C3616f c3616f3 = this.f12849a;
                CastSeekBar castSeekBar = (CastSeekBar) this.f5341c;
                if (c3616f3 != null && c3616f3.m7311o()) {
                    int iM7298b = (int) c3616f3.m7298b();
                    MediaStatus mediaStatusM7302f = c3616f3.m7302f();
                    AdBreakClipInfo adBreakClipInfoM3601j = mediaStatusM7302f != null ? mediaStatusM7302f.m3601j() : null;
                    int i6 = adBreakClipInfoM3601j != null ? (int) adBreakClipInfoM3601j.f4566c : iM7298b;
                    if (iM7298b < 0) {
                        iM7298b = 0;
                    }
                    if (i6 < 0) {
                        i6 = 1;
                    }
                    if (iM7298b > i6) {
                        i6 = iM7298b;
                    }
                    C3151r c3151r = new C3151r();
                    c3151r.f10634a = iM7298b;
                    c3151r.f10635b = i6;
                    castSeekBar.f4886d = c3151r;
                    castSeekBar.postInvalidate();
                } else {
                    castSeekBar.f4886d = null;
                    castSeekBar.postInvalidate();
                }
                break;
        }
    }

    public void m3846g() {
        C3616f c3616f = this.f12849a;
        CastSeekBar castSeekBar = (CastSeekBar) this.f5341c;
        if (c3616f == null || !c3616f.m7305i() || c3616f.m7311o()) {
            castSeekBar.setEnabled(false);
        } else {
            castSeekBar.setEnabled(true);
        }
        C3626p c3626p = this.f5342d;
        int iM7347a = c3626p.m7347a();
        int iM7348b = c3626p.m7348b();
        int i6 = (int) (-c3626p.m7351e());
        C3616f c3616f2 = this.f12849a;
        int iM7350d = (c3616f2 != null && c3616f2.m7305i() && c3616f2.m7294D()) ? c3626p.m7350d() : c3626p.m7347a();
        C3616f c3616f3 = this.f12849a;
        int iM7349c = (c3616f3 != null && c3616f3.m7305i() && c3616f3.m7294D()) ? c3626p.m7349c() : c3626p.m7347a();
        C3616f c3616f4 = this.f12849a;
        boolean z7 = c3616f4 != null && c3616f4.m7305i() && c3616f4.m7294D();
        if (castSeekBar.f4884b) {
            return;
        }
        C3894b c3894b = new C3894b();
        c3894b.f13088a = iM7347a;
        c3894b.f13089b = iM7348b;
        c3894b.f13090c = i6;
        c3894b.f13091d = iM7350d;
        c3894b.f13092e = iM7349c;
        c3894b.f13093f = z7;
        castSeekBar.f4883a = c3894b;
        castSeekBar.f4885c = null;
        C3624n c3624n = castSeekBar.f4888f;
        if (c3624n != null) {
            castSeekBar.getProgress();
            c3624n.m7342j(false);
        }
        castSeekBar.postInvalidate();
    }

    public void m3847h() {
        m3846g();
        C3616f c3616f = this.f12849a;
        ArrayList arrayList = null;
        MediaInfo mediaInfoM7301e = c3616f == null ? null : c3616f.m7301e();
        CastSeekBar castSeekBar = (CastSeekBar) this.f5341c;
        if (c3616f == null || !c3616f.m7305i() || c3616f.m7308l() || mediaInfoM7301e == null) {
            castSeekBar.m3623a(null);
        } else {
            ArrayList arrayList2 = mediaInfoM7301e.f4646i;
            List<AdBreakInfo> listUnmodifiableList = arrayList2 == null ? null : Collections.unmodifiableList(arrayList2);
            if (listUnmodifiableList != null) {
                arrayList = new ArrayList();
                for (AdBreakInfo adBreakInfo : listUnmodifiableList) {
                    if (adBreakInfo != null) {
                        C3626p c3626p = this.f5342d;
                        long j10 = adBreakInfo.f4577a;
                        int iM7348b = j10 == -1000 ? c3626p.m7348b() : Math.min((int) (j10 - c3626p.m7351e()), c3626p.m7348b());
                        if (iM7348b >= 0) {
                            arrayList.add(new C3893a(iM7348b, (int) adBreakInfo.f4579c, adBreakInfo.f4583g));
                        }
                    }
                }
            }
            castSeekBar.m3623a(arrayList);
        }
        m3845f();
    }

    public C1582i0(CastSeekBar castSeekBar, C3626p c3626p) {
        this.f5340b = 2;
        this.f5341c = castSeekBar;
        this.f5342d = c3626p;
        castSeekBar.setEnabled(false);
        castSeekBar.m3623a(null);
        castSeekBar.f4886d = null;
        castSeekBar.postInvalidate();
    }
}
