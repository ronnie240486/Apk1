package com.google.android.material.bottomsheet;

import android.os.Parcel;
import android.os.Parcelable;

public final class C1768a implements Parcelable.ClassLoaderCreator {
    @Override
    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new BottomSheetBehavior.SavedState(parcel, classLoader);
    }

    @Override
    public final Object[] newArray(int i6) {
        return new BottomSheetBehavior.SavedState[i6];
    }

    @Override
    public final Object createFromParcel(Parcel parcel) {
        return new BottomSheetBehavior.SavedState(parcel, (ClassLoader) null);
    }
}
