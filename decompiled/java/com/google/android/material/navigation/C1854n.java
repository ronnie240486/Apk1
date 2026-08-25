package com.google.android.material.navigation;

import android.os.Parcel;
import android.os.Parcelable;

public final class C1854n implements Parcelable.ClassLoaderCreator {
    @Override
    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new NavigationView.SavedState(parcel, classLoader);
    }

    @Override
    public final Object[] newArray(int i6) {
        return new NavigationView.SavedState[i6];
    }

    @Override
    public final Object createFromParcel(Parcel parcel) {
        return new NavigationView.SavedState(parcel, null);
    }
}
