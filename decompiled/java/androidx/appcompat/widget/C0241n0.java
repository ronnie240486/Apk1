package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable;

public final class C0241n0 implements Parcelable.Creator {
    @Override
    public final Object createFromParcel(Parcel parcel) {
        AppCompatSpinner.SavedState savedState = new AppCompatSpinner.SavedState(parcel);
        savedState.f651a = parcel.readByte() != 0;
        return savedState;
    }

    @Override
    public final Object[] newArray(int i6) {
        return new AppCompatSpinner.SavedState[i6];
    }
}
