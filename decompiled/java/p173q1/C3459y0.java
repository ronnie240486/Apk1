package p173q1;

import android.media.MediaRouter;
import android.os.Bundle;
import android.view.Display;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import p001a0.C0023f;

public final class C3459y0 extends MediaRouter.Callback {

    public final C3404e1 f11718a;

    public C3459y0(C3404e1 c3404e1) {
        this.f11718a = c3404e1;
    }

    @Override
    public final void onRouteAdded(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        C3404e1 c3404e1 = this.f11718a;
        if (c3404e1.m6911h(routeInfo)) {
            c3404e1.m6919r();
        }
    }

    @Override
    public final void onRouteChanged(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        int iM6912i;
        C3404e1 c3404e1 = this.f11718a;
        c3404e1.getClass();
        if (C3404e1.m6909m(routeInfo) != null || (iM6912i = c3404e1.m6912i(routeInfo)) < 0) {
            return;
        }
        C3398c1 c3398c1 = (C3398c1) c3404e1.f11468q.get(iM6912i);
        C0023f c0023f = new C0023f(c3398c1.f11440b, c3404e1.m6915l(c3398c1.f11439a));
        c3404e1.mo6884n(c3398c1, c0023f);
        c3398c1.f11441c = c0023f.m103c();
        c3404e1.m6919r();
    }

    @Override
    public final void onRouteGrouped(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo, MediaRouter.RouteGroup routeGroup, int i6) {
        this.f11718a.getClass();
    }

    @Override
    public final void onRoutePresentationDisplayChanged(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        C3404e1 c3404e1 = this.f11718a;
        int iM6912i = c3404e1.m6912i(routeInfo);
        if (iM6912i >= 0) {
            C3398c1 c3398c1 = (C3398c1) c3404e1.f11468q.get(iM6912i);
            Display presentationDisplay = routeInfo.getPresentationDisplay();
            int displayId = presentationDisplay != null ? presentationDisplay.getDisplayId() : -1;
            if (displayId != c3398c1.f11441c.f11701a.getInt("presentationDisplayId", -1)) {
                C3454w c3454w = c3398c1.f11441c;
                new ArrayList();
                new ArrayList();
                new HashSet();
                if (c3454w == null) {
                    throw new IllegalArgumentException("descriptor must not be null");
                }
                Bundle bundle = new Bundle(c3454w.f11701a);
                ArrayList arrayListM7087d = c3454w.m7087d();
                ArrayList arrayListM7085b = c3454w.m7085b();
                HashSet hashSetM7084a = c3454w.m7084a();
                bundle.putInt("presentationDisplayId", displayId);
                bundle.putParcelableArrayList("controlFilters", new ArrayList<>(arrayListM7085b));
                bundle.putStringArrayList("groupMemberIds", new ArrayList<>(arrayListM7087d));
                bundle.putStringArrayList("allowedPackages", new ArrayList<>(hashSetM7084a));
                c3398c1.f11441c = new C3454w(bundle);
                c3404e1.m6919r();
            }
        }
    }

    @Override
    public final void onRouteRemoved(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        int iM6912i;
        C3404e1 c3404e1 = this.f11718a;
        c3404e1.getClass();
        if (C3404e1.m6909m(routeInfo) != null || (iM6912i = c3404e1.m6912i(routeInfo)) < 0) {
            return;
        }
        c3404e1.f11468q.remove(iM6912i);
        c3404e1.m6919r();
    }

    @Override
    public final void onRouteSelected(MediaRouter mediaRouter, int i6, MediaRouter.RouteInfo routeInfo) {
        C3445s0 c3445s0;
        C3404e1 c3404e1 = this.f11718a;
        if (routeInfo != c3404e1.f11461j.getSelectedRoute(8388611)) {
            return;
        }
        C3401d1 c3401d1M6909m = C3404e1.m6909m(routeInfo);
        if (c3401d1M6909m != null) {
            c3401d1M6909m.f11445a.m7029l(false);
            return;
        }
        int iM6912i = c3404e1.m6912i(routeInfo);
        if (iM6912i >= 0) {
            String str = ((C3398c1) c3404e1.f11468q.get(iM6912i)).f11440b;
            C3411h c3411h = c3404e1.f11460i;
            c3411h.f11488a.removeMessages(262);
            C3442r0 c3442r0M6937d = c3411h.m6937d(c3411h.f11506s);
            if (c3442r0M6937d != null) {
                Iterator it = c3442r0M6937d.f11644b.iterator();
                do {
                    if (!it.hasNext()) {
                        c3445s0 = null;
                        break;
                    }
                    c3445s0 = (C3445s0) it.next();
                } while (!c3445s0.f11653b.equals(str));
                if (c3445s0 != null) {
                    c3445s0.m7029l(false);
                }
            }
        }
    }

    @Override
    public final void onRouteUngrouped(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo, MediaRouter.RouteGroup routeGroup) {
        this.f11718a.getClass();
    }

    @Override
    public final void onRouteUnselected(MediaRouter mediaRouter, int i6, MediaRouter.RouteInfo routeInfo) {
        this.f11718a.getClass();
    }

    @Override
    public final void onRouteVolumeChanged(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        int iM6912i;
        C3404e1 c3404e1 = this.f11718a;
        c3404e1.getClass();
        if (C3404e1.m6909m(routeInfo) != null || (iM6912i = c3404e1.m6912i(routeInfo)) < 0) {
            return;
        }
        C3398c1 c3398c1 = (C3398c1) c3404e1.f11468q.get(iM6912i);
        int volume = routeInfo.getVolume();
        if (volume != c3398c1.f11441c.m7091h()) {
            C3454w c3454w = c3398c1.f11441c;
            new ArrayList();
            new ArrayList();
            new HashSet();
            if (c3454w == null) {
                throw new IllegalArgumentException("descriptor must not be null");
            }
            Bundle bundle = new Bundle(c3454w.f11701a);
            ArrayList arrayListM7087d = c3454w.m7087d();
            ArrayList arrayListM7085b = c3454w.m7085b();
            HashSet hashSetM7084a = c3454w.m7084a();
            bundle.putInt("volume", volume);
            bundle.putParcelableArrayList("controlFilters", new ArrayList<>(arrayListM7085b));
            bundle.putStringArrayList("groupMemberIds", new ArrayList<>(arrayListM7087d));
            bundle.putStringArrayList("allowedPackages", new ArrayList<>(hashSetM7084a));
            c3398c1.f11441c = new C3454w(bundle);
            c3404e1.m6919r();
        }
    }
}
