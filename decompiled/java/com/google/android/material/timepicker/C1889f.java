package com.google.android.material.timepicker;

import android.os.Parcel;
import android.os.Parcelable;

public final class C1889f implements Parcelable.Creator {
    @Override
    public final Object createFromParcel(Parcel parcel) {
        return new TimeModel(parcel);
    }

    @Override
    public final Object[] newArray(int i6) {
        return new TimeModel[i6];
    }
}
