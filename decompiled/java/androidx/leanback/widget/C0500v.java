package androidx.leanback.widget;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public final class C0500v implements Parcelable.Creator {
    @Override
    public final Object createFromParcel(Parcel parcel) {
        GridLayoutManager.SavedState savedState = new GridLayoutManager.SavedState();
        savedState.f2133b = Bundle.EMPTY;
        savedState.f2132a = parcel.readInt();
        savedState.f2133b = parcel.readBundle(GridLayoutManager.class.getClassLoader());
        return savedState;
    }

    @Override
    public final Object[] newArray(int i6) {
        return new GridLayoutManager.SavedState[i6];
    }
}
