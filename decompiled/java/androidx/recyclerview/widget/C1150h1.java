package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;

public final class C1150h1 implements Parcelable.ClassLoaderCreator {
    @Override
    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new RecyclerView.SavedState(parcel, classLoader);
    }

    @Override
    public final Object[] newArray(int i6) {
        return new RecyclerView.SavedState[i6];
    }

    @Override
    public final Object createFromParcel(Parcel parcel) {
        return new RecyclerView.SavedState(parcel, null);
    }
}
