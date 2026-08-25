package p173q1;

import android.media.MediaRouter;

public final class C3395b1 extends AbstractC3397c0 {

    public final MediaRouter.RouteInfo f11435a;

    public C3395b1(MediaRouter.RouteInfo routeInfo) {
        this.f11435a = routeInfo;
    }

    @Override
    public final void mo6894g(int i6) {
        this.f11435a.requestSetVolume(i6);
    }

    @Override
    public final void mo6895j(int i6) {
        this.f11435a.requestUpdateVolume(i6);
    }
}
