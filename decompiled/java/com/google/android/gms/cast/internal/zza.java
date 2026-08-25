package com.google.android.gms.cast.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import p156o9.AbstractC3280d;
import p165p4.C3371p;
import p230v4.AbstractC3987a;

public final class zza extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zza> CREATOR = new C3371p(13);

    public final String f4946a;

    public zza(String str) {
        this.f4946a = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zza) {
            return AbstractC3987a.m7972e(this.f4946a, ((zza) obj).f4946a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f4946a});
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6579R(parcel, 2, this.f4946a);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
