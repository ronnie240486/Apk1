package com.google.android.gms.cast.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.zzat;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import java.util.Locale;
import p156o9.AbstractC3280d;
import p165p4.C3371p;
import p230v4.AbstractC3987a;

public final class zzac extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzac> CREATOR = new C3371p(12);

    public double f4956a;

    public boolean f4957b;

    public int f4958c;

    public ApplicationMetadata f4959d;

    public int f4960e;

    public zzat f4961f;

    public double f4962g;

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzac)) {
            return false;
        }
        zzac zzacVar = (zzac) obj;
        if (this.f4956a == zzacVar.f4956a && this.f4957b == zzacVar.f4957b && this.f4958c == zzacVar.f4958c && AbstractC3987a.m7972e(this.f4959d, zzacVar.f4959d) && this.f4960e == zzacVar.f4960e) {
            zzat zzatVar = this.f4961f;
            if (AbstractC3987a.m7972e(zzatVar, zzatVar) && this.f4962g == zzacVar.f4962g) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Double.valueOf(this.f4956a), Boolean.valueOf(this.f4957b), Integer.valueOf(this.f4958c), this.f4959d, Integer.valueOf(this.f4960e), this.f4961f, Double.valueOf(this.f4962g)});
    }

    public final String toString() {
        return String.format(Locale.ROOT, "volume=%f", Double.valueOf(this.f4956a));
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6585X(parcel, 2, 8);
        parcel.writeDouble(this.f4956a);
        AbstractC3280d.m6585X(parcel, 3, 4);
        parcel.writeInt(this.f4957b ? 1 : 0);
        AbstractC3280d.m6585X(parcel, 4, 4);
        parcel.writeInt(this.f4958c);
        AbstractC3280d.m6578Q(parcel, 5, this.f4959d, i6);
        AbstractC3280d.m6585X(parcel, 6, 4);
        parcel.writeInt(this.f4960e);
        AbstractC3280d.m6578Q(parcel, 7, this.f4961f, i6);
        AbstractC3280d.m6585X(parcel, 8, 8);
        parcel.writeDouble(this.f4962g);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
