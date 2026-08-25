package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
final class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new C0393b(0);

    public final int[] f1750a;

    public final ArrayList f1751b;

    public final int[] f1752c;

    public final int[] f1753d;

    public final int f1754e;

    public final String f1755f;

    public final int f1756g;

    public final int f1757h;

    public final CharSequence f1758i;

    public final int f1759j;

    public final CharSequence f1760k;

    public final ArrayList f1761l;

    public final ArrayList f1762m;

    public final boolean f1763n;

    public BackStackState(C0391a c0391a) {
        int size = c0391a.f1801a.size();
        this.f1750a = new int[size * 5];
        if (!c0391a.f1807g) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f1751b = new ArrayList(size);
        this.f1752c = new int[size];
        this.f1753d = new int[size];
        int i6 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            C0426r0 c0426r0 = (C0426r0) c0391a.f1801a.get(i10);
            int i11 = i6 + 1;
            this.f1750a[i6] = c0426r0.f1937a;
            ArrayList arrayList = this.f1751b;
            AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s = c0426r0.f1938b;
            arrayList.add(abstractComponentCallbacksC0427s != null ? abstractComponentCallbacksC0427s.f1969f : null);
            int[] iArr = this.f1750a;
            iArr[i11] = c0426r0.f1939c;
            iArr[i6 + 2] = c0426r0.f1940d;
            int i12 = i6 + 4;
            iArr[i6 + 3] = c0426r0.f1941e;
            i6 += 5;
            iArr[i12] = c0426r0.f1942f;
            this.f1752c[i10] = c0426r0.f1943g.ordinal();
            this.f1753d[i10] = c0426r0.f1944h.ordinal();
        }
        this.f1754e = c0391a.f1806f;
        this.f1755f = c0391a.f1809i;
        this.f1756g = c0391a.f1819s;
        this.f1757h = c0391a.f1810j;
        this.f1758i = c0391a.f1811k;
        this.f1759j = c0391a.f1812l;
        this.f1760k = c0391a.f1813m;
        this.f1761l = c0391a.f1814n;
        this.f1762m = c0391a.f1815o;
        this.f1763n = c0391a.f1816p;
    }

    @Override
    public final int describeContents() {
        return 0;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        parcel.writeIntArray(this.f1750a);
        parcel.writeStringList(this.f1751b);
        parcel.writeIntArray(this.f1752c);
        parcel.writeIntArray(this.f1753d);
        parcel.writeInt(this.f1754e);
        parcel.writeString(this.f1755f);
        parcel.writeInt(this.f1756g);
        parcel.writeInt(this.f1757h);
        TextUtils.writeToParcel(this.f1758i, parcel, 0);
        parcel.writeInt(this.f1759j);
        TextUtils.writeToParcel(this.f1760k, parcel, 0);
        parcel.writeStringList(this.f1761l);
        parcel.writeStringList(this.f1762m);
        parcel.writeInt(this.f1763n ? 1 : 0);
    }

    public BackStackState(Parcel parcel) {
        this.f1750a = parcel.createIntArray();
        this.f1751b = parcel.createStringArrayList();
        this.f1752c = parcel.createIntArray();
        this.f1753d = parcel.createIntArray();
        this.f1754e = parcel.readInt();
        this.f1755f = parcel.readString();
        this.f1756g = parcel.readInt();
        this.f1757h = parcel.readInt();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.f1758i = (CharSequence) creator.createFromParcel(parcel);
        this.f1759j = parcel.readInt();
        this.f1760k = (CharSequence) creator.createFromParcel(parcel);
        this.f1761l = parcel.createStringArrayList();
        this.f1762m = parcel.createStringArrayList();
        this.f1763n = parcel.readInt() != 0;
    }
}
