package p173q1;

import android.support.v4.media.session.MediaSessionCompat;

public final class C3402e {

    public final MediaSessionCompat f11447a;

    public C3399d f11448b;

    public final C3411h f11449c;

    public C3402e(C3411h c3411h, MediaSessionCompat mediaSessionCompat) {
        this.f11449c = c3411h;
        this.f11447a = mediaSessionCompat;
    }

    public final void m6901a() {
        MediaSessionCompat mediaSessionCompat = this.f11447a;
        if (mediaSessionCompat != null) {
            mediaSessionCompat.setPlaybackToLocal(this.f11449c.f11501n.f11625d);
            this.f11448b = null;
        }
    }
}
