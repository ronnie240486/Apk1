package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;

public final class C1812b implements Parcelable.ClassLoaderCreator {
    @Override
    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new CheckableImageButton.SavedState(parcel, classLoader);
    }

    @Override
    public final Object[] newArray(int i6) {
        return new CheckableImageButton.SavedState[i6];
    }

    @Override
    public final Object createFromParcel(Parcel parcel) {
        return new CheckableImageButton.SavedState(parcel, null);
    }
}
