package com.google.android.gms.common.moduleinstall.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import p018b5.AbstractC1312l;
import p156o9.AbstractC3280d;
import p237w0.C4043d;

public class ApiFeatureRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ApiFeatureRequest> CREATOR = new C4043d(27);

    public final ArrayList f5121a;

    public final boolean f5122b;

    public final String f5123c;

    public final String f5124d;

    public ApiFeatureRequest(ArrayList arrayList, boolean z7, String str, String str2) {
        AbstractC1312l.m3198e(arrayList);
        this.f5121a = arrayList;
        this.f5122b = z7;
        this.f5123c = str;
        this.f5124d = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ApiFeatureRequest)) {
            return false;
        }
        ApiFeatureRequest apiFeatureRequest = (ApiFeatureRequest) obj;
        return this.f5122b == apiFeatureRequest.f5122b && AbstractC1312l.m3201h(this.f5121a, apiFeatureRequest.f5121a) && AbstractC1312l.m3201h(this.f5123c, apiFeatureRequest.f5123c) && AbstractC1312l.m3201h(this.f5124d, apiFeatureRequest.f5124d);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.f5122b), this.f5121a, this.f5123c, this.f5124d});
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6582U(parcel, 1, this.f5121a);
        AbstractC3280d.m6585X(parcel, 2, 4);
        parcel.writeInt(this.f5122b ? 1 : 0);
        AbstractC3280d.m6579R(parcel, 3, this.f5123c);
        AbstractC3280d.m6579R(parcel, 4, this.f5124d);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
