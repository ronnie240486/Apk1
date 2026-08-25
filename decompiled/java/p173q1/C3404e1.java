package p173q1;

import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.media.MediaRouter;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import androidx.appcompat.app.C0157r0;
import com.lzy.okgo.model.Progress;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import p001a0.C0023f;
import p101j7.C2782c;

public class C3404e1 extends AbstractC3407f1 {

    public static final ArrayList f11458s;

    public static final ArrayList f11459t;

    public final C3411h f11460i;

    public final MediaRouter f11461j;

    public final C3459y0 f11462k;

    public final C3461z0 f11463l;

    public final MediaRouter.RouteCategory f11464m;

    public int f11465n;

    public boolean f11466o;

    public boolean f11467p;

    public final ArrayList f11468q;

    public final ArrayList f11469r;

    static {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addCategory("android.media.intent.category.LIVE_AUDIO");
        ArrayList arrayList = new ArrayList();
        f11458s = arrayList;
        arrayList.add(intentFilter);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addCategory("android.media.intent.category.LIVE_VIDEO");
        ArrayList arrayList2 = new ArrayList();
        f11459t = arrayList2;
        arrayList2.add(intentFilter2);
    }

    public C3404e1(Context context, C3411h c3411h) {
        super(context, new C2782c(27, new ComponentName("android", AbstractC3407f1.class.getName())));
        this.f11468q = new ArrayList();
        this.f11469r = new ArrayList();
        this.f11460i = c3411h;
        MediaRouter mediaRouter = (MediaRouter) context.getSystemService("media_router");
        this.f11461j = mediaRouter;
        this.f11462k = new C3459y0(this);
        this.f11463l = new C3461z0(this);
        this.f11464m = mediaRouter.createRouteCategory((CharSequence) context.getResources().getString(R.string.mr_user_route_category_name), false);
        m6920s();
    }

    public static C3401d1 m6909m(MediaRouter.RouteInfo routeInfo) {
        Object tag = routeInfo.getTag();
        if (tag instanceof C3401d1) {
            return (C3401d1) tag;
        }
        return null;
    }

    public static void m6910t(C3401d1 c3401d1) {
        MediaRouter.UserRouteInfo userRouteInfo = c3401d1.f11446b;
        C3445s0 c3445s0 = c3401d1.f11445a;
        userRouteInfo.setName(c3445s0.f11655d);
        userRouteInfo.setPlaybackType(c3445s0.f11663l);
        userRouteInfo.setPlaybackStream(c3445s0.f11664m);
        userRouteInfo.setVolume(c3445s0.f11667p);
        userRouteInfo.setVolumeMax(c3445s0.f11668q);
        userRouteInfo.setVolumeHandling((!c3445s0.m7022e() || C3451u0.m7072g()) ? c3445s0.f11666o : 0);
        userRouteInfo.setDescription(c3445s0.f11656e);
    }

    @Override
    public final AbstractC3397c0 mo6903b(String str) {
        int iM6913j = m6913j(str);
        if (iM6913j >= 0) {
            return new C3395b1(((C3398c1) this.f11468q.get(iM6913j)).f11439a);
        }
        return null;
    }

    @Override
    public final void mo6906e(C3456x c3456x) {
        boolean zM7096b;
        int i6 = 0;
        if (c3456x != null) {
            c3456x.m7095a();
            ArrayList arrayListM7001c = c3456x.f11707b.m7001c();
            int size = arrayListM7001c.size();
            int i10 = 0;
            while (i6 < size) {
                String str = (String) arrayListM7001c.get(i6);
                if (str.equals("android.media.intent.category.LIVE_AUDIO")) {
                    i10 |= 1;
                } else {
                    i10 = str.equals("android.media.intent.category.LIVE_VIDEO") ? i10 | 2 : i10 | 8388608;
                }
                i6++;
            }
            zM7096b = c3456x.m7096b();
            i6 = i10;
        } else {
            zM7096b = false;
        }
        if (this.f11465n == i6 && this.f11466o == zM7096b) {
            return;
        }
        this.f11465n = i6;
        this.f11466o = zM7096b;
        m6920s();
    }

