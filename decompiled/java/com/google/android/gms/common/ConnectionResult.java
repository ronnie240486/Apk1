package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import p007a7.C0069f;
import p018b5.AbstractC1312l;
import p055ea.AbstractC2460q;
import p156o9.AbstractC3280d;
import p165p4.C3371p;

public final class ConnectionResult extends AbstractSafeParcelable {

    public final int f4970a;

    public final int f4971b;

    public final PendingIntent f4972c;

    public final String f4973d;

    public static final ConnectionResult f4969e = new ConnectionResult(0);
    public static final Parcelable.Creator<ConnectionResult> CREATOR = new C3371p(26);

    public ConnectionResult(int i6, int i10, PendingIntent pendingIntent, String str) {
        this.f4970a = i6;
        this.f4971b = i10;
        this.f4972c = pendingIntent;
        this.f4973d = str;
    }

    public static String m3634j(int i6) {
        if (i6 == 99) {
            return "UNFINISHED";
        }
        if (i6 == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i6) {
            case -1:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i6) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    case 22:
                        return "RESOLUTION_ACTIVITY_NOT_FOUND";
                    case 23:
                        return "API_DISABLED";
                    case 24:
                        return "API_DISABLED_FOR_CONNECTION";
                    case 25:
                        return "API_INSTALL_REQUIRED";
                    default:
                        return AbstractC2460q.m5492f(i6, "UNKNOWN_ERROR_CODE(", ")");
                }
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionResult)) {
            return false;
        }
        ConnectionResult connectionResult = (ConnectionResult) obj;
        return this.f4971b == connectionResult.f4971b && AbstractC1312l.m3201h(this.f4972c, connectionResult.f4972c) && AbstractC1312l.m3201h(this.f4973d, connectionResult.f4973d);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f4971b), this.f4972c, this.f4973d});
    }

    public final String toString() {
        C0069f c0069f = new C0069f(this);
        c0069f.m229c(m3634j(this.f4971b), "statusCode");
        c0069f.m229c(this.f4972c, "resolution");
        c0069f.m229c(this.f4973d, "message");
        return c0069f.toString();
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6585X(parcel, 1, 4);
        parcel.writeInt(this.f4970a);
        AbstractC3280d.m6585X(parcel, 2, 4);
        parcel.writeInt(this.f4971b);
        AbstractC3280d.m6578Q(parcel, 3, this.f4972c, i6);
        AbstractC3280d.m6579R(parcel, 4, this.f4973d);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }

    public ConnectionResult(int i6) {
        this(1, i6, null, null);
    }

    public ConnectionResult(int i6, PendingIntent pendingIntent) {
        this(1, i6, pendingIntent, null);
    }
}
