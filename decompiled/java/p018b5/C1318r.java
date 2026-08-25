package p018b5;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.AbstractC1500a;

public final class C1318r extends AbstractC1309i {

    public final AbstractC1500a f4109g;

    public C1318r(AbstractC1500a abstractC1500a, int i6, Bundle bundle) {
        super(abstractC1500a, i6, bundle);
        this.f4109g = abstractC1500a;
    }

    @Override
    public final void mo3187a(ConnectionResult connectionResult) {
        AbstractC1500a abstractC1500a = this.f4109g;
        abstractC1500a.getClass();
        abstractC1500a.f5078j.mo48a(connectionResult);
        abstractC1500a.mo3667t(connectionResult);
    }

    @Override
    public final boolean mo3188b() {
        this.f4109g.f5078j.mo48a(ConnectionResult.f4969e);
        return true;
    }
}
