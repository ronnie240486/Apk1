package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;

public final class C1198x1 implements Parcelable.Creator {
    @Override
    public final Object createFromParcel(Parcel parcel) {
        StaggeredGridLayoutManager.SavedState savedState = new StaggeredGridLayoutManager.SavedState();
        savedState.f3500a = parcel.readInt();
        savedState.f3501b = parcel.readInt();
        int i6 = parcel.readInt();
        savedState.f3502c = i6;
        if (i6 > 0) {
            int[] iArr = new int[i6];
            savedState.f3503d = iArr;
            parcel.readIntArray(iArr);
        }
        int i10 = parcel.readInt();
        savedState.f3504e = i10;
        if (i10 > 0) {
            int[] iArr2 = new int[i10];
            savedState.f3505f = iArr2;
            parcel.readIntArray(iArr2);
        }
        savedState.f3507h = parcel.readInt() == 1;
        savedState.f3508i = parcel.readInt() == 1;
        savedState.f3509j = parcel.readInt() == 1;
        savedState.f3506g = parcel.readArrayList(StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem.class.getClassLoader());
        return savedState;
    }

    @Override
    public final Object[] newArray(int i6) {
        return new StaggeredGridLayoutManager.SavedState[i6];
    }
}
