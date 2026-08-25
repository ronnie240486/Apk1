package com.google.android.gms.internal.cast;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import p242w5.C4056d;
import p261y4.C4257e;
import p261y4.C4263k;

public final class BinderC1513b1 extends AbstractBinderC1694u implements InterfaceC1563g1 {

    public final C4056d f5217d;

    public BinderC1513b1(C4056d c4056d) {
        super("com.google.android.gms.usagereporting.internal.IUsageReportingCallbacks", 0);
        this.f5217d = c4056d;
    }

    @Override
    public final void mo3730h(Status status, zzfk zzfkVar) {
        C1583i1 c1583i1 = new C1583i1(zzfkVar);
        C1533d1 c1533d1 = new C1533d1();
        c1533d1.f5243a = c1583i1;
        C4056d c4056d = this.f5217d;
        if (status.f4994a <= 0) {
            c4056d.m8059b(c1533d1);
        } else {
            c4056d.m8058a(status.f4996c != null ? new C4263k(status) : new C4257e(status));
        }
    }

    @Override
    public void mo3731j(Status status) {
        throw new IllegalStateException("Not implemented.");
    }

    @Override
    public final boolean mo3202w(int i6, Parcel parcel, Parcel parcel2) {
        switch (i6) {
            case 2:
                Status status = (Status) AbstractC1542e0.m3807a(parcel, Status.CREATOR);
                zzfk zzfkVar = (zzfk) AbstractC1542e0.m3807a(parcel, zzfk.CREATOR);
                AbstractC1542e0.m3808b(parcel);
                mo3730h(status, zzfkVar);
                return true;
            case 3:
                AbstractC1542e0.m3808b(parcel);
                throw new IllegalStateException("Not implemented.");
            case 4:
                AbstractC1542e0.m3808b(parcel);
                throw new IllegalStateException("Not implemented.");
            case 5:
                Status status2 = (Status) AbstractC1542e0.m3807a(parcel, Status.CREATOR);
                AbstractC1542e0.m3808b(parcel);
                mo3731j(status2);
                return true;
            case 6:
                parcel.createStringArrayList();
                AbstractC1542e0.m3808b(parcel);
                throw new IllegalStateException("Not implemented.");
            case 7:
                AbstractC1542e0.m3808b(parcel);
                throw new IllegalStateException("Not implemented.");
            case 8:
                parcel.readInt();
                AbstractC1542e0.m3808b(parcel);
                throw new IllegalStateException("Not implemented.");
            case 9:
                AbstractC1542e0.m3808b(parcel);
                throw new IllegalStateException("Not implemented");
            case 10:
                AbstractC1542e0.m3808b(parcel);
                throw new IllegalStateException("Not implemented");
            case 11:
                AbstractC1542e0.m3808b(parcel);
                throw new IllegalStateException("Not implemented.");
            case 12:
                AbstractC1542e0.m3808b(parcel);
                throw new IllegalStateException("Not implemented.");
            case 13:
                AbstractC1542e0.m3808b(parcel);
                throw new IllegalStateException("Not implemented.");
            case 14:
                AbstractC1542e0.m3808b(parcel);
                throw new IllegalStateException("Not implemented.");
            case 15:
                AbstractC1542e0.m3808b(parcel);
                throw new IllegalStateException("Not implemented.");
            default:
                return false;
        }
    }
}
