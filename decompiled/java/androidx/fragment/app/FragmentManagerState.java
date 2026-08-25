package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new C0393b(2);

    public ArrayList f1776a;

    public ArrayList f1777b;

    public BackStackState[] f1778c;

    public int f1779d;

    public String f1780e;

    public ArrayList f1781f;

    public ArrayList f1782g;

    public ArrayList f1783h;

    @Override
    public final int describeContents() {
        return 0;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        parcel.writeTypedList(this.f1776a);
        parcel.writeStringList(this.f1777b);
        parcel.writeTypedArray(this.f1778c, i6);
        parcel.writeInt(this.f1779d);
        parcel.writeString(this.f1780e);
        parcel.writeStringList(this.f1781f);
        parcel.writeTypedList(this.f1782g);
        parcel.writeTypedList(this.f1783h);
    }
}
