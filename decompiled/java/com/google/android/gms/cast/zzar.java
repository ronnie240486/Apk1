package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import p078h5.C2661a;
import p156o9.AbstractC3280d;

public final class zzar extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzar> CREATOR = new C2661a(12);

    public final float f4963a;

    public final float f4964b;

    public final float f4965c;

    public zzar(float f, float f3, float f4) {
        this.f4963a = f;
        this.f4964b = f3;
        this.f4965c = f4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzar)) {
            return false;
        }
        zzar zzarVar = (zzar) obj;
        return this.f4963a == zzarVar.f4963a && this.f4964b == zzarVar.f4964b && this.f4965c == zzarVar.f4965c;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f4963a), Float.valueOf(this.f4964b), Float.valueOf(this.f4965c)});
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6585X(parcel, 2, 4);
        parcel.writeFloat(this.f4963a);
        AbstractC3280d.m6585X(parcel, 3, 4);
        parcel.writeFloat(this.f4964b);
        AbstractC3280d.m6585X(parcel, 4, 4);
        parcel.writeFloat(this.f4965c);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
