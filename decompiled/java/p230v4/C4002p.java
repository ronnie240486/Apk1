package p230v4;

import android.content.Context;
import android.os.Parcel;
import com.google.android.gms.common.api.ApiMetadata;
import com.google.android.gms.common.api.ComplianceOptions;
import com.google.android.gms.internal.cast.AbstractC1542e0;
import p242w5.C4056d;
import p271z4.InterfaceC4340k;

public final class C4002p implements InterfaceC4340k {

    public final int f13561a;

    public final String[] f13562b;

    public C4002p(C4004r c4004r, String[] strArr, int i6) {
        this.f13561a = i6;
        this.f13562b = strArr;
    }

    @Override
    public final void mo99p(Object obj, Object obj2) {
        C4005s c4005s = (C4005s) obj;
        C4056d c4056d = (C4056d) obj2;
        switch (this.f13561a) {
            case 0:
                BinderC4003q binderC4003q = new BinderC4003q(1, c4056d);
                Context context = c4005s.f5071c;
                ComplianceOptions complianceOptions = new ComplianceOptions(-1, -1, 0, true);
                C3993g c3993g = (C3993g) c4005s.m3663p();
                ApiMetadata apiMetadata = new ApiMetadata(complianceOptions);
                Parcel parcelM3687l = c3993g.m3687l();
                AbstractC1542e0.m3810d(parcelM3687l, binderC4003q);
                parcelM3687l.writeStringArray(this.f13562b);
                AbstractC1542e0.m3809c(parcelM3687l, apiMetadata);
                c3993g.m3690y(parcelM3687l, 6);
                break;
            case 1:
                BinderC4003q binderC4003q2 = new BinderC4003q(0, c4056d);
                Context context2 = c4005s.f5071c;
                ComplianceOptions complianceOptions2 = new ComplianceOptions(-1, -1, 0, true);
                C3993g c3993g2 = (C3993g) c4005s.m3663p();
                ApiMetadata apiMetadata2 = new ApiMetadata(complianceOptions2);
                Parcel parcelM3687l2 = c3993g2.m3687l();
                AbstractC1542e0.m3810d(parcelM3687l2, binderC4003q2);
                parcelM3687l2.writeStringArray(this.f13562b);
                AbstractC1542e0.m3809c(parcelM3687l2, apiMetadata2);
                c3993g2.m3690y(parcelM3687l2, 5);
                break;
            default:
                BinderC4003q binderC4003q3 = new BinderC4003q(2, c4056d);
                Context context3 = c4005s.f5071c;
                ComplianceOptions complianceOptions3 = new ComplianceOptions(-1, -1, 0, true);
                C3993g c3993g3 = (C3993g) c4005s.m3663p();
                ApiMetadata apiMetadata3 = new ApiMetadata(complianceOptions3);
                Parcel parcelM3687l3 = c3993g3.m3687l();
                AbstractC1542e0.m3810d(parcelM3687l3, binderC4003q3);
                parcelM3687l3.writeStringArray(this.f13562b);
                AbstractC1542e0.m3809c(parcelM3687l3, apiMetadata3);
                c3993g3.m3690y(parcelM3687l3, 7);
                break;
        }
    }
}
