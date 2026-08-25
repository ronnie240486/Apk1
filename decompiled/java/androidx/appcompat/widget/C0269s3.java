package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable;

public final class C0269s3 implements Parcelable.ClassLoaderCreator {
    @Override
    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new Toolbar.SavedState(parcel, classLoader);
    }

    @Override
    public final Object[] newArray(int i6) {
        return new Toolbar.SavedState[i6];
    }

    @Override
    public final Object createFromParcel(Parcel parcel) {
        return new Toolbar.SavedState(parcel, null);
    }
}
