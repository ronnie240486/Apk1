package p176q4;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.cast.AbstractC1542e0;
import com.google.android.gms.internal.cast.C1507a5;
import com.google.android.gms.internal.cast.C1552f0;
import com.google.android.gms.internal.cast.C1562g0;
import p025c2.C1381b;
import p187r4.C3616f;

public final class C3478d0 {

    public final C3475c f11773a;

    public C3478d0(C3475c c3475c) {
        this.f11773a = c3475c;
    }

    public final void m7135a() {
        C3475c c3475c = this.f11773a;
        if (c3475c.f11758e == null) {
            return;
        }
        try {
            C3616f c3616f = c3475c.f11763j;
            if (c3616f != null) {
                c3616f.m7320y();
            }
            C3489o c3489o = (C3489o) c3475c.f11758e;
            Parcel parcelM3687l = c3489o.m3687l();
            int i6 = AbstractC1542e0.f5277a;
            parcelM3687l.writeInt(0);
            c3489o.m3689x(parcelM3687l, 1);
        } catch (RemoteException e5) {
            C3475c.f11755m.m7974a(e5, "Unable to call %s on %s.", "onConnected", InterfaceC3491q.class.getSimpleName());
        }
        C1507a5 c1507a5 = c3475c.f11765l;
        if (c1507a5 != null) {
            C1381b.m3250k(c1507a5.f5205a, new C1562g0(new C1552f0(3)));
        }
    }
}
