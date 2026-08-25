package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import p099j5.C2778b;
import p156o9.AbstractC3280d;

@Deprecated
public final class WakeLockEvent extends StatsEvent {
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new C2778b();

    public final int f5163a;

    public final long f5164b;

    public final int f5165c;

    public final String f5166d;

    public final String f5167e;

    public final String f5168f;

    public final int f5169g;

    public final ArrayList f5170h;

    public final String f5171i;

    public final long f5172j;

    public final int f5173k;

    public final String f5174l;

    public final float f5175m;

    public final long f5176n;

    public final boolean f5177o;

    public WakeLockEvent(int i6, long j10, int i10, String str, int i11, ArrayList arrayList, String str2, long j11, int i12, String str3, String str4, float f, long j12, String str5, boolean z7) {
        this.f5163a = i6;
        this.f5164b = j10;
        this.f5165c = i10;
        this.f5166d = str;
        this.f5167e = str3;
        this.f5168f = str5;
        this.f5169g = i11;
        this.f5170h = arrayList;
        this.f5171i = str2;
        this.f5172j = j11;
        this.f5173k = i12;
        this.f5174l = str4;
        this.f5175m = f;
        this.f5176n = j12;
        this.f5177o = z7;
    }

    @Override
    public final int mo3683j() {
        return this.f5165c;
    }

    @Override
    public final long mo3684l() {
        return this.f5164b;
    }

    @Override
    public final String mo3685m() {
        ArrayList arrayList = this.f5170h;
        String strJoin = arrayList == null ? "" : TextUtils.join(",", arrayList);
        StringBuilder sb = new StringBuilder("\t");
        sb.append(this.f5166d);
        sb.append("\t");
        sb.append(this.f5169g);
        sb.append("\t");
        sb.append(strJoin);
        sb.append("\t");
        sb.append(this.f5173k);
        sb.append("\t");
        String str = this.f5167e;
        if (str == null) {
            str = "";
        }
        sb.append(str);
        sb.append("\t");
        String str2 = this.f5174l;
        if (str2 == null) {
            str2 = "";
        }
        sb.append(str2);
        sb.append("\t");
        sb.append(this.f5175m);
        sb.append("\t");
        String str3 = this.f5168f;
        sb.append(str3 != null ? str3 : "");
        sb.append("\t");
        sb.append(this.f5177o);
        return sb.toString();
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6585X(parcel, 1, 4);
        parcel.writeInt(this.f5163a);
        AbstractC3280d.m6585X(parcel, 2, 8);
        parcel.writeLong(this.f5164b);
        AbstractC3280d.m6579R(parcel, 4, this.f5166d);
        AbstractC3280d.m6585X(parcel, 5, 4);
        parcel.writeInt(this.f5169g);
        AbstractC3280d.m6580S(parcel, 6, this.f5170h);
        AbstractC3280d.m6585X(parcel, 8, 8);
        parcel.writeLong(this.f5172j);
        AbstractC3280d.m6579R(parcel, 10, this.f5167e);
        AbstractC3280d.m6585X(parcel, 11, 4);
        parcel.writeInt(this.f5165c);
        AbstractC3280d.m6579R(parcel, 12, this.f5171i);
        AbstractC3280d.m6579R(parcel, 13, this.f5174l);
        AbstractC3280d.m6585X(parcel, 14, 4);
        parcel.writeInt(this.f5173k);
        AbstractC3280d.m6585X(parcel, 15, 4);
        parcel.writeFloat(this.f5175m);
        AbstractC3280d.m6585X(parcel, 16, 8);
        parcel.writeLong(this.f5176n);
        AbstractC3280d.m6579R(parcel, 17, this.f5168f);
        AbstractC3280d.m6585X(parcel, 18, 4);
        parcel.writeInt(this.f5177o ? 1 : 0);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}
