package p173q1;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaRoute2Info;
import android.media.MediaRouter2;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;
import androidx.appcompat.app.C0157r0;
import androidx.media3.extractor.p010ts.TsExtractor;
import androidx.mediarouter.media.MediaTransferReceiver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import p000a.AbstractC0004e;
import p000a.RunnableC0001b;
import p055ea.AbstractC2460q;
import p097j3.C2772c;
import p128m0.C3026b;
import p129m1.AbstractC3050v;
import p129m1.AbstractC3051w;
import p222u7.AbstractC3928d;

public final class C3411h {

    public static final int f11482F = 0;

    public C3456x f11483A;

    public int f11484B;

    public C3402e f11485C;

    public MediaSessionCompat f11486D;

    public final C3390a f11487E;

    public final C3434o1 f11490c;

    public C3445s0 f11491d;

    public AbstractC3397c0 f11492e;

    public C3439q0 f11493f;

    public final Context f11494g;

    public final C3437p1 f11501n;

    public final C3405f f11502o;

    public final boolean f11503p;

    public final boolean f11504q;

    public C3435p f11505r;

    public final C3404e1 f11506s;

    public final C3453v0 f11507t;

    public C3457x0 f11508u;

    public C3445s0 f11509v;

    public C3445s0 f11510w;

    public C3445s0 f11511x;

    public AbstractC3394b0 f11512y;

    public C3456x f11513z;

    public final HandlerC3393b f11488a = new HandlerC3393b(this);

    public final HashMap f11489b = new HashMap();

    public final ArrayList f11495h = new ArrayList();

    public final ArrayList f11496i = new ArrayList();

    public final HashMap f11497j = new HashMap();

    public final HashMap f11498k = new HashMap();

    public final ArrayList f11499l = new ArrayList();

    public final ArrayList f11500m = new ArrayList();

    static {
        Log.isLoggable("AxMediaRouter", 3);
    }

    public C3411h(Context context) {
        boolean z7;
        C3437p1 c3437p1 = new C3437p1();
        c3437p1.f11624c = 0;
        c3437p1.f11625d = 3;
        this.f11501n = c3437p1;
        this.f11502o = new C3405f(0, this);
        this.f11487E = new C3390a(this);
        this.f11494g = context;
        this.f11503p = ((ActivityManager) context.getSystemService("activity")).isLowRamDevice();
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 30) {
            int i10 = MediaTransferReceiver.f3443a;
            Intent intent = new Intent(context, (Class<?>) MediaTransferReceiver.class);
            intent.setPackage(context.getPackageName());
            if (context.getPackageManager().queryBroadcastReceivers(intent, 0).size() > 0) {
                z7 = true;
            } else {
                z7 = false;
            }
        } else {
            z7 = false;
        }
        this.f11504q = z7;
        int i11 = AbstractC3449t1.f11675a;
        Intent intent2 = new Intent(context, (Class<?>) AbstractC3449t1.class);
        intent2.setPackage(context.getPackageName());
        context.getPackageManager().queryBroadcastReceivers(intent2, 0).size();
        this.f11505r = (i6 < 30 || !z7) ? null : new C3435p(context, new C3390a(this));
        C3404e1 c3392a1 = i6 >= 24 ? new C3392a1(context, this) : new C3404e1(context, this);
        this.f11506s = c3392a1;
        this.f11507t = new C3453v0(new RunnableC0001b(13, this));
        m6934a(c3392a1, true);
        AbstractC3403e0 abstractC3403e0 = this.f11505r;
        if (abstractC3403e0 != null) {
            m6934a(abstractC3403e0, true);
        }
        C3434o1 c3434o1 = new C3434o1(context, this);
        this.f11490c = c3434o1;
        if (c3434o1.f11606g) {
            return;
        }
        c3434o1.f11606g = true;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addAction("android.intent.action.PACKAGE_CHANGED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addAction("android.intent.action.PACKAGE_RESTARTED");
        intentFilter.addDataScheme("package");
        Handler handler = c3434o1.f11602c;
        c3434o1.f11600a.registerReceiver(c3434o1.f11607h, intentFilter, null, handler);
        handler.post(c3434o1.f11608i);
    }

