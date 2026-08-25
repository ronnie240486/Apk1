package p173q1;

import android.content.Context;
import android.media.MediaRoute2ProviderService;
import android.media.RouteDiscoveryPreference;
import android.media.RoutingSessionInfo;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import androidx.appcompat.app.C0157r0;
import androidx.mediarouter.media.MediaRouteProviderService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import p041d7.C2203g0;
import p160p.C3339c;
import p160p.C3341e;
import p222u7.AbstractC3928d;

public final class C3452v extends MediaRoute2ProviderService {

    public static final int f11690f = 0;

    public final C3412h0 f11692b;

    public volatile C0157r0 f11695e;

    public final Object f11691a = new Object();

    public final C3341e f11693c = new C3341e(0);

    public final SparseArray f11694d = new SparseArray();

    static {
        Log.isLoggable("MR2ProviderService", 3);
    }

    public C3452v(C3412h0 c3412h0) {
        this.f11692b = c3412h0;
    }

    public final String m7076a(C3450u c3450u) {
        String string;
        synchronized (this.f11691a) {
            do {
                string = UUID.randomUUID().toString();
            } while (this.f11693c.containsKey(string));
            c3450u.f11684i = string;
            this.f11693c.put(string, c3450u);
        }
        return string;
    }

    @Override
    public final void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public final AbstractC3397c0 m7077b(String str) {
        ArrayList<C3450u> arrayList;
        synchronized (this.f11691a) {
            arrayList = new ArrayList(this.f11693c.values());
        }
        for (C3450u c3450u : arrayList) {
            C3409g0 c3409g0 = (C3409g0) c3450u.f11680e.get();
            AbstractC3397c0 abstractC3397c0 = c3409g0 != null ? (AbstractC3397c0) c3409g0.f11476i.get(str) : (AbstractC3397c0) c3450u.f11676a.get(str);
            if (abstractC3397c0 != null) {
                return abstractC3397c0;
            }
        }
        return null;
    }

    public final AbstractC3394b0 m7078c(String str) {
        AbstractC3394b0 abstractC3394b0;
        synchronized (this.f11691a) {
            C3450u c3450u = (C3450u) this.f11693c.get(str);
            abstractC3394b0 = c3450u == null ? null : c3450u.f11677b;
        }
        return abstractC3394b0;
    }

    public final C3454w m7079d(String str, String str2) {
        MediaRouteProviderService mediaRouteProviderService = this.f11692b.f11538a;
        if ((mediaRouteProviderService == null ? null : mediaRouteProviderService.f3441d) == null || this.f11695e == null) {
            Log.w("MR2ProviderService", str2.concat(": no provider info"));
            return null;
        }
        for (C3454w c3454w : (List) this.f11695e.f429c) {
            if (TextUtils.equals(c3454w.m7089f(), str)) {
                return c3454w;
            }
        }
        Log.w("MR2ProviderService", str2 + ": Couldn't find a route : " + str);
        return null;
    }

    public final void m7080e(C3409g0 c3409g0, AbstractC3397c0 abstractC3397c0, int i6, String str, String str2) {
        int i10;
        AbstractC3394b0 c3441r;
        C3454w c3454wM7079d = m7079d(str2, "notifyRouteControllerAdded");
        if (c3454wM7079d == null) {
            return;
        }
        if (abstractC3397c0 instanceof AbstractC3394b0) {
            c3441r = (AbstractC3394b0) abstractC3397c0;
            i10 = 6;
        } else {
            i10 = !c3454wM7079d.m7087d().isEmpty() ? 2 : 0;
            c3441r = new C3441r(str2, abstractC3397c0);
        }
        C3450u c3450u = new C3450u(this, c3441r, 0L, i10, c3409g0);
        c3450u.f11685j = str2;
        String strM7076a = m7076a(c3450u);
        this.f11694d.put(i6, strM7076a);
        RoutingSessionInfo.Builder volumeMax = AbstractC3417j.m6972e(strM7076a, str).setName(c3454wM7079d.m7090g()).setVolumeHandling(c3454wM7079d.m7092i()).setVolume(c3454wM7079d.m7091h()).setVolumeMax(c3454wM7079d.m7093j());
        if (c3454wM7079d.m7087d().isEmpty()) {
            volumeMax.addSelectedRoute(str2);
        } else {
            Iterator it = c3454wM7079d.m7087d().iterator();
            while (it.hasNext()) {
                volumeMax.addSelectedRoute((String) it.next());
            }
        }
        c3450u.m7064b(volumeMax.build());
    }

    public final void m7081f(int i6) {
        C3450u c3450u;
        String str = (String) this.f11694d.get(i6);
        if (str == null) {
            return;
        }
        this.f11694d.remove(i6);
        synchronized (this.f11691a) {
            c3450u = (C3450u) this.f11693c.remove(str);
        }
        if (c3450u != null) {
            c3450u.m7063a(false);
        }
    }

