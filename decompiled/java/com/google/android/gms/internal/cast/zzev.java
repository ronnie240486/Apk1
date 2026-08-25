package com.google.android.gms.internal.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import p018b5.AbstractC1312l;
import p156o9.AbstractC3280d;

public final class zzev extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzev> CREATOR = new C1740z0(0);

    public final String f5750a;

    public final byte[] f5751b;

    public final ArrayList f5752c;

    public zzev(String str, byte[] bArr, ArrayList arrayList) {
        this.f5750a = str;
        this.f5751b = bArr;
        this.f5752c = arrayList == null ? new ArrayList(0) : new ArrayList(arrayList);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzev)) {
            return false;
        }
        zzev zzevVar = (zzev) obj;
        return AbstractC1312l.m3201h(this.f5750a, zzevVar.f5750a) && AbstractC1312l.m3201h(this.f5751b, zzevVar.f5751b) && AbstractC1312l.m3201h(this.f5752c, zzevVar.f5752c);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f5750a, this.f5751b, this.f5752c});
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6579R(parcel, 1, this.f5750a);
        byte[] bArr = this.f5751b;
        if (bArr != null) {
            int iM6583V2 = AbstractC3280d.m6583V(parcel, 2);
            parcel.writeByteArray(bArr);
            AbstractC3280d.m6584W(parcel, iM6583V2);
        }
        ArrayList arrayList = new ArrayList(this.f5752c);
        int iM6583V3 = AbstractC3280d.m6583V(parcel, 3);
        int size = arrayList.size();
        parcel.writeInt(size);
        for (int i10 = 0; i10 < size; i10++) {
            parcel.writeInt(((Integer) arrayList.get(i10)).intValue());
        }
        AbstractC3280d.m6584W(parcel, iM6583V3);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
