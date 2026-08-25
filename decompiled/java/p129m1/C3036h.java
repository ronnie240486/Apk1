package p129m1;

import android.content.Context;
import android.os.Bundle;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.media.MediaBrowserServiceCompat;

public final class C3036h extends C3034f {

    public final C3037i f10373c;

    public C3036h(C3037i c3037i, Context context) {
        super(c3037i, context);
        this.f10373c = c3037i;
    }

    @Override
    public final void onLoadChildren(String str, MediaBrowserService.Result result, Bundle bundle) {
        MediaSessionCompat.ensureClassLoader(bundle);
        C3037i c3037i = this.f10373c;
        MediaBrowserServiceCompat mediaBrowserServiceCompat = c3037i.f10374f;
        C3030b c3030b = mediaBrowserServiceCompat.f2572b;
        mediaBrowserServiceCompat.m1532b();
        c3037i.f10374f.getClass();
    }
}
