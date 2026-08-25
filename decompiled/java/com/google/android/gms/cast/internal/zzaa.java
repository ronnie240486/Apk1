package com.google.android.gms.cast.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import p156o9.AbstractC3280d;
import p165p4.C3371p;

public final class zzaa extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaa> CREATOR = new C3371p(11);

    public final int f4947a;

    public final boolean f4948b;

    public final boolean f4949c;

    public final String f4950d;

    public final String f4951e;

    public final String f4952f;

    public final String f4953g;

    public final String f4954h;

    public final boolean f4955i;

    public zzaa(int i6, boolean z7, boolean z10, String str, String str2, String str3, String str4, String str5, boolean z11) {
        this.f4947a = i6;
        this.f4948b = z7;
        this.f4949c = z10;
        this.f4950d = str;
        this.f4951e = str2;
        this.f4952f = str3;
        this.f4953g = str4;
        this.f4954h = str5;
        this.f4955i = z11;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzaa)) {
            return false;
        }
        zzaa zzaaVar = (zzaa) obj;
        return this.f4947a == zzaaVar.f4947a && this.f4948b == zzaaVar.f4948b && this.f4949c == zzaaVar.f4949c && TextUtils.equals(this.f4950d, zzaaVar.f4950d) && TextUtils.equals(this.f4951e, zzaaVar.f4951e) && TextUtils.equals(this.f4952f, zzaaVar.f4952f) && TextUtils.equals(this.f4953g, zzaaVar.f4953g) && TextUtils.equals(this.f4954h, zzaaVar.f4954h) && this.f4955i == zzaaVar.f4955i;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f4947a), Boolean.valueOf(this.f4948b), Boolean.valueOf(this.f4949c), this.f4950d, this.f4951e, this.f4952f, this.f4953g, this.f4954h, Boolean.valueOf(this.f4955i)});
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6585X(parcel, 2, 4);
        parcel.writeInt(this.f4947a);
        AbstractC3280d.m6585X(parcel, 3, 4);
        parcel.writeInt(this.f4948b ? 1 : 0);
        AbstractC3280d.m6585X(parcel, 4, 4);
        parcel.writeInt(this.f4949c ? 1 : 0);
        AbstractC3280d.m6579R(parcel, 5, this.f4950d);
        AbstractC3280d.m6579R(parcel, 6, this.f4951e);
        AbstractC3280d.m6579R(parcel, 7, this.f4952f);
        AbstractC3280d.m6579R(parcel, 8, this.f4953g);
        AbstractC3280d.m6579R(parcel, 9, this.f4954h);
        AbstractC3280d.m6585X(parcel, 10, 4);
        parcel.writeInt(this.f4955i ? 1 : 0);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