    public final void m7082g(AbstractC3394b0 abstractC3394b0, C3454w c3454w, ArrayList arrayList) {
        C3450u c3450u;
        synchronized (this.f11691a) {
            try {
                Iterator it = ((C2203g0) this.f11693c.entrySet()).iterator();
                while (true) {
                    C3339c c3339c = (C3339c) it;
                    if (!c3339c.hasNext()) {
                        c3450u = null;
                        break;
                    }
                    c3339c.next();
                    c3450u = (C3450u) c3339c.getValue();
                    if (c3450u.f11677b == abstractC3394b0) {
                        break;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (c3450u == null) {
            Log.w("MR2ProviderService", "setDynamicRouteDescriptor: Ignoring unknown controller");
        } else {
            c3450u.m7066d(c3454w, arrayList);
        }
    }

    @Override
    public final void onCreateSession(long j10, String str, String str2, Bundle bundle) {
        int i6;
        AbstractC3394b0 c3441r;
        MediaRouteProviderService mediaRouteProviderService = this.f11692b.f11538a;
        AbstractC3403e0 abstractC3403e0 = mediaRouteProviderService == null ? null : mediaRouteProviderService.f3441d;
        C3454w c3454wM7079d = m7079d(str2, "onCreateSession");
        if (c3454wM7079d == null) {
            notifyRequestFailed(j10, 3);
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("controlHints", bundle);
        bundle2.putString("clientPackageName", str);
        C3400d0 c3400d0 = new C3400d0(bundle2);
        if (this.f11695e.f428b) {
            AbstractC3394b0 abstractC3394b0Mo6902a = abstractC3403e0.mo6902a(str2, c3400d0);
            if (abstractC3394b0Mo6902a == null) {
                Log.w("MR2ProviderService", "onCreateSession: Couldn't create a dynamic controller");
                notifyRequestFailed(j10, 1);
                return;
            } else {
                c3441r = abstractC3394b0Mo6902a;
                i6 = 7;
            }
        } else {
            AbstractC3397c0 abstractC3397c0Mo6905d = abstractC3403e0.mo6905d(str2, c3400d0);
            if (abstractC3397c0Mo6905d == null) {
                Log.w("MR2ProviderService", "onCreateSession: Couldn't create a controller");
                notifyRequestFailed(j10, 1);
                return;
            } else {
                i6 = !c3454wM7079d.m7087d().isEmpty() ? 3 : 1;
                c3441r = new C3441r(str2, abstractC3397c0Mo6905d);
            }
        }
        c3441r.mo6898f();
        C3450u c3450u = new C3450u(this, c3441r, j10, i6, null);
        RoutingSessionInfo.Builder volumeMax = AbstractC3417j.m6972e(m7076a(c3450u), str).setName(c3454wM7079d.m7090g()).setVolumeHandling(c3454wM7079d.m7092i()).setVolume(c3454wM7079d.m7091h()).setVolumeMax(c3454wM7079d.m7093j());
        if (c3454wM7079d.m7087d().isEmpty()) {
            volumeMax.addSelectedRoute(str2);
        } else {
            Iterator it = c3454wM7079d.m7087d().iterator();
            while (it.hasNext()) {
                volumeMax.addSelectedRoute((String) it.next());
            }
        }
        RoutingSessionInfo routingSessionInfoBuild = volumeMax.build();
        c3450u.m7064b(routingSessionInfoBuild);
        if ((i6 & 4) == 0) {
            if ((i6 & 2) != 0) {
                c3450u.m7065c(str2, null, routingSessionInfoBuild, c3400d0);
            } else {
                c3450u.f11676a.put(str2, c3450u.f11677b);
            }
        }
        C3412h0 c3412h0 = this.f11692b;
        c3441r.m6893q(AbstractC3928d.m7849m(c3412h0.f11538a.getApplicationContext()), c3412h0.f11515j);
    }

    @Override
    public final void onDeselectRoute(long j10, String str, String str2) {
        if (getSessionInfo(str) == null) {
            Log.w("MR2ProviderService", "onDeselectRoute: Couldn't find a session");
            notifyRequestFailed(j10, 4);
        } else {
            if (m7079d(str2, "onDeselectRoute") == null) {
                notifyRequestFailed(j10, 3);
                return;
            }
            AbstractC3394b0 abstractC3394b0M7078c = m7078c(str);
            if (abstractC3394b0M7078c != null) {
                abstractC3394b0M7078c.mo6891o(str2);
            } else {
                Log.w("MR2ProviderService", "onDeselectRoute: Couldn't find a controller");
                notifyRequestFailed(j10, 3);
            }
        }
    }

    @Override
    public final void onDiscoveryPreferenceChanged(RouteDiscoveryPreference routeDiscoveryPreference) {
        C3424l0 c3424l0;
        C3412h0 c3412h0 = this.f11692b;
        ArrayList<String> arrayList = new ArrayList();
        for (String str : routeDiscoveryPreference.getPreferredFeatures()) {
            str.getClass();
            switch (str) {
                case "android.media.route.feature.REMOTE_AUDIO_PLAYBACK":
                    str = "android.media.intent.category.REMOTE_AUDIO_PLAYBACK";
                    break;
                case "android.media.route.feature.REMOTE_VIDEO_PLAYBACK":
                    str = "android.media.intent.category.REMOTE_VIDEO_PLAYBACK";
                    break;
                case "android.media.route.feature.REMOTE_PLAYBACK":
                    str = "android.media.intent.category.REMOTE_PLAYBACK";
                    break;
                case "android.media.route.feature.LIVE_AUDIO":
                    str = "android.media.intent.category.LIVE_AUDIO";
                    break;
                case "android.media.route.feature.LIVE_VIDEO":
                    str = "android.media.intent.category.LIVE_VIDEO";
                    break;
            }
            arrayList.add(str);
        }
        ArrayList<String> arrayList2 = null;
        if (!arrayList.isEmpty()) {
            for (String str2 : arrayList) {
                if (str2 == null) {
                    throw new IllegalArgumentException("category must not be null");
                }
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>();
                }
                if (!arrayList2.contains(str2)) {
                    arrayList2.add(str2);
                }
            }
        }
        if (arrayList2 == null) {
            c3424l0 = C3424l0.f11567c;
        } else {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("controlCategories", arrayList2);
            c3424l0 = new C3424l0(bundle, arrayList2);
        }
        C3456x c3456x = new C3456x(c3424l0, routeDiscoveryPreference.shouldPerformActiveScan());
        c3412h0.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (!Objects.equals(c3412h0.f11541d, c3456x) || c3456x.m7096b()) {
            c3412h0.f11541d = c3456x;
            c3412h0.f11542e = jElapsedRealtime;
            c3412h0.m6998h();
        }
    }

    @Override
    public final void onReleaseSession(long j10, String str) {
        C3450u c3450u;
        if (getSessionInfo(str) == null) {
            return;
        }
        synchronized (this.f11691a) {
            c3450u = (C3450u) this.f11693c.remove(str);
        }
        if (c3450u != null) {
            c3450u.m7063a(true);
        } else {
            Log.w("MR2ProviderService", "onReleaseSession: Couldn't find a session");
            notifyRequestFailed(j10, 4);
        }
    }

    @Override
    public final void onSelectRoute(long j10, String str, String str2) {
        if (getSessionInfo(str) == null) {
            Log.w("MR2ProviderService", "onSelectRoute: Couldn't find a session");
            notifyRequestFailed(j10, 4);
        } else {
            if (m7079d(str2, "onSelectRoute") == null) {
                notifyRequestFailed(j10, 3);
                return;
            }
            AbstractC3394b0 abstractC3394b0M7078c = m7078c(str);
            if (abstractC3394b0M7078c != null) {
                abstractC3394b0M7078c.mo6890n(str2);
            } else {
                Log.w("MR2ProviderService", "onSelectRoute: Couldn't find a controller");
                notifyRequestFailed(j10, 3);
            }
        }
    }

    @Override
    public final void onSetRouteVolume(long j10, String str, int i6) {
        AbstractC3397c0 abstractC3397c0M7077b = m7077b(str);
        if (abstractC3397c0M7077b != null) {
            abstractC3397c0M7077b.mo6894g(i6);
            return;
        }
        Log.w("MR2ProviderService", "onSetRouteVolume: Couldn't find a controller for routeId=" + str);
        notifyRequestFailed(j10, 3);
    }

    @Override
    public final void onSetSessionVolume(long j10, String str, int i6) {
        if (getSessionInfo(str) == null) {
            Log.w("MR2ProviderService", "onSetSessionVolume: Couldn't find a session");
            notifyRequestFailed(j10, 4);
            return;
        }
        AbstractC3394b0 abstractC3394b0M7078c = m7078c(str);
        if (abstractC3394b0M7078c != null) {
            abstractC3394b0M7078c.mo6894g(i6);
        } else {
            Log.w("MR2ProviderService", "onSetSessionVolume: Couldn't find a controller");
            notifyRequestFailed(j10, 3);
        }
    }

    @Override
    public final void onTransferToRoute(long j10, String str, String str2) {
        if (getSessionInfo(str) == null) {
            Log.w("MR2ProviderService", "onTransferToRoute: Couldn't find a session");
            notifyRequestFailed(j10, 4);
        } else {
            if (m7079d(str2, "onTransferToRoute") == null) {
                notifyRequestFailed(j10, 3);
                return;
            }
            AbstractC3394b0 abstractC3394b0M7078c = m7078c(str);
            if (abstractC3394b0M7078c != null) {
                abstractC3394b0M7078c.mo6892p(Collections.singletonList(str2));
            } else {
                Log.w("MR2ProviderService", "onTransferToRoute: Couldn't find a controller");
                notifyRequestFailed(j10, 3);
            }
        }
    }
}
