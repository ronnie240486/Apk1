package androidx.core.widget;

import android.os.Parcel;
import android.os.Parcelable;

public final class C0379l implements Parcelable.Creator {
    @Override
    public final Object createFromParcel(Parcel parcel) {
        NestedScrollView.SavedState savedState = new NestedScrollView.SavedState(parcel);
        savedState.f1651a = parcel.readInt();
        return savedState;
    }

    @Override
    public final Object[] newArray(int i6) {
        return new NestedScrollView.SavedState[i6];
    }
}
