package p173q1;

import android.media.MediaRouter;

public final class C3461z0 extends MediaRouter.VolumeCallback {

    public final C3404e1 f11725a;

    public C3461z0(C3404e1 c3404e1) {
        this.f11725a = c3404e1;
    }

    @Override
    public final void onVolumeSetRequest(MediaRouter.RouteInfo routeInfo, int i6) {
        this.f11725a.getClass();
        C3401d1 c3401d1M6909m = C3404e1.m6909m(routeInfo);
        if (c3401d1M6909m != null) {
            c3401d1M6909m.f11445a.m7027j(i6);
        }
    }

    @Override
    public final void onVolumeUpdateRequest(MediaRouter.RouteInfo routeInfo, int i6) {
        this.f11725a.getClass();
        C3401d1 c3401d1M6909m = C3404e1.m6909m(routeInfo);
        if (c3401d1M6909m != null) {
            c3401d1M6909m.f11445a.m7028k(i6);
        }
    }
}
