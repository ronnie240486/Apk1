package p099j5;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.stats.WakeLockEvent;
import java.util.ArrayList;
import p143n5.AbstractC3198d;

public final class C2778b implements Parcelable.Creator {
    @Override
    public final Object createFromParcel(Parcel parcel) {
        int iM6447V = AbstractC3198d.m6447V(parcel);
        String strM6463k = null;
        ArrayList arrayListM6466n = null;
        String strM6463k2 = null;
        String strM6463k3 = null;
        String strM6463k4 = null;
        String strM6463k5 = null;
        long jM6438M = 0;
        long jM6438M2 = 0;
        long jM6438M3 = 0;
        int iM6436K = 0;
        int iM6436K2 = 0;
        int iM6436K3 = 0;
        int iM6436K4 = 0;
        float fM6434I = 0.0f;
        boolean zM6431F = false;
        while (parcel.dataPosition() < iM6447V) {
            int i6 = parcel.readInt();
            switch ((char) i6) {
                case 1:
                    iM6436K = AbstractC3198d.m6436K(parcel, i6);
                    break;
                case 2:
                    jM6438M = AbstractC3198d.m6438M(parcel, i6);
                    break;
                case 3:
                case 7:
                case '\t':
                default:
                    AbstractC3198d.m6445T(parcel, i6);
                    break;
                case 4:
                    strM6463k = AbstractC3198d.m6463k(parcel, i6);
                    break;
                case 5:
                    iM6436K3 = AbstractC3198d.m6436K(parcel, i6);
                    break;
                case 6:
                    arrayListM6466n = AbstractC3198d.m6466n(parcel, i6);
                    break;
                case '\b':
                    jM6438M2 = AbstractC3198d.m6438M(parcel, i6);
                    break;
                case '\n':
                    strM6463k3 = AbstractC3198d.m6463k(parcel, i6);
                    break;
                case 11:
                    iM6436K2 = AbstractC3198d.m6436K(parcel, i6);
                    break;
                case '\f':
                    strM6463k2 = AbstractC3198d.m6463k(parcel, i6);
                    break;
                case '\r':
                    strM6463k4 = AbstractC3198d.m6463k(parcel, i6);
                    break;
                case 14:
                    iM6436K4 = AbstractC3198d.m6436K(parcel, i6);
                    break;
                case 15:
                    fM6434I = AbstractC3198d.m6434I(parcel, i6);
                    break;
                case 16:
                    jM6438M3 = AbstractC3198d.m6438M(parcel, i6);
                    break;
                case 17:
                    strM6463k5 = AbstractC3198d.m6463k(parcel, i6);
                    break;
                case 18:
                    zM6431F = AbstractC3198d.m6431F(parcel, i6);
                    break;
            }
        }
        AbstractC3198d.m6470r(parcel, iM6447V);
        return new WakeLockEvent(iM6436K, jM6438M, iM6436K2, strM6463k, iM6436K3, arrayListM6466n, strM6463k2, jM6438M2, iM6436K4, strM6463k3, strM6463k4, fM6434I, jM6438M3, strM6463k5, zM6431F);
    }

    @Override
    public final Object[] newArray(int i6) {
        return new WakeLockEvent[i6];
    }
}
