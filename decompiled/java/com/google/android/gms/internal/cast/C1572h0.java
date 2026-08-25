package com.google.android.gms.internal.cast;

import android.widget.ImageView;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaTrack;
import com.google.android.gms.cast.framework.media.widget.ExpandedControllerActivity;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;
import java.util.Iterator;
import p176q4.C3475c;
import p187r4.C3616f;
import p210t4.AbstractC3808a;

public final class C1572h0 extends AbstractC3808a {

    public final ImageView f5333b;

    public final String f5334c;

    public final String f5335d;

    public C1572h0(ImageView imageView, ExpandedControllerActivity expandedControllerActivity) {
        this.f5333b = imageView;
        this.f5334c = expandedControllerActivity.getString(R.string.cast_closed_captions);
        this.f5335d = expandedControllerActivity.getString(R.string.cast_closed_captions_unavailable);
        imageView.setEnabled(false);
    }

    @Override
    public final void mo3832b() {
        m3836f();
    }

    @Override
    public final void mo3833c() {
        this.f5333b.setEnabled(false);
    }

    @Override
    public final void mo3834d(C3475c c3475c) {
        super.mo3834d(c3475c);
        this.f5333b.setEnabled(true);
        m3836f();
    }

    @Override
    public final void mo3835e() {
        this.f5333b.setEnabled(false);
        this.f12849a = null;
    }

    public final void m3836f() {
        MediaInfo mediaInfoM7301e;
        ArrayList arrayList;
        C3616f c3616f = this.f12849a;
        ImageView imageView = this.f5333b;
        if (c3616f != null && c3616f.m7305i() && (mediaInfoM7301e = c3616f.m7301e()) != null && (arrayList = mediaInfoM7301e.f4643f) != null && !arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            int i6 = 0;
            while (true) {
                if (it.hasNext()) {
                    int i10 = ((MediaTrack) it.next()).f4729b;
                    if (i10 == 2) {
                        i6++;
                        if (i6 > 1) {
                            break;
                        }
                    } else if (i10 == 1) {
                        break;
                    }
                }
            }
            if (!c3616f.m7311o()) {
                imageView.setEnabled(true);
                imageView.setContentDescription(this.f5334c);
                return;
            }
        }
        imageView.setEnabled(false);
        imageView.setContentDescription(this.f5335d);
    }
}
