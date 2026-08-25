package androidx.customview.view;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
public abstract class AbsSavedState implements Parcelable {

    public final Parcelable f1689a;

    public static final AbsSavedState f1688b = new C03871();
    public static final Parcelable.Creator<AbsSavedState> CREATOR = new C0388a(0);

    public class C03871 extends AbsSavedState {
    }

    public AbsSavedState() {
        this.f1689a = null;
    }

    @Override
    public final int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeParcelable(this.f1689a, i6);
    }

    public AbsSavedState(Parcelable parcelable) {
        if (parcelable != null) {
            this.f1689a = parcelable == f1688b ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    public AbsSavedState(Parcel parcel, ClassLoader classLoader) {
        Parcelable parcelable = parcel.readParcelable(classLoader);
        this.f1689a = parcelable == null ? f1688b : parcelable;
    }
}
