package p129m1;

import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.os.ResultReceiver;
import android.util.Log;
import androidx.media.MediaBrowserServiceCompat;
import com.bumptech.glide.AbstractC1465c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import p101j7.C2782c;
import p128m0.C3026b;

public final class RunnableC3041m implements Runnable {

    public final int f10383a = 1;

    public final C3044p f10384b;

    public final String f10385c;

    public final Bundle f10386d;

    public final C2782c f10387e;

    public final Object f10388f;

    public RunnableC3041m(C2782c c2782c, C3044p c3044p, String str, IBinder iBinder, Bundle bundle) {
        this.f10387e = c2782c;
        this.f10384b = c3044p;
        this.f10385c = str;
        this.f10388f = iBinder;
        this.f10386d = bundle;
    }

    @Override
    public final void run() {
        switch (this.f10383a) {
            case 0:
                IBinder binder = this.f10384b.f10399a.getBinder();
                C2782c c2782c = this.f10387e;
                C3030b c3030b = (C3030b) ((MediaBrowserServiceCompat) c2782c.f9501b).f2574d.get(binder);
                String str = this.f10385c;
                if (c3030b == null) {
                    Log.w("MBServiceCompat", "addSubscription for callback that isn't registered id=" + str);
                    return;
                }
                MediaBrowserServiceCompat mediaBrowserServiceCompat = (MediaBrowserServiceCompat) c2782c.f9501b;
                mediaBrowserServiceCompat.getClass();
                HashMap map = c3030b.f10364e;
                List arrayList = (List) map.get(str);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                Iterator it = arrayList.iterator();
                while (true) {
                    boolean zHasNext = it.hasNext();
                    IBinder iBinder = (IBinder) this.f10388f;
                    Bundle bundle = this.f10386d;
                    if (!zHasNext) {
                        arrayList.add(new C3026b(iBinder, bundle));
                        map.put(str, arrayList);
                        if (bundle == null) {
                            mediaBrowserServiceCompat.m1532b();
                        } else {
                            mediaBrowserServiceCompat.m1532b();
                        }
                        throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + c3030b.f10360a + " id=" + str);
                    }
                    C3026b c3026b = (C3026b) it.next();
                    if (iBinder == c3026b.f10354a && AbstractC1465c.m3467b(bundle, (Bundle) c3026b.f10355b)) {
                        return;
                    }
                }
                break;
            default:
                IBinder binder2 = this.f10384b.f10399a.getBinder();
                C2782c c2782c2 = this.f10387e;
                if (((C3030b) ((MediaBrowserServiceCompat) c2782c2.f9501b).f2574d.get(binder2)) != null) {
                    ((MediaBrowserServiceCompat) c2782c2.f9501b).getClass();
                    ((ResultReceiver) this.f10388f).send(-1, null);
                    return;
                }
                Log.w("MBServiceCompat", "sendCustomAction for callback that isn't registered action=" + this.f10385c + ", extras=" + this.f10386d);
                return;
        }
    }

    public RunnableC3041m(C2782c c2782c, C3044p c3044p, String str, Bundle bundle, ResultReceiver resultReceiver) {
        this.f10387e = c2782c;
        this.f10384b = c3044p;
        this.f10385c = str;
        this.f10386d = bundle;
        this.f10388f = resultReceiver;
    }
}
