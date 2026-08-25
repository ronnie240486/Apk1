package p088i5;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.server.converter.zaa;
import com.google.android.gms.common.server.response.FastJsonResponse$Field;
import p143n5.AbstractC3198d;

public final class C2705a implements Parcelable.Creator {
    @Override
    public final Object createFromParcel(Parcel parcel) {
        int iM6447V = AbstractC3198d.m6447V(parcel);
        String strM6463k = null;
        String strM6463k2 = null;
        zaa zaaVar = null;
        int iM6436K = 0;
        int iM6436K2 = 0;
        boolean zM6431F = false;
        int iM6436K3 = 0;
        boolean zM6431F2 = false;
        int iM6436K4 = 0;
        while (parcel.dataPosition() < iM6447V) {
            int i6 = parcel.readInt();
            switch ((char) i6) {
                case 1:
                    iM6436K = AbstractC3198d.m6436K(parcel, i6);
                    break;
                case 2:
                    iM6436K2 = AbstractC3198d.m6436K(parcel, i6);
                    break;
                case 3:
                    zM6431F = AbstractC3198d.m6431F(parcel, i6);
                    break;
                case 4:
                    iM6436K3 = AbstractC3198d.m6436K(parcel, i6);
                    break;
                case 5:
                    zM6431F2 = AbstractC3198d.m6431F(parcel, i6);
                    break;
                case 6:
                    strM6463k = AbstractC3198d.m6463k(parcel, i6);
                    break;
                case 7:
                    iM6436K4 = AbstractC3198d.m6436K(parcel, i6);
                    break;
                case '\b':
                    strM6463k2 = AbstractC3198d.m6463k(parcel, i6);
                    break;
                case '\t':
                    zaaVar = (zaa) AbstractC3198d.m6462j(parcel, i6, zaa.CREATOR);
                    break;
                default:
                    AbstractC3198d.m6445T(parcel, i6);
                    break;
            }
        }
        AbstractC3198d.m6470r(parcel, iM6447V);
        return new FastJsonResponse$Field(iM6436K, iM6436K2, zM6431F, iM6436K3, zM6431F2, strM6463k, iM6436K4, strM6463k2, zaaVar);
    }

    @Override
    public final Object[] newArray(int i6) {
        return new FastJsonResponse$Field[i6];
    }
}
