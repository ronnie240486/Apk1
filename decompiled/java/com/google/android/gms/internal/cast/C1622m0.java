package com.google.android.gms.internal.cast;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import p176q4.C3475c;
import p187r4.C3616f;
import p210t4.AbstractC3808a;

public final class C1622m0 extends AbstractC3808a {

    public final int f5404b;

    public final View f5405c;

    public C1622m0(ImageView imageView, int i6) {
        this.f5404b = i6;
        switch (i6) {
            case 1:
                this.f5405c = imageView;
                imageView.setEnabled(false);
                break;
            default:
                this.f5405c = imageView;
                imageView.setEnabled(false);
                break;
        }
    }

    @Override
    public final void mo3832b() {
        switch (this.f5404b) {
            case 0:
                m3930f();
                break;
            case 1:
                m3931g();
                break;
            default:
                C3616f c3616f = this.f12849a;
                ProgressBar progressBar = (ProgressBar) this.f5405c;
                if (c3616f == null || !c3616f.m7305i() || c3616f.m7306j()) {
                    progressBar.setVisibility(0);
                } else {
                    progressBar.setVisibility(8);
                }
                break;
        }
    }

    @Override
    public final void mo3833c() {
        switch (this.f5404b) {
            case 0:
                ((ImageView) this.f5405c).setEnabled(false);
                break;
            case 1:
                ((ImageView) this.f5405c).setEnabled(false);
                break;
            default:
                ((ProgressBar) this.f5405c).setVisibility(0);
                break;
        }
    }

    @Override
    public final void mo3834d(C3475c c3475c) {
        switch (this.f5404b) {
            case 0:
                super.mo3834d(c3475c);
                m3930f();
                break;
            case 1:
                super.mo3834d(c3475c);
                m3931g();
                break;
            default:
                super.mo3834d(c3475c);
                C3616f c3616f = this.f12849a;
                ProgressBar progressBar = (ProgressBar) this.f5405c;
                if (c3616f == null || !c3616f.m7305i() || c3616f.m7306j()) {
                    progressBar.setVisibility(0);
                } else {
                    progressBar.setVisibility(8);
                }
                break;
        }
    }

    @Override
    public final void mo3835e() {
        switch (this.f5404b) {
            case 0:
                ((ImageView) this.f5405c).setEnabled(false);
                this.f12849a = null;
                break;
            case 1:
                ((ImageView) this.f5405c).setEnabled(false);
                this.f12849a = null;
                break;
            default:
                ((ProgressBar) this.f5405c).setVisibility(8);
                this.f12849a = null;
                break;
        }
    }

    public void m3930f() {
        C3616f c3616f = this.f12849a;
        ImageView imageView = (ImageView) this.f5405c;
        if (c3616f == null || !c3616f.m7291A() || c3616f.m7311o()) {
            imageView.setVisibility(0);
            imageView.setEnabled(false);
        } else {
            imageView.setVisibility(0);
            imageView.setEnabled(true);
        }
    }

    public void m3931g() {
        C3616f c3616f = this.f12849a;
        ImageView imageView = (ImageView) this.f5405c;
        if (c3616f == null || !c3616f.m7292B() || c3616f.m7311o()) {
            imageView.setVisibility(0);
            imageView.setEnabled(false);
        } else {
            imageView.setVisibility(0);
            imageView.setEnabled(true);
        }
    }

    public C1622m0(ProgressBar progressBar) {
        this.f5404b = 2;
        this.f5405c = progressBar;
    }
}
