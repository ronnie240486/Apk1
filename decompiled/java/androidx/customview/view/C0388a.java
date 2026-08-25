package androidx.customview.view;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.internal.ParcelableSparseArray;
import com.google.android.material.stateful.ExtendableSavedState;

public final class C0388a implements Parcelable.ClassLoaderCreator {

    public final int f1690a;

    @Override
    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        switch (this.f1690a) {
            case 0:
                if (parcel.readParcelable(classLoader) == null) {
                    return AbsSavedState.f1688b;
                }
                throw new IllegalStateException("superState must be null");
            case 1:
                return new ParcelableSparseArray(parcel, classLoader);
            default:
                return new ExtendableSavedState(parcel, classLoader);
        }
    }

    @Override
    public final Object[] newArray(int i6) {
        switch (this.f1690a) {
            case 0:
                return new AbsSavedState[i6];
            case 1:
                return new ParcelableSparseArray[i6];
            default:
                return new ExtendableSavedState[i6];
        }
    }

    @Override
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f1690a) {
            case 0:
                if (parcel.readParcelable(null) == null) {
                    return AbsSavedState.f1688b;
                }
                throw new IllegalStateException("superState must be null");
            case 1:
                return new ParcelableSparseArray(parcel, null);
            default:
                return new ExtendableSavedState(parcel, null);
        }
    }
}
