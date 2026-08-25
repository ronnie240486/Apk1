package com.google.android.material.timepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

class TimeModel implements Parcelable {
    public static final Parcelable.Creator<TimeModel> CREATOR = new C1889f();

    public final int f6937a;

    public final int f6938b;

    public final int f6939c;

    public final int f6940d;

    public TimeModel(Parcel parcel) {
        int i6 = parcel.readInt();
        int i10 = parcel.readInt();
        int i11 = parcel.readInt();
        int i12 = parcel.readInt();
        this.f6938b = i6;
        this.f6939c = i10;
        this.f6940d = i11;
        this.f6937a = i12;
    }

    @Override
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimeModel)) {
            return false;
        }
        TimeModel timeModel = (TimeModel) obj;
        return this.f6938b == timeModel.f6938b && this.f6939c == timeModel.f6939c && this.f6937a == timeModel.f6937a && this.f6940d == timeModel.f6940d;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f6937a), Integer.valueOf(this.f6938b), Integer.valueOf(this.f6939c), Integer.valueOf(this.f6940d)});
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        parcel.writeInt(this.f6938b);
        parcel.writeInt(this.f6939c);
        parcel.writeInt(this.f6940d);
        parcel.writeInt(this.f6937a);
    }
}
