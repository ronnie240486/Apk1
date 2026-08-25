package androidx.viewpager.widget;

import android.os.Parcel;
import android.os.Parcelable;

public final class C1205a implements Parcelable.ClassLoaderCreator {
    @Override
    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new ViewPager.SavedState(parcel, classLoader);
    }

    @Override
    public final Object[] newArray(int i6) {
        return new ViewPager.SavedState[i6];
    }

    @Override
    public final Object createFromParcel(Parcel parcel) {
        return new ViewPager.SavedState(parcel, null);
    }
}
