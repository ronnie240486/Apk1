package p129m1;

import android.os.Messenger;
import androidx.media.MediaBrowserServiceCompat;
import java.util.ArrayList;

public class C3033e implements InterfaceC3031c {

    public final ArrayList f10367a = new ArrayList();

    public C3032d f10368b;

    public Messenger f10369c;

    public final MediaBrowserServiceCompat f10370d;

    public C3033e(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
        this.f10370d = mediaBrowserServiceCompat;
    }

    @Override
    public void mo6102a() {
        C3032d c3032d = new C3032d(this, this.f10370d);
        this.f10368b = c3032d;
        c3032d.onCreate();
    }
}
