package p129m1;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.media.MediaBrowserServiceCompat;
import java.util.Iterator;
import p101j7.C2782c;

public final class RunnableC3043o implements Runnable {

    public final C3044p f10394a;

    public final int f10395b;

    public final String f10396c;

    public final int f10397d;

    public final C2782c f10398e;

    public RunnableC3043o(int i6, int i10, Bundle bundle, C2782c c2782c, String str, C3044p c3044p) {
        this.f10398e = c2782c;
        this.f10394a = c3044p;
        this.f10395b = i6;
        this.f10396c = str;
        this.f10397d = i10;
    }

    @Override
    public final void run() {
        C3030b c3030b;
        C3044p c3044p = this.f10394a;
        IBinder binder = c3044p.f10399a.getBinder();
        C2782c c2782c = this.f10398e;
        ((MediaBrowserServiceCompat) c2782c.f9501b).f2574d.remove(binder);
        MediaBrowserServiceCompat mediaBrowserServiceCompat = (MediaBrowserServiceCompat) c2782c.f9501b;
        Iterator it = mediaBrowserServiceCompat.f2573c.iterator();
        while (true) {
            c3030b = null;
            if (!it.hasNext()) {
                break;
            }
            C3030b c3030b2 = (C3030b) it.next();
            if (c3030b2.f10362c == this.f10395b) {
                if (TextUtils.isEmpty(this.f10396c) || this.f10397d <= 0) {
                    c3030b = new C3030b((MediaBrowserServiceCompat) c2782c.f9501b, c3030b2.f10360a, c3030b2.f10361b, c3030b2.f10362c, c3044p);
                }
                it.remove();
                break;
            }
        }
        if (c3030b == null) {
            c3030b = new C3030b((MediaBrowserServiceCompat) c2782c.f9501b, this.f10396c, this.f10397d, this.f10395b, c3044p);
        }
        mediaBrowserServiceCompat.f2574d.put(binder, c3030b);
        try {
            binder.linkToDeath(c3030b, 0);
        } catch (RemoteException unused) {
            Log.w("MBServiceCompat", "IBinder is already dead.");
        }
    }
}
