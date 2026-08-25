package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import p156o9.AbstractC3280d;
import p261y4.C4266n;

public final class ComplianceOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ComplianceOptions> CREATOR = new C4266n(1);

    public final int f4983a;

    public final int f4984b;

    public final int f4985c;

    public final boolean f4986d;

    public ComplianceOptions(int i6, int i10, int i11, boolean z7) {
        this.f4983a = i6;
        this.f4984b = i10;
        this.f4985c = i11;
        this.f4986d = z7;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ComplianceOptions)) {
            return false;
        }
        ComplianceOptions complianceOptions = (ComplianceOptions) obj;
        return this.f4983a == complianceOptions.f4983a && this.f4984b == complianceOptions.f4984b && this.f4985c == complianceOptions.f4985c && this.f4986d == complianceOptions.f4986d;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f4983a), Integer.valueOf(this.f4984b), Integer.valueOf(this.f4985c), Boolean.valueOf(this.f4986d)});
    }

    public final String toString() {
        return "ComplianceOptions{callerProductId=" + this.f4983a + ", dataOwnerProductId=" + this.f4984b + ", processingReason=" + this.f4985c + ", isUserData=" + this.f4986d + "}";
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6585X(parcel, 1, 4);
        parcel.writeInt(this.f4983a);
        AbstractC3280d.m6585X(parcel, 2, 4);
        parcel.writeInt(this.f4984b);
        AbstractC3280d.m6585X(parcel, 3, 4);
        parcel.writeInt(this.f4985c);
        AbstractC3280d.m6585X(parcel, 4, 4);
        parcel.writeInt(this.f4986d ? 1 : 0);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
