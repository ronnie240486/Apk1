package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.HashMap;
import p078h5.C2661a;
import p156o9.AbstractC3280d;

public final class StringToIntConverter extends AbstractSafeParcelable {
    public static final Parcelable.Creator<StringToIntConverter> CREATOR = new C2661a(0);

    public final int f5128a;

    public final HashMap f5129b = new HashMap();

    public final SparseArray f5130c = new SparseArray();

    public StringToIntConverter(int i6, ArrayList arrayList) {
        this.f5128a = i6;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            zac zacVar = (zac) arrayList.get(i10);
            String str = zacVar.f5134b;
            int i11 = zacVar.f5135c;
            this.f5129b.put(str, Integer.valueOf(i11));
            this.f5130c.put(i11, str);
        }
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6585X(parcel, 1, 4);
        parcel.writeInt(this.f5128a);
        ArrayList arrayList = new ArrayList();
        HashMap map = this.f5129b;
        for (String str : map.keySet()) {
            arrayList.add(new zac(str, ((Integer) map.get(str)).intValue()));
        }
        AbstractC3280d.m6582U(parcel, 2, arrayList);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
