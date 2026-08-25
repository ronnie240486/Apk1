package com.google.android.material.navigation;

import android.os.Parcel;
import android.os.Parcelable;

public final class C1851k implements Parcelable.ClassLoaderCreator {
    @Override
    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new NavigationBarView$SavedState(parcel, classLoader);
    }

    @Override
    public final Object[] newArray(int i6) {
        return new NavigationBarView$SavedState[i6];
    }

    @Override
    public final Object createFromParcel(Parcel parcel) {
        return new NavigationBarView$SavedState(parcel, null);
    }
}
