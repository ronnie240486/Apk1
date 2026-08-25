package com.google.android.material.slider;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

public final class C1860f implements Parcelable.Creator {
    @Override
    public final Object createFromParcel(Parcel parcel) {
        BaseSlider.SliderState sliderState = new BaseSlider.SliderState(parcel);
        sliderState.f6658a = parcel.readFloat();
        sliderState.f6659b = parcel.readFloat();
        ArrayList arrayList = new ArrayList();
        sliderState.f6660c = arrayList;
        parcel.readList(arrayList, Float.class.getClassLoader());
        sliderState.f6661d = parcel.readFloat();
        sliderState.f6662e = parcel.createBooleanArray()[0];
        return sliderState;
    }

    @Override
    public final Object[] newArray(int i6) {
        return new BaseSlider.SliderState[i6];
    }
}
