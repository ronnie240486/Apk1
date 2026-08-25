package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import p000a.AbstractC0004e;
import p007a7.C0069f;
import p018b5.AbstractC1312l;
import p156o9.AbstractC3280d;
import p261y4.C4266n;
import p261y4.InterfaceC4264l;

public final class Status extends AbstractSafeParcelable implements InterfaceC4264l, ReflectedParcelable {

    public final int f4994a;

    public final String f4995b;

    public final PendingIntent f4996c;

    public final ConnectionResult f4997d;

    public static final Status f4991e = new Status(0, null, null, null);

    public static final Status f4992f = new Status(15, null, null, null);

    public static final Status f4993g = new Status(16, null, null, null);
    public static final Parcelable.Creator<Status> CREATOR = new C4266n(3);

    public Status(int i6, String str, PendingIntent pendingIntent, ConnectionResult connectionResult) {
        this.f4994a = i6;
        this.f4995b = str;
        this.f4996c = pendingIntent;
        this.f4997d = connectionResult;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f4994a == status.f4994a && AbstractC1312l.m3201h(this.f4995b, status.f4995b) && AbstractC1312l.m3201h(this.f4996c, status.f4996c) && AbstractC1312l.m3201h(this.f4997d, status.f4997d);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f4994a), this.f4995b, this.f4996c, this.f4997d});
    }

    public final String toString() {
        C0069f c0069f = new C0069f(this);
        String strM20n = this.f4995b;
        if (strM20n == null) {
            int i6 = this.f4994a;
            switch (i6) {
                case -1:
                    strM20n = "SUCCESS_CACHE";
                    break;
                case 0:
                    strM20n = "SUCCESS";
                    break;
                case 1:
                case 9:
                case 11:
                case 12:
                default:
                    strM20n = AbstractC0004e.m20n(i6, "unknown status code: ");
                    break;
                case 2:
                    strM20n = "SERVICE_VERSION_UPDATE_REQUIRED";
                    break;
                case 3:
                    strM20n = "SERVICE_DISABLED";
                    break;
                case 4:
                    strM20n = "SIGN_IN_REQUIRED";
                    break;
                case 5:
                    strM20n = "INVALID_ACCOUNT";
                    break;
                case 6:
                    strM20n = "RESOLUTION_REQUIRED";
                    break;
                case 7:
                    strM20n = "NETWORK_ERROR";
                    break;
                case 8:
                    strM20n = "INTERNAL_ERROR";
                    break;
                case 10:
                    strM20n = "DEVELOPER_ERROR";
                    break;
                case 13:
                    strM20n = "ERROR";
                    break;
                case 14:
                    strM20n = "INTERRUPTED";
                    break;
                case 15:
                    strM20n = "TIMEOUT";
                    break;
                case 16:
                    strM20n = "CANCELED";
                    break;
                case 17:
                    strM20n = "API_NOT_CONNECTED";
                    break;
                case 18:
                    strM20n = "DEAD_CLIENT";
                    break;
                case 19:
                    strM20n = "REMOTE_EXCEPTION";
                    break;
                case 20:
                    strM20n = "CONNECTION_SUSPENDED_DURING_CALL";
                    break;
                case 21:
                    strM20n = "RECONNECTION_TIMED_OUT_DURING_UPDATE";
                    break;
                case 22:
                    strM20n = "RECONNECTION_TIMED_OUT";
                    break;
            }
        }
        c0069f.m229c(strM20n, "statusCode");
        c0069f.m229c(this.f4996c, "resolution");
        return c0069f.toString();
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6585X(parcel, 1, 4);
        parcel.writeInt(this.f4994a);
        AbstractC3280d.m6579R(parcel, 2, this.f4995b);
        AbstractC3280d.m6578Q(parcel, 3, this.f4996c, i6);
        AbstractC3280d.m6578Q(parcel, 4, this.f4997d, i6);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }

    @Override
    public final Status mo3637h() {
        return this;
    }
}
