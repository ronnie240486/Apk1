package p173q1;

import android.content.Context;
import android.media.MediaRoute2Info;
import android.media.MediaRouter2;
import android.media.RouteDiscoveryPreference;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Log;
import androidx.appcompat.app.C0157r0;
import androidx.media3.common.AbstractC0590d;
import androidx.media3.common.util.ExecutorC0620e;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p001a0.C0023f;
import p003a2.AbstractC0032a;

public final class C3435p extends AbstractC3403e0 {

    public static final int f11609s = 0;

    public final MediaRouter2 f11610i;

    public final C3390a f11611j;

    public final ArrayMap f11612k;

    public final MediaRouter2.RouteCallback f11613l;

    public final C3432o f11614m;

    public final C3420k f11615n;

    public final ExecutorC0620e f11616o;

    public boolean f11617p;

    public ArrayList f11618q;

    public final ArrayMap f11619r;

    static {
        Log.isLoggable("MR2Provider", 3);
    }

    public C3435p(Context context, C3390a c3390a) {
        super(context, null);
        this.f11612k = new ArrayMap();
        this.f11614m = new C3432o(this);
        this.f11615n = new C3420k(this);
        this.f11618q = new ArrayList();
        this.f11619r = new ArrayMap();
        this.f11610i = MediaRouter2.getInstance(context);
        this.f11611j = c3390a;
        this.f11616o = new ExecutorC0620e(new Handler(Looper.getMainLooper()));
        if (Build.VERSION.SDK_INT >= 34) {
            this.f11613l = new C3429n(this, 1);
        } else {
            this.f11613l = new C3429n(this, 0);
        }
    }

    @Override
    public final AbstractC3394b0 mo6902a(String str, C3400d0 c3400d0) {
        Iterator it = this.f11612k.entrySet().iterator();
        while (it.hasNext()) {
            C3423l c3423l = (C3423l) ((Map.Entry) it.next()).getValue();
            if (TextUtils.equals(str, c3423l.f11556f)) {
                return c3423l;
            }
        }
        return null;
    }

    @Override
    public final AbstractC3397c0 mo6903b(String str) {
        return new C3426m((String) this.f11619r.get(str), null);
    }

    @Override
    public final AbstractC3397c0 mo6904c(String str, String str2) {
        String str3 = (String) this.f11619r.get(str);
        for (C3423l c3423l : this.f11612k.values()) {
            C3454w c3454w = c3423l.f11565o;
            if (TextUtils.equals(str2, c3454w != null ? c3454w.m7089f() : c3423l.f11557g.getId())) {
                return new C3426m(str3, c3423l);
            }
        }
        Log.w("MR2Provider", "Could not find the matching GroupRouteController. routeId=" + str + ", routeGroupId=" + str2);
        return new C3426m(str3, null);
    }

