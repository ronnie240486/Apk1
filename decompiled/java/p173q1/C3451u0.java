package p173q1;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class C3451u0 {

    public static C3411h f11687c;

    public final Context f11688a;

    public final ArrayList f11689b = new ArrayList();

    static {
        Log.isLoggable("AxMediaRouter", 3);
    }

    public C3451u0(Context context) {
        this.f11688a = context;
    }

    public static void m7067b() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("The media router service must only be accessed on the application's main thread.");
        }
    }

    public static C3411h m7068c() {
        C3411h c3411h = f11687c;
        if (c3411h != null) {
            return c3411h;
        }
        throw new IllegalStateException("getGlobalRouter cannot be called when sGlobal is null");
    }

    public static C3451u0 m7069d(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context must not be null");
        }
        m7067b();
        if (f11687c == null) {
            f11687c = new C3411h(context.getApplicationContext());
        }
        ArrayList arrayList = f11687c.f11495h;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                C3451u0 c3451u0 = new C3451u0(context);
                arrayList.add(new WeakReference(c3451u0));
                return c3451u0;
            }
            C3451u0 c3451u1 = (C3451u0) ((WeakReference) arrayList.get(size)).get();
            if (c3451u1 == null) {
                arrayList.remove(size);
            } else if (c3451u1.f11688a == context) {
                return c3451u1;
            }
        }
    }

    public static MediaSessionCompat.Token m7070e() {
        C3411h c3411h = f11687c;
        if (c3411h == null) {
            return null;
        }
        C3402e c3402e = c3411h.f11485C;
        if (c3402e != null) {
            MediaSessionCompat mediaSessionCompat = c3402e.f11447a;
            if (mediaSessionCompat != null) {
                return mediaSessionCompat.getSessionToken();
            }
            return null;
        }
        MediaSessionCompat mediaSessionCompat2 = c3411h.f11486D;
        if (mediaSessionCompat2 != null) {
            return mediaSessionCompat2.getSessionToken();
        }
        return null;
    }

    public static C3445s0 m7071f() {
        m7067b();
        return m7068c().m6940g();
    }

    public static boolean m7072g() {
        Bundle bundle;
        if (f11687c == null) {
            return false;
        }
        C3457x0 c3457x0 = m7068c().f11508u;
        return c3457x0 == null || (bundle = c3457x0.f11712e) == null || bundle.getBoolean("androidx.mediarouter.media.MediaRouterParams.ENABLE_GROUP_VOLUME_UX", true);
    }

    public static void m7073i(int i6) {
        if (i6 < 0 || i6 > 3) {
            throw new IllegalArgumentException("Unsupported reason to unselect route");
        }
        m7067b();
        C3411h c3411hM7068c = m7068c();
        C3445s0 c3445s0M6936c = c3411hM7068c.m6936c();
        if (c3411hM7068c.m6940g() != c3445s0M6936c) {
            c3411hM7068c.m6943j(c3445s0M6936c, i6, true);
        }
    }

    public final void m7074a(C3424l0 c3424l0, AbstractC3427m0 abstractC3427m0, int i6) {
        C3430n0 c3430n0;
        C3424l0 c3424l1;
        if (c3424l0 == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        if (abstractC3427m0 == null) {
            throw new IllegalArgumentException("callback must not be null");
        }
        m7067b();
        ArrayList arrayList = this.f11689b;
        int size = arrayList.size();
        boolean z7 = false;
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                i10 = -1;
                break;
            } else if (((C3430n0) arrayList.get(i10)).f11593b == abstractC3427m0) {
                break;
            } else {
                i10++;
            }
        }
        if (i10 < 0) {
            c3430n0 = new C3430n0(this, abstractC3427m0);
            arrayList.add(c3430n0);
        } else {
            c3430n0 = (C3430n0) arrayList.get(i10);
        }
        boolean z10 = true;
        if (i6 != c3430n0.f11595d) {
            c3430n0.f11595d = i6;
            z7 = true;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if ((i6 & 1) != 0) {
            z7 = true;
        }
        c3430n0.f11596e = jElapsedRealtime;
        C3424l0 c3424l2 = c3430n0.f11594c;
        c3424l2.m7000a();
        c3424l0.m7000a();
        if (c3424l2.f11569b.containsAll(c3424l0.f11569b)) {
            z10 = z7;
        } else {
            C3424l0 c3424l3 = c3430n0.f11594c;
            if (c3424l3 == null) {
                throw new IllegalArgumentException("selector must not be null");
            }
            c3424l3.m7000a();
            ArrayList<String> arrayList2 = !c3424l3.f11569b.isEmpty() ? new ArrayList<>(c3424l3.f11569b) : null;
            ArrayList<String> arrayListM7001c = c3424l0.m7001c();
            if (!arrayListM7001c.isEmpty()) {
                for (String str : arrayListM7001c) {
                    if (str == null) {
                        throw new IllegalArgumentException("category must not be null");
                    }
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList<>();
                    }
                    if (!arrayList2.contains(str)) {
                        arrayList2.add(str);
                    }
                }
            }
            if (arrayList2 == null) {
                c3424l1 = C3424l0.f11567c;
            } else {
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("controlCategories", arrayList2);
                c3424l1 = new C3424l0(bundle, arrayList2);
            }
            c3430n0.f11594c = c3424l1;
        }
        if (z10) {
            m7068c().m6945l();
        }
    }

    public final void m7075h(AbstractC3427m0 abstractC3427m0) {
        if (abstractC3427m0 == null) {
            throw new IllegalArgumentException("callback must not be null");
        }
        m7067b();
        ArrayList arrayList = this.f11689b;
        int size = arrayList.size();
        int i6 = 0;
        while (true) {
            if (i6 >= size) {
                i6 = -1;
                break;
            } else if (((C3430n0) arrayList.get(i6)).f11593b == abstractC3427m0) {
                break;
            } else {
                i6++;
            }
        }
        if (i6 >= 0) {
            arrayList.remove(i6);
            m7068c().m6945l();
        }
    }
}
