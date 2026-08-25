package p173q1;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Messenger;
import android.os.SystemClock;
import androidx.appcompat.app.C0157r0;
import androidx.appcompat.app.RunnableC0147m0;
import androidx.mediarouter.media.MediaRouteProviderService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import p000a.RunnableC0005f;
import p097j3.C2772c;
import p128m0.InterfaceC3025a;

public class C3421k0 {

    public final MediaRouteProviderService f11538a;

    public C3456x f11540c;

    public C3456x f11541d;

    public long f11542e;

    public final ArrayList f11539b = new ArrayList();

    public final HashMap f11543f = new HashMap();

    public final Object f11544g = new Object();

    public final C3453v0 f11545h = new C3453v0(new RunnableC0005f(29, this));

    public C3421k0(MediaRouteProviderService mediaRouteProviderService) {
        this.f11538a = mediaRouteProviderService;
    }

    public C3418j0 mo6951b(Messenger messenger, int i6, String str) {
        return new C3418j0(this, messenger, i6, str);
    }

    public final int m6995c(Messenger messenger) {
        ArrayList arrayList = this.f11539b;
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            if (((C3418j0) arrayList.get(i6)).f11528a.getBinder() == messenger.getBinder()) {
                return i6;
            }
        }
        return -1;
    }

    public final C3418j0 m6996d(Messenger messenger) {
        int iM6995c = m6995c(messenger);
        if (iM6995c >= 0) {
            return (C3418j0) this.f11539b.get(iM6995c);
        }
        return null;
    }

    public final void m6997e() {
        if (this.f11543f.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = new ArrayList(this.f11539b).iterator();
        while (it.hasNext()) {
            ((C3418j0) it.next()).getClass();
            arrayList.add(new C3406f0(0));
        }
        synchronized (this.f11544g) {
            try {
                for (Map.Entry entry : this.f11543f.entrySet()) {
                    ((Executor) entry.getValue()).execute(new RunnableC0147m0((InterfaceC3025a) entry.getKey(), 15, arrayList));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public IBinder mo6952f(Intent intent) {
        if (!intent.getAction().equals("android.media.MediaRouteProviderService")) {
            return null;
        }
        MediaRouteProviderService mediaRouteProviderService = this.f11538a;
        mediaRouteProviderService.m2807b();
        if (mediaRouteProviderService.f3441d != null) {
            return mediaRouteProviderService.f3438a.getBinder();
        }
        return null;
    }

    public void mo6953g(C0157r0 c0157r0) {
        ArrayList arrayList = this.f11539b;
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            C3418j0 c3418j0 = (C3418j0) arrayList.get(i6);
            MediaRouteProviderService.m2806e(c3418j0.f11528a, 5, 0, 0, c3418j0.mo6928a(c0157r0), null);
        }
    }

    public final boolean m6998h() {
        C2772c c2772c;
        ArrayList arrayList;
        C3453v0 c3453v0 = this.f11545h;
        c3453v0.f11698c = 0L;
        c3453v0.f11700e = false;
        c3453v0.f11699d = SystemClock.elapsedRealtime();
        Handler handler = c3453v0.f11696a;
        Runnable runnable = c3453v0.f11697b;
        handler.removeCallbacks(runnable);
        C3456x c3456x = this.f11541d;
        if (c3456x != null) {
            c3453v0.m7083a(this.f11542e, c3456x.m7096b());
            C3456x c3456x2 = this.f11541d;
            c3456x2.m7095a();
            c2772c = new C2772c(c3456x2.f11707b);
        } else {
            c2772c = null;
        }
        ArrayList arrayList2 = this.f11539b;
        int size = arrayList2.size();
        int i6 = 0;
        while (i6 < size) {
            C3418j0 c3418j0 = (C3418j0) arrayList2.get(i6);
            C3456x c3456x3 = c3418j0.f11531d;
            if (c3456x3 != null) {
                c3456x3.m7095a();
                if (!c3456x3.f11707b.m7002d() || c3456x3.m7096b()) {
                    arrayList = arrayList2;
                    c3453v0.m7083a(c3418j0.f11532e, c3456x3.m7096b());
                    if (c2772c == null) {
                        c3456x3.m7095a();
                        c2772c = new C2772c(c3456x3.f11707b);
                    } else {
                        c3456x3.m7095a();
                        C3424l0 c3424l0 = c3456x3.f11707b;
                        if (c3424l0 == null) {
                            throw new IllegalArgumentException("selector must not be null");
                        }
                        c2772c.m5742a(c3424l0.m7001c());
                    }
                } else {
                    arrayList = arrayList2;
                }
            } else {
                arrayList = arrayList2;
            }
            i6++;
            arrayList2 = arrayList;
        }
        if (c3453v0.f11700e) {
            long j10 = c3453v0.f11698c;
            if (j10 > 0) {
                handler.postDelayed(runnable, j10);
            }
        }
        C3456x c3456x4 = c2772c == null ? null : new C3456x(c2772c.m5743b(), c3453v0.f11700e);
        if (Objects.equals(this.f11540c, c3456x4)) {
            return false;
        }
        this.f11540c = c3456x4;
        AbstractC3403e0 abstractC3403e0 = this.f11538a.f3441d;
        if (abstractC3403e0 == null) {
            return true;
        }
        abstractC3403e0.m6908g(c3456x4);
        return true;
    }

    public void mo6950a(Context context) {
    }
}
