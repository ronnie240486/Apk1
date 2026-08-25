package p003a2;

import android.os.Parcel;
import android.util.SparseIntArray;
import p000a.AbstractC0004e;
import p160p.C3341e;

public final class C0034c extends AbstractC0033b {

    public final SparseIntArray f98d;

    public final Parcel f99e;

    public final int f100f;

    public final int f101g;

    public final String f102h;

    public int f103i;

    public int f104j;

    public int f105k;

    public C0034c(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new C3341e(0), new C3341e(0), new C3341e(0));
    }

    @Override
    public final C0034c mo179a() {
        Parcel parcel = this.f99e;
        int iDataPosition = parcel.dataPosition();
        int i6 = this.f104j;
        if (i6 == this.f100f) {
            i6 = this.f101g;
        }
        return new C0034c(parcel, iDataPosition, i6, AbstractC0004e.m26t(new StringBuilder(), this.f102h, "  "), this.f95a, this.f96b, this.f97c);
    }

    @Override
    public final boolean mo183e(int i6) {
        while (this.f104j < this.f101g) {
            int i10 = this.f105k;
            if (i10 == i6) {
                return true;
            }
            if (String.valueOf(i10).compareTo(String.valueOf(i6)) > 0) {
                return false;
            }
            int i11 = this.f104j;
            Parcel parcel = this.f99e;
            parcel.setDataPosition(i11);
            int i12 = parcel.readInt();
            this.f105k = parcel.readInt();
            this.f104j += i12;
        }
        return this.f105k == i6;
    }

    @Override
    public final void mo187i(int i6) {
        int i10 = this.f103i;
        SparseIntArray sparseIntArray = this.f98d;
        Parcel parcel = this.f99e;
        if (i10 >= 0) {
            int i11 = sparseIntArray.get(i10);
            int iDataPosition = parcel.dataPosition();
            parcel.setDataPosition(i11);
            parcel.writeInt(iDataPosition - i11);
            parcel.setDataPosition(iDataPosition);
        }
        this.f103i = i6;
        sparseIntArray.put(i6, parcel.dataPosition());
        parcel.writeInt(0);
        parcel.writeInt(i6);
    }

    public C0034c(Parcel parcel, int i6, int i10, String str, C3341e c3341e, C3341e c3341e2, C3341e c3341e3) {
        super(c3341e, c3341e2, c3341e3);
        this.f98d = new SparseIntArray();
        this.f103i = -1;
        this.f105k = -1;
        this.f99e = parcel;
        this.f100f = i6;
        this.f101g = i10;
        this.f104j = i6;
        this.f102h = str;
    }
}
