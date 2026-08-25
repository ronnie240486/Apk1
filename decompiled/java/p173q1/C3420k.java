package p173q1;

import android.media.MediaRouter2;

public final class C3420k extends MediaRouter2.ControllerCallback {

    public final C3435p f11537a;

    public C3420k(C3435p c3435p) {
        this.f11537a = c3435p;
    }

    @Override
    public final void onControllerUpdated(MediaRouter2.RoutingController routingController) {
        this.f11537a.m7012j(routingController);
    }
}
