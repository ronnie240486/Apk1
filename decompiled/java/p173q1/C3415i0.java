package p173q1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Messenger;
import androidx.mediarouter.media.MediaRouteProviderService;

public final class C3415i0 extends AbstractC3433o0 {

    public final Messenger f11525a;

    public final int f11526b;

    public final C3421k0 f11527c;

    public C3415i0(C3421k0 c3421k0, C3418j0 c3418j0, int i6, Intent intent, Messenger messenger, int i10) {
        this.f11527c = c3421k0;
        this.f11525a = messenger;
        this.f11526b = i10;
    }

    @Override
    public final void mo6959a(String str, Bundle bundle) {
        int i6 = MediaRouteProviderService.f3437f;
        if (this.f11527c.m6995c(this.f11525a) >= 0) {
            if (str == null) {
                MediaRouteProviderService.m2806e(this.f11525a, 4, this.f11526b, 0, bundle, null);
            } else {
                Bundle bundle2 = new Bundle();
                bundle2.putString("error", str);
                MediaRouteProviderService.m2806e(this.f11525a, 4, this.f11526b, 0, bundle, bundle2);
            }
        }
    }

    @Override
    public final void mo6960b(Bundle bundle) {
        int i6 = MediaRouteProviderService.f3437f;
        if (this.f11527c.m6995c(this.f11525a) >= 0) {
            MediaRouteProviderService.m2806e(this.f11525a, 3, this.f11526b, 0, bundle, null);
        }
    }
}