    public final void m6934a(AbstractC3403e0 abstractC3403e0, boolean z7) {
        if (m6937d(abstractC3403e0) == null) {
            C3442r0 c3442r0 = new C3442r0(abstractC3403e0, z7);
            this.f11499l.add(c3442r0);
            this.f11488a.m6886b(513, c3442r0);
            m6947n(c3442r0, abstractC3403e0.f11456g);
            C3451u0.m7067b();
            abstractC3403e0.f11453d = this.f11502o;
            abstractC3403e0.m6908g(this.f11513z);
        }
    }

    public final String m6935b(C3442r0 c3442r0, String str) {
        String strFlattenToShortString = ((ComponentName) c3442r0.f11646d.f9501b).flattenToShortString();
        boolean z7 = c3442r0.f11645c;
        String strM5495i = z7 ? str : AbstractC2460q.m5495i(strFlattenToShortString, ":", str);
        HashMap map = this.f11498k;
        if (!z7) {
            ArrayList arrayList = this.f11496i;
            int size = arrayList.size();
            int i6 = 0;
            while (true) {
                if (i6 >= size) {
                    i6 = -1;
                    break;
                }
                if (((C3445s0) arrayList.get(i6)).f11654c.equals(strM5495i)) {
                    break;
                }
                i6++;
            }
            if (i6 >= 0) {
                Log.w("AxMediaRouter", "Either " + str + " isn't unique in " + strFlattenToShortString + " or we're trying to assign a unique ID for an already added route");
                int i10 = 2;
                while (true) {
                    Locale locale = Locale.US;
                    String str2 = strM5495i + "_" + i10;
                    int size2 = arrayList.size();
                    int i11 = 0;
                    while (true) {
                        if (i11 >= size2) {
                            i11 = -1;
                            break;
                        }
                        if (((C3445s0) arrayList.get(i11)).f11654c.equals(str2)) {
                            break;
                        }
                        i11++;
                    }
                    if (i11 < 0) {
                        map.put(new C3026b(strFlattenToShortString, str), str2);
                        return str2;
                    }
                    i10++;
                }
            }
        }
        map.put(new C3026b(strFlattenToShortString, str), strM5495i);
        return strM5495i;
    }

    public final C3445s0 m6936c() {
        for (C3445s0 c3445s0 : this.f11496i) {
            if (c3445s0 != this.f11509v && c3445s0.m7020c() == this.f11506s && c3445s0.m7030m("android.media.intent.category.LIVE_AUDIO") && !c3445s0.m7030m("android.media.intent.category.LIVE_VIDEO") && c3445s0.m7023f()) {
                return c3445s0;
            }
        }
        return this.f11509v;
    }

    public final C3442r0 m6937d(AbstractC3403e0 abstractC3403e0) {
        for (C3442r0 c3442r0 : this.f11499l) {
            if (c3442r0.f11643a == abstractC3403e0) {
                return c3442r0;
            }
        }
        return null;
    }

    public final void m6938e() {
        Iterator it = this.f11497j.values().iterator();
        if (it.hasNext()) {
            throw AbstractC0004e.m18l(it);
        }
    }

    public final AbstractC3397c0 m6939f(C3445s0 c3445s0) {
        AbstractC3397c0 abstractC3397c0;
        if (c3445s0 == this.f11491d && (abstractC3397c0 = this.f11492e) != null) {
            return abstractC3397c0;
        }
        if ((c3445s0 instanceof C3436p0) && ((C3436p0) c3445s0).m7013n()) {
            m6938e();
            return null;
        }
        AbstractC3397c0 abstractC3397c1 = (AbstractC3397c0) this.f11489b.get(c3445s0.f11654c);
        if (abstractC3397c1 != null) {
            return abstractC3397c1;
        }
        Iterator it = this.f11497j.values().iterator();
        if (it.hasNext()) {
            throw AbstractC0004e.m18l(it);
        }
        return abstractC3397c1;
    }

    public final C3445s0 m6940g() {
        C3445s0 c3445s0 = this.f11491d;
        if (c3445s0 != null) {
            return c3445s0;
        }
        throw new IllegalStateException("There is no currently selected route.  The media router has not yet been fully initialized.");
    }

    public final boolean m6941h() {
        C3457x0 c3457x0;
        return this.f11504q && ((c3457x0 = this.f11508u) == null || c3457x0.f11708a);
    }

