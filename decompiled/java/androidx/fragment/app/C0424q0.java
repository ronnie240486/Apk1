package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;

public final class C0424q0 implements Parcelable.Creator {
    @Override
    public final Object createFromParcel(Parcel parcel) {
        FragmentTabHost.SavedState savedState = new FragmentTabHost.SavedState(parcel);
        savedState.f1800a = parcel.readString();
        return savedState;
    }

    @Override
    public final Object[] newArray(int i6) {
        return new FragmentTabHost.SavedState[i6];
    }
}
