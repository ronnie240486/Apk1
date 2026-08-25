package androidx.leanback.widget;

import android.os.Parcel;
import android.os.Parcelable;

public final class C0475j0 implements Parcelable.Creator {
    @Override
    public final Object createFromParcel(Parcel parcel) {
        PersistentFocusWrapper.SavedState savedState = new PersistentFocusWrapper.SavedState(parcel);
        savedState.f2207a = parcel.readInt();
        return savedState;
    }

    @Override
    public final Object[] newArray(int i6) {
        return new PersistentFocusWrapper.SavedState[i6];
    }
}
