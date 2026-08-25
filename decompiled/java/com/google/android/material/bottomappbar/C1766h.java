package com.google.android.material.bottomappbar;

import android.os.Parcel;
import android.os.Parcelable;

public final class C1766h implements Parcelable.ClassLoaderCreator {
    @Override
    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new BottomAppBar.SavedState(parcel, classLoader);
    }

    @Override
    public final Object[] newArray(int i6) {
        return new BottomAppBar.SavedState[i6];
    }

    @Override
    public final Object createFromParcel(Parcel parcel) {
        return new BottomAppBar.SavedState(parcel, null);
    }
}
