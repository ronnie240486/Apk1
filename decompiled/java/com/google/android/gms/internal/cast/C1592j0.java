package com.google.android.gms.internal.cast;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.framework.media.CastMediaOptions;
import com.google.android.gms.cast.framework.media.ImageHints;
import com.google.android.gms.cast.framework.media.widget.ExpandedControllerActivity;
import com.google.android.gms.common.images.WebImage;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;
import p018b5.AbstractC1312l;
import p025c2.C1381b;
import p165p4.C3370o;
import p176q4.C3473b;
import p176q4.C3475c;
import p187r4.C3616f;
import p210t4.AbstractC3808a;
import p219u4.C3895c;

public final class C1592j0 extends AbstractC3808a {

    public final int f5356b;

    public final ImageView f5357c;

    public final Object f5358d;

    public final Object f5359e;

    public final Object f5360f;

    public Object f5361g;

    public C1592j0(ImageView imageView, ExpandedControllerActivity expandedControllerActivity) {
        this.f5356b = 1;
        this.f5357c = imageView;
        Context applicationContext = expandedControllerActivity.getApplicationContext();
        this.f5360f = applicationContext;
        this.f5358d = applicationContext.getString(R.string.cast_mute);
        this.f5359e = applicationContext.getString(R.string.cast_unmute);
        imageView.setEnabled(false);
        this.f5361g = null;
    }

    @Override
    public final void mo3832b() {
        switch (this.f5356b) {
            case 0:
                m3874h();
                break;
            default:
                m3872f();
                break;
        }
    }

    @Override
    public void mo3833c() {
        switch (this.f5356b) {
            case 1:
                this.f5357c.setEnabled(false);
                break;
        }
    }

    @Override
    public final void mo3834d(C3475c c3475c) {
        switch (this.f5356b) {
            case 0:
                super.mo3834d(c3475c);
                ((C1381b) this.f5361g).f4202f = new C1675r7(3, this);
                m3873g();
                m3874h();
                break;
            default:
                if (((C1602k0) this.f5361g) == null) {
                    this.f5361g = new C1602k0(0, this);
                }
                C1602k0 c1602k0 = (C1602k0) this.f5361g;
                c3475c.getClass();
                AbstractC1312l.m3195b("Must be called from the main thread.");
                if (c1602k0 != null) {
                    c3475c.f11757d.add(c1602k0);
                }
                super.mo3834d(c3475c);
                m3872f();
                break;
        }
    }

    @Override
    public final void mo3835e() {
        C1602k0 c1602k0;
        switch (this.f5356b) {
            case 0:
                C1381b c1381b = (C1381b) this.f5361g;
                c1381b.m3260j();
                c1381b.f4202f = null;
                m3873g();
                this.f12849a = null;
                break;
            default:
                this.f5357c.setEnabled(false);
                C3475c c3475cM7142c = C3473b.m7099b((Context) this.f5360f).m7102a().m7142c();
                if (c3475cM7142c != null && (c1602k0 = (C1602k0) this.f5361g) != null) {
                    AbstractC1312l.m3195b("Must be called from the main thread.");
                    c3475cM7142c.f11757d.remove(c1602k0);
                }
                this.f12849a = null;
                break;
        }
    }

    public void m3872f() {
        C3475c c3475cM7142c = C3473b.m7099b((Context) this.f5360f).m7102a().m7142c();
        ImageView imageView = this.f5357c;
        boolean z7 = false;
        if (c3475cM7142c == null || !c3475cM7142c.m7136a()) {
            imageView.setEnabled(false);
            return;
        }
        C3616f c3616f = this.f12849a;
        if (c3616f == null || !c3616f.m7305i()) {
            imageView.setEnabled(false);
        } else {
            imageView.setEnabled(true);
        }
        AbstractC1312l.m3195b("Must be called from the main thread.");
        C3370o c3370o = c3475cM7142c.f11762i;
        if (c3370o != null && c3370o.m6865j()) {
            AbstractC1312l.m3200g("Not connected to device", c3370o.m6865j());
            if (c3370o.f11391v) {
                z7 = true;
            }
        }
        imageView.setSelected(z7);
        imageView.setContentDescription(z7 ? (String) this.f5359e : (String) this.f5358d);
    }

    public void m3873g() {
        ImageView imageView = this.f5357c;
        View view = (View) this.f5359e;
        if (view != null) {
            view.setVisibility(0);
            imageView.setVisibility(4);
        }
        Bitmap bitmap = (Bitmap) this.f5358d;
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
        }
    }

    public void m3874h() {
        MediaMetadata mediaMetadata;
        ArrayList arrayList;
        C3616f c3616f = this.f12849a;
        if (c3616f == null || !c3616f.m7305i()) {
            m3873g();
            return;
        }
        MediaInfo mediaInfoM7301e = c3616f.m7301e();
        Uri uri = null;
        if (mediaInfoM7301e != null && (mediaMetadata = mediaInfoM7301e.f4641d) != null && (arrayList = mediaMetadata.f4677a) != null && arrayList.size() > 0) {
            uri = ((WebImage) arrayList.get(0)).f5023b;
        }
        if (uri == null) {
            m3873g();
        } else {
            ((C1381b) this.f5361g).m3259i(uri);
        }
    }

    public C1592j0(ImageView imageView, ExpandedControllerActivity expandedControllerActivity, ImageHints imageHints, View view, C3895c c3895c) {
        this.f5356b = 0;
        this.f5357c = imageView;
        this.f5360f = c3895c;
        this.f5358d = null;
        this.f5359e = view;
        C3473b c3473bM7100c = C3473b.m7100c(expandedControllerActivity);
        if (c3473bM7100c != null) {
            AbstractC1312l.m3195b("Must be called from the main thread.");
            CastMediaOptions castMediaOptions = c3473bM7100c.f11747e.f4768f;
            if (castMediaOptions != null) {
                castMediaOptions.m3622j();
            }
        }
        this.f5361g = new C1381b(expandedControllerActivity.getApplicationContext());
    }
}
