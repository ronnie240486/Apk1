package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import p078h5.C2661a;
import p156o9.AbstractC3280d;
import p230v4.AbstractC3987a;

public class ApplicationMetadata extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ApplicationMetadata> CREATOR = new C2661a(28);

    public final String f4590a;

    public final String f4591b;

    public final ArrayList f4592c;

    public final String f4593d;

    public final Uri f4594e;

    public final String f4595f;

    public final String f4596g;

    public final Boolean f4597h;

    public final Boolean f4598i;

    public final int f4599j;

    public ApplicationMetadata(String str, String str2, ArrayList arrayList, String str3, Uri uri, String str4, String str5, Boolean bool, Boolean bool2, int i6) {
        this.f4590a = str;
        this.f4591b = str2;
        this.f4592c = arrayList;
        this.f4593d = str3;
        this.f4594e = uri;
        this.f4595f = str4;
        this.f4596g = str5;
        this.f4597h = bool;
        this.f4598i = bool2;
        this.f4599j = i6;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ApplicationMetadata)) {
            return false;
        }
        ApplicationMetadata applicationMetadata = (ApplicationMetadata) obj;
        return AbstractC3987a.m7972e(this.f4590a, applicationMetadata.f4590a) && AbstractC3987a.m7972e(this.f4591b, applicationMetadata.f4591b) && AbstractC3987a.m7972e(this.f4592c, applicationMetadata.f4592c) && AbstractC3987a.m7972e(this.f4593d, applicationMetadata.f4593d) && AbstractC3987a.m7972e(this.f4594e, applicationMetadata.f4594e) && AbstractC3987a.m7972e(this.f4595f, applicationMetadata.f4595f) && AbstractC3987a.m7972e(this.f4596g, applicationMetadata.f4596g) && this.f4599j == applicationMetadata.f4599j;
    }

    public final int hashCode() {
        Integer numValueOf = Integer.valueOf(this.f4599j);
        return Arrays.hashCode(new Object[]{this.f4590a, this.f4591b, this.f4592c, this.f4593d, this.f4594e, this.f4595f, numValueOf});
    }

    public final String toString() {
        ArrayList arrayList = this.f4592c;
        return "applicationId: " + this.f4590a + ", name: " + this.f4591b + ", namespaces.count: " + (arrayList == null ? 0 : arrayList.size()) + ", senderAppIdentifier: " + this.f4593d + ", senderAppLaunchUrl: " + String.valueOf(this.f4594e) + ", iconUrl: " + this.f4595f + ", type: " + this.f4596g;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6579R(parcel, 2, this.f4590a);
        AbstractC3280d.m6579R(parcel, 3, this.f4591b);
        AbstractC3280d.m6580S(parcel, 5, Collections.unmodifiableList(this.f4592c));
        AbstractC3280d.m6579R(parcel, 6, this.f4593d);
        AbstractC3280d.m6578Q(parcel, 7, this.f4594e, i6);
        AbstractC3280d.m6579R(parcel, 8, this.f4595f);
        AbstractC3280d.m6579R(parcel, 9, this.f4596g);
        AbstractC3280d.m6573L(parcel, 10, this.f4597h);
        AbstractC3280d.m6573L(parcel, 11, this.f4598i);
        AbstractC3280d.m6585X(parcel, 12, 4);
        parcel.writeInt(this.f4599j);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
