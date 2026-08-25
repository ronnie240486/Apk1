package p261y4;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ApiMetadata;
import com.google.android.gms.common.api.ComplianceOptions;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import p143n5.AbstractC3198d;

public final class C4266n implements Parcelable.Creator {

    public static final C4266n f14467b = new C4266n(0);

    public final int f14468a;

    public C4266n(int i6) {
        this.f14468a = i6;
    }

    @Override
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f14468a) {
            case 0:
                int iDataPosition = parcel.dataPosition();
                if (parcel.readInt() != -204102970) {
                    parcel.setDataPosition(iDataPosition - 4);
                    return ApiMetadata.f4981b;
                }
                int iM6447V = AbstractC3198d.m6447V(parcel);
                ComplianceOptions complianceOptions = null;
                while (parcel.dataPosition() < iM6447V) {
                    int i6 = parcel.readInt();
                    if (((char) i6) != 1) {
                        AbstractC3198d.m6445T(parcel, i6);
                    } else {
                        complianceOptions = (ComplianceOptions) AbstractC3198d.m6462j(parcel, i6, ComplianceOptions.CREATOR);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V);
                return new ApiMetadata(complianceOptions);
            case 1:
                int iM6447V2 = AbstractC3198d.m6447V(parcel);
                int iM6436K = 0;
                int iM6436K2 = 0;
                int iM6436K3 = 0;
                boolean zM6431F = true;
                while (parcel.dataPosition() < iM6447V2) {
                    int i10 = parcel.readInt();
                    char c5 = (char) i10;
                    if (c5 == 1) {
                        iM6436K = AbstractC3198d.m6436K(parcel, i10);
                    } else if (c5 == 2) {
                        iM6436K2 = AbstractC3198d.m6436K(parcel, i10);
                    } else if (c5 == 3) {
                        iM6436K3 = AbstractC3198d.m6436K(parcel, i10);
                    } else if (c5 != 4) {
                        AbstractC3198d.m6445T(parcel, i10);
                    } else {
                        zM6431F = AbstractC3198d.m6431F(parcel, i10);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V2);
                return new ComplianceOptions(iM6436K, iM6436K2, iM6436K3, zM6431F);
            case 2:
                int iM6447V3 = AbstractC3198d.m6447V(parcel);
                String strM6463k = null;
                int iM6436K4 = 0;
                while (parcel.dataPosition() < iM6447V3) {
                    int i11 = parcel.readInt();
                    char c8 = (char) i11;
                    if (c8 == 1) {
                        iM6436K4 = AbstractC3198d.m6436K(parcel, i11);
                    } else if (c8 != 2) {
                        AbstractC3198d.m6445T(parcel, i11);
                    } else {
                        strM6463k = AbstractC3198d.m6463k(parcel, i11);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V3);
                return new Scope(iM6436K4, strM6463k);
            default:
                int iM6447V4 = AbstractC3198d.m6447V(parcel);
                String strM6463k2 = null;
                PendingIntent pendingIntent = null;
                ConnectionResult connectionResult = null;
                int iM6436K5 = 0;
                while (parcel.dataPosition() < iM6447V4) {
                    int i12 = parcel.readInt();
                    char c10 = (char) i12;
                    if (c10 == 1) {
                        iM6436K5 = AbstractC3198d.m6436K(parcel, i12);
                    } else if (c10 == 2) {
                        strM6463k2 = AbstractC3198d.m6463k(parcel, i12);
                    } else if (c10 == 3) {
                        pendingIntent = (PendingIntent) AbstractC3198d.m6462j(parcel, i12, PendingIntent.CREATOR);
                    } else if (c10 != 4) {
                        AbstractC3198d.m6445T(parcel, i12);
                    } else {
                        connectionResult = (ConnectionResult) AbstractC3198d.m6462j(parcel, i12, ConnectionResult.CREATOR);
                    }
                }
                AbstractC3198d.m6470r(parcel, iM6447V4);
                return new Status(iM6436K5, strM6463k2, pendingIntent, connectionResult);
        }
    }

    @Override
    public final Object[] newArray(int i6) {
        switch (this.f14468a) {
            case 0:
                return new ApiMetadata[i6];
            case 1:
                return new ComplianceOptions[i6];
            case 2:
                return new Scope[i6];
            default:
                return new Status[i6];
        }
    }
}
