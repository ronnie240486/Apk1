package com.google.android.material.button;

import android.os.Parcel;
import android.os.Parcelable;

public final class C1770b implements Parcelable.ClassLoaderCreator {
    @Override
    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new MaterialButton.SavedState(parcel, classLoader);
    }

    @Override
    public final Object[] newArray(int i6) {
        return new MaterialButton.SavedState[i6];
    }

    @Override
    public final Object createFromParcel(Parcel parcel) {
        return new MaterialButton.SavedState(parcel, null);
    }
}
