package p018b5;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.AbstractC1500a;

public abstract class AbstractC1309i {

    public Boolean f4091a;

    public boolean f4092b;

    public final AbstractC1500a f4093c;

    public final int f4094d;

    public final Bundle f4095e;

    public final AbstractC1500a f4096f;

    public AbstractC1309i(AbstractC1500a abstractC1500a, int i6, Bundle bundle) {
        this.f4096f = abstractC1500a;
        Boolean bool = Boolean.TRUE;
        this.f4093c = abstractC1500a;
        this.f4091a = bool;
        this.f4092b = false;
        this.f4094d = i6;
        this.f4095e = bundle;
    }

    public abstract void mo3187a(ConnectionResult connectionResult);

    public abstract boolean mo3188b();

    public final void m3189c() {
        synchronized (this) {
            this.f4091a = null;
        }
    }

    public final void m3190d() {
        m3189c();
        synchronized (this.f4093c.f5080l) {
            this.f4093c.f5080l.remove(this);
        }
    }
}
