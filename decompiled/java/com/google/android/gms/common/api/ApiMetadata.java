package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Objects;
import p000a.AbstractC0004e;
import p156o9.AbstractC3280d;
import p261y4.C4266n;

public final class ApiMetadata extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ApiMetadata> CREATOR = C4266n.f14467b;

    public static final ApiMetadata f4981b = new ApiMetadata(null);

    public final ComplianceOptions f4982a;

    public ApiMetadata(ComplianceOptions complianceOptions) {
        this.f4982a = complianceOptions;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ApiMetadata) {
            return Objects.equals(this.f4982a, ((ApiMetadata) obj).f4982a);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.f4982a);
    }

    public final String toString() {
        return AbstractC0004e.m24r("ApiMetadata(complianceOptions=", String.valueOf(this.f4982a), ")");
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        parcel.writeInt(-204102970);
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6578Q(parcel, 1, this.f4982a, i6);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
