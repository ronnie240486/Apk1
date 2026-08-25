package p105k;

import android.os.IBinder;
import android.util.Log;
import androidx.media.MediaBrowserServiceCompat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import p101j7.C2782c;
import p128m0.C3026b;
import p129m1.C3030b;
import p129m1.C3044p;

public final class RunnableC2828d implements Runnable {

    public final int f9618a;

    public final Object f9619b;

    public final Object f9620c;

    public final Object f9621d;

    public final Object f9622e;

    public RunnableC2828d(Object obj, Object obj2, Object obj3, Object obj4, int i6) {
        this.f9618a = i6;
        this.f9622e = obj;
        this.f9619b = obj2;
        this.f9620c = obj3;
        this.f9621d = obj4;
    }

    @Override
    public final void run() {
        switch (this.f9618a) {
            case 0:
                C2830e c2830e = (C2830e) this.f9619b;
                if (c2830e != null) {
                    C2782c c2782c = (C2782c) this.f9622e;
                    ((ViewOnKeyListenerC2832f) c2782c.f9501b).f9671z = true;
                    c2830e.f9643b.m5827c(false);
                    ((ViewOnKeyListenerC2832f) c2782c.f9501b).f9671z = false;
                }
                C2840n c2840n = (C2840n) this.f9620c;
                if (c2840n.isEnabled() && c2840n.hasSubMenu()) {
                    ((MenuC2838l) this.f9621d).m5832q(c2840n, null, 4);
                    break;
                }
                break;
            default:
                IBinder binder = ((C3044p) this.f9619b).f10399a.getBinder();
                C2782c c2782c2 = (C2782c) this.f9622e;
                C3030b c3030b = (C3030b) ((MediaBrowserServiceCompat) c2782c2.f9501b).f2574d.get(binder);
                String str = (String) this.f9620c;
                if (c3030b != null) {
                    ((MediaBrowserServiceCompat) c2782c2.f9501b).getClass();
                    HashMap map = c3030b.f10364e;
                    IBinder iBinder = (IBinder) this.f9621d;
                    boolean z7 = false;
                    if (iBinder != null) {
                        List list = (List) map.get(str);
                        if (list != null) {
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                if (iBinder == ((C3026b) it.next()).f10354a) {
                                    it.remove();
                                    z7 = true;
                                }
                            }
                            if (list.size() == 0) {
                                map.remove(str);
                            }
                        }
                    } else if (map.remove(str) != null) {
                        z7 = true;
                    }
                    if (!z7) {
                        Log.w("MBServiceCompat", "removeSubscription called for " + str + " which is not subscribed");
                    }
                } else {
                    Log.w("MBServiceCompat", "removeSubscription for callback that isn't registered id=" + str);
                }
                break;
        }
    }
}
