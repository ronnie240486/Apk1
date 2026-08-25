package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Map;
import p078h5.C2661a;
import p156o9.AbstractC3280d;

public final class zal extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zal> CREATOR = new C2661a(4);

    public final int f5154a;

    public final String f5155b;

    public final ArrayList f5156c;

    public zal(int i6, String str, ArrayList arrayList) {
        this.f5154a = i6;
        this.f5155b = str;
        this.f5156c = arrayList;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6585X(parcel, 1, 4);
        parcel.writeInt(this.f5154a);
        AbstractC3280d.m6579R(parcel, 2, this.f5155b);
        AbstractC3280d.m6582U(parcel, 3, this.f5156c);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }

    public zal(String str, Map map) {
        ArrayList arrayList;
        this.f5154a = 1;
        this.f5155b = str;
        if (map == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (String str2 : map.keySet()) {
                arrayList.add(new zam(str2, (FastJsonResponse$Field) map.get(str2)));
            }
        }
        this.f5156c = arrayList;
    }
}
