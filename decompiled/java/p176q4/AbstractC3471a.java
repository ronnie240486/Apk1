package p176q4;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.mediarouter.app.MediaRouteButton;
import com.google.android.gms.internal.cast.AbstractC1542e0;
import com.google.android.gms.internal.cast.C1670r2;
import com.google.android.gms.internal.cast.EnumC1679s2;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import org.bitspark.android.Spark;
import p018b5.AbstractC1312l;
import p173q1.C3424l0;

public abstract class AbstractC3471a {

    public static final ArrayList f11736a;

    public static final Object f11737b;

    static {
        AbstractC1312l.m3197d("CastButtonFactory", "The log tag cannot be null or empty.");
        new ArrayList();
        f11736a = new ArrayList();
        f11737b = new Object();
    }

    public static void m7098a(Spark spark, MediaRouteButton mediaRouteButton) {
        C3424l0 c3424l0M6999b;
        AbstractC1312l.m3195b("Must be called from the main thread.");
        if (mediaRouteButton != null) {
            AbstractC1312l.m3195b("Must be called from the main thread.");
            C3473b c3473bM7100c = C3473b.m7100c(spark);
            if (c3473bM7100c != null) {
                AbstractC1312l.m3195b("Must be called from the main thread.");
                try {
                    C3486l c3486l = (C3486l) c3473bM7100c.f11744b;
                    Parcel parcelM3688w = c3486l.m3688w(c3486l.m3687l(), 1);
                    Bundle bundle = (Bundle) AbstractC1542e0.m3807a(parcelM3688w, Bundle.CREATOR);
                    parcelM3688w.recycle();
                    c3424l0M6999b = C3424l0.m6999b(bundle);
                } catch (RemoteException e5) {
                    C3473b.f11740k.m7974a(e5, "Unable to call %s on %s.", "getMergedSelectorAsBundle", InterfaceC3488n.class.getSimpleName());
                    c3424l0M6999b = null;
                }
                if (c3424l0M6999b != null) {
                    mediaRouteButton.setRouteSelector(c3424l0M6999b);
                }
            }
            synchronized (f11737b) {
                f11736a.add(new WeakReference(mediaRouteButton));
            }
        }
        C1670r2.m3989a(EnumC1679s2.CAST_DEFAULT_MEDIA_ROUTER_DIALOG);
    }
}
