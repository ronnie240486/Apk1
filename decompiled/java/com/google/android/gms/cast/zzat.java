package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import p078h5.C2661a;
import p156o9.AbstractC3280d;
import p230v4.AbstractC3987a;

public final class zzat extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzat> CREATOR = new C2661a(13);

    public final zzar f4966a;

    public final zzar f4967b;

    public zzat(zzar zzarVar, zzar zzarVar2) {
        this.f4966a = zzarVar;
        this.f4967b = zzarVar2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzat)) {
            return false;
        }
        zzat zzatVar = (zzat) obj;
        return AbstractC3987a.m7972e(this.f4966a, zzatVar.f4966a) && AbstractC3987a.m7972e(this.f4967b, zzatVar.f4967b);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f4966a, this.f4967b});
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6578Q(parcel, 2, this.f4966a, i6);
        AbstractC3280d.m6578Q(parcel, 3, this.f4967b, i6);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
