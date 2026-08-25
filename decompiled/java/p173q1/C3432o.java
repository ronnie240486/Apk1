package p173q1;

import android.media.MediaRoute2Info;
import android.media.MediaRouter2;
import android.text.TextUtils;
import android.util.Log;
import androidx.media3.common.AbstractC0590d;
import java.util.Iterator;
import java.util.List;

public final class C3432o extends MediaRouter2.TransferCallback {

    public final C3435p f11599a;

    public C3432o(C3435p c3435p) {
        this.f11599a = c3435p;
    }

    @Override
    public final void onStop(MediaRouter2.RoutingController routingController) {
        AbstractC3397c0 abstractC3397c0 = (AbstractC3397c0) this.f11599a.f11612k.remove(routingController);
        if (abstractC3397c0 == null) {
            Log.w("MR2Provider", "onStop: No matching routeController found. routingController=" + routingController);
            return;
        }
        C3411h c3411h = this.f11599a.f11611j.f11426a;
        if (abstractC3397c0 != c3411h.f11492e) {
            int i6 = C3411h.f11482F;
            return;
        }
        C3445s0 c3445s0M6936c = c3411h.m6936c();
        if (c3411h.m6940g() != c3445s0M6936c) {
            c3411h.m6944k(c3445s0M6936c, 2, true);
        }
    }

    @Override
    public final void onTransfer(MediaRouter2.RoutingController routingController, MediaRouter2.RoutingController routingController2) {
        C3445s0 c3445s0;
        this.f11599a.f11612k.remove(routingController);
        if (routingController2 == this.f11599a.f11610i.getSystemController()) {
            C3411h c3411h = this.f11599a.f11611j.f11426a;
            C3445s0 c3445s0M6936c = c3411h.m6936c();
            if (c3411h.m6940g() != c3445s0M6936c) {
                c3411h.m6944k(c3445s0M6936c, 3, true);
                return;
            }
            return;
        }
        List selectedRoutes = routingController2.getSelectedRoutes();
        if (selectedRoutes.isEmpty()) {
            Log.w("MR2Provider", "Selected routes are empty. This shouldn't happen.");
            return;
        }
        String id = AbstractC0590d.m1624f(selectedRoutes.get(0)).getId();
        this.f11599a.f11612k.put(routingController2, new C3423l(this.f11599a, routingController2, id));
        C3411h c3411h2 = this.f11599a.f11611j.f11426a;
        Iterator it = c3411h2.f11496i.iterator();
        while (true) {
            if (!it.hasNext()) {
                c3445s0 = null;
                break;
            }
            c3445s0 = (C3445s0) it.next();
            if (c3445s0.m7020c() == c3411h2.f11505r && TextUtils.equals(id, c3445s0.f11653b)) {
                break;
            }
        }
        if (c3445s0 == null) {
            Log.w("AxMediaRouter", "onSelectRoute: The target RouteInfo is not found for descriptorId=" + id);
        } else {
            c3411h2.m6944k(c3445s0, 3, true);
        }
        this.f11599a.m7012j(routingController2);
    }

    @Override
    public final void onTransferFailure(MediaRoute2Info mediaRoute2Info) {
        Log.w("MR2Provider", "Transfer failed. requestedRoute=" + mediaRoute2Info);
    }
}
