package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p018b5.AbstractC1312l;
import p156o9.AbstractC3280d;
import p261y4.C4266n;

public final class Scope extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new C4266n(2);

    public final int f4989a;

    public final String f4990b;

    public Scope(int i6, String str) {
        AbstractC1312l.m3197d(str, "scopeUri must not be null or empty");
        this.f4989a = i6;
        this.f4990b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        return this.f4990b.equals(((Scope) obj).f4990b);
    }

    public final int hashCode() {
        return this.f4990b.hashCode();
    }

    public final String toString() {
        return this.f4990b;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6585X(parcel, 1, 4);
        parcel.writeInt(this.f4989a);
        AbstractC3280d.m6579R(parcel, 2, this.f4990b);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
