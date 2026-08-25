package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import p018b5.AbstractC1312l;
import p078h5.C2661a;
import p156o9.AbstractC3280d;

public final class zan extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zan> CREATOR = new C2661a(3);

    public final int f5160a;

    public final HashMap f5161b;

    public final String f5162c;

    public zan(int i6, String str, ArrayList arrayList) {
        this.f5160a = i6;
        HashMap map = new HashMap();
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            zal zalVar = (zal) arrayList.get(i10);
            String str2 = zalVar.f5155b;
            HashMap map2 = new HashMap();
            ArrayList arrayList2 = zalVar.f5156c;
            AbstractC1312l.m3198e(arrayList2);
            int size2 = arrayList2.size();
            for (int i11 = 0; i11 < size2; i11++) {
                zam zamVar = (zam) arrayList2.get(i11);
                map2.put(zamVar.f5158b, zamVar.f5159c);
            }
            map.put(str2, map2);
        }
        this.f5161b = map;
        AbstractC1312l.m3198e(str);
        this.f5162c = str;
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            Map map3 = (Map) map.get((String) it.next());
            Iterator it2 = map3.keySet().iterator();
            while (it2.hasNext()) {
                ((FastJsonResponse$Field) map3.get((String) it2.next())).f5145j = this;
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        HashMap map = this.f5161b;
        for (String str : map.keySet()) {
            sb.append(str);
            sb.append(":\n");
            Map map2 = (Map) map.get(str);
            for (String str2 : map2.keySet()) {
                sb.append("  ");
                sb.append(str2);
                sb.append(": ");
                sb.append(map2.get(str2));
            }
        }
        return sb.toString();
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6585X(parcel, 1, 4);
        parcel.writeInt(this.f5160a);
        ArrayList arrayList = new ArrayList();
        HashMap map = this.f5161b;
        for (String str : map.keySet()) {
            arrayList.add(new zal(str, (Map) map.get(str)));
        }
        AbstractC3280d.m6582U(parcel, 2, arrayList);
        AbstractC3280d.m6579R(parcel, 3, this.f5162c);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
