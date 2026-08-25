package com.google.android.gms.internal.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import p018b5.AbstractC1312l;
import p156o9.AbstractC3280d;

public final class zzew extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzew> CREATOR;

    public final ArrayList f5753a;

    public final boolean f5754b;

    public final boolean f5755c;

    static {
        new zzew(null, false, false);
        CREATOR = new C1740z0(1);
    }

    public zzew(ArrayList arrayList, boolean z7, boolean z10) {
        this.f5753a = arrayList == null ? new ArrayList(0) : new ArrayList(arrayList);
        this.f5754b = z7;
        this.f5755c = z10;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzew)) {
            return false;
        }
        zzew zzewVar = (zzew) obj;
        return AbstractC1312l.m3201h(this.f5753a, zzewVar.f5753a) && AbstractC1312l.m3201h(Boolean.valueOf(this.f5754b), Boolean.valueOf(zzewVar.f5754b));
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f5753a, Boolean.valueOf(this.f5754b)});
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6582U(parcel, 1, new ArrayList(this.f5753a));
        AbstractC3280d.m6585X(parcel, 2, 4);
        parcel.writeInt(this.f5754b ? 1 : 0);
        AbstractC3280d.m6585X(parcel, 3, 4);
        parcel.writeInt(this.f5755c ? 1 : 0);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
