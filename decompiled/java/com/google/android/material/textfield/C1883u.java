package com.google.android.material.textfield;

import android.os.Parcel;
import android.os.Parcelable;

public final class C1883u implements Parcelable.ClassLoaderCreator {
    @Override
    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new TextInputLayout.SavedState(parcel, classLoader);
    }

    @Override
    public final Object[] newArray(int i6) {
        return new TextInputLayout.SavedState[i6];
    }

    @Override
    public final Object createFromParcel(Parcel parcel) {
        return new TextInputLayout.SavedState(parcel, null);
    }
}
