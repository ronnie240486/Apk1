package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;

public final class C0425r implements Parcelable.ClassLoaderCreator {
    @Override
    public final Object createFromParcel(Parcel parcel) {
        return new Fragment$SavedState(parcel, null);
    }

    @Override
    public final Object[] newArray(int i6) {
        return new Fragment$SavedState[i6];
    }

    @Override
    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new Fragment$SavedState(parcel, classLoader);
    }
}
