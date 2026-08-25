package androidx.appcompat.app;

import android.os.Parcel;
import android.os.Parcelable;

public final class C0131e0 implements Parcelable.ClassLoaderCreator {
    @Override
    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return AppCompatDelegateImpl$PanelFeatureState$SavedState.m367h(parcel, classLoader);
    }

    @Override
    public final Object[] newArray(int i6) {
        return new AppCompatDelegateImpl$PanelFeatureState$SavedState[i6];
    }

    @Override
    public final Object createFromParcel(Parcel parcel) {
        return AppCompatDelegateImpl$PanelFeatureState$SavedState.m367h(parcel, null);
    }
}
