package p129m1;

import androidx.media.MediaBrowserServiceCompat;

public class C3037i extends C3035g {

    public final MediaBrowserServiceCompat f10374f;

    public C3037i(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
        super(mediaBrowserServiceCompat);
        this.f10374f = mediaBrowserServiceCompat;
    }

    @Override
    public final void mo6102a() {
        C3036h c3036h = new C3036h(this, this.f10374f);
        this.f10368b = c3036h;
        c3036h.onCreate();
    }
}
