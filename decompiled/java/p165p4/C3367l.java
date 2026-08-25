package p165p4;

import android.content.Context;
import android.os.Parcel;
import androidx.media3.common.PlaybackException;
import com.google.android.gms.common.api.ApiMetadata;
import com.google.android.gms.common.api.ComplianceOptions;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.cast.AbstractC1542e0;
import p018b5.AbstractC1312l;
import p187r4.C3616f;
import p230v4.C3988b;
import p230v4.C3990d;
import p230v4.C4009w;
import p242w5.C4056d;
import p261y4.C4257e;
import p271z4.InterfaceC4340k;

public final class C3367l implements InterfaceC4340k {

    public final int f11365a = 1;

    public final C3370o f11366b;

    public final String f11367c;

    public C3367l(C3370o c3370o, String str) {
        this.f11366b = c3370o;
        this.f11367c = str;
    }

    @Override
    public final void mo99p(Object obj, Object obj2) {
        switch (this.f11365a) {
            case 0:
                C4009w c4009w = (C4009w) obj;
                C4056d c4056d = (C4056d) obj2;
                AbstractC1312l.m3200g("Not active connection", this.f11366b.f11378E != 1);
                Context context = c4009w.f5071c;
                ApiMetadata apiMetadata = new ApiMetadata(new ComplianceOptions(-1, -1, 0, true));
                C3990d c3990d = (C3990d) c4009w.m3663p();
                String str = this.f11367c;
                Parcel parcelM3687l = c3990d.m3687l();
                parcelM3687l.writeString(str);
                AbstractC1542e0.m3809c(parcelM3687l, apiMetadata);
                c3990d.m3690y(parcelM3687l, 12);
                C3990d c3990d2 = (C3990d) c4009w.m3663p();
                Parcel parcelM3687l2 = c3990d2.m3687l();
                parcelM3687l2.writeString(str);
                AbstractC1542e0.m3809c(parcelM3687l2, apiMetadata);
                c3990d2.m3690y(parcelM3687l2, 11);
                c4056d.m8059b(null);
                return;
            default:
                C3370o c3370o = this.f11366b;
                String str2 = this.f11367c;
                C4009w c4009w2 = (C4009w) obj;
                C4056d c4056d2 = (C4056d) obj2;
                C3988b c3988b = C3370o.f11372F;
                AbstractC1312l.m3200g("Not connected to device", c3370o.m6865j());
                Context context2 = c4009w2.f5071c;
                ComplianceOptions complianceOptions = new ComplianceOptions(-1, -1, 0, true);
                C3990d c3990d3 = (C3990d) c4009w2.m3663p();
                ApiMetadata apiMetadata2 = new ApiMetadata(complianceOptions);
                Parcel parcelM3687l3 = c3990d3.m3687l();
                parcelM3687l3.writeString(str2);
                AbstractC1542e0.m3809c(parcelM3687l3, apiMetadata2);
                c3990d3.m3690y(parcelM3687l3, 5);
                synchronized (c3370o.f11387r) {
                    try {
                        if (c3370o.f11384o != null) {
                            c4056d2.m8058a(new C4257e(new Status(PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_FAILED, null, null, null)));
                            return;
                        } else {
                            c3370o.f11384o = c4056d2;
                            return;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
        }
    }

    public C3367l(C3370o c3370o, String str, C3616f c3616f) {
        this.f11366b = c3370o;
        this.f11367c = str;
    }
}
