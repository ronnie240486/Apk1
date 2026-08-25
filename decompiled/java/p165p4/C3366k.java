package p165p4;

import android.content.Context;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.ApiMetadata;
import com.google.android.gms.common.api.ComplianceOptions;
import com.google.android.gms.internal.cast.AbstractC1542e0;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;
import p018b5.AbstractC1312l;
import p230v4.C3988b;
import p230v4.C3990d;
import p230v4.C4009w;
import p242w5.C4056d;
import p271z4.InterfaceC4340k;

public final class C3366k implements InterfaceC4340k {

    public final int f11361a;

    public final C3370o f11362b;

    public final String f11363c;

    public final String f11364d;

    public C3366k(C3370o c3370o, String str, String str2, int i6) {
        this.f11361a = i6;
        this.f11362b = c3370o;
        this.f11363c = str;
        this.f11364d = str2;
    }

    @Override
    public final void mo99p(Object obj, Object obj2) {
        switch (this.f11361a) {
            case 0:
                C4009w c4009w = (C4009w) obj;
                C4056d c4056d = (C4056d) obj2;
                C3988b c3988b = C3370o.f11372F;
                C3370o c3370o = this.f11362b;
                AbstractC1312l.m3200g("Not connected to device", c3370o.m6865j());
                Context context = c4009w.f5071c;
                ComplianceOptions complianceOptions = new ComplianceOptions(-1, -1, 0, true);
                C3990d c3990d = (C3990d) c4009w.m3663p();
                ApiMetadata apiMetadata = new ApiMetadata(complianceOptions);
                Parcel parcelM3687l = c3990d.m3687l();
                parcelM3687l.writeString(this.f11363c);
                parcelM3687l.writeString(this.f11364d);
                int i6 = AbstractC1542e0.f5277a;
                parcelM3687l.writeInt(0);
                AbstractC1542e0.m3809c(parcelM3687l, apiMetadata);
                c3990d.m3690y(parcelM3687l, 14);
                synchronized (c3370o.f11386q) {
                    try {
                        if (c3370o.f11383n != null) {
                            c3370o.m6863h(2477);
                        }
                        c3370o.f11383n = c4056d;
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return;
            default:
                String str = this.f11363c;
                String str2 = this.f11364d;
                C4009w c4009w2 = (C4009w) obj;
                C4056d c4056d2 = (C4056d) obj2;
                C3370o c3370o2 = this.f11362b;
                AtomicLong atomicLong = c3370o2.f11385p;
                HashMap map = c3370o2.f11374A;
                long jIncrementAndGet = atomicLong.incrementAndGet();
                AbstractC1312l.m3200g("Not connected to device", c3370o2.m6865j());
                try {
                    map.put(Long.valueOf(jIncrementAndGet), c4056d2);
                    Context context2 = c4009w2.f5071c;
                    ApiMetadata apiMetadata2 = new ApiMetadata(new ComplianceOptions(-1, -1, 0, true));
                    C3990d c3990d2 = (C3990d) c4009w2.m3663p();
                    Parcel parcelM3687l2 = c3990d2.m3687l();
                    parcelM3687l2.writeString(str);
                    parcelM3687l2.writeString(str2);
                    parcelM3687l2.writeLong(jIncrementAndGet);
                    AbstractC1542e0.m3809c(parcelM3687l2, apiMetadata2);
                    c3990d2.m3690y(parcelM3687l2, 9);
                    return;
                } catch (RemoteException e5) {
                    map.remove(Long.valueOf(jIncrementAndGet));
                    c4056d2.m8058a(e5);
                    return;
                }
        }
    }
}
