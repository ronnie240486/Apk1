package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

@SuppressLint({"BanParcelableUsage"})
class StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem implements Parcelable {
    public static final Parcelable.Creator<StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> CREATOR = new C1192v1();

    public int f3496a;

    public int f3497b;

    public int[] f3498c;

    public boolean f3499d;

    @Override
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "FullSpanItem{mPosition=" + this.f3496a + ", mGapDir=" + this.f3497b + ", mHasUnwantedGapAfter=" + this.f3499d + ", mGapPerSpan=" + Arrays.toString(this.f3498c) + '}';
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        parcel.writeInt(this.f3496a);
        parcel.writeInt(this.f3497b);
        parcel.writeInt(this.f3499d ? 1 : 0);
        int[] iArr = this.f3498c;
        if (iArr == null || iArr.length <= 0) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(iArr.length);
            parcel.writeIntArray(this.f3498c);
        }
    }
}
