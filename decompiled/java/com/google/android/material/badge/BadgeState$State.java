package com.google.android.material.badge;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Locale;
import p249x4.C4120m;

public final class BadgeState$State implements Parcelable {
    public static final Parcelable.Creator<BadgeState$State> CREATOR = new C4120m(2);

    public int f5882a;

    public Integer f5883b;

    public Integer f5884c;

    public Locale f5888g;

    public CharSequence f5889h;

    public int f5890i;

    public int f5891j;

    public Integer f5892k;

    public Integer f5894m;

    public Integer f5895n;

    public Integer f5896o;

    public Integer f5897p;

    public Integer f5898q;

    public Integer f5899r;

    public int f5885d = 255;

    public int f5886e = -2;

    public int f5887f = -2;

    public Boolean f5893l = Boolean.TRUE;

    @Override
    public final int describeContents() {
        return 0;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        parcel.writeInt(this.f5882a);
        parcel.writeSerializable(this.f5883b);
        parcel.writeSerializable(this.f5884c);
        parcel.writeInt(this.f5885d);
        parcel.writeInt(this.f5886e);
        parcel.writeInt(this.f5887f);
        CharSequence charSequence = this.f5889h;
        parcel.writeString(charSequence == null ? null : charSequence.toString());
        parcel.writeInt(this.f5890i);
        parcel.writeSerializable(this.f5892k);
        parcel.writeSerializable(this.f5894m);
        parcel.writeSerializable(this.f5895n);
        parcel.writeSerializable(this.f5896o);
        parcel.writeSerializable(this.f5897p);
        parcel.writeSerializable(this.f5898q);
        parcel.writeSerializable(this.f5899r);
        parcel.writeSerializable(this.f5893l);
        parcel.writeSerializable(this.f5888g);
    }
}
