package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.lzy.okgo.cookie.SerializableCookie;
import java.util.Arrays;
import p007a7.C0069f;
import p156o9.AbstractC3280d;
import p165p4.C3371p;

public class Feature extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Feature> CREATOR = new C3371p(27);

    public final String f4974a;

    public final int f4975b;

    public final long f4976c;

    public Feature(String str) {
        this.f4974a = str;
        this.f4976c = 1L;
        this.f4975b = -1;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Feature) {
            Feature feature = (Feature) obj;
            String str = this.f4974a;
            if (((str != null && str.equals(feature.f4974a)) || (str == null && feature.f4974a == null)) && m3635j() == feature.m3635j()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f4974a, Long.valueOf(m3635j())});
    }

    public final long m3635j() {
        long j10 = this.f4976c;
        return j10 == -1 ? this.f4975b : j10;
    }

    public final String toString() {
        C0069f c0069f = new C0069f(this);
        c0069f.m229c(this.f4974a, SerializableCookie.NAME);
        c0069f.m229c(Long.valueOf(m3635j()), "version");
        return c0069f.toString();
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6579R(parcel, 1, this.f4974a);
        AbstractC3280d.m6585X(parcel, 2, 4);
        parcel.writeInt(this.f4975b);
        long jM3635j = m3635j();
        AbstractC3280d.m6585X(parcel, 3, 8);
        parcel.writeLong(jM3635j);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }

    public Feature(String str, int i6, long j10) {
        this.f4974a = str;
        this.f4975b = i6;
        this.f4976c = j10;
    }
}
