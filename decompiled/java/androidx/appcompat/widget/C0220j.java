package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable;

public final class C0220j implements Parcelable.Creator {
    @Override
    public final Object createFromParcel(Parcel parcel) {
        ActionMenuPresenter$SavedState actionMenuPresenter$SavedState = new ActionMenuPresenter$SavedState();
        actionMenuPresenter$SavedState.f574a = parcel.readInt();
        return actionMenuPresenter$SavedState;
    }

    @Override
    public final Object[] newArray(int i6) {
        return new ActionMenuPresenter$SavedState[i6];
    }
}
