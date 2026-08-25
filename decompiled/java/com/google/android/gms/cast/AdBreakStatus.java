package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import p078h5.C2661a;
import p156o9.AbstractC3280d;
import p230v4.AbstractC3987a;
import p230v4.C3988b;

public class AdBreakStatus extends AbstractSafeParcelable {

    public final long f4585a;

    public final long f4586b;

    public final String f4587c;

    public final String f4588d;

    public final long f4589e;

    public static final C3988b f4584f = new C3988b("AdBreakStatus", null);
    public static final Parcelable.Creator<AdBreakStatus> CREATOR = new C2661a(20);

    public AdBreakStatus(long j10, long j11, String str, String str2, long j12) {
        this.f4585a = j10;
        this.f4586b = j11;
        this.f4587c = str;
        this.f4588d = str2;
        this.f4589e = j12;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdBreakStatus)) {
            return false;
        }
        AdBreakStatus adBreakStatus = (AdBreakStatus) obj;
        return this.f4585a == adBreakStatus.f4585a && this.f4586b == adBreakStatus.f4586b && AbstractC3987a.m7972e(this.f4587c, adBreakStatus.f4587c) && AbstractC3987a.m7972e(this.f4588d, adBreakStatus.f4588d) && this.f4589e == adBreakStatus.f4589e;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f4585a), Long.valueOf(this.f4586b), this.f4587c, this.f4588d, Long.valueOf(this.f4589e)});
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6585X(parcel, 2, 8);
        parcel.writeLong(this.f4585a);
        AbstractC3280d.m6585X(parcel, 3, 8);
        parcel.writeLong(this.f4586b);
        AbstractC3280d.m6579R(parcel, 4, this.f4587c);
        AbstractC3280d.m6579R(parcel, 5, this.f4588d);
        AbstractC3280d.m6585X(parcel, 6, 8);
        parcel.writeLong(this.f4589e);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
