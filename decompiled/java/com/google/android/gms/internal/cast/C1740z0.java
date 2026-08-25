package com.google.android.gms.internal.cast;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import p143n5.AbstractC3198d;

public final class C1740z0 implements Parcelable.Creator {

    public final int f5742a;

    public C1740z0(int i6) {
        this.f5742a = i6;
    }

    @Override
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f5742a) {
            case 0:
                int iM6447V = AbstractC3198d.m6447V(parcel);
                String strM6463k = null;
                byte[] bArrM6459g = null;
                ArrayList arrayList = null;
                while (parcel.dataPosition() < iM6447V) {
                    int i6 = parcel.readInt();
                    char c5 = (char) i6;
                    if (c5 == 1) {
                        strM6463k = AbstractC3198d.m6463k(parcel, i6);
                    } else if (c5 == 2) {
                        bArrM6459g = AbstractC3198d.m6459g(parcel, i6);
                    } else if (c5 != 3) {
                        AbstractC3198d.m6445T(parcel, i6);
                    } else {
                        int iM6439N = AbstractC3198d.m6439N(parcel, i6);
                        int iDataPosition = parcel.dataPosition();
                        if (iM6439N == 0) {
                            arrayList = null;
                        } else {
                            ArrayList arrayList2 = new ArrayList();
                            int i10 = parcel.readInt();
                            for (int i11 = 0; i11 < i10; i11++) {
                                arrayList2.add(Integer.valueOf(parcel.readInt()));
                            }
                            parcel.setDataPosition(iDataPosition + iM6439N);
                            arrayList = arrayList2;
                        }
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V);
                return new zzev(strM6463k, bArrM6459g, arrayList);
            case 1:
                int iM6447V2 = AbstractC3198d.m6447V(parcel);
                boolean zM6431F = false;
                ArrayList arrayListM6468p = null;
                boolean zM6431F2 = false;
                while (parcel.dataPosition() < iM6447V2) {
                    int i12 = parcel.readInt();
                    char c8 = (char) i12;
                    if (c8 == 1) {
                        arrayListM6468p = AbstractC3198d.m6468p(parcel, i12, zzev.CREATOR);
                    } else if (c8 == 2) {
                        zM6431F = AbstractC3198d.m6431F(parcel, i12);
                    } else if (c8 != 3) {
                        AbstractC3198d.m6445T(parcel, i12);
                    } else {
                        zM6431F2 = AbstractC3198d.m6431F(parcel, i12);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V2);
                return new zzew(arrayListM6468p, zM6431F, zM6431F2);
            case 2:
                int iM6447V3 = AbstractC3198d.m6447V(parcel);
                boolean zM6431F3 = false;
                int iM6436K = 0;
                while (parcel.dataPosition() < iM6447V3) {
                    int i13 = parcel.readInt();
                    char c10 = (char) i13;
                    if (c10 == 2) {
                        zM6431F3 = AbstractC3198d.m6431F(parcel, i13);
                    } else if (c10 != 3) {
                        AbstractC3198d.m6445T(parcel, i13);
                    } else {
                        iM6436K = AbstractC3198d.m6436K(parcel, i13);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V3);
                return new zzey(zM6431F3, iM6436K);
            case 3:
                int iM6447V4 = AbstractC3198d.m6447V(parcel);
                boolean zM6431F4 = false;
                boolean zM6431F5 = false;
                int iM6436K2 = 0;
                while (parcel.dataPosition() < iM6447V4) {
                    int i14 = parcel.readInt();
                    char c11 = (char) i14;
                    if (c11 == 2) {
                        zM6431F4 = AbstractC3198d.m6431F(parcel, i14);
                    } else if (c11 == 3) {
                        zM6431F5 = AbstractC3198d.m6431F(parcel, i14);
                    } else if (c11 != 4) {
                        AbstractC3198d.m6445T(parcel, i14);
                    } else {
                        iM6436K2 = AbstractC3198d.m6436K(parcel, i14);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V4);
                return new zzff(iM6436K2, zM6431F4, zM6431F5);
            default:
                int iM6447V5 = AbstractC3198d.m6447V(parcel);
                ArrayList arrayListM6466n = null;
                String strM6463k2 = null;
                int iM6436K3 = 0;
                boolean zM6431F6 = false;
                int iM6436K4 = 0;
                boolean zM6431F7 = false;
                while (parcel.dataPosition() < iM6447V5) {
                    int i15 = parcel.readInt();
                    switch ((char) i15) {
                        case 2:
                            iM6436K3 = AbstractC3198d.m6436K(parcel, i15);
                            break;
                        case 3:
                            zM6431F6 = AbstractC3198d.m6431F(parcel, i15);
                            break;
                        case 4:
                            arrayListM6466n = AbstractC3198d.m6466n(parcel, i15);
                            break;
                        case 5:
                            iM6436K4 = AbstractC3198d.m6436K(parcel, i15);
                            break;
                        case 6:
                            strM6463k2 = AbstractC3198d.m6463k(parcel, i15);
                            break;
                        case 7:
                            zM6431F7 = AbstractC3198d.m6431F(parcel, i15);
                            break;
                        default:
                            AbstractC3198d.m6445T(parcel, i15);
                            break;
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V5);
                return new zzfk(iM6436K3, zM6431F6, arrayListM6466n, iM6436K4, strM6463k2, zM6431F7);
        }
    }

    @Override
    public final Object[] newArray(int i6) {
        switch (this.f5742a) {
            case 0:
                return new zzev[i6];
            case 1:
                return new zzew[i6];
            case 2:
                return new zzey[i6];
            case 3:
                return new zzff[i6];
            default:
                return new zzfk[i6];
        }
    }
}