    public final void m6942i() {
        if (this.f11491d.m7022e()) {
            List<C3445s0> listUnmodifiableList = Collections.unmodifiableList(this.f11491d.f11673v);
            HashSet hashSet = new HashSet();
            Iterator it = listUnmodifiableList.iterator();
            while (it.hasNext()) {
                hashSet.add(((C3445s0) it.next()).f11654c);
            }
            HashMap map = this.f11489b;
            Iterator it2 = map.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry entry = (Map.Entry) it2.next();
                if (!hashSet.contains(entry.getKey())) {
                    AbstractC3397c0 abstractC3397c0 = (AbstractC3397c0) entry.getValue();
                    abstractC3397c0.mo6900i(0);
                    abstractC3397c0.mo6897e();
                    it2.remove();
                }
            }
            for (C3445s0 c3445s0 : listUnmodifiableList) {
                if (!map.containsKey(c3445s0.f11654c)) {
                    AbstractC3397c0 abstractC3397c0Mo6904c = c3445s0.m7020c().mo6904c(c3445s0.f11653b, this.f11491d.f11653b);
                    if (abstractC3397c0Mo6904c != null) {
                        abstractC3397c0Mo6904c.mo6898f();
                        map.put(c3445s0.f11654c, abstractC3397c0Mo6904c);
                    }
                }
            }
        }
    }

    public final void m6943j(C3445s0 c3445s0, int i6, boolean z7) {
        if (!this.f11496i.contains(c3445s0)) {
            Log.w("AxMediaRouter", "Ignoring attempt to select removed route: " + c3445s0);
            return;
        }
        if (!c3445s0.f11658g) {
            Log.w("AxMediaRouter", "Ignoring attempt to select disabled route: " + c3445s0);
            return;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            AbstractC3403e0 abstractC3403e0M7020c = c3445s0.m7020c();
            C3435p c3435p = this.f11505r;
            if (abstractC3403e0M7020c == c3435p && this.f11491d != c3445s0) {
                String str = c3445s0.f11653b;
                MediaRoute2Info mediaRoute2InfoM7010h = c3435p.m7010h(str);
                if (mediaRoute2InfoM7010h != null) {
                    c3435p.f11610i.transferTo(mediaRoute2InfoM7010h);
                    return;
                }
                Log.w("MR2Provider", "transferTo: Specified route not found. routeId=" + str);
                return;
            }
        }
        m6944k(c3445s0, i6, z7);
    }

    public final void m6944k(C3445s0 c3445s0, int i6, boolean z7) {
        C0157r0 c0157r0;
        String str;
        if (this.f11491d == c3445s0) {
            return;
        }
        boolean z10 = c3445s0 == this.f11509v;
        C3445s0 c3445s1 = this.f11510w;
        Context context = this.f11494g;
        if (c3445s1 != null && z10) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            StringBuilder sb = new StringBuilder("- Stracktrace: [");
            int i10 = 3;
            while (i10 < stackTrace.length) {
                StackTraceElement stackTraceElement = stackTrace[i10];
                sb.append(stackTraceElement.getClassName());
                sb.append(".");
                sb.append(stackTraceElement.getMethodName());
                sb.append(":");
                sb.append(stackTraceElement.getLineNumber());
                i10++;
                if (i10 < stackTrace.length) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            C3445s0 c3445s2 = this.f11491d;
            if (c3445s2 != null) {
                Locale locale = Locale.US;
                String str2 = c3445s2.f11655d;
                C3451u0.m7067b();
                str = str2 + "(BT=" + (C3451u0.m7068c().f11510w == c3445s2) + ", syncMediaRoute1Provider=" + z7 + ")";
            } else {
                str = null;
            }
            StringBuilder sbM30x = AbstractC0004e.m30x("Changing selection(", str, ") to default while BT is available: pkgName=");
            sbM30x.append(context.getPackageName());
            sbM30x.append((Object) sb);
            Log.w("AxMediaRouter", sbM30x.toString());
        }
        if (this.f11511x != null) {
            this.f11511x = null;
            AbstractC3394b0 abstractC3394b0 = this.f11512y;
            if (abstractC3394b0 != null) {
                abstractC3394b0.mo6900i(3);
                this.f11512y.mo6897e();
                this.f11512y = null;
            }
        }
        if (m6941h() && (c0157r0 = c3445s0.f11652a.f11647e) != null && c0157r0.f428b) {
            AbstractC3403e0 abstractC3403e0M7020c = c3445s0.m7020c();
            Bundle bundle = new Bundle();
            bundle.putString("clientPackageName", context.getPackageName());
            AbstractC3394b0 abstractC3394b0Mo6902a = abstractC3403e0M7020c.mo6902a(c3445s0.f11653b, new C3400d0(bundle));
            if (abstractC3394b0Mo6902a != null) {
                abstractC3394b0Mo6902a.m6893q(AbstractC3928d.m7849m(context), this.f11487E);
                this.f11511x = c3445s0;
                this.f11512y = abstractC3394b0Mo6902a;
                abstractC3394b0Mo6902a.mo6898f();
                return;
            }
            Log.w("AxMediaRouter", "setSelectedRouteInternal: Failed to create dynamic group route controller. route=" + c3445s0);
        }
        AbstractC3403e0 abstractC3403e0M7020c2 = c3445s0.m7020c();
        Bundle bundle2 = new Bundle();
        bundle2.putString("clientPackageName", context.getPackageName());
        AbstractC3397c0 abstractC3397c0Mo6905d = abstractC3403e0M7020c2.mo6905d(c3445s0.f11653b, new C3400d0(bundle2));
        if (abstractC3397c0Mo6905d != null) {
            abstractC3397c0Mo6905d.mo6898f();
        }
        if (this.f11491d == null) {
            this.f11491d = c3445s0;
            this.f11492e = abstractC3397c0Mo6905d;
            HandlerC3393b handlerC3393b = this.f11488a;
            handlerC3393b.getClass();
            Message messageObtainMessage = handlerC3393b.obtainMessage(262, new C3408g(null, c3445s0, z7));
            messageObtainMessage.arg1 = i6;
            messageObtainMessage.sendToTarget();
            return;
        }
        C3439q0 c3439q0 = this.f11493f;
        if (c3439q0 != null) {
            if (!c3439q0.f11637i && !c3439q0.f11638j) {
                c3439q0.f11638j = true;
                AbstractC3397c0 abstractC3397c0 = c3439q0.f11629a;
                if (abstractC3397c0 != null) {
                    abstractC3397c0.mo6900i(0);
                    abstractC3397c0.mo6897e();
                }
            }
            this.f11493f = null;
        }
        C3439q0 c3439q1 = new C3439q0(this, c3445s0, abstractC3397c0Mo6905d, i6, z7, null, null);
        this.f11493f = c3439q1;
        c3439q1.m7017a();
    }

    public final void m6945l() {
        C2772c c2772c = new C2772c();
        C3453v0 c3453v0 = this.f11507t;
        c3453v0.f11698c = 0L;
        c3453v0.f11700e = false;
        c3453v0.f11699d = SystemClock.elapsedRealtime();
        c3453v0.f11696a.removeCallbacks(c3453v0.f11697b);
        ArrayList arrayList = this.f11495h;
        int size = arrayList.size();
        int i6 = 0;
        boolean z7 = false;
        while (true) {
            size--;
            boolean z10 = this.f11503p;
            if (size < 0) {
                C3453v0 c3453v1 = this.f11507t;
                if (c3453v1.f11700e) {
                    long j10 = c3453v1.f11698c;
                    if (j10 > 0) {
                        c3453v1.f11696a.postDelayed(c3453v1.f11697b, j10);
                    }
                }
                boolean z11 = c3453v1.f11700e;
                this.f11484B = i6;
                C3424l0 c3424l0M5743b = z7 ? c2772c.m5743b() : C3424l0.f11567c;
                C3424l0 c3424l0M5743b2 = c2772c.m5743b();
                if (m6941h()) {
                    C3456x c3456x = this.f11483A;
                    if (c3456x != null) {
                        c3456x.m7095a();
                        if (!c3456x.f11707b.equals(c3424l0M5743b2) || this.f11483A.m7096b() != z11) {
                            if (c3424l0M5743b2.m7002d() || z11) {
                                this.f11483A = new C3456x(c3424l0M5743b2, z11);
                            } else if (this.f11483A != null) {
                                this.f11483A = null;
                            }
                            this.f11505r.m6908g(this.f11483A);
                        }
                    } else if (c3424l0M5743b2.m7002d()) {
                        this.f11483A = new C3456x(c3424l0M5743b2, z11);
                        this.f11505r.m6908g(this.f11483A);
                    } else {
                        this.f11483A = new C3456x(c3424l0M5743b2, z11);
                        this.f11505r.m6908g(this.f11483A);
                    }
                }
                C3456x c3456x2 = this.f11513z;
                if (c3456x2 != null) {
                    c3456x2.m7095a();
                    if (c3456x2.f11707b.equals(c3424l0M5743b) && this.f11513z.m7096b() == z11) {
                        return;
                    }
                }
                if (!c3424l0M5743b.m7002d() || z11) {
                    this.f11513z = new C3456x(c3424l0M5743b, z11);
                } else if (this.f11513z == null) {
                    return;
                } else {
                    this.f11513z = null;
                }
                if (z7 && !z11 && z10) {
                    Log.i("AxMediaRouter", "Forcing passive route discovery on a low-RAM device, system performance may be affected.  Please consider using CALLBACK_FLAG_REQUEST_DISCOVERY instead of CALLBACK_FLAG_FORCE_DISCOVERY.");
                }
                Iterator it = this.f11499l.iterator();
                while (it.hasNext()) {
                    AbstractC3403e0 abstractC3403e0 = ((C3442r0) it.next()).f11643a;
                    if (abstractC3403e0 != this.f11505r) {
                        abstractC3403e0.m6908g(this.f11513z);
                    }
                }
                return;
            }
            C3451u0 c3451u0 = (C3451u0) ((WeakReference) arrayList.get(size)).get();
            if (c3451u0 == null) {
                arrayList.remove(size);
            } else {
                ArrayList arrayList2 = c3451u0.f11689b;
                int size2 = arrayList2.size();
                i6 += size2;
                for (int i10 = 0; i10 < size2; i10++) {
                    C3430n0 c3430n0 = (C3430n0) arrayList2.get(i10);
                    C3424l0 c3424l0 = c3430n0.f11594c;
                    if (c3424l0 == null) {
                        throw new IllegalArgumentException("selector must not be null");
                    }
                    c2772c.m5742a(c3424l0.m7001c());
                    boolean z12 = (c3430n0.f11595d & 1) != 0;
                    this.f11507t.m7083a(c3430n0.f11596e, z12);
                    if (z12) {
                        z7 = true;
                    }
                    int i11 = c3430n0.f11595d;
                    if ((i11 & 4) != 0 && !z10) {
                        z7 = true;
                    }
                    if ((i11 & 8) != 0) {
                        z7 = true;
                    }
                }
            }
        }
    }

    public final void m6946m() {
        MediaRouter2.RoutingController routingController;
        C3445s0 c3445s0 = this.f11491d;
        if (c3445s0 == null) {
            C3402e c3402e = this.f11485C;
            if (c3402e != null) {
                c3402e.m6901a();
                return;
            }
            return;
        }
        int i6 = c3445s0.f11667p;
        C3437p1 c3437p1 = this.f11501n;
        c3437p1.f11622a = i6;
        c3437p1.f11623b = c3445s0.f11668q;
        c3437p1.f11624c = (!c3445s0.m7022e() || C3451u0.m7072g()) ? c3445s0.f11666o : 0;
        c3437p1.f11625d = this.f11491d.f11664m;
        String id = null;
        if (m6941h() && this.f11491d.m7020c() == this.f11505r) {
            AbstractC3397c0 abstractC3397c0 = this.f11492e;
            int i10 = C3435p.f11609s;
            if ((abstractC3397c0 instanceof C3423l) && (routingController = ((C3423l) abstractC3397c0).f11557g) != null) {
                id = routingController.getId();
            }
            c3437p1.f11626e = id;
        } else {
            c3437p1.f11626e = null;
        }
        Iterator it = this.f11500m.iterator();
        if (it.hasNext()) {
            throw AbstractC0004e.m18l(it);
        }
        C3402e c3402e2 = this.f11485C;
        if (c3402e2 != null) {
            C3445s0 c3445s1 = this.f11491d;
            C3445s0 c3445s2 = this.f11509v;
            if (c3445s2 == null) {
                throw new IllegalStateException("There is no default route.  The media router has not yet been fully initialized.");
            }
            if (c3445s1 == c3445s2 || c3445s1 == this.f11510w) {
                c3402e2.m6901a();
                return;
            }
            int i11 = c3437p1.f11624c == 1 ? 2 : 0;
            int i12 = c3437p1.f11623b;
            int i13 = c3437p1.f11622a;
            String str = c3437p1.f11626e;
            MediaSessionCompat mediaSessionCompat = c3402e2.f11447a;
            if (mediaSessionCompat != null) {
                C3399d c3399d = c3402e2.f11448b;
                if (c3399d == null || i11 != 0 || i12 != 0) {
                    C3399d c3399d2 = new C3399d(c3402e2, i11, i12, i13, str);
                    c3402e2.f11448b = c3399d2;
                    mediaSessionCompat.setPlaybackToRemote(c3399d2);
                } else {
                    c3399d.f10409d = i13;
                    AbstractC3050v.m6103a(c3399d.m6104a(), i13);
                    AbstractC3051w abstractC3051w = c3399d.f10410e;
                    if (abstractC3051w != null) {
                        abstractC3051w.onVolumeChanged(c3399d);
                    }
                }
            }
        }
    }

    public final void m6947n(C3442r0 c3442r0, C0157r0 c0157r0) {
        boolean z7;
        String str;
        int i6;
        Iterator it;
        boolean z10;
        if (c3442r0.f11647e != c0157r0) {
            c3442r0.f11647e = c0157r0;
            ArrayList arrayList = this.f11496i;
            ArrayList arrayList2 = c3442r0.f11644b;
            HandlerC3393b handlerC3393b = this.f11488a;
            if (c0157r0 != null) {
                List list = (List) c0157r0.f429c;
                int size = list.size();
                int i10 = 0;
                while (true) {
                    if (i10 < size) {
                        C3454w c3454w = (C3454w) list.get(i10);
                        if (c3454w != null && c3454w.m7094k()) {
                            i10++;
                        } else if (c0157r0 != this.f11506s.f11456g) {
                            z7 = false;
                            if (c0157r0 != null) {
                                str = "Ignoring invalid provider descriptor: " + c0157r0;
                            } else {
                                str = "Ignoring null provider descriptor from " + ((ComponentName) c3442r0.f11646d.f9501b);
                            }
                            Log.w("AxMediaRouter", str);
                            i6 = 0;
                        }
                    }
                    ArrayList<C3026b> arrayList3 = new ArrayList();
                    ArrayList<C3026b> arrayList4 = new ArrayList();
                    Iterator it2 = list.iterator();
                    int i11 = 0;
                    boolean z11 = false;
                    while (it2.hasNext()) {
                        C3454w c3454w2 = (C3454w) it2.next();
                        if (c3454w2 == null || !c3454w2.m7094k()) {
                            it = it2;
                            z10 = z11;
                            Log.w("AxMediaRouter", "Ignoring invalid route descriptor: " + c3454w2);
                        } else {
                            String strM7089f = c3454w2.m7089f();
                            int size2 = arrayList2.size();
                            int i12 = 0;
                            while (true) {
                                if (i12 >= size2) {
                                    i12 = -1;
                                    break;
                                } else if (((C3445s0) arrayList2.get(i12)).f11653b.equals(strM7089f)) {
                                    break;
                                } else {
                                    i12++;
                                }
                            }
                            if (i12 < 0) {
                                it = it2;
                                z10 = z11;
                                C3445s0 c3445s0 = new C3445s0(c3442r0, strM7089f, m6935b(c3442r0, strM7089f), c3454w2.f11701a.getBoolean("isSystemRoute", false));
                                int i13 = i11 + 1;
                                arrayList2.add(i11, c3445s0);
                                arrayList.add(c3445s0);
                                if (c3454w2.m7087d().isEmpty()) {
                                    c3445s0.m7026i(c3454w2);
                                    handlerC3393b.m6886b(TsExtractor.TS_STREAM_TYPE_AIT, c3445s0);
                                } else {
                                    arrayList3.add(new C3026b(c3445s0, c3454w2));
                                }
                                i11 = i13;
                            } else {
                                it = it2;
                                z10 = z11;
                                if (i12 < i11) {
                                    Log.w("AxMediaRouter", "Ignoring route descriptor with duplicate id: " + c3454w2);
                                } else {
                                    C3445s0 c3445s1 = (C3445s0) arrayList2.get(i12);
                                    int i14 = i11 + 1;
                                    Collections.swap(arrayList2, i12, i11);
                                    if (!c3454w2.m7087d().isEmpty()) {
                                        arrayList4.add(new C3026b(c3445s1, c3454w2));
                                    } else if (m6948o(c3445s1, c3454w2) != 0 && c3445s1 == this.f11491d) {
                                        i11 = i14;
                                        z10 = true;
                                    }
                                    i11 = i14;
                                }
                            }
                        }
                        it2 = it;
                        z11 = z10;
                    }
                    boolean z12 = z11;
                    for (C3026b c3026b : arrayList3) {
                        C3445s0 c3445s2 = (C3445s0) c3026b.f10354a;
                        c3445s2.m7026i((C3454w) c3026b.f10355b);
                        handlerC3393b.m6886b(TsExtractor.TS_STREAM_TYPE_AIT, c3445s2);
                    }
                    boolean z13 = z12;
                    for (C3026b c3026b2 : arrayList4) {
                        C3445s0 c3445s3 = (C3445s0) c3026b2.f10354a;
                        if (m6948o(c3445s3, (C3454w) c3026b2.f10355b) != 0 && c3445s3 == this.f11491d) {
                            z13 = true;
                        }
                    }
                    z7 = z13;
                    i6 = i11;
                }
            } else {
                z7 = false;
                if (c0157r0 != null) {
                    str = "Ignoring invalid provider descriptor: " + c0157r0;
                } else {
                    str = "Ignoring null provider descriptor from " + ((ComponentName) c3442r0.f11646d.f9501b);
                }
                Log.w("AxMediaRouter", str);
                i6 = 0;
            }
            for (int size3 = arrayList2.size() - 1; size3 >= i6; size3--) {
                C3445s0 c3445s4 = (C3445s0) arrayList2.get(size3);
                c3445s4.m7026i(null);
                arrayList.remove(c3445s4);
            }
            m6949p(z7);
            for (int size4 = arrayList2.size() - 1; size4 >= i6; size4--) {
                handlerC3393b.m6886b(258, (C3445s0) arrayList2.remove(size4));
            }
            handlerC3393b.m6886b(515, c3442r0);
        }
    }

    public final int m6948o(C3445s0 c3445s0, C3454w c3454w) {
        int iM7026i = c3445s0.m7026i(c3454w);
        if (iM7026i != 0) {
            int i6 = iM7026i & 1;
            HandlerC3393b handlerC3393b = this.f11488a;
            if (i6 != 0) {
                handlerC3393b.m6886b(259, c3445s0);
            }
            if ((iM7026i & 2) != 0) {
                handlerC3393b.m6886b(260, c3445s0);
            }
            if ((iM7026i & 4) != 0) {
                handlerC3393b.m6886b(261, c3445s0);
            }
        }
        return iM7026i;
    }

    public final void m6949p(boolean z7) {
        C3445s0 c3445s0 = this.f11509v;
        if (c3445s0 != null && !c3445s0.m7023f()) {
            Log.i("AxMediaRouter", "Clearing the default route because it is no longer selectable: " + this.f11509v);
            this.f11509v = null;
        }
        C3445s0 c3445s1 = this.f11509v;
        ArrayList<C3445s0> arrayList = this.f11496i;
        if (c3445s1 == null) {
            for (C3445s0 c3445s2 : arrayList) {
                if (c3445s2.m7020c() == this.f11506s && c3445s2.f11653b.equals("DEFAULT_ROUTE") && c3445s2.m7023f()) {
                    this.f11509v = c3445s2;
                    Log.i("AxMediaRouter", "Found default route: " + this.f11509v);
                    break;
                }
            }
        }
        C3445s0 c3445s3 = this.f11510w;
        if (c3445s3 != null && !c3445s3.m7023f()) {
            Log.i("AxMediaRouter", "Clearing the bluetooth route because it is no longer selectable: " + this.f11510w);
            this.f11510w = null;
        }
        if (this.f11510w == null) {
            for (C3445s0 c3445s4 : arrayList) {
                if (c3445s4.m7020c() == this.f11506s && c3445s4.m7030m("android.media.intent.category.LIVE_AUDIO") && !c3445s4.m7030m("android.media.intent.category.LIVE_VIDEO") && c3445s4.m7023f()) {
                    this.f11510w = c3445s4;
                    Log.i("AxMediaRouter", "Found bluetooth route: " + this.f11510w);
                    break;
                }
            }
        }
        C3445s0 c3445s5 = this.f11491d;
        if (c3445s5 == null || !c3445s5.f11658g) {
            Log.i("AxMediaRouter", "Unselecting the current route because it is no longer selectable: " + this.f11491d);
            m6944k(m6936c(), 0, true);
            return;
        }
        if (z7) {
            m6942i();
            m6946m();
        }
    }
}
