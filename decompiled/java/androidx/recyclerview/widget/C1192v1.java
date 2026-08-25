package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;

public final class C1192v1 implements Parcelable.Creator {
    @Override
    public final Object createFromParcel(Parcel parcel) {
        StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = new StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem();
        staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.f3496a = parcel.readInt();
        staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.f3497b = parcel.readInt();
        staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.f3499d = parcel.readInt() == 1;
        int i6 = parcel.readInt();
        if (i6 > 0) {
            int[] iArr = new int[i6];
            staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.f3498c = iArr;
            parcel.readIntArray(iArr);
        }
        return staggeredGridLayoutManager$LazySpanLookup$FullSpanItem;
    }

    @Override
    public final Object[] newArray(int i6) {
        return new StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem[i6];
    }
}