    public final boolean m6911h(MediaRouter.RouteInfo routeInfo) {
        String str;
        if (m6909m(routeInfo) != null || m6912i(routeInfo) >= 0) {
            return false;
        }
        String str2 = this.f11461j.getDefaultRoute() == routeInfo ? "DEFAULT_ROUTE" : String.format(Locale.US, "ROUTE_%08x", Integer.valueOf(m6915l(routeInfo).hashCode()));
        if (m6913j(str2) >= 0) {
            int i6 = 2;
            while (true) {
                Locale locale = Locale.US;
                str = str2 + "_" + i6;
                if (m6913j(str) < 0) {
                    break;
                }
                i6++;
            }
            str2 = str;
        }
        C3398c1 c3398c1 = new C3398c1(routeInfo, str2);
        C0023f c0023f = new C0023f(str2, m6915l(routeInfo));
        mo6884n(c3398c1, c0023f);
        c3398c1.f11441c = c0023f.m103c();
        this.f11468q.add(c3398c1);
        return true;
    }

    public final int m6912i(MediaRouter.RouteInfo routeInfo) {
        ArrayList arrayList = this.f11468q;
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            if (((C3398c1) arrayList.get(i6)).f11439a == routeInfo) {
                return i6;
            }
        }
        return -1;
    }

    public final int m6913j(String str) {
        ArrayList arrayList = this.f11468q;
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            if (((C3398c1) arrayList.get(i6)).f11440b.equals(str)) {
                return i6;
            }
        }
        return -1;
    }

    public final int m6914k(C3445s0 c3445s0) {
        ArrayList arrayList = this.f11469r;
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            if (((C3401d1) arrayList.get(i6)).f11445a == c3445s0) {
                return i6;
            }
        }
        return -1;
    }

    public final String m6915l(MediaRouter.RouteInfo routeInfo) {
        int i6;
        Context context = this.f11450a;
        CharSequence name = routeInfo.getName(context);
        if (!TextUtils.isEmpty(name)) {
            return name.toString();
        }
        if ((routeInfo.getSupportedTypes() & 8388608) != 0) {
            return "";
        }
        int deviceType = Build.VERSION.SDK_INT >= 24 ? routeInfo.getDeviceType() : 0;
        if (deviceType == 1) {
            i6 = R.string.mr_route_name_tv;
        } else if (deviceType != 2) {
            i6 = deviceType != 3 ? R.string.mr_route_name_unknown : R.string.mr_route_name_bluetooth;
        } else {
            i6 = R.string.mr_route_name_speaker;
        }
        return context.getString(i6);
    }

    public void mo6884n(C3398c1 c3398c1, C0023f c0023f) {
        int supportedTypes = c3398c1.f11439a.getSupportedTypes();
        if ((supportedTypes & 1) != 0) {
            c0023f.m102b(f11458s);
        }
        if ((supportedTypes & 2) != 0) {
            c0023f.m102b(f11459t);
        }
        MediaRouter.RouteInfo routeInfo = c3398c1.f11439a;
        int playbackType = routeInfo.getPlaybackType();
        Bundle bundle = (Bundle) c0023f.f44b;
        bundle.putInt("playbackType", playbackType);
        bundle.putInt("playbackStream", routeInfo.getPlaybackStream());
        bundle.putInt("volume", routeInfo.getVolume());
        bundle.putInt("volumeMax", routeInfo.getVolumeMax());
        bundle.putInt("volumeHandling", routeInfo.getVolumeHandling());
        bundle.putBoolean("isSystemRoute", (supportedTypes & 8388608) == 0);
        if (!routeInfo.isEnabled()) {
            bundle.putBoolean("enabled", false);
        }
        if (routeInfo.isConnecting()) {
            bundle.putInt("connectionState", 1);
        }
        Display presentationDisplay = routeInfo.getPresentationDisplay();
        if (presentationDisplay != null) {
            bundle.putInt("presentationDisplayId", presentationDisplay.getDisplayId());
        }
        CharSequence description = routeInfo.getDescription();
        if (description != null) {
            bundle.putString(Progress.STATUS, description.toString());
        }
    }

    public final void m6916o(C3445s0 c3445s0) {
        AbstractC3403e0 abstractC3403e0M7020c = c3445s0.m7020c();
        MediaRouter mediaRouter = this.f11461j;
        if (abstractC3403e0M7020c == this) {
            int iM6912i = m6912i(mediaRouter.getSelectedRoute(8388611));
            if (iM6912i < 0 || !((C3398c1) this.f11468q.get(iM6912i)).f11440b.equals(c3445s0.f11653b)) {
                return;
            }
            c3445s0.m7029l(false);
            return;
        }
        MediaRouter.UserRouteInfo userRouteInfoCreateUserRoute = mediaRouter.createUserRoute(this.f11464m);
        C3401d1 c3401d1 = new C3401d1(c3445s0, userRouteInfoCreateUserRoute);
        userRouteInfoCreateUserRoute.setTag(c3401d1);
        userRouteInfoCreateUserRoute.setVolumeCallback(this.f11463l);
        m6910t(c3401d1);
        this.f11469r.add(c3401d1);
        mediaRouter.addUserRoute(userRouteInfoCreateUserRoute);
    }

    public final void m6917p(C3445s0 c3445s0) {
        int iM6914k;
        if (c3445s0.m7020c() == this || (iM6914k = m6914k(c3445s0)) < 0) {
            return;
        }
        C3401d1 c3401d1 = (C3401d1) this.f11469r.remove(iM6914k);
        c3401d1.f11446b.setTag(null);
        MediaRouter.UserRouteInfo userRouteInfo = c3401d1.f11446b;
        userRouteInfo.setVolumeCallback(null);
        try {
            this.f11461j.removeUserRoute(userRouteInfo);
        } catch (IllegalArgumentException e5) {
            Log.w("AxSysMediaRouteProvider", "Failed to remove user route", e5);
        }
    }

    public final void m6918q(C3445s0 c3445s0) {
        if (c3445s0.m7024g()) {
            AbstractC3403e0 abstractC3403e0M7020c = c3445s0.m7020c();
            MediaRouter mediaRouter = this.f11461j;
            if (abstractC3403e0M7020c != this) {
                int iM6914k = m6914k(c3445s0);
                if (iM6914k >= 0) {
                    mediaRouter.selectRoute(8388611, ((C3401d1) this.f11469r.get(iM6914k)).f11446b);
                    return;
                }
                return;
            }
            int iM6913j = m6913j(c3445s0.f11653b);
            if (iM6913j >= 0) {
                mediaRouter.selectRoute(8388611, ((C3398c1) this.f11468q.get(iM6913j)).f11439a);
            }
        }
    }

    public final void m6919r() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.f11468q;
        int size = arrayList2.size();
        for (int i6 = 0; i6 < size; i6++) {
            C3454w c3454w = ((C3398c1) arrayList2.get(i6)).f11441c;
            if (c3454w == null) {
                throw new IllegalArgumentException("route must not be null");
            }
            if (arrayList.contains(c3454w)) {
                throw new IllegalArgumentException("route descriptor already added");
            }
            arrayList.add(c3454w);
        }
        m6907f(new C0157r0(arrayList, false));
    }

    public final void m6920s() {
        boolean z7 = this.f11467p;
        MediaRouter mediaRouter = this.f11461j;
        C3459y0 c3459y0 = this.f11462k;
        if (z7) {
            mediaRouter.removeCallback(c3459y0);
        }
        this.f11467p = true;
        mediaRouter.addCallback(this.f11465n, c3459y0, (this.f11466o ? 1 : 0) | 2);
        int routeCount = mediaRouter.getRouteCount();
        ArrayList arrayList = new ArrayList(routeCount);
        boolean zM6911h = false;
        for (int i6 = 0; i6 < routeCount; i6++) {
            arrayList.add(mediaRouter.getRouteAt(i6));
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            zM6911h |= m6911h((MediaRouter.RouteInfo) it.next());
        }
        if (zM6911h) {
            m6919r();
        }
    }
}
