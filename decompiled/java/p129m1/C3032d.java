package p129m1;

import android.content.Context;
import android.os.Bundle;
import android.os.Messenger;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.media.MediaBrowserServiceCompat;

public class C3032d extends MediaBrowserService {

    public final C3033e f10366a;

    public C3032d(C3033e c3033e, Context context) {
        this.f10366a = c3033e;
        attachBaseContext(context);
    }

    @Override
    public final MediaBrowserService.BrowserRoot onGetRoot(String str, int i6, Bundle bundle) {
        int i10;
        MediaSessionCompat.ensureClassLoader(bundle);
        Bundle bundle2 = bundle == null ? null : new Bundle(bundle);
        C3033e c3033e = this.f10366a;
        MediaBrowserServiceCompat mediaBrowserServiceCompat = c3033e.f10370d;
        if (bundle2 == null || bundle2.getInt("extra_client_version", 0) == 0) {
            i10 = -1;
        } else {
            bundle2.remove("extra_client_version");
            c3033e.f10369c = new Messenger(mediaBrowserServiceCompat.f2575e);
            Bundle bundle3 = new Bundle();
            bundle3.putInt("extra_service_version", 2);
            bundle3.putBinder("extra_messenger", c3033e.f10369c.getBinder());
            c3033e.f10367a.add(bundle3);
            int i11 = bundle2.getInt("extra_calling_pid", -1);
            bundle2.remove("extra_calling_pid");
            i10 = i11;
        }
        C3030b c3030b = new C3030b(c3033e.f10370d, str, i10, i6, null);
        mediaBrowserServiceCompat.getClass();
        if (mediaBrowserServiceCompat.m1531a() == null) {
            return null;
        }
        if (c3033e.f10369c == null) {
            throw null;
        }
        mediaBrowserServiceCompat.f2573c.add(c3030b);
        throw null;
    }

    @Override
    public final void onLoadChildren(String str, MediaBrowserService.Result result) {
        C3033e c3033e = this.f10366a;
        c3033e.getClass();
        MediaBrowserServiceCompat mediaBrowserServiceCompat = c3033e.f10370d;
        C3030b c3030b = mediaBrowserServiceCompat.f2572b;
        mediaBrowserServiceCompat.m1532b();
    }
}
