package com.google.android.material.slider;

import android.os.Parcel;
import android.os.Parcelable;

public final class C1862h implements Parcelable.Creator {
    @Override
    public final Object createFromParcel(Parcel parcel) {
        return new RangeSlider.RangeSliderState(parcel);
    }

    @Override
    public final Object[] newArray(int i6) {
        return new RangeSlider.RangeSliderState[i6];
    }
}
