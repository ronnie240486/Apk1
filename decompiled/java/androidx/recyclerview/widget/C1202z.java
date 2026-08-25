package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;

public final class C1202z implements Parcelable.Creator {
    @Override
    public final Object createFromParcel(Parcel parcel) {
        LinearLayoutManager.SavedState savedState = new LinearLayoutManager.SavedState();
        savedState.f3458a = parcel.readInt();
        savedState.f3459b = parcel.readInt();
        savedState.f3460c = parcel.readInt() == 1;
        return savedState;
    }

    @Override
    public final Object[] newArray(int i6) {
        return new LinearLayoutManager.SavedState[i6];
    }
}
