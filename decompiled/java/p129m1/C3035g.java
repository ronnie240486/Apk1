package p129m1;

import androidx.media.MediaBrowserServiceCompat;

public class C3035g extends C3033e {

    public final MediaBrowserServiceCompat f10372e;

    public C3035g(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
        super(mediaBrowserServiceCompat);
        this.f10372e = mediaBrowserServiceCompat;
    }

    @Override
    public void mo6102a() {
        C3034f c3034f = new C3034f(this, this.f10372e);
        this.f10368b = c3034f;
        c3034f.onCreate();
    }
}
