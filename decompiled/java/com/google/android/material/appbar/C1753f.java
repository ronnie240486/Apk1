package com.google.android.material.appbar;

import android.os.Parcel;
import android.os.Parcelable;

public final class C1753f implements Parcelable.ClassLoaderCreator {
    @Override
    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new AppBarLayout.BaseBehavior.SavedState(parcel, classLoader);
    }

    @Override
    public final Object[] newArray(int i6) {
        return new AppBarLayout.BaseBehavior.SavedState[i6];
    }

    @Override
    public final Object createFromParcel(Parcel parcel) {
        return new AppBarLayout.BaseBehavior.SavedState(parcel, null);
    }
}
