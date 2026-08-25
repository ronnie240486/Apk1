package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import p000a.AbstractC0004e;
import p078h5.C2661a;
import p156o9.AbstractC3280d;

public final class zzbs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbs> CREATOR = new C2661a(15);

    public final int f4968a;

    public zzbs(int i6) {
        this.f4968a = i6;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof zzbs) && this.f4968a == ((zzbs) obj).f4968a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f4968a)});
    }

    public final String toString() {
        String str;
        int i6 = this.f4968a;
        if (i6 != 0) {
            str = i6 != 2 ? "UNKNOWN" : "INVISIBLE";
        } else {
            str = "STRONG";
        }
        return AbstractC0004e.m24r("joinOptions(connectionType=", str, ")");
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6585X(parcel, 2, 4);
        parcel.writeInt(this.f4968a);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
