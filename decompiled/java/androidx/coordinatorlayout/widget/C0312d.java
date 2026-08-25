package androidx.coordinatorlayout.widget;

import android.os.Parcel;
import android.os.Parcelable;

public final class C0312d implements Parcelable.ClassLoaderCreator {
    @Override
    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new CoordinatorLayout.SavedState(parcel, classLoader);
    }

    @Override
    public final Object[] newArray(int i6) {
        return new CoordinatorLayout.SavedState[i6];
    }

    @Override
    public final Object createFromParcel(Parcel parcel) {
        return new CoordinatorLayout.SavedState(parcel, null);
    }
}
