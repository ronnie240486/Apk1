package p165p4;

import com.google.android.gms.cast.CastRemoteDisplayLocalService;
import p173q1.AbstractC3427m0;
import p230v4.C3988b;

public final class C3363h extends AbstractC3427m0 {

    public final CastRemoteDisplayLocalService f11355a;

    public C3363h(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
        this.f11355a = castRemoteDisplayLocalService;
    }

    @Override
    public final void mo2757k() {
        C3988b c3988b = CastRemoteDisplayLocalService.f4620d;
        CastRemoteDisplayLocalService castRemoteDisplayLocalService = this.f11355a;
        castRemoteDisplayLocalService.m3589a("onRouteUnselected");
        castRemoteDisplayLocalService.m3589a("onRouteUnselected, no device was selected");
    }
}
