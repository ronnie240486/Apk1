package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new C0393b(3);

    public final String f1784a;

    public final String f1785b;

    public final boolean f1786c;

    public final int f1787d;

    public final int f1788e;

    public final String f1789f;

    public final boolean f1790g;

    public final boolean f1791h;

    public final boolean f1792i;

    public final Bundle f1793j;

    public final boolean f1794k;

    public final int f1795l;

    public Bundle f1796m;

    public FragmentState(AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s) {
        this.f1784a = abstractComponentCallbacksC0427s.getClass().getName();
        this.f1785b = abstractComponentCallbacksC0427s.f1969f;
        this.f1786c = abstractComponentCallbacksC0427s.f1977n;
        this.f1787d = abstractComponentCallbacksC0427s.f1986w;
        this.f1788e = abstractComponentCallbacksC0427s.f1987x;
        this.f1789f = abstractComponentCallbacksC0427s.f1988y;
        this.f1790g = abstractComponentCallbacksC0427s.f1947B;
        this.f1791h = abstractComponentCallbacksC0427s.f1976m;
        this.f1792i = abstractComponentCallbacksC0427s.f1946A;
        this.f1793j = abstractComponentCallbacksC0427s.f1970g;
        this.f1794k = abstractComponentCallbacksC0427s.f1989z;
        this.f1795l = abstractComponentCallbacksC0427s.f1957L.ordinal();
    }

    @Override
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f1784a);
        sb.append(" (");
        sb.append(this.f1785b);
        sb.append(")}:");
        if (this.f1786c) {
            sb.append(" fromLayout");
        }
        int i6 = this.f1788e;
        if (i6 != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(i6));
        }
        String str = this.f1789f;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(str);
        }
        if (this.f1790g) {
            sb.append(" retainInstance");
        }
        if (this.f1791h) {
            sb.append(" removing");
        }
        if (this.f1792i) {
            sb.append(" detached");
        }
        if (this.f1794k) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f1784a);
        parcel.writeString(this.f1785b);
        parcel.writeInt(this.f1786c ? 1 : 0);
        parcel.writeInt(this.f1787d);
        parcel.writeInt(this.f1788e);
        parcel.writeString(this.f1789f);
        parcel.writeInt(this.f1790g ? 1 : 0);
        parcel.writeInt(this.f1791h ? 1 : 0);
        parcel.writeInt(this.f1792i ? 1 : 0);
        parcel.writeBundle(this.f1793j);
        parcel.writeInt(this.f1794k ? 1 : 0);
        parcel.writeBundle(this.f1796m);
        parcel.writeInt(this.f1795l);
    }

    public FragmentState(Parcel parcel) {
        this.f1784a = parcel.readString();
        this.f1785b = parcel.readString();
        this.f1786c = parcel.readInt() != 0;
        this.f1787d = parcel.readInt();
        this.f1788e = parcel.readInt();
        this.f1789f = parcel.readString();
        this.f1790g = parcel.readInt() != 0;
        this.f1791h = parcel.readInt() != 0;
        this.f1792i = parcel.readInt() != 0;
        this.f1793j = parcel.readBundle();
        this.f1794k = parcel.readInt() != 0;
        this.f1796m = parcel.readBundle();
        this.f1795l = parcel.readInt();
    }
}
