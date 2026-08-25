package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable;

public final class C0182b3 implements Parcelable.ClassLoaderCreator {
    @Override
    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new SearchView.SavedState(parcel, classLoader);
    }

    @Override
    public final Object[] newArray(int i6) {
        return new SearchView.SavedState[i6];
    }

    @Override
    public final Object createFromParcel(Parcel parcel) {
        return new SearchView.SavedState(parcel, null);
    }
}
