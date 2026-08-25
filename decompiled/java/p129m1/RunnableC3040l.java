package p129m1;

import android.os.IBinder;
import androidx.media.MediaBrowserServiceCompat;
import p101j7.C2782c;

public final class RunnableC3040l implements Runnable {

    public final int f10380a;

    public final C3044p f10381b;

    public final C2782c f10382c;

    public RunnableC3040l(C2782c c2782c, C3044p c3044p, int i6) {
        this.f10380a = i6;
        this.f10382c = c2782c;
        this.f10381b = c3044p;
    }

    @Override
    public final void run() {
        switch (this.f10380a) {
            case 0:
                C3030b c3030b = (C3030b) ((MediaBrowserServiceCompat) this.f10382c.f9501b).f2574d.remove(this.f10381b.f10399a.getBinder());
                if (c3030b != null) {
                    c3030b.f10363d.f10399a.getBinder().unlinkToDeath(c3030b, 0);
                }
                break;
            default:
                IBinder binder = this.f10381b.f10399a.getBinder();
                C3030b c3030b2 = (C3030b) ((MediaBrowserServiceCompat) this.f10382c.f9501b).f2574d.remove(binder);
                if (c3030b2 != null) {
                    binder.unlinkToDeath(c3030b2, 0);
                }
                break;
        }
    }
}
