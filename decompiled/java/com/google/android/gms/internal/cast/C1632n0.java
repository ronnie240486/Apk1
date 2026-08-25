package com.google.android.gms.internal.cast;

import android.widget.TextView;
import com.google.android.gms.cast.MediaInfo;
import com.p2serv.android.p032ds.R;
import p176q4.C3475c;
import p187r4.C3616f;
import p187r4.C3626p;
import p187r4.InterfaceC3615e;
import p210t4.AbstractC3808a;

public final class C1632n0 extends AbstractC3808a implements InterfaceC3615e {

    public final int f5419b;

    public final TextView f5420c;

    public final C3626p f5421d;

    public C1632n0(TextView textView, C3626p c3626p, int i6) {
        this.f5419b = i6;
        switch (i6) {
            case 1:
                this.f5420c = textView;
                this.f5421d = c3626p;
                textView.setText(textView.getContext().getString(R.string.cast_invalid_stream_duration_text));
                break;
            default:
                this.f5420c = textView;
                this.f5421d = c3626p;
                textView.setText(textView.getContext().getString(R.string.cast_invalid_stream_duration_text));
                break;
        }
    }

    @Override
    public final void mo3844a() {
        switch (this.f5419b) {
            case 0:
                m3952f();
                break;
            default:
                m3952f();
                break;
        }
    }

    @Override
    public final void mo3832b() {
        switch (this.f5419b) {
            case 0:
                m3952f();
                break;
            default:
                m3952f();
                break;
        }
    }

    @Override
    public final void mo3834d(C3475c c3475c) {
        switch (this.f5419b) {
            case 0:
                super.mo3834d(c3475c);
                C3616f c3616f = this.f12849a;
                if (c3616f != null) {
                    c3616f.m7297a(this);
                }
                m3952f();
                break;
            default:
                super.mo3834d(c3475c);
                C3616f c3616f2 = this.f12849a;
                if (c3616f2 != null) {
                    c3616f2.m7297a(this);
                }
                m3952f();
                break;
        }
    }

    @Override
    public final void mo3835e() {
        switch (this.f5419b) {
            case 0:
                C3616f c3616f = this.f12849a;
                if (c3616f != null) {
                    c3616f.m7315s(this);
                }
                this.f12849a = null;
                m3952f();
                break;
            default:
                C3616f c3616f2 = this.f12849a;
                if (c3616f2 != null) {
                    c3616f2.m7315s(this);
                }
                this.f12849a = null;
                m3952f();
                break;
        }
    }

    public final void m3952f() {
        switch (this.f5419b) {
            case 0:
                C3616f c3616f = this.f12849a;
                TextView textView = this.f5420c;
                if (c3616f != null && c3616f.m7305i()) {
                    boolean zM7307k = c3616f.m7307k();
                    C3626p c3626p = this.f5421d;
                    if (zM7307k && c3626p.m7354h() == null) {
                        textView.setVisibility(8);
                    } else {
                        textView.setVisibility(0);
                        textView.setText(c3626p.m7357k(c3626p.m7351e() + ((long) c3626p.m7348b())));
                    }
                } else {
                    textView.setText(textView.getContext().getString(R.string.cast_invalid_stream_duration_text));
                }
                break;
            default:
                C3616f c3616f2 = this.f12849a;
                TextView textView2 = this.f5420c;
                if (c3616f2 != null && c3616f2.m7305i()) {
                    long jM7299c = c3616f2.m7299c();
                    if (jM7299c == MediaInfo.f4637s) {
                        jM7299c = c3616f2.m7304h();
                    }
                    textView2.setText(this.f5421d.m7357k(jM7299c));
                } else {
                    textView2.setText(textView2.getContext().getString(R.string.cast_invalid_stream_duration_text));
                }
                break;
        }
    }
}
