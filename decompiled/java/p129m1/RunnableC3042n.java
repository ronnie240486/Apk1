package p129m1;

import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.os.ResultReceiver;
import android.util.Log;
import androidx.media.MediaBrowserServiceCompat;
import p101j7.C2782c;

public final class RunnableC3042n implements Runnable {

    public final int f10389a = 1;

    public final C3044p f10390b;

    public final String f10391c;

    public final ResultReceiver f10392d;

    public final C2782c f10393e;

    public RunnableC3042n(C2782c c2782c, C3044p c3044p, String str, ResultReceiver resultReceiver) {
        this.f10393e = c2782c;
        this.f10390b = c3044p;
        this.f10391c = str;
        this.f10392d = resultReceiver;
    }

    @Override
    public final void run() {
        switch (this.f10389a) {
            case 0:
                IBinder binder = this.f10390b.f10399a.getBinder();
                C2782c c2782c = this.f10393e;
                if (((C3030b) ((MediaBrowserServiceCompat) c2782c.f9501b).f2574d.get(binder)) != null) {
                    ((MediaBrowserServiceCompat) c2782c.f9501b).getClass();
                    ResultReceiver resultReceiver = this.f10392d;
                    if ((2 & 2) == 0) {
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("media_item", null);
                        resultReceiver.send(0, bundle);
                    } else {
                        resultReceiver.send(-1, null);
                    }
                } else {
                    Log.w("MBServiceCompat", "getMediaItem for callback that isn't registered id=" + this.f10391c);
                }
                break;
            default:
                IBinder binder2 = this.f10390b.f10399a.getBinder();
                C2782c c2782c2 = this.f10393e;
                if (((C3030b) ((MediaBrowserServiceCompat) c2782c2.f9501b).f2574d.get(binder2)) != null) {
                    ((MediaBrowserServiceCompat) c2782c2.f9501b).getClass();
                    this.f10392d.send(-1, null);
                } else {
                    Log.w("MBServiceCompat", "search for callback that isn't registered query=" + this.f10391c);
                }
                break;
        }
    }

    public RunnableC3042n(C2782c c2782c, C3044p c3044p, String str, Bundle bundle, ResultReceiver resultReceiver) {
        this.f10393e = c2782c;
        this.f10390b = c3044p;
        this.f10391c = str;
        this.f10392d = resultReceiver;
    }
}