    @Override
    public final void mo6906e(C3456x c3456x) {
        ArrayList<String> arrayList;
        C3424l0 c3424l0;
        RouteDiscoveryPreference routeDiscoveryPreferenceBuild;
        int i6 = C3451u0.f11687c == null ? 0 : C3451u0.m7068c().f11484B;
        C3420k c3420k = this.f11615n;
        C3432o c3432o = this.f11614m;
        if (i6 <= 0) {
            this.f11610i.unregisterRouteCallback(this.f11613l);
            this.f11610i.unregisterTransferCallback(c3432o);
            this.f11610i.unregisterControllerCallback(c3420k);
            return;
        }
        C3457x0 c3457x0 = C3451u0.m7068c().f11508u;
        boolean z7 = c3457x0 == null ? false : c3457x0.f11710c;
        if (c3456x == null) {
            c3456x = new C3456x(C3424l0.f11567c, false);
        }
        c3456x.m7095a();
        ArrayList<String> arrayListM7001c = c3456x.f11707b.m7001c();
        if (!z7) {
            arrayListM7001c.remove("android.media.intent.category.LIVE_AUDIO");
        } else if (!arrayListM7001c.contains("android.media.intent.category.LIVE_AUDIO")) {
            arrayListM7001c.add("android.media.intent.category.LIVE_AUDIO");
        }
        if (arrayListM7001c.isEmpty()) {
            arrayList = null;
        } else {
            arrayList = null;
            for (String str : arrayListM7001c) {
                if (str == null) {
                    throw new IllegalArgumentException("category must not be null");
                }
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
            }
        }
        if (arrayList == null) {
            c3424l0 = C3424l0.f11567c;
        } else {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("controlCategories", arrayList);
            c3424l0 = new C3424l0(bundle, arrayList);
        }
        boolean zM7096b = c3456x.m7096b();
        if (c3424l0 == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        Bundle bundle2 = new Bundle();
        bundle2.putBundle("selector", c3424l0.f11568a);
        bundle2.putBoolean("activeScan", zM7096b);
        MediaRouter2 mediaRouter2 = this.f11610i;
        MediaRouter2.RouteCallback routeCallback = this.f11613l;
        c3424l0.m7000a();
        if (c3424l0.f11569b.contains(null)) {
            AbstractC0590d.m1634p();
            routeDiscoveryPreferenceBuild = AbstractC3447t.m7042h(new ArrayList()).build();
        } else {
            boolean z10 = bundle2.getBoolean("activeScan");
            ArrayList arrayList2 = new ArrayList();
            for (String str2 : c3424l0.m7001c()) {
                str2.getClass();
                switch (str2) {
                    case "android.media.intent.category.REMOTE_PLAYBACK":
                        str2 = "android.media.route.feature.REMOTE_PLAYBACK";
                        break;
                    case "android.media.intent.category.LIVE_AUDIO":
                        str2 = "android.media.route.feature.LIVE_AUDIO";
                        break;
                    case "android.media.intent.category.LIVE_VIDEO":
                        str2 = "android.media.route.feature.LIVE_VIDEO";
                        break;
                    case "android.media.intent.category.REMOTE_AUDIO_PLAYBACK":
                        str2 = "android.media.route.feature.REMOTE_AUDIO_PLAYBACK";
                        break;
                    case "android.media.intent.category.REMOTE_VIDEO_PLAYBACK":
                        str2 = "android.media.route.feature.REMOTE_VIDEO_PLAYBACK";
                        break;
                }
                arrayList2.add(str2);
            }
            routeDiscoveryPreferenceBuild = AbstractC3447t.m7043i(arrayList2, z10).build();
        }
        ExecutorC0620e executorC0620e = this.f11616o;
        mediaRouter2.registerRouteCallback(executorC0620e, routeCallback, routeDiscoveryPreferenceBuild);
        this.f11610i.registerTransferCallback(executorC0620e, c3432o);
        this.f11610i.registerControllerCallback(executorC0620e, c3420k);
    }

    public final MediaRoute2Info m7010h(String str) {
        if (str == null) {
            return null;
        }
        Iterator it = this.f11618q.iterator();
        while (it.hasNext()) {
            MediaRoute2Info mediaRoute2InfoM1624f = AbstractC0590d.m1624f(it.next());
            if (TextUtils.equals(mediaRoute2InfoM1624f.getId(), str)) {
                return mediaRoute2InfoM1624f;
            }
        }
        return null;
    }

    public final void m7011i() {
        ArrayList arrayList = new ArrayList();
        ArraySet arraySet = new ArraySet();
        Iterator it = this.f11610i.getRoutes().iterator();
        while (it.hasNext()) {
            MediaRoute2Info mediaRoute2InfoM1624f = AbstractC0590d.m1624f(it.next());
            if (mediaRoute2InfoM1624f != null && !arraySet.contains(mediaRoute2InfoM1624f) && !mediaRoute2InfoM1624f.isSystemRoute()) {
                if (this.f11617p) {
                    if (!mediaRoute2InfoM1624f.getId().startsWith(this.f11450a.getPackageName() + "/")) {
                    }
                }
                arraySet.add(mediaRoute2InfoM1624f);
                arrayList.add(mediaRoute2InfoM1624f);
            }
        }
        if (arrayList.equals(this.f11618q)) {
            return;
        }
        this.f11618q = arrayList;
        ArrayMap arrayMap = this.f11619r;
        arrayMap.clear();
        Iterator it2 = this.f11618q.iterator();
        while (it2.hasNext()) {
            MediaRoute2Info mediaRoute2InfoM1624f2 = AbstractC0590d.m1624f(it2.next());
            Bundle extras = mediaRoute2InfoM1624f2.getExtras();
            if (extras == null || extras.getString("androidx.mediarouter.media.KEY_ORIGINAL_ROUTE_ID") == null) {
                Log.w("MR2Provider", "Cannot find the original route Id. route=" + mediaRoute2InfoM1624f2);
            } else {
                arrayMap.put(mediaRoute2InfoM1624f2.getId(), extras.getString("androidx.mediarouter.media.KEY_ORIGINAL_ROUTE_ID"));
            }
        }
        ArrayList<C3454w> arrayList2 = new ArrayList();
        Iterator it3 = this.f11618q.iterator();
        while (it3.hasNext()) {
            C3454w c3454wM157M = AbstractC0032a.m157M(AbstractC0590d.m1624f(it3.next()));
            if (c3454wM157M != null) {
                arrayList2.add(c3454wM157M);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        if (!arrayList2.isEmpty()) {
            for (C3454w c3454w : arrayList2) {
                if (c3454w == null) {
                    throw new IllegalArgumentException("route must not be null");
                }
                if (arrayList3.contains(c3454w)) {
                    throw new IllegalArgumentException("route descriptor already added");
                }
                arrayList3.add(c3454w);
            }
        }
        m6907f(new C0157r0(arrayList3, true));
    }

    public final void m7012j(MediaRouter2.RoutingController routingController) {
        C0023f c0023f;
        C3423l c3423l = (C3423l) this.f11612k.get(routingController);
        if (c3423l == null) {
            Log.w("MR2Provider", "setDynamicRouteDescriptors: No matching routeController found. routingController=" + routingController);
            return;
        }
        List selectedRoutes = routingController.getSelectedRoutes();
        if (selectedRoutes.isEmpty()) {
            Log.w("MR2Provider", "setDynamicRouteDescriptors: No selected routes. This may happen when the selected routes become invalid.routingController=" + routingController);
            return;
        }
        ArrayList<String> arrayListM151C = AbstractC0032a.m151C(selectedRoutes);
        C3454w c3454wM157M = AbstractC0032a.m157M(AbstractC0590d.m1624f(selectedRoutes.get(0)));
        Bundle controlHints = routingController.getControlHints();
        String string = this.f11450a.getString(R.string.mr_dialog_default_group_name);
        C3454w c3454w = null;
        if (controlHints != null) {
            try {
                String string2 = controlHints.getString("androidx.mediarouter.media.KEY_SESSION_NAME");
                if (!TextUtils.isEmpty(string2)) {
                    string = string2;
                }
                Bundle bundle = controlHints.getBundle("androidx.mediarouter.media.KEY_GROUP_ROUTE");
                if (bundle != null) {
                    c3454w = new C3454w(bundle);
                }
            } catch (Exception e5) {
                Log.w("MR2Provider", "Exception while unparceling control hints.", e5);
            }
        }
        if (c3454w == null) {
            c0023f = new C0023f(routingController.getId(), string);
            Bundle bundle2 = (Bundle) c0023f.f44b;
            bundle2.putInt("connectionState", 2);
            bundle2.putInt("playbackType", 1);
        } else {
            c0023f = new C0023f(c3454w);
        }
        int volume = routingController.getVolume();
        Bundle bundle3 = (Bundle) c0023f.f44b;
        bundle3.putInt("volume", volume);
        bundle3.putInt("volumeMax", routingController.getVolumeMax());
        bundle3.putInt("volumeHandling", routingController.getVolumeHandling());
        ((ArrayList) c0023f.f45c).clear();
        c0023f.m102b(c3454wM157M.m7085b());
        ArrayList arrayList = (ArrayList) c0023f.f46d;
        arrayList.clear();
        if (!arrayListM151C.isEmpty()) {
            for (String str : arrayListM151C) {
                if (TextUtils.isEmpty(str)) {
                    throw new IllegalArgumentException("groupMemberId must not be empty");
                }
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
            }
        }
        C3454w c3454wM103c = c0023f.m103c();
        ArrayList arrayListM151C2 = AbstractC0032a.m151C(routingController.getSelectableRoutes());
        ArrayList arrayListM151C3 = AbstractC0032a.m151C(routingController.getDeselectableRoutes());
        C0157r0 c0157r0 = this.f11456g;
        if (c0157r0 == null) {
            Log.w("MR2Provider", "setDynamicRouteDescriptors: providerDescriptor is not set.");
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        List<C3454w> list = (List) c0157r0.f429c;
        if (!list.isEmpty()) {
            for (C3454w c3454w2 : list) {
                String strM7089f = c3454w2.m7089f();
                arrayList2.add(new C3460z(c3454w2, arrayListM151C.contains(strM7089f) ? 3 : 1, arrayListM151C3.contains(strM7089f), arrayListM151C2.contains(strM7089f), true));
            }
        }
        c3423l.f11565o = c3454wM103c;
        c3423l.m6889m(c3454wM103c, arrayList2);
    }
}
