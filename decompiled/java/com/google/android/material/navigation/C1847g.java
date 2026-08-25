package com.google.android.material.navigation;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.internal.ParcelableSparseArray;

public final class C1847g implements Parcelable.Creator {
    @Override
    public final Object createFromParcel(Parcel parcel) {
        NavigationBarPresenter$SavedState navigationBarPresenter$SavedState = new NavigationBarPresenter$SavedState();
        navigationBarPresenter$SavedState.f6500a = parcel.readInt();
        navigationBarPresenter$SavedState.f6501b = (ParcelableSparseArray) parcel.readParcelable(NavigationBarPresenter$SavedState.class.getClassLoader());
        return navigationBarPresenter$SavedState;
    }

    @Override
    public final Object[] newArray(int i6) {
        return new NavigationBarPresenter$SavedState[i6];
    }
}
