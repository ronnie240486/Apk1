package p173q1;

import android.os.Bundle;
import android.util.Log;

public final class C3419j1 extends AbstractC3433o0 {

    public final C3422k1 f11536a;

    public C3419j1(C3422k1 c3422k1) {
        this.f11536a = c3422k1;
    }

    @Override
    public final void mo6959a(String str, Bundle bundle) {
        Log.d("MediaRouteProviderProxy", "Error: " + str + ", data: " + bundle);
    }

    @Override
    public final void mo6960b(Bundle bundle) {
        String string = bundle.getString("groupableTitle");
        C3422k1 c3422k1 = this.f11536a;
        c3422k1.f11548h = string;
        c3422k1.f11549i = bundle.getString("transferableTitle");
    }
}
