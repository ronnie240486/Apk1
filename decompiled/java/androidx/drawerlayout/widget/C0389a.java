package androidx.drawerlayout.widget;

import android.os.Parcel;
import android.os.Parcelable;

public final class C0389a implements Parcelable.ClassLoaderCreator {
    @Override
    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new DrawerLayout.SavedState(parcel, classLoader);
    }

    @Override
    public final Object[] newArray(int i6) {
        return new DrawerLayout.SavedState[i6];
    }

    @Override
    public final Object createFromParcel(Parcel parcel) {
        return new DrawerLayout.SavedState(parcel, null);
    }
}
